Feature: Functionality of cause searching

  @test
  Scenario Outline: Opening of the Easyfunraising Cause page
    Given I navigate to "<Url>" for Easyfunraising
    When I click on the search for a cause textbox
    And I enter cause name as "<Cause_Name>"
    And I click on the Search button
    And the cause Search page is displayed
    And I click on the cause listed in number <Item_no> on the search result list
    Then the selected cause page is displayed
    And the title for the cause is printed_out



    Examples:
      | Url                                | Cause_Name | Item_no |
      | https://www.easyfundraising.org.uk | cause      | 12      |
