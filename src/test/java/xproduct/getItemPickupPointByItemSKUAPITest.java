package xproduct;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.practice.Payload.XproductAPIPayload;
import com.practice.base.TestBase;
import com.practice.restclient.XproductAPIRestClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class getItemPickupPointByItemSKUAPITest extends TestBase {

    public static String xProductBaseUrl = TestBase.xProductServiceBaseURL();
    public static String requestPayload;
    public static Response xproductApiResponse;
    public static DocumentContext jsonContext;


    @Test
    public void validateItemPickUpPointByItemSKUAPITest()
    {
        String pickupPointCode="";
        String apiEndPoint = xProductBaseUrl+"/"+"listing"+"/"+"getItemPickupPointsByItemSku";
        requestPayload = XproductAPIPayload.generateItemPickupPointByItemSKUPayload();
        if(requestPayload!=null)
        {
            xproductApiResponse = XproductAPIRestClient.jsonClientPostItemPickupPointByItemSKU(requestPayload,apiEndPoint);
            if(xproductApiResponse!=null)
            {
                int statusCode = xproductApiResponse.getStatusCode();
                Assert.assertEquals(statusCode,TestBase.statusCode_200OK);

                jsonContext = JsonPath.parse(xproductApiResponse.getBody().prettyPrint());
                pickupPointCode = jsonContext.read("$.content[1].pickUpPointCode");
                Assert.assertEquals(pickupPointCode,"PP-3410275");
            }
        }
    }
}
