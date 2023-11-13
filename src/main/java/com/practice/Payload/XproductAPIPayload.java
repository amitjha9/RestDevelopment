package com.practice.Payload;

import com.gdn.x.product.rest.web.model.request.ItemPickupPointListingRequest;
import com.gdn.x.product.rest.web.model.request.ItemPickupPointRequest;
import com.gdn.x.product.rest.web.model.request.ItemPickupPointSummaryRequest;
import com.gdn.x.product.rest.web.model.request.ItemRequestV2;
import com.practice.base.TestBase;
import org.json.JSONObject;
import java.util.Properties;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class XproductAPIPayload {

    public static Properties properties;
    public static String payload;
    public static JSONObject requestBody;
    public static ItemPickupPointListingRequest itemPickupPointListingRequest;
    public static ItemPickupPointSummaryRequest itemPickupPointSummaryRequest;
    public static ItemPickupPointRequest itemPickupPointRequest;
    public static ItemRequestV2 itemRequestV2;

    public static String generateItemPickupPointListingPayload()
    {
        itemPickupPointListingRequest = new ItemPickupPointListingRequest();
        properties = TestBase.loadTestDataProperty();
        Set<String> pickupPointCodes = new HashSet<>();
        pickupPointCodes.add(properties.getProperty("pickupPointCodes"));
        try {
            itemPickupPointListingRequest.setBusinessPartnerCode(properties.getProperty("ItemPickupPointListing.businessPartnerCode"));
            itemPickupPointListingRequest.setProductSku(properties.getProperty("ItemPickupPointListing.productSku"));
            itemPickupPointListingRequest.setItemSku(properties.getProperty("ItemPickupPointListing.itemSku"));
            itemPickupPointListingRequest.setKeyword(properties.getProperty("keyword"));
            itemPickupPointListingRequest.setResponseWithoutPickupPoint(true);
            itemPickupPointListingRequest.setPickupPointCodes(pickupPointCodes);
            itemPickupPointListingRequest.setFbbSortRequired(true);
            requestBody = new JSONObject(itemPickupPointListingRequest);
            payload = requestBody.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return payload;
    }

    public static String generateItemPickupPointSummaryPayload()
    {
        itemPickupPointRequest = new ItemPickupPointRequest();
        itemPickupPointSummaryRequest = new ItemPickupPointSummaryRequest();
        properties = TestBase.loadTestDataProperty();
        Set<String> itemCodes = new HashSet<>();
        itemCodes.add(properties.getProperty("itemCode"));

        List<String> productSkuList = new ArrayList<>();
        productSkuList.add(properties.getProperty("ItemPickupPointListing.productSku"));

        List<ItemPickupPointRequest> itemPickupPointCode = new ArrayList<>();
        try {
            itemPickupPointRequest.setItemSku(properties.getProperty("ItemPickupPointListing.itemSku"));
            itemPickupPointRequest.setPickupPointCode(properties.getProperty("pickupPointCodes"));
            itemPickupPointCode.add(itemPickupPointRequest);
            itemPickupPointSummaryRequest.setMerchantCode(properties.getProperty("ItemPickupPointListing.businessPartnerCode"));
            itemPickupPointSummaryRequest.setItemSku(properties.getProperty("ItemPickupPointListing.itemSku"));
            itemPickupPointSummaryRequest.setItemCodes(itemCodes);
            itemPickupPointSummaryRequest.setKeyword(properties.getProperty("keyword"));
            itemPickupPointSummaryRequest.setProductSkuList(productSkuList);
            itemPickupPointSummaryRequest.setItemPickupPointCode(itemPickupPointCode);

            requestBody = new JSONObject(itemPickupPointSummaryRequest);
            payload = requestBody.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return payload;
    }

    public static String generateItemPickupPointByItemSKUPayload()
    {
        try {
            properties = TestBase.loadTestDataProperty();
            List<String> itemSkuList = new ArrayList<>();
            itemRequestV2 = new ItemRequestV2();
            itemRequestV2.setMerchantCode(properties.getProperty("ItemPickupPointListing.businessPartnerCode"));
            itemSkuList.add(properties.getProperty("ItemPickupPointListing.itemSku"));
            itemRequestV2.setItemSkuList(itemSkuList);

            requestBody = new JSONObject(itemRequestV2);
            payload = requestBody.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return payload;
    }
}
