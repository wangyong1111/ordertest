package com.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangyong on 2019/8/30.
 */
@FeignClient(name="app-itmayiedu-member")
public interface MemberApiFeign {
    @RequestMapping("/getMember")
    public String getMember();
}