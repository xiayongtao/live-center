package com.happok.xiyan.livecenter.feignclient;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedHashMap;

@FeignClient(name = "MEDIA-SERVICE")
public interface MediaServiceFeign {

    @RequestMapping(value = "/mediaservice/streamturnpush", method = RequestMethod.POST)
    public JSONObject AddPullStream(@RequestBody LinkedHashMap<String, String> param);

    @RequestMapping(value = "/mediaservice/streamturnpush/{id}", method = RequestMethod.DELETE)
    public JSONObject DelPullStream(@PathVariable("id") Integer id);

}
