package com.happok.xiyan.livecenter.moudle;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
@Data
public class ChannelMoudle {

    @Length(max = 2, message = "{channel.name}")
    private String name;

    @Pattern(
            regexp = "",
            message = "{channel.url}"
    )
    private String live_src;

    @NotBlank(message = "{channel.type}")
    private String type;
}
