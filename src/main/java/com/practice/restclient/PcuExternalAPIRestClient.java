package com.practice.restclient;

import com.practice.base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Example;
import java.util.Properties;

public class PcuExternalAPIRestClient extends TestBase {

    public static Logger log = Logger.getLogger(Example.class.getName());
    public static Properties prop;
    public static String apiCookie;
    public static Response jsonClientPcuExternalGET(String url)
    {
        Response response = null;
        try {
            prop = TestBase.loadTestDataProperty();
            apiCookie=RestClient.getCookies();
            RestAssured.baseURI = url;
            RequestSpecification httpRequest = RestAssured.given();
            httpRequest.header("Content-Type", "application/json");
            httpRequest.header("accept","application/json");
            httpRequest.header("Cookie",apiCookie);
            httpRequest.queryParam("isActive",prop.getProperty("isActive"));
            response = httpRequest.request(Method.GET,url);

            if(response.getStatusCode()!=TestBase.statusCode_201OK && response.getStatusCode()!=TestBase.statusCode_200OK)
            {
                log.info("API call failed with status code:" +response.getStatusCode()+ " and message:" +response.asString());
            }
            else
            {
                log.info("API call is success with HTTP status code:" +response.getStatusCode());
            }
        }
        catch (final Exception e)
        {
            throw new RuntimeException("API call Failed: HTTP status code:" +response.getStatusCode());
        }
        return response;
    }
}
