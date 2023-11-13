package partners;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.practice.Payload.PartnersPayload;
import com.practice.base.TestBase;
import com.practice.restclient.RestClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class partnerSwitchAPITest extends TestBase {

    Response signAPIResponse = null;
    Response switchAPIResponse = null;
    DocumentContext jsonContext;
    public String signInApiURL = TestBase.partnerServiceBaseURL()+"/authentication/sign-in";
    public String switchApiURL = TestBase.partnerServiceBaseURL()+"/session/switch";
    @Test
    public void switchAPITest()
    {
        String signature = "";
        String requestSignInPayload = PartnersPayload.generateSignInRequestBody();
        String requestSwitchAPIPayload= PartnersPayload.generateSwitchAPIRequestBody();
        if(requestSwitchAPIPayload!=null)
        {
            signAPIResponse = RestClient.jsonClientPartnersSignInPOST(signInApiURL,requestSignInPayload);
            if(signAPIResponse!=null)
            {
                jsonContext = JsonPath.parse(signAPIResponse.getBody().prettyPrint());
                signature = jsonContext.read("$.value.signature");
                switchAPIResponse=RestClient.jsonClientPartnersSwitchAPIPOST(switchApiURL,requestSwitchAPIPayload,signature);
                if(switchAPIResponse!=null)
                {
                    Assert.assertEquals(switchAPIResponse.getStatusCode(),TestBase.statusCode_200OK);
                }
            }
        }
    }
}
