package com.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wangyong on 2019/8/30.
 */

@RestController
public class OrderTestController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private MemberApiFeign memberApiFeign;
    @RequestMapping("/getorder")
    public String getOrder() {
        // order 使用rpc 远程调用技术 调用 会员服务
        String memberUrl = "http://app-itmayiedu-member/getMember";
        String result = restTemplate.getForObject(memberUrl, String.class);
        System.out.println("会员服务调用订单服务,result:" + result);
        return result;
    }

    @RequestMapping("/getorderfeign")
    public String getOrderFeign() {
        System.out.println("会员服务调用订单服务,result:" + memberApiFeign.getMember());
        return memberApiFeign.getMember();
    }


    @HystrixCommand(fallbackMethod = "getHystrixFallback")
    @RequestMapping("/getHystrix")
    public String getHystrixEn(){
        return "";
    }

    public  String getHystrixFallback(){

        return "";
    }
}
