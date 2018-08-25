package com.happok.xiyan.livecenter.entity;

import lombok.Data;

import java.util.Date;

@Data
public class MediaCenterEntity {

    private Integer id;
    private String name;
    private String server_ip;
    private Integer port;
    private Date update_time;
    private String status;
}
