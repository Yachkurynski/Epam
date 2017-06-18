package websiteSerfer.instructionReader;

import java.util.List;

/**
 * Parent class for instruction readers from some source.
 */
public abstract class InstructionReader {
  /**
   * Reads instructions from some source.
   * @return collection of string instructions.
   */
  public abstract List<String> readInstructions();
}
