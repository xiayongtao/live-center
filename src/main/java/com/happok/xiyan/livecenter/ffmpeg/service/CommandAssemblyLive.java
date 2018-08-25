package com.happok.xiyan.livecenter.ffmpeg.service;

import com.happok.xiyan.livecenter.ffmpeg.config.FFmpegConfig;
import com.happok.xiyan.livecenter.ffmpeg.config.FFmpegConfigStatic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class CommandAssemblyLive implements CommandAssembly {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public CommandAssemblyLive() {
    }

    @Override
    public String assembly(Map<String, String> paramMap) {
        try {

            FFmpegConfig fFmpegConfig = FFmpegConfigStatic.getFFmpegConfig();
            if (paramMap.containsKey("ffmpegPath")) {
                String ffmpegPath = (String) paramMap.get("ffmpegPath");
                StringBuilder comm = new StringBuilder();
                if (paramMap.containsKey("input")
                        && paramMap.containsKey("output")
                        && paramMap.containsKey("appName")) {

                    String input = (String) paramMap.get("input");
                    String output = (String) paramMap.get("output");
                    String appName = (String) paramMap.get("appName");

                    comm.append(ffmpegPath);
                    if (input.startsWith("rtsp:")) {
                        comm.append(" -rtsp_transport tcp ");
                    }

                    if (input.endsWith(".mp4")) {
                        comm.append(" -re -fflags +genpts -stream_loop -1 ");
                    }

                    if (input.endsWith(".jpg")
                            || input.endsWith(".png")
                            || input.endsWith(".bmp")) {

                        String rootPaht = System.getProperty("user.dir");
                        if (input.contains("default")) {
                            input = rootPaht + "/" + input;
                        }

                        comm.append(" -re -fflags +genpts -stream_loop -1 ");
                        comm.append(" -f image2  -i \"" + input + "\"");
                        //TODO 静默音频
                        comm.append(" -fflags +genpts  -stream_loop -1 -i  ");
                        comm.append(rootPaht + "/" + fFmpegConfig.getDefaultaudio());

                        comm.append(" -vcodec ");
                        comm.append(fFmpegConfig.getVcodec());
                        comm.append(" -acodec ");
                        comm.append(fFmpegConfig.getAcodec());
                        comm.append(" -f flv \"" + output + "/" + appName + "\"");
                        String rest = comm.toString();

                        logger.info("cmd:" + rest);
                        return rest;
                    }

                    comm.append(" -i \"" + input + "\"");
                    comm.append(" -vcodec copy ");
                    comm.append(" -acodec copy ");
                    comm.append(" -f flv \"" + output + "/" + appName + "\"");
                    String rest = comm.toString();

                    logger.info("cmd:" + rest);
                    return rest;
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}
