package xproduct;

import com.practice.Payload.XproductAPIPayload;
import com.practice.base.TestBase;
import com.practice.restclient.XproductAPIRestClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class getItemPickupPointSummaryAPITest extends TestBase {

    public static String xProductBaseUrl = TestBase.xProductServiceBaseURL();
    public static String requestPayload;
    public static Response xproductApiResponse;

    @Test
    public void validateItemPickupPointSummaryAPI()
    {
        String apiEndPoint = xProductBaseUrl+"/"+"listing"+"/"+"getItemPickupPointSummary";
        requestPayload = XproductAPIPayload.generateItemPickupPointSummaryPayload();
        if(requestPayload!=null)
        {
            xproductApiResponse = XproductAPIRestClient.jsonClientPostItemPickupPointSummary(requestPayload,apiEndPoint);
            if(xproductApiResponse!=null)
            {
                int statusCode = xproductApiResponse.getStatusCode();
                Assert.assertEquals(statusCode,TestBase.statusCode_200OK);
            }
        }
    }
}
