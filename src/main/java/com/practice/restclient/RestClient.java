package com.practice.restclient;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.practice.Payload.PartnersPayload;
import com.practice.base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Example;

public class RestClient extends TestBase {

    public static Properties properties;
    public static Logger log = Logger.getLogger(Example.class.getName());
    public static Response jsonClientPartnersGET(String url)
    {
        Response response = null;
        try {
            RestAssured.baseURI = url;
            RequestSpecification httpRequest = RestAssured.given();
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

    public static Response jsonClientPartnersSignInPOST(String url, String payload)
    {
        Response response = null;
        try {
            properties = TestBase.loadTestDataProperty();
            RestAssured.baseURI = url;
            RequestSpecification httpRequest = RestAssured.given();
            httpRequest.header("Content-Type", "application/json");
            httpRequest.header("accept","application/json");
            httpRequest.queryParam("channelId",properties.getProperty("mta.channelId"));
            httpRequest.queryParam("clientId",properties.getProperty("mta.clientId"));
            httpRequest.queryParam("requestId",properties.getProperty("mta.requestId"));
            httpRequest.queryParam("storeId",properties.getProperty("mta.storeId"));
            httpRequest.queryParam("username",properties.getProperty("mta.username"));
            httpRequest.body(payload);
            response = httpRequest.request(Method.POST,url);

            if(response.getStatusCode()!=TestBase.statusCode_200OK && response.getStatusCode()!=TestBase.statusCode_201OK)
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
            throw new RuntimeException("API call failed with HTTP Status Code:" +response.getStatusCode());
        }
        return response;
    }

    public static Response jsonClientPartnersSwitchAPIPOST(String url, String payload,String signature)
    {
        Response response = null;
        try {
            properties = TestBase.loadTestDataProperty();
            RestAssured.baseURI = url;
            RequestSpecification httpRequest = RestAssured.given();
            httpRequest.header("Content-Type", "application/json");
            httpRequest.header("accept","application/json");
            httpRequest.queryParam("channelId",properties.getProperty("mta.channelId"));
            httpRequest.queryParam("clientId",properties.getProperty("mta.clientId"));
            httpRequest.queryParam("requestId",properties.getProperty("mta.requestId"));
            httpRequest.queryParam("signature",signature);
            httpRequest.queryParam("storeId",properties.getProperty("mta.storeId"));
            httpRequest.queryParam("username",properties.getProperty("mta.username"));
            httpRequest.body(payload);
            response = httpRequest.request(Method.POST,url);

            if(response.getStatusCode()!=TestBase.statusCode_200OK && response.getStatusCode()!=TestBase.statusCode_201OK)
            {
                log.info("API Call failed with status code:" +response.getStatusCode()+ " and message:" +response.asString());
            }
            else
            {
                log.info("API call is success with HTTP status code:" +response.getStatusCode());
            }
        }
        catch (final Exception e)
        {
            throw new RuntimeException("API call failed with HTTP Status Code:" +response.getStatusCode());
        }
        return response;
    }

    public static String getCookies()
    {
        String cookie = "";
        String signature = "";
        Response signAPIResponse;
        Response switchAPIResponse;
        DocumentContext jsonContextSignIn;
        DocumentContext jsonContextSwitch;
        String sessionId = "";
        String userName = "";
        String userID = "";
        String signInApiURL = TestBase.partnerServiceBaseURL()+"/authentication/sign-in";
        String switchApiURL = TestBase.partnerServiceBaseURL()+"/session/switch";
        String requestSignInPayload = PartnersPayload.generateSignInRequestBody();
        String requestSwitchAPIPayload= PartnersPayload.generateSwitchAPIRequestBody();
        try {
            if(requestSwitchAPIPayload!=null)
            {
                signAPIResponse = RestClient.jsonClientPartnersSignInPOST(signInApiURL,requestSignInPayload);
                if(signAPIResponse!=null)
                {
                    jsonContextSignIn = JsonPath.parse(signAPIResponse.getBody().prettyPrint());
                    signature = jsonContextSignIn.read("$.value.signature");
                    switchAPIResponse=RestClient.jsonClientPartnersSwitchAPIPOST(switchApiURL,requestSwitchAPIPayload,signature);
                    System.out.println(switchAPIResponse.getBody().prettyPrint());
                    if(switchAPIResponse!=null)
                    {
                        jsonContextSwitch = JsonPath.parse(switchAPIResponse.getBody().prettyPrint());
                        sessionId = jsonContextSwitch.read("$.value.sessionId");
                        userName = jsonContextSwitch.read("$.value.username");
                        userID = jsonContextSignIn.read("$.value.userId");
                    }
                }
            }
            cookie = "Partners-Signature=" +sessionId+ ";" +" Partners-User-Id=" +userID+ ";" + " Partners-Username=" +userName+ ";";
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return cookie;
    }
}
