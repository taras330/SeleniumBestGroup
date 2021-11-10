package com.cydeo.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutomationUtils {

    public static void OpenLogin(String loginPage, WebDriver drv){
        drv.manage().window().maximize();
        drv.get(loginPage);
    }

    public static void EnterTextIntoInputBox(String inputBox, String Text, WebDriver drv){

        drv.findElement(By.name(inputBox)).sendKeys(Text);
    }

    public static void LogInClick(WebDriver drv){
        drv.findElement(By.xpath("//*[@value='Log In']")).click();
    }

    public static void AssertIncorrectLoginMessage(String expectedErrMsg, WebDriver drv){
        String actualErrorMessage = drv.findElement(By.xpath
                ("//div[normalize-space(text()) = 'Incorrect login or password']")).getText();
        System.out.println(actualErrorMessage);
        if (actualErrorMessage.contains(expectedErrMsg)){
            System.out.println("PASSED: user was not able to Log In and see \"Incorrect login or password\" message");
        } else{
            System.out.println("FAIL: user was able to Log In or did not see \"Incorrect login or password\" message");
        }
    }
}
