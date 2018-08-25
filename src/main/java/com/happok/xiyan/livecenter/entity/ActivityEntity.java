package com.happok.xiyan.livecenter.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ActivityEntity {
    private Integer id;
    private String name;
    private Integer channel_id;
    private boolean transcode;
    private String activity_status;
    private String broadcast_status;
    private Date create_time;
    private Date update_time;
    private String target_url;
    private String broadcast_url;
    private String source_url;
}
