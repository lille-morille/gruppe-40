package no.ntnu.idi.stud.serialization;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;
import no.ntnu.idi.stud.model.ChaosGameDescription;
import no.ntnu.idi.stud.model.Matrix2x2;
import no.ntnu.idi.stud.model.Vector2D;
import no.ntnu.idi.stud.transformation.AffineTransform2D;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChaosGameFileHandlerTest {
  ChaosGameFileHandler fileHandler;

  @BeforeEach
  void setUp() {
    fileHandler = new ChaosGameFileHandler();
  }

  @AfterEach
  void tearDown() {
    fileHandler = null;
  }

  @Test
  void readFromString() throws IOException {
    var input = """
        0.0,0.0
        1.0,1.0
        AffineTransform2D
        0.5,0.0,0.0,0.5, 0.0,0.0
        AffineTransform2D
        0.5,0.0,0.0,0.5, 0.25,0.5
        AffineTransform2D
        0.5,0.0,0.0,0.5, 0.5,0.0
        """;

    var correctDescription =
        new ChaosGameDescription(new Vector2D(0.0, 0.0), new Vector2D(1.0, 1.0), List.of(
            new AffineTransform2D(new Matrix2x2(0.5, 0.0, 0.0, 0.5), new Vector2D(0.0, 0.0)),
            new AffineTransform2D(new Matrix2x2(0.5, 0.0, 0.0, 0.5), new Vector2D(0.25, 0.5)),
            new AffineTransform2D(new Matrix2x2(0.5, 0.0, 0.0, 0.5), new Vector2D(0.5, 0.0))));

    var parsedDescription = fileHandler.readFromString(input);

    assertEquals(correctDescription.getMaxCoords(), parsedDescription.getMaxCoords());
    assertEquals(correctDescription.getMinCoords(), parsedDescription.getMinCoords());

    for (int i = 0; i < correctDescription.getTransforms().size(); i++) {
      // Use serialized string to compare the two transforms
      assertEquals(correctDescription.getTransforms().get(i).toSerializedString(),
          parsedDescription.getTransforms().get(i).toSerializedString());
    }
  }

  @Test
  void writeToString() throws IOException {
    var description = new ChaosGameDescription(new Vector2D(0.0, 0.0), new Vector2D(1.0, 1.0),
        List.of(new AffineTransform2D(new Matrix2x2(0.5, 0.0, 0.0, 0.5), new Vector2D(0.0, 0.0)),
            new AffineTransform2D(new Matrix2x2(0.5, 0.0, 0.0, 0.5), new Vector2D(0.25, 0.5)),
            new AffineTransform2D(new Matrix2x2(0.5, 0.0, 0.0, 0.5), new Vector2D(0.5, 0.0))));

    var correctOutput = """
        0.0,0.0
        1.0,1.0
        AffineTransform2D
        0.5,0.0,0.0,0.5, 0.0,0.0
        AffineTransform2D
        0.5,0.0,0.0,0.5, 0.25,0.5
        AffineTransform2D
        0.5,0.0,0.0,0.5, 0.5,0.0
        """;

    var output = fileHandler.writeToString(description);
    assertEquals(correctOutput, output);
  }
}
