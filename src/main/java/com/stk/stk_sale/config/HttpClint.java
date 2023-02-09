package com.stk.stk_sale.config;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpClint {
    public String HttpConfig(String url, MultiValueMap params){
        RestTemplate client =new RestTemplate();
        //  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
        HttpHeaders headers =new HttpHeaders();
        // headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);//  封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        //  执行HTTP请求
        HttpEntity requestEntity =new HttpEntity(params, headers);
        //  输出结果
        String response = client.postForObject(url, requestEntity, String.class);
        return response;
    }
}
