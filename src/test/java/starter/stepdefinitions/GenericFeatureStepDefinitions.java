package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.steps.GenericFeatureSteps;

public class GenericFeatureStepDefinitions {

    @Steps
    GenericFeatureSteps genericFeatureSteps;

    @Given("the username {string} exists")
    public void theUsernameExists(String userName) {
    }

    @When("I check the comments on the posts made by the user")
    public void iCheckTheCommentsOnThePostsMadeByTheUser() {
    }

    @Then("the emailIDs in all the comments should be valid")
    public void theEmailIDsInAllTheCommentsShouldBeValid() {
    }
}
