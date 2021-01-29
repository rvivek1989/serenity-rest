Feature: Generic features

  Scenario: Validation on email IDs of the comments posted by the users
    Given the username "Delphine" exists
    When I check the comments on the posts made by the user
    Then the emailIDs in all the comments should be valid