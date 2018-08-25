package com.happok.xiyan.livecenter.controller;

import com.happok.xiyan.livecenter.moudle.ChannelMoudle;
import com.happok.xiyan.livecenter.result.ResultBody;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/livecenter/channels")
public class ChannelController {

    @PostMapping("/pull")
    public ResultBody CreateChannelPull(@RequestBody @Validated ChannelMoudle channelMoudle) {
        return null;
    }

    @PostMapping("/push")
    public ResultBody CreateChannelPush(@RequestBody @Validated ChannelMoudle channelMoudle) {
        return null;
    }
}
