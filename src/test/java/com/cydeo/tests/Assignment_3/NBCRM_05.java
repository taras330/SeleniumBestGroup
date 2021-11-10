package com.cydeo.tests.Assignment_3;

import com.cydeo.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NBCRM_05 {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        String url = "https://login2.nextbasecrm.com/";

        driver.manage().window().maximize();

        // GIVEN Open website / go to login page
        driver.get(url);

        String username = "hr11@cybertekschool.com";
        String password = "userNotUser";

        // WHEN user enter username
        driver.findElement(By.name("USER_LOGIN")).sendKeys(username);
        // AND user enter invalid pasword
        driver.findElement(By.name("USER_PASSWORD")).sendKeys(password);

        Thread.sleep(2000);

        // Then user click bttn
        driver.findElement(By.xpath("//input[@class='login-btn']")).click();

        // Then user get a message
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class = 'errortext']"));
        System.out.println("Message = " + errorMessage.getText());

        String expectedMessage = "Incorrect login or password";
        String actualMessage = errorMessage.getText();

        if(actualMessage.equals(expectedMessage)){
            System.out.println("PASS: user couldn't login");
        } else {
            System.out.println("FAIL: user could login");
        }

        // just testing

    }
}
