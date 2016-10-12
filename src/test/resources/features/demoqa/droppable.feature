Feature: Droppable

  Scenario: Dropping element
    Given I am on the Droppable page
    When I drag and drop element into the area
    Then I should see 'Dropped!' as the title of the area