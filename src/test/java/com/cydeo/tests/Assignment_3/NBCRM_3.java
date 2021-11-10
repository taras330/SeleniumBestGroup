package com.cydeo.tests.Assignment_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NBCRM_3 {
    /*
    TC # 3 Marketing11 login to Next Base CRM with valid data
   1. GIVEN Open website /
   2. go to login page https://login2.nextbasecrm.com/
   3. WHEN user enter username: marketing11@cybertekschool.com
   4. AND user enter pasword: UserUser
   5. Then user click bttn
   6. Then user on the home

     */

    public static void main(String[] args) throws InterruptedException {


        //SETUP THE BROWSER DRIVER
        WebDriverManager.chromedriver().setup();

        //1. Open Chrome browser
        WebDriver driver = new ChromeDriver();

        //maximize the page
        driver.manage().window().maximize();

        //2. Go to https://login2.nextbasecrm.com/
        driver.get("https://login2.nextbasecrm.com/");

        //3.Enter correct username
        driver.findElement(By.name("USER_LOGIN")).sendKeys("marketing11@cybertekschool.com");

        // 4. AND user enter pasword: UserUser
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser" );

        //5. Then user click bttn
        WebElement searchLogin = driver.findElement(By.cssSelector("input[value='Log In']"));
        searchLogin.click();
        Thread.sleep(2000);
        String expectedUrl = "https://login2.nextbasecrm.com/stream/?login=yes";

        String actualUrl = driver.getCurrentUrl();
        // System.out.println(actualUrl);

        if(expectedUrl.equals(actualUrl)){
            System.out.println("Pass: User log in");
        }else{
            System.out.println("Fail: Login Fail");
        }
        driver.quit();

    }

}
