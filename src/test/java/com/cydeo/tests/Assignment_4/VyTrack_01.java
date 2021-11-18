package com.cydeo.tests.Assignment_4;

import com.cydeo.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class VyTrack_01 {

    /* Group 5:
       Truck Drivers: user13, user14, user15
       Store Manager: storemanager59, storemanager60
       Sales Manager: salesmanager113, salesmanager114, salesmanager115
       -->> Correct Password: UserUser123
    */

    public static void main(String[] args) throws InterruptedException {

        String appUrl = "http://qa2.vytrack.com/user/login";
        String userName = "user13";
        String password = "UserUser123";

        // ->> 1. Open website / go to login page
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(appUrl);

        Actions action = new Actions(driver);

        // ->> 2. Enter valid  username:
        driver.findElement(By.xpath("//input[@name='_username']")).sendKeys(userName);
        //    ->> 3. Enter valid password:
        driver.findElement(By.cssSelector("input[name='_password']")).sendKeys(password);
        //    ->> 4. Click "Log in" button
        WebElement logInButton = driver.findElement(By.cssSelector("button[type='submit']"));
        logInButton.click();

        // 1. Verify that truck driver should be able to see all Vehicle information once navigate to Vehicle page.
        // <li class="dropdown dropdown-level-1">
        Thread.sleep(5000);
        WebElement fleetPage = driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1']"));
        action.moveToElement(fleetPage).perform();
        // <span class="title title-level-2">Vehicles</span>
        Thread.sleep(5000);
        WebElement vehiclesButton = driver.findElement(By.xpath("//span[@class='title title-level-2']"));
        vehiclesButton.click();


        // 2.Verify that when user click on any car on the grid , system should display general information about the car

        Thread.sleep(5000);
        List<WebElement> gridTr = driver.findElements(By.xpath("//tr[@class='grid-row row-click-action']"));
        System.out.println("We have " + gridTr.size() + " grid results on this page");

        Thread.sleep(5000);
        gridTr.get(1).click();

        Thread.sleep(5000);
        WebElement isDisp = driver.findElement(By.xpath("//span[.='General Information']"));
        // WebElement isDisp = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/h5/span"));

        if (isDisp.isDisplayed()) {
            System.out.println("PASS: System displays general information about the car");
        } else {
            System.out.println("FAILED");
        }

        //driver.navigate().back();

        // 3.Verify that truck driver can add Event and it should display under Activity tab and General information page as well

        Thread.sleep(5000);
        WebElement addEvent = driver.findElement(By.xpath("//a[@title='Add an event to this record']"));
        addEvent.click();

        // Title FIELD
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@data-name='field__title']")).sendKeys("2021_November_Title");

        Thread.sleep(5000);
        driver.switchTo().frame(0);
        WebElement editable = driver.switchTo().activeElement();
        editable.sendKeys("2021_November_Title");
        driver.switchTo().defaultContent();

        // Organizer display name FIELD
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@data-name='field__organizer-display-name']")).sendKeys("2021_November_Name");

        // Organizer email FIELD
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@data-name='field__organizer-email']")).sendKeys("november2021@gmail.com");


        Thread.sleep(5000);
        WebElement saveButton = driver.findElement(By.xpath("//button[.='Save']"));
        saveButton.click();

        // DO NOT KNOW HOW TO CONTINUE THE AUTOMATION CODE FROM THIS POINT

        // 4.Verify that Truck driver can reset the setting


        // driver.quit();
    }
}
