package com.practice.Payload;

import com.practice.base.TestBase;
import com.practice.data.PartnerEngineData;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PartnersPayload {

    public static PartnerEngineData partnerEngineData;
    public static Properties properties;
    public static JSONObject requestBody;
    public static String payload;
    public static Map<Object,Object> data;

    public static String generateSignInRequestBody()
    {
        data = new HashMap<>();
        properties = TestBase.loadTestDataProperty();
        partnerEngineData = new PartnerEngineData();
        try {
            partnerEngineData.setPassword(properties.getProperty("password"));
            partnerEngineData.setRemoteAddress(properties.getProperty("remoteAddress"));
            partnerEngineData.setUserAgent(properties.getProperty("userAgent"));
            partnerEngineData.setUsername(properties.getProperty("username"));

            data.put("password",partnerEngineData.getPassword());
            data.put("remoteAddress",partnerEngineData.getRemoteAddress());
            data.put("userAgent",partnerEngineData.getUserAgent());
            data.put("username",partnerEngineData.getUsername());

            requestBody = new JSONObject(data);
            payload = requestBody.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return payload;
    }

    public static String generateSwitchAPIRequestBody()
    {
        data = new HashMap<>();
        properties = TestBase.loadTestDataProperty();
        partnerEngineData = new PartnerEngineData();
        try
        {
            partnerEngineData.setMerchantCode(properties.getProperty("mta.merchantCode"));
            partnerEngineData.setStoreType(properties.getProperty("mta.storename"));

            data.put("code",partnerEngineData.getMerchantCode());
            data.put("type",partnerEngineData.getStoreType());

            requestBody = new JSONObject(data);
            payload = requestBody.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return payload;
    }
}
