package com.happok.xiyan.livecenter.moudle;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class ActivityMoudle {

    @Length(max = 60, message = "名称超过限制(max = 60)")
    private String name;

    private Integer channel_id;
    private boolean isTranscode;
}
