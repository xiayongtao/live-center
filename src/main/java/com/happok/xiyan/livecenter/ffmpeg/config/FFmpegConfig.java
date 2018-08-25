package com.happok.xiyan.livecenter.ffmpeg.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

@Component
@ConfigurationProperties(prefix = "ffmpeg")

public class FFmpegConfig {
    private String path;
    private boolean debug;
    private Integer size;
    private boolean issyspath;
    private String rootPath;
    private String defaultaudio;
    private String defaultimage;
    private String vcodec;
    private String acodec;



    //private String rootPath;
    public FFmpegConfig() {
        this.rootPath = ClassUtils.getDefaultClassLoader().getResource("ffmpeg").getPath();
    }

    public String getVcodec() {
        return vcodec;
    }

    public void setVcodec(String vcodec) {
        this.vcodec = vcodec;
    }

    public String getAcodec() {
        return acodec;
    }

    public void setAcodec(String acodec) {
        this.acodec = acodec;
    }

    public boolean isIssyspath() {
        return issyspath;
    }

    public void setIssyspath(boolean issyspath) {
        this.issyspath = issyspath;
    }

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    public String getDefaultaudio() {
        return defaultaudio;
    }

    public void setDefaultaudio(String defaultaudio) {
        this.defaultaudio = defaultaudio;
    }

    public String getDefaultimage() {
        return defaultimage;
    }

    public void setDefaultimage(String defaultimage) {
        this.defaultimage = defaultimage;
    }

    public String getPath() {
        if (issyspath) {
            return rootPath + "/" + path;
        } else {
            return path;
        }
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "FFmpegConfig [path=" + path + ", debug=" + debug + ", size=" + size + "]";
    }
}
