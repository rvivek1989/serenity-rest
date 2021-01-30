package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.steps.GenericFeatureSteps;

import java.util.ArrayList;
import java.util.List;

public class GenericFeatureStepDefinitions {

    private static int HTTPS_OK = 200;
    ArrayList<String> emailIds = new ArrayList<>();

    @Steps
    GenericFeatureSteps genericFeatureSteps;

    @Given("the username {string} exists")
    public void theUsernameExists(String userName) {
        genericFeatureSteps.getUser(userName);
        genericFeatureSteps.checkResponse(HTTPS_OK);
    }

    @When("I check the comments on the posts made by the user")
    public void iCheckTheCommentsOnThePostsMadeByTheUser() {
        int userId = genericFeatureSteps.getUserId();
        List<Integer> postIds = genericFeatureSteps.getPosts(userId);
        postIds.forEach((postId) ->
                emailIds.addAll(genericFeatureSteps.getCommentEmail(postId)));
    }

    @Then("the email IDs in all the comments should be valid")
    public void theEmailIDsInAllTheCommentsShouldBeValid() {
        emailIds.forEach((email) ->
                genericFeatureSteps.validateEmail(email));
    }

}
