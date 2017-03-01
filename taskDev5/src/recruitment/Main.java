package recruitment;

/**
 * Employ the taem by entered parameters.
 */
public class Main {

  /**
   * Enter point to the program.
   *
   * @param args are not used.
   */
  public static void main(String[] args) {
    ConsoleReader reader = new ConsoleReader();
    Recruitment recruitment = new Recruitment();
    PrintResults printer = new PrintResults();

    printer.print(recruitment.recruit(reader.readWayOfRecruitment()));
  }
}
