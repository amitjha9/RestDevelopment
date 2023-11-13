package partners;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.practice.Payload.PartnersPayload;
import com.practice.base.TestBase;
import com.practice.restclient.RestClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class partnerSignAPITest extends TestBase {

    Response response = null;
    DocumentContext jsonContext;
    @Test
    public void validateSignInTest()
    {
        String apiURL = TestBase.partnerServiceBaseURL()+"/authentication/sign-in";
        String requestSignInPayload=PartnersPayload.generateSignInRequestBody();
        if(requestSignInPayload!=null)
        {
            response = RestClient.jsonClientPartnersSignInPOST(apiURL,requestSignInPayload);
            jsonContext = JsonPath.parse(response.getBody().prettyPrint());
            Assert.assertEquals(jsonContext.read("$.value.username"),"amit.jha@gdn-commerce.com");
        }
    }
}
