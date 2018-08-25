package com.happok.xiyan.livecenter.moudle;

import lombok.Data;

@Data
public class MediaStreamMoudle {

    private String name;
    private Integer clients;
    private double send_bytes;
    private double recv_bytes;
    private boolean publish_active;
    private String recv_30s;
    private String send_30s;
    private String status;
}
