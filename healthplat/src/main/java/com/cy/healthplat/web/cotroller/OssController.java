package com.cy.healthplat.web.cotroller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import com.aliyun.oss.OSS;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.cy.healthplat.common.util.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/oss")
public class OssController {
@Resource
OSS ossClient;
@Value("${alibaba.cloud.oss.endpoint}")
private String endpoint;
@Value("${alibaba.cloud.oss.bucket}")
private String bucket;
@Value("${alibaba.cloud.access-key}")
private String accessId;

@RequestMapping("/policy")
public Result policy() {
    String host = "https://" + bucket + "." + endpoint; // host的格式为 bucketname.endpoint
    // callbackUrl为 上传回调服务器的URL，请将下面的IP和Port配置为您自己的真实信息。
    // String callbackUrl = "http://88.88.88.88:8888";
    String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    String dir = format + "/"; // 用户上传文件时指定的前缀。

    Map<String, String> respMap = null;
    try {
        long expireTime = 30;
        long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
        Date expiration = new Date(expireEndTime);
        PolicyConditions policyConds = new PolicyConditions();
        policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
        policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

        String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
        byte[] binaryData = postPolicy.getBytes("utf-8");
        String encodedPolicy = BinaryUtil.toBase64String(binaryData);
        String postSignature = ossClient.calculatePostSignature(postPolicy);

        respMap = new LinkedHashMap<String, String>();
        respMap.put("accessid", accessId);
        respMap.put("policy", encodedPolicy);
        respMap.put("signature", postSignature);
        respMap.put("dir", dir);
        respMap.put("host", host);
        respMap.put("expire", String.valueOf(expireEndTime / 1000));
        // respMap.put("expire", formatISO8601Date(expiration));

        // 下面是 回调 和 以跨域的方式响应数据 咱们配置过跨域了 所以这里注释掉
        /*
           JSONObject jasonCallback = new JSONObject();
           jasonCallback.put("callbackUrl", callbackUrl);
           jasonCallback.put("callbackBody",
                   "filename=${object}&size=${size}&mimeType=${mimeType}&height=${imageInfo.height}&width=${imageInfo.width}");
           jasonCallback.put("callbackBodyType", "application/x-www-form-urlencoded");
           String base64CallbackBody = BinaryUtil.toBase64String(jasonCallback.toString().getBytes());
           respMap.put("callback", base64CallbackBody);

           JSONObject ja1 = JSONObject.fromObject(respMap);
           // System.out.println(ja1.toString());
           response.setHeader("Access-Control-Allow-Origin", "*");
           response.setHeader("Access-Control-Allow-Methods", "GET, POST");
           response(request, response, ja1.toString());
           */

    } catch (Exception e) {
        // Assert.fail(e.getMessage());
        System.out.println(e.getMessage());
    }
    return Result.success(respMap);
    }
}

