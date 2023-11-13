package com.practice.base;

import java.io.FileInputStream;
import java.util.Properties;

public class TestBase {

    public static final int statusCode_200OK = 200;
    public static final int statusCode_201OK = 201;
    public static final int statusCode_204OK = 204;
    public static final int statusCode_400_Bad_Request = 400;
    public static final int statusCode_401 = 401;
    public static final int statusCode_500 = 500;
    public static final String status_Line_200OK = "HTTP/1.1 200 OK";
    public static final String status_Line_201OK = "HTTP/1.1 201 Created";
    public static final String status_Line_204OK = "HTTP/1.1 204 No Content";
    public static final String status_Line_400_Bad_Request = "HTTP/1.1 400 Bad Request";

    public static Properties prop;
    public static FileInputStream fip;
    public static String baseServiceURL;

    public static Properties loadTestDataProperty()
    {
        try {
            prop = new Properties();
            fip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/practice/TestData/TestData.properties");
            prop.load(fip);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return prop;
    }

    public static Properties dbConfig()
    {
        try {
            prop = new Properties();
            fip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/practice/config/DbConfig.properties");
            prop.load(fip);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return prop;
    }

    public static String partnerServiceBaseURL()
    {
        try {
            prop=loadTestDataProperty();
            baseServiceURL = prop.getProperty("service_url") + "/" + prop.getProperty("service_uri") + "/" + prop.getProperty("service_end_point");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return baseServiceURL;
    }

    public static String pcuExternalServiceBaseURL()
    {
        try {
            prop=loadTestDataProperty();
            baseServiceURL = prop.getProperty("ServiceBaseUrl") + "/" + prop.getProperty("ServiceBaseUri") + "/" + prop.getProperty("ServiceEndPoint");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return baseServiceURL;
    }

    public static String xProductServiceBaseURL()
    {
        try {
            prop=loadTestDataProperty();
            baseServiceURL = prop.getProperty("ProductServiceBaseUrl") + "/" + prop.getProperty("ProductServiceBaseUri") + "/" + prop.getProperty("ProductServiceEndPoint");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return baseServiceURL;
    }
}
