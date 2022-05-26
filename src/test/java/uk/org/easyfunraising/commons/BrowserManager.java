package uk.org.easyfunraising.commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class BrowserManager extends DriverManager {
    private WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();

    }

    private WebDriver initEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    private WebDriver initChromeHeadless() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "--headless");
        return new ChromeDriver(options);
    }

    private WebDriver initFireFoxHeadless() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-gpu", "--headless");
        return new FirefoxDriver(options);
    }

    private WebDriver initEdgeHeadless() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-gpu", "--headless");
        return new EdgeDriver(options);
    }

    public void launchBrowser(String browser) {
        switch (browser) {
            case "Chrome":
                driver = initChromeDriver();
                break;
            case "Firefox":
                driver = initFirefoxDriver();
                break;
            case "Edge":
                driver = initEdgeDriver();
                break;
            case "ChromeHeadless":
                driver = initChromeHeadless();
                break;
            case "FirefoxHealess":
                driver = initFireFoxHeadless();
                break;
            case "EdgeHeadless":
                driver = initEdgeHeadless();
                break;
            default:
                driver = initChromeDriver();
                break;
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public void closeBrowser() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
