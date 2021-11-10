package com.cydeo.tests.Assignment_3;

import com.cydeo.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NBCRM_04 {
    public static void main(String[] args) throws InterruptedException {

        /*
GIVEN Open website / go to login page
WHEN user enter username
AND user enter pasword
Then user click bttn
Then user on the home
         */

        /*

        "1.Next Base CRM login page should be open /display
User should be on the login page successfully "
2. hr12  user should able to enter and type username on the input box
3. hr12  user should able to enter and type password on the input box
4. hr12 user should be able to click the "Login" button
"5.User should NOT able to login
User is still on the login page
User should see a message : ""Incorrect login or password."" "
         */


        //Open Chrome Browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
       driver.manage().window().maximize();

        // 1.Open login pane on browser
        String url = "https://login2.nextbasecrm.com";
        driver.get(url);

        String correctUserName = "marketing12@cybertekschool.com";
        String incorrectPassword = "apple123";

        //2. Enter and type username on the input box
        driver.findElement(By.name("USER_LOGIN")).sendKeys(correctUserName);

        //3.Enter and type  incorrect password on the input box
        driver.findElement(By.cssSelector("input[name='USER_PASSWORD']")).sendKeys(incorrectPassword);

        Thread.sleep(2000);

        //4.click the "Login" button
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //5. User should see a message : "Incorrect login or password"
        WebElement message = driver.findElement(By.xpath("//div[@class='errortext']"));

        String actualMessage = message.getText();
        String expectedMessage = "Incorrect login or password";

        Thread.sleep(2000);

        System.out.println("Actual message on the screen: " + actualMessage);

        if(actualMessage.equals(expectedMessage)){
            System.out.println("PASS: user entered incorrect password");
        }else {
            System.out.println("FAIL: user entered either correct credentials or any other issue occurred");
        }

        Thread.sleep(1234);
        driver.quit();




    }

}
