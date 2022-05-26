package uk.org.easyfunraising.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CausePage extends BasePage {
    public CausePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void assertCausePage() {
        int UniqueElementOnPage;
        UniqueElementOnPage = driver.findElements(By.xpath("//title[contains(text(),'Cause')]")).size();
        String expectedtitle = "Fundraising | Charity Fundraising Online | Easyfundraising";
        Assert.assertTrue(UniqueElementOnPage > 0);
    }

    public void printedOutTheCauseTitle() {
        String PageTitle = driver.getTitle();
        System.out.println(PageTitle);
    }

}
