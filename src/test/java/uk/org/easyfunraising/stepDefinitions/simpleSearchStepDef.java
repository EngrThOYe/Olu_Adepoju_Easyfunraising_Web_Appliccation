package uk.org.easyfunraising.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uk.org.easyfunraising.pages.BasePage;
import uk.org.easyfunraising.pages.CausePage;
import uk.org.easyfunraising.pages.HomePage;
import uk.org.easyfunraising.pages.SearchPage_cause;

public class simpleSearchStepDef extends BasePage {
    HomePage homePage = new HomePage(driver);
    SearchPage_cause searchPage_cause = new SearchPage_cause(driver);
    CausePage causePage = new CausePage(driver);

    @Given("I navigate to {string} for Easyfunraising")

    public void i_navigate_to_for_easyfunraising(String Url) {
        NavigateToUrl(Url);
        homePage.assertHomePage();
        homePage.acceptCookies();
    }

    @When("I click on the search for a cause textbox")
    public void i_click_on_the_search_for_a_cause_textbox() {
        homePage.clickSearchTextbox();

    }

    @When("I enter cause name as {string}")
    public void i_enter_cause_name_as(String Cause_Name) {
        homePage.enterCauseName(Cause_Name);

    }

    @When("I click on the Search button")
    public void i_click_on_the_search_button() throws InterruptedException {
        homePage.clickSearchButton();
        Thread.sleep(2000);

    }

    @When("the cause Search page is displayed")
    public void the_cause_search_page_is_displayed() {
        searchPage_cause.assertSearchPage();

    }

    @And("I click on the cause listed in number {int} on the search result list")
    public void iClickOnTheCauseListedInNumberItem_noOnTheSearchResultList(Integer Item_no) throws InterruptedException {
        searchPage_cause.clickCauseFromList(Item_no);

    }

    @Then("the selected cause page is displayed")
    public void the_selected_cause_page_is_displayed() {
        causePage.assertCausePage();

    }

    @Then("the title for the cause is printed_out")
    public void the_title_for_the_cause_is_printed_out() {
        causePage.printedOutTheCauseTitle();

    }


}
