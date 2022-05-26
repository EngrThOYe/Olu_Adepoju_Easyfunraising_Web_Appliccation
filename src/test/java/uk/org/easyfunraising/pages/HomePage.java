package uk.org.easyfunraising.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void assertHomePage() {
        String expectedtitle = "Fundraising | Charity Fundraising Online | Easyfundraising";
        String actualtitle = driver.getTitle();
        Assert.assertEquals(actualtitle, expectedtitle);
    }

    public void acceptCookies() {
        driver.findElement(By.xpath("/html/body/div[1]/div/a")).click();
    }

    public void clickSearchTextbox() {
        driver.findElement(By.xpath("//*[@id=\"causeTerm\"]")).click();
    }

    public void enterCauseName(String Cause_Name) {
        driver.findElement(By.xpath("//*[@id=\"causeTerm\"]")).sendKeys(Cause_Name);
    }

    public SearchPage_cause clickSearchButton() {
        driver.findElement(By.id("causeSubmitSearch")).click();
        return new SearchPage_cause(driver);
    }

}
