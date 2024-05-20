package no.ntnu.idi.stud.serialization;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import no.ntnu.idi.stud.model.ChaosGameDescription;
import no.ntnu.idi.stud.model.Complex;
import no.ntnu.idi.stud.model.Matrix2x2;
import no.ntnu.idi.stud.model.Vector2D;
import no.ntnu.idi.stud.transformation.AffineTransform2D;
import no.ntnu.idi.stud.transformation.JuliaTransform;
import no.ntnu.idi.stud.transformation.Transform2D;

/**
 * Handles serialization and deserialization of chaos game descriptions.
 */
public class ChaosGameFileHandler {
  /**
   * The file extension to use for file descriptions.
   */
  static final String FILE_EXTENSION = ".txt";

  /**
   * The base path where all files are located.
   */
  static final String BASE_PATH = "games/";

  /**
   * Get the path to a file with the given name.
   *
   * @param name The name of the file without extension
   * @return The path to the file
   */
  private String getPathFromName(String name) {
    return BASE_PATH + name + FILE_EXTENSION;
  }

  /**
   * Read a chaos game description from a file.
   *
   * @param name The name of the file (without the extension)
   * @return The description
   * @throws IOException If the file could not be read
   */
  public ChaosGameDescription readFromFile(String name) throws IOException {
    var reader = new FileReader(getPathFromName(name));
    return handleRead(reader);
  }

  /**
   * Read a chaos game description from a string.
   *
   * @param description The description string to read
   * @return The deserialized description
   * @throws IOException If the description could not be read
   */
  public ChaosGameDescription readFromString(String description) throws IOException {
    var reader = new StringReader(description);
    return handleRead(reader);
  }

  /**
   * Handles reading a chaos game description from the given reader.
   *
   * @param reader The reader to read from
   */
  private ChaosGameDescription handleRead(Reader reader) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(reader);
    var minCoords = Vector2D.fromString(bufferedReader.readLine());
    var maxCoords = Vector2D.fromString(bufferedReader.readLine());

    List<Transform2D> transformations = new ArrayList<>();

    while (true) {
      String transformation = bufferedReader.readLine();
      if (transformation == null) {
        break;
      }

      var parts = bufferedReader.readLine().split(", ");

      if (transformation.equals(JuliaTransform.class.getSimpleName())) {
        var point = Complex.fromString(parts[0]);

        transformations.add(new JuliaTransform(point));
      } else {
        var matrix = Matrix2x2.fromString(parts[0]);
        var vector = Vector2D.fromString(parts[1]);

        transformations.add(new AffineTransform2D(matrix, vector));
      }
    }

    return new ChaosGameDescription(minCoords, maxCoords, transformations);
  }

  /**
   * Write a chaos game description to a file.
   *
   * @param description The description to write
   * @param name        The name of the file (without the extension)
   * @throws IOException If the file could not be written
   */
  public void writeToFile(ChaosGameDescription description, String name) throws IOException {
    FileWriter writer = new FileWriter(getPathFromName(name));
    handleWrite(writer, description);
  }

  /**
   * Write a chaos game description to a string.
   *
   * @param description The description to write
   * @return The serialized description
   * @throws IOException If the description could not be written
   */
  public String writeToString(ChaosGameDescription description) throws IOException {
    StringWriter writer = new StringWriter();
    handleWrite(writer, description);
    return writer.toString();
  }

  /**
   * Handles writing the given description to the writer.
   *
   * @param writer      The writer to write to
   * @param description The description to write
   * @throws IOException If the description could not be written
   */
  private void handleWrite(Writer writer, ChaosGameDescription description) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(writer);
    bufferedWriter.write(description.getMinCoords().toSerializedString());
    bufferedWriter.newLine();
    bufferedWriter.write(description.getMaxCoords().toSerializedString());
    bufferedWriter.newLine();

    for (Transform2D transform : description.getTransforms()) {
      bufferedWriter.write(transform.toSerializedString());
      bufferedWriter.newLine();
    }

    bufferedWriter.close();
  }

  /**
   * Get a list of all saved games on disk.
   *
   * @return A list of all filenames without extension.
   */
  public List<String> getSavedGames() {
    List<String> savedGames = new ArrayList<>();
    try (Stream<Path> paths = Files.walk(Paths.get(BASE_PATH))) {
      paths.filter(Files::isRegularFile).forEach(
          game -> savedGames.add(game.getFileName().toString().replace(FILE_EXTENSION, "")));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return savedGames;
  }

  /**
   * Delete a file with the given name.
   *
   * @param game The name of the file to delete (without extension)
   */
  public void deleteFile(String game) {
    try {
      Files.delete(Paths.get(BASE_PATH + game + FILE_EXTENSION));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
