package websiteSerfer.instructionReader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads instructions from text file.
 */
public class InstructionFileReader extends InstructionReader {
  private String fileName;

  /**
   * Creates instance for reading instructions from file.
   * @param fileName file's name.
   */
  public InstructionFileReader(String fileName) {
    this.fileName = fileName;
  }

  /**
   * Reads instructions from text file.
   * @return
   */
  @Override
  public List<String> readInstructions() {
    List<String> instructions = new ArrayList<>();
    String instruction;

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(
        fileName)))) {
      while((instruction = reader.readLine()) != null) {
        instructions.add(instruction);
      }
    } catch (IOException e) {
      System.out.println(e.getLocalizedMessage());
    }
    return instructions;
  }
}
