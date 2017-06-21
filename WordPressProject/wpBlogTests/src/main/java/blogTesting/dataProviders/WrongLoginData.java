package blogTesting.dataProviders;

import org.testng.annotations.DataProvider;

/**
 * Data provider for authorization with wrong parameters.
 */
public class WrongLoginData {
  /**
   * Returns data for testing wrong admin authorization. Contains login and password.
   * @return data for authorization.
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
   * Returns data for testing wrong subscriber authorization. Contains login and password.
   * @return data for authorization.
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
