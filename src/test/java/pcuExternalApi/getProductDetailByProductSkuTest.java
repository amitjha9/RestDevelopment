package pcuExternalApi;

import com.practice.base.TestBase;
import com.practice.restclient.PcuExternalAPIRestClient;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.Properties;

public class getProductDetailByProductSkuTest extends TestBase{

    public static Response response = null;
    public static Properties properties;
    public static String pcuExternalBaseUrl = TestBase.pcuExternalServiceBaseURL();

    @Test
    public void validateGetProductDetailByProductSkuTest()
    {
        properties = TestBase.loadTestDataProperty();
        String serviceEndPoint = pcuExternalBaseUrl+"/products/"+properties.getProperty("productSku")+"/detail";
        response = PcuExternalAPIRestClient.jsonClientPcuExternalGET(serviceEndPoint);
        System.out.println("Response:" +response.getBody().prettyPrint());
    }
}
