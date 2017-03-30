package mailLogin;

import org.testng.annotations.DataProvider;

/**
 * Describes data provider which contains login and passwords for testing wrong authorization.
 */
public class WrongAuthorizationData {

  /**
   * Returns data with login and passwords for testing wrong authorization.
   * @return array of login and passwords.
   */
  @DataProvider(name = "dataForNegativeAuthorization")
  public static Object[][] dataForNegativeAuthorization() {
    return new Object[][]{{"tat-13", "23.03.2017"}, {"tat-dev13", "23.17"},
        {"t@t$%13", "23.03.2017"}, {"tat-dev13", "@$%*^"},
        {"почта", "23.03.2017"}, {"tat-dev13", "пароль"},
        {"", "23.03.2017"}, {"tat-dev13", ""},
        {"tat - dev 13", "23.03.2017"}, {"tat-dev13", "23 03 2017"},
        {"ItsAVeryBigLoginForCheckingHowDoesTheSystemReactToSuchLongLoginIThinkThats"
            + "EnoughForThisTest", "23.03.2017"},
        {"tat-dev13", "ItsAVeryBigPasswordForCheckingHowDoesTheSystemReactToSuchLongPassword"
            + "TextWasCopiedFromBigLoginIThinkThatsEnoughForThisTest"}};
  }
}
