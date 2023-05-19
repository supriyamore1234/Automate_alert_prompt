package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.awt.*;
///
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase16() {
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");

        driver.switchTo().frame("iframeResult");
        WebElement tryit = driver.findElement(By.xpath("//button[text()='Try it']"));
        tryit.click();

        driver.switchTo().alert().sendKeys("Supriya");

        driver.switchTo().alert().accept();

        WebElement message = driver.findElement(By.xpath("//p[@id='demo']"));
        String ss = message.getText();

        if (ss.contains("Supriya")) {
            System.out.println("Name is send successfully ");
        } else {
            System.out.println("Name is not send successfully ");
        }

    }
}
