package taskDev3.peopleData;

import java.util.*;
import java.io.*;

/**
 * Reads need data from console.
 */
class ConsoleReader {
  private static final String ENTER_ASK = "Enter person's ";
  private static final String NAME = "name: ";
  private static final String SURNAME = "surname: ";
  private static final String AGE = "age: ";
  private static final String SEX = "sex (w|m): ";
  private static final String ENTER_CORRECT_ASK = "Enter correct ";
  private static final String MEN_SYMB = "m";
  private static final String WOMEN_SYMB = "w";
  private static final char SYMB_A = 'a';
  private static final char SYMB_Z = 'z';
  private static final char SYMB_DASH = '-';
  private static final int SURNAME_NUM = 0;
  private static final int NAME_NUM = 1;
  private static final int SEX_NUM = 2;
  private static final int AGE_NUM = 3;
  private static final int ARRAY_SIZE = 4; // For 4 parameters: surname, name, sex, age.
  
  /**
   * Returns a read string.
   * 
   * @return input information.
   */
  public String[] readFromConsole() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String[] persInform = new String[ARRAY_SIZE];
    boolean needRepeat = true;

    do {
      System.out.print(ENTER_ASK + SURNAME);
      persInform[SURNAME_NUM] = reader.readLine();
      
      if (checkString(persInform[SURNAME_NUM])) {
        continue;
      }
      System.out.print(ENTER_ASK + NAME);
      persInform[NAME_NUM] = reader.readLine();
      
      if (checkString(persInform[NAME_NUM])) {
        continue;
      }
      System.out.print(ENTER_ASK + SEX);
      persInform[SEX_NUM] = reader.readLine();
      
      if (!(persInform[SEX_NUM].toLowerCase().equals(WOMEN_SYMB) || persInform[SEX_NUM].toLowerCase().equals(MEN_SYMB))) { 
        System.out.println(ENTER_CORRECT_ASK + SEX);
        continue;
      } 
      System.out.print(ENTER_ASK + AGE);
      persInform[AGE_NUM] = reader.readLine();
      
      try {
        Integer.parseInt(persInform[AGE_NUM]);
      } catch (NumberFormatException ex) {
        System.out.println(ENTER_CORRECT_ASK + AGE);
        continue;
      }
      needRepeat = false;
    } while (needRepeat);
    return persInform;
  }
  
  /**
   * Checks that string consists only from letters and "-".
   * 
   * @param str - string to check
   * @return true, if string is incorrect.
   */
  private boolean checkString(String str) {
    boolean needRepeat = false;
    char[] chArray = str.toLowerCase().toCharArray();

    if (chArray.length == 0) {
      needRepeat = true;
    } else {
      for (int i = 0; i < chArray.length; i++) {
        if ((chArray[i] < SYMB_A || chArray[i] > SYMB_Z) && chArray[i] != SYMB_DASH) {
          System.out.println(ENTER_CORRECT_ASK + NAME);
          needRepeat = true;
        }
      }
    }
    return needRepeat;
  }
}