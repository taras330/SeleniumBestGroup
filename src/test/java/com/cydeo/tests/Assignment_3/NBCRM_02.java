package com.cydeo.tests.Assignment_3;

import com.cydeo.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NBCRM_02 {

     /*
    ->> 1. Open website / go to login page
    ->> 2. Enter valid  username
    ->> 3. Enter invalid password
    ->> 4. Click "Log in" button
    ->> 5. User should see a message
"Incorrect login or password"
     */

    public static void main(String[] args) throws InterruptedException {

        String appUrl = "https://login2.nextbasecrm.com/";
        String userName = "helpdesk12@cybertekschool.com";
        String password = "CydeoUser";
        String expectedErrorMessage = "Incorrect login or password";

        // ->> 1. Open website / go to login page login2.nextbasecrm.com
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(appUrl);

        // ->> 2. Enter valid  username: helpdesk12@cybertekschool.com
        // <input class="login-inp" type="text" name="USER_LOGIN" placeholder="Login" value="" maxlength="255">
        driver.findElement(By.xpath("//input[@ name='USER_LOGIN']")).sendKeys(userName);
        // driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk12@cybertekschool.com");

        Thread.sleep(2000);

        //    ->> 3. Enter invalid password:
        // <input class="login-inp" type="password" name="USER_PASSWORD" placeholder="Password" maxlength="255">
        driver.findElement(By.cssSelector("input[ name='USER_PASSWORD']")).sendKeys(password);
        //driver.findElement(By.xpath("//input[@ name='USER_PASSWORD']")).sendKeys("CydeoUser");

        Thread.sleep(2000);

        //    ->> 4. Click "Log in" button
        WebElement logInButton = driver.findElement(By.cssSelector("input[type='submit']"));
        logInButton.click();

        //    ->> 5. User should see a message "Incorrect login or password"
        //  <div class="errortext">Incorrect login or password<br></div>
        WebElement errorText = driver.findElement(By.cssSelector("div[class='errortext']"));


        String actualErrorMessage = errorText.getText();

        if (actualErrorMessage.equals(expectedErrorMessage)){
            System.out.println("PASSED: user was not able to Log In and see \"Incorrect login or password\" message");

        } else {
            System.out.println("FAIL: user was able to Log In or did not see \"Incorrect login or password\" message");
        }

        Thread.sleep(3000);

        driver.quit();

    }
}
