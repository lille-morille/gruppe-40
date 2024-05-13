package no.ntnu.idi.stud.serialization;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import no.ntnu.idi.stud.model.ChaosGameDescription;
import no.ntnu.idi.stud.model.Complex;
import no.ntnu.idi.stud.model.Matrix2x2;
import no.ntnu.idi.stud.model.Vector2D;
import no.ntnu.idi.stud.transformation.AffineTransform2D;
import no.ntnu.idi.stud.transformation.JuliaTransform;
import no.ntnu.idi.stud.transformation.Transform2D;

public class ChaosGameFileHandler {
  static final String FILE_EXTENSION = ".txt";
  static final String BASE_PATH = "games/";

  public ChaosGameDescription readFromFile(String name) throws IOException {
    String fullPath = BASE_PATH + name + FILE_EXTENSION;
    try (BufferedReader reader = new BufferedReader(new FileReader(fullPath))) {
      var minCoords = Vector2D.fromString(reader.readLine());
      var maxCoords = Vector2D.fromString(reader.readLine());

      List<Transform2D> transformations = new ArrayList<>();

      while (true) {
        String transformation = reader.readLine();
        System.out.println(transformation);
        if (transformation == null) {
          break;
        }

        var parts = reader.readLine().split(", ");

        if (transformation.equals(JuliaTransform.class.getSimpleName())) {
          var point = Complex.fromString(parts[0]);

          transformations.add(new JuliaTransform(point));
        } else {
          System.out.println(Arrays.toString(parts));
          var matrix = Matrix2x2.fromString(parts[0]);
          var vector = Vector2D.fromString(parts[1]);

          transformations.add(new AffineTransform2D(matrix, vector));
        }

      }

      ChaosGameDescription description =
          new ChaosGameDescription(minCoords, maxCoords, transformations);

      System.out.println(description);

      return description;

    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  public void writeToFile(ChaosGameDescription description, String name) throws IOException {
    String fullPath = BASE_PATH + name + FILE_EXTENSION;

    FileWriter writer = new FileWriter(fullPath);
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

  public void deleteFile(String game) {
    try {
      Files.delete(Paths.get
          (BASE_PATH + game + FILE_EXTENSION));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
