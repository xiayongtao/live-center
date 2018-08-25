package com.happok.xiyan.livecenter.moudle;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.Date;

@Data
public class MediaClientMoudle {

    private Integer push_number;
    private Integer live_number;

    private Date update_time;

    private String type;
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String server_ip;
    private String uuid;

    private String status;

    private String recv_30s;
    private String send_30s;
}
