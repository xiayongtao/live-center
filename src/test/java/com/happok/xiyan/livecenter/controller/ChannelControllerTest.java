package com.happok.xiyan.livecenter.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.happok.xiyan.livecenter.moudle.ChannelMoudle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class ChannelControllerTest extends AbstractTransactionalJUnit4SpringContextTests {
    //模拟mvc对象类.
    private MockMvc mvc;

    @Resource
    private WebApplicationContext webApplicationContext = null;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void createChannelPull() throws Exception {

        ChannelMoudle channelMoudle = new ChannelMoudle();
        channelMoudle.setName("dddgsgdsgdsgs");
        channelMoudle.setType("pull");
        JSONObject res_upload = (JSONObject) JSON.toJSON(channelMoudle);
        String responseString = mvc.perform(post("/livecenter/channels/pull")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(res_upload.toJSONString())
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().is(400))
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void createChannelPush() throws Exception {
    }
}