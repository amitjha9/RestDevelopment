package com.practice.restclient;

import com.practice.base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Example;
import java.util.Properties;

public class XproductAPIRestClient extends TestBase {

    public static Logger log = Logger.getLogger(Example.class.getName());
    public static Properties prop;
    public static String apiCookie;
    public static RequestSpecification requestSpecification;

    public static Response jsonClientPostItemPickupPointListing(String requestBody,String url)
    {
        Response response = null;
        try {
            prop = TestBase.loadTestDataProperty();
            apiCookie = RestClient.getCookies();
            RestAssured.baseURI = url;
            requestSpecification = RestAssured.given();
            requestSpecification.header("Content-Type", "application/json");
            requestSpecification.header("accept","application/json");
            requestSpecification.header("Cookie",apiCookie);

            requestSpecification.queryParam("storeId",prop.getProperty("productStoreId"));
            requestSpecification.queryParam("channelId",prop.getProperty("productChannelId"));
            requestSpecification.queryParam("clientId",prop.getProperty("productClientId"));
            requestSpecification.queryParam("requestId",prop.getProperty("productRequestId"));
            requestSpecification.queryParam("username",prop.getProperty("productUserName"));
            requestSpecification.queryParam("page",prop.getProperty("productPage"));
            requestSpecification.queryParam("size",prop.getProperty("productSize"));

            requestSpecification.body(requestBody);
            response = requestSpecification.request(Method.POST,url);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return response;
    }

    public static Response jsonClientPostItemPickupPointSummary(String requestBody,String url)
    {
        Response response = null;
        try {
            prop = TestBase.loadTestDataProperty();
            apiCookie = RestClient.getCookies();
            RestAssured.baseURI = url;
            requestSpecification = RestAssured.given();
            requestSpecification.header("Content-Type", "application/json");
            requestSpecification.header("accept","application/json");
            requestSpecification.header("Cookie",apiCookie);

            requestSpecification.queryParam("storeId",prop.getProperty("productStoreId"));
            requestSpecification.queryParam("channelId",prop.getProperty("productChannelId"));
            requestSpecification.queryParam("clientId",prop.getProperty("productClientId"));
            requestSpecification.queryParam("requestId",prop.getProperty("productRequestId"));
            requestSpecification.queryParam("username",prop.getProperty("productUserName"));
            requestSpecification.queryParam("page",prop.getProperty("productPage"));
            requestSpecification.queryParam("size",prop.getProperty("productSize"));

            requestSpecification.body(requestBody);
            response = requestSpecification.request(Method.POST,url);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return response;
    }

    public static Response jsonClientPostItemPickupPointByItemSKU(String requestBody,String url)
    {
        Response response = null;
        try {
            prop = TestBase.loadTestDataProperty();
            apiCookie = RestClient.getCookies();
            RestAssured.baseURI = url;
            requestSpecification = RestAssured.given();
            requestSpecification.header("Content-Type", "application/json");
            requestSpecification.header("accept","application/json");
            requestSpecification.header("Cookie",apiCookie);

            requestSpecification.queryParam("storeId",prop.getProperty("productStoreId"));
            requestSpecification.queryParam("channelId",prop.getProperty("productChannelId"));
            requestSpecification.queryParam("clientId",prop.getProperty("productClientId"));
            requestSpecification.queryParam("requestId",prop.getProperty("productRequestId"));
            requestSpecification.queryParam("username",prop.getProperty("productUserName"));
            requestSpecification.queryParam("page",prop.getProperty("productPage"));
            requestSpecification.queryParam("size",prop.getProperty("productSize"));

            requestSpecification.body(requestBody);
            response = requestSpecification.request(Method.POST,url);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return response;
    }
}
