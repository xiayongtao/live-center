package com.happok.xiyan.livecenter.entity;

import lombok.Data;

@Data
public class ChannelPerViewEntity {
    private Integer id;
    private String type;
    private Integer channel_id;
    private String stream_url;
}
