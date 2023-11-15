package pcuExternalApi;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.practice.base.TestBase;
import com.practice.restclient.PcuExternalAPIRestClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

public class getBusinessPartnerProfileByIdTest extends TestBase {

    public static Properties properties;
    public static Response response = null;
    public static DocumentContext jsonContext;
    public static String pcuExternalBaseUrl = TestBase.pcuExternalServiceBaseURL();

    @Test
    public void validateGetBusinessPartnerProfileByIdTest()
    {
        properties = TestBase.loadTestDataProperty();
        String serviceEndPoint = pcuExternalBaseUrl+"/productBusinessPartners/getBusinessPartnerProfileById";
        response = PcuExternalAPIRestClient.jsonClientPcuExternalGET(serviceEndPoint);
        Assert.assertEquals(response.getStatusCode(),TestBase.statusCode_200OK);

        jsonContext = JsonPath.parse(response.getBody().prettyPrint());
        boolean official = jsonContext.read("$.value.official");

        Assert.assertEquals(official,true);

    }
}
