package uk.org.easyfunraising.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchPage_cause extends BasePage {
    public SearchPage_cause(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void assertSearchPage() {
        String expectedtitle = "Search | easyfundraising";
        String actualtitle = driver.getTitle();
        Assert.assertEquals(actualtitle, expectedtitle);
    }

    private void searchForCauseOnSearchList(Integer Item_no) {
        int ResultList = 0;
        try {
            while (ResultList < Item_no) {
                driver.findElement(By.id("primarySearchResultsShowMore")).click();
                ResultList = driver.findElements(By.xpath("//div[contains(@id,'causesSearchItem')]")).size();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Item Not Found On The List");
        }
    }

    private void selectCauseOnSearchList(Integer Item_no) {
        Integer ItemToClick = Item_no - 1;
        driver.findElements(By.xpath("//div[contains(@id,'causesSearchItem')]")).get(ItemToClick).click();
    }

    public CausePage clickCauseFromList(Integer Item_no) throws InterruptedException {
        try {
            searchForCauseOnSearchList(Item_no);
            Thread.sleep(2000);
            selectCauseOnSearchList(Item_no);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Item Number " + Item_no + " Not Found");
        }
        return new CausePage(driver);

    }
}
