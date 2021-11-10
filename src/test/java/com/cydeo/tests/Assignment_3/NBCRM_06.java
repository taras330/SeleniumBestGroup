package com.cydeo.tests.Assignment_3;

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

    public static void OpenLogin(){
        driver.manage().window().maximize();
        String url = "https://login2.nextbasecrm.com/";
        driver.get(url);
    }

    public static void EnterTextIntoInputBox(String inputBox, String Text){
        driver.findElement(By.name(inputBox)).sendKeys(Text);
    }

    public static void LogInClick(){
        driver.findElement(By.xpath("//*[@value='Log In']")).click();
    }

    public static void AssertIncorrectLoginMessage(String expectedErrMsg){
        String actualErrorMessage = driver.findElement(By.xpath
                ("//div[normalize-space(text()) = 'Incorrect login or password']")).getText();
        System.out.println(actualErrorMessage);
        if (actualErrorMessage.contains(expectedErrMsg)){
            System.out.println("PASSED: user was not able to Log In and see \"Incorrect login or password\" message");
        } else{
            System.out.println("FAIL: user was able to Log In or did not see \"Incorrect login or password\" message");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        String userName = "hr12@cybertekschool.com";
        String password = "user123";
        String expectedErrorMessage = "Incorrect login or password";

        // ->> 1. Open website / go to login page login2.nextbasecrm.com
        OpenLogin();

        // ->> 2. Enter valid  username: hr12@cybertekschool.com
        // <input class="login-inp" type="text" name="USER_LOGIN" placeholder="Login" value="" maxlength="255">
        EnterTextIntoInputBox("USER_LOGIN", userName);
        Thread.sleep(2000);

        // ->> 3. Enter invalid password:
        // <input class="login-inp" type="password" name="USER_PASSWORD" placeholder="Password" maxlength="255">
        EnterTextIntoInputBox("USER_PASSWORD", password);
        Thread.sleep(2000);

        // ->> 4. Click "Log in" button
        // <input type="submit" value="Log In" class="login-btn" onclick="BX.addClass(this, 'wait');">
        LogInClick();

        //    ->> 5. User should see a message "Incorrect login or password"
        //  <div class="errortext">Incorrect login or password<br></div>
        AssertIncorrectLoginMessage(expectedErrorMessage);

        Thread.sleep(3000);

        driver.quit();

    }
}
