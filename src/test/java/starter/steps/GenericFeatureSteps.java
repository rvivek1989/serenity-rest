package starter.steps;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.validator.routines.EmailValidator;
import org.junit.Assert;
import starter.WebServiceEndPoints;
import starter.utils.ReuseableSpecifications;

import java.util.List;

public class GenericFeatureSteps {

    private static String USERS = WebServiceEndPoints.USERS.getUrl();
    private static String POSTS = WebServiceEndPoints.POSTS.getUrl();
    private static String COMMENTS = WebServiceEndPoints.COMMENTS.getUrl();
    EmailValidator validator = EmailValidator.getInstance();

    @Step("Get the user with username {0} from the user end point")
    public void getUser(String userName) {
        SerenityRest.given()
                .queryParam("username", userName)
                .spec(ReuseableSpecifications.getGenericRequestSpec())
                .get(USERS);
    }

    @Step("Check whether the response is {0}")
    public void checkResponse(int response) {
        SerenityRest.then()
                .spec(ReuseableSpecifications.getGenericResponseSpec())
                .statusCode(response);
    }

    @Step("Get the user ID from the last response")
    public int getUserId() {
        return SerenityRest.lastResponse()
                .then()
                .extract()
                .path("id[0]");
    }

    @Step("Get the post IDs of the user with user ID : {0}")
    public List<Integer> getPosts(int userId) {
        return SerenityRest.given()
                .queryParam("userId", userId)
                .spec(ReuseableSpecifications.getGenericRequestSpec())
                .get(POSTS)
                .then()
                .extract()
                .jsonPath()
                .get("id");
    }

    @Step("Get the email IDs of the comment with post ID : {0}")
    public List<String> getCommentEmail(int postId) {
        return SerenityRest.given()
                .queryParam("postId", postId)
                .spec(ReuseableSpecifications.getGenericRequestSpec())
                .get(COMMENTS)
                .then()
                .extract()
                .jsonPath()
                .get("email");
    }

    @Step("Validate the email ID : {0}")
    public void validateEmail(String email) {
        Assert.assertTrue(validator.isValid(email));
    }

}
