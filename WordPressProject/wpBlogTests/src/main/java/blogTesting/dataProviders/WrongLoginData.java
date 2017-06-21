package blogTesting.dataProviders;

import org.testng.annotations.DataProvider;

/**
 * Data provider for authorization with wrong parameters.
 */
public class WrongLoginData {
  /**
   * Returns data with login and passwords for testing wrong admin authorization.
   * @return array of login and passwords.
   */
  @DataProvider(name = "getWrongAdminLoginData")
  public Object[][] getWrongAdminLoginData() {
    return new Object[][]{{"@%#|.", "testsForWp"},{"admin", "!e#s$h%f&d*)/"},
        {"логин", "testsForWp"}, {"admin", "пароль"}, {"", "testsForWp"}, {"admin", ""},
        {"ad mi n", "testsForWp"}, {"admin", "tests For Wp"}, {"login", "password"},
        {"ItsAVeryBigLoginForCheckingHowDoesTheSystemReactToSuchLongLoginIThinkThatsEnoughForThis",
            "testsForWp"}, {"admin", "ItsAVeryBigPasswordForCheckingHowDoesTheSystemReactToSuchLong"
        + "PasswordTextWasCopiedFromBigLoginIThinkThatsEnoughForThisTest"}};
  }

  /**
   * Returns data with login and passwords for testing wrong subscriber authorization.
   * @return array of login and passwords.
   */
  @DataProvider(name = "getWrongSubscriberLoginData")
  public Object[][] getWrongSubscriberLoginData() {
    return new Object[][]{{"@%#|.", "subscriberUser"}, {"subscriber", "!e#s$h%f&d*)/"},
        {"логин", "subscriberUser"}, {"subscriber", "пароль"}, {"", "subscriberUser"},
        {"subscriber", ""}, {"subs criber", "subscriberUser"}, {"subscriber", "subscriber User"},
        {"login", "password"}, {"ItsAVeryBigLoginForCheckingHowDoesTheSystemReactToSuchLongLoginI"
        + "ThinkThatsEnoughForThis", "subscriberUser"}, {"subscriber", "AVeryBigPasswordForChecking"
        + "HowDoesTheSystemReactToSuchPasswordTextWasCopiedFromBigLoginIThinkThatsEnoughForThis"}};
  }
}
