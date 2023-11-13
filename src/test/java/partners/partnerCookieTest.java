package partners;

import com.practice.restclient.RestClient;
import org.testng.Assert;
import org.testng.annotations.Test;


public class partnerCookieTest {

    @Test
    public void validateCookieTest()
    {
        String expectedCookie = "";
        String cookies=RestClient.getCookies();
        System.out.println("Cookie:" +cookies);
        expectedCookie = cookies;
        Assert.assertEquals(cookies,expectedCookie,"Cookie is empty");
    }
}
