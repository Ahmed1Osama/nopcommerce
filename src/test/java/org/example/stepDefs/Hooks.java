package org.example.stepDefs;

import io.cucumber.core.gherkin.Feature;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver = null;


    @Before
    public static void openBrowser(){
        // set Property
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Toshiba\\Desktop\\nopcommerce\\drivers\\chromedriver.exe");

        // create new object webdrive
        driver = new ChromeDriver();

        // configuration
        // maximize window
        driver.manage().window().maximize();
        // implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /// navigate to  URL
        driver.navigate().to("https://demo.nopcommerce.com/");


    }
    @After
    public static void quitBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
