package com.cydeo.tests.Assignment_3;

import com.cydeo.utils.AutomationUtils;
import com.cydeo.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NBCRM_06 {

    /*
    ->> 1. Open website / go to login page
    ->> 2. Enter valid  username
    ->> 3. Enter invalid password
    ->> 4. Click "Log in" button
    ->> 5. User should see a message
"Incorrect login or password"
     */

    static WebDriver driver = WebDriverFactory.getDriver("chrome");

    public static void main(String[] args) throws InterruptedException {

        String userName = "hr12@cybertekschool.com";
        String password = "user123";
        String expectedErrorMessage = "Incorrect login or password";

        // ->> 1. Open website / go to login page login2.nextbasecrm.com
        AutomationUtils.OpenLogin("https://login2.nextbasecrm.com/", driver);

        // ->> 2. Enter valid  username: hr12@cybertekschool.com
        // <input class="login-inp" type="text" name="USER_LOGIN" placeholder="Login" value="" maxlength="255">
       AutomationUtils.EnterTextIntoInputBox("USER_LOGIN", userName, driver);
       // EnterTextIntoInputBox("USER_LOGIN", userName);
        Thread.sleep(2000);

        // ->> 3. Enter invalid password:
        // <input class="login-inp" type="password" name="USER_PASSWORD" placeholder="Password" maxlength="255">
        AutomationUtils.EnterTextIntoInputBox("USER_PASSWORD", password, driver);
        Thread.sleep(2000);

        // ->> 4. Click "Log in" button
        // <input type="submit" value="Log In" class="login-btn" onclick="BX.addClass(this, 'wait');">
        AutomationUtils.LogInClick(driver);

        //    ->> 5. User should see a message "Incorrect login or password"
        //  <div class="errortext">Incorrect login or password<br></div>
        AutomationUtils.AssertIncorrectLoginMessage(expectedErrorMessage, driver);

        Thread.sleep(3000);

        driver.quit();

    }
}
