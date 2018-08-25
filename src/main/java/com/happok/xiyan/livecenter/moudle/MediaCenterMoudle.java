package com.happok.xiyan.livecenter.moudle;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class MediaCenterMoudle {

    @NotBlank
    @Length(max = 60)
    private String name;

    @NotBlank(message = "服务器IP不能为空")
    @Length(max = 16)
    @Pattern(regexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}", message = "IP格式不正确")
    private String server_ip;

    @Range(min = 0, max = 63353, message = "端口错误")
    private Integer port;
}
