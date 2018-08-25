package com.happok.xiyan.livecenter.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.Date;

@Data
public class ChannelEntity {

    private Integer id;
    private Integer media_id;

    private String type;
    private String name;
    private String status;
    private Date create_time;
    private Date update_time;
    private String stream_url;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Integer pull_id;
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String live_src;
}

