package com.happok.xiyan.livecenter.ffmpeg.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class CommandAssemblyShot implements CommandAssembly {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String assembly(Map<String, String> paramMap) {
        try {
            if (paramMap.containsKey("ffmpegPath")) {
                String ffmpegPath = (String) paramMap.get("ffmpegPath");

                StringBuilder comm = new StringBuilder(ffmpegPath);

//                if (paramMap.containsKey("ss")) {
//                    String ss = (String) paramMap.get("ss");
//                    comm.append(" -ss " + ss);
//                }

                if (paramMap.containsKey("input")
                        && paramMap.containsKey("output")) {

                    String input = (String) paramMap.get("input");
                    String output = (String) paramMap.get("output");

                    comm.append(" -i ");
                    comm.append(input);


                    if (paramMap.containsKey("rs")) {
                        String rs = (String) paramMap.get("rs");
                        comm.append(" -s " + rs);
                    }

                    comm.append(" -f image2 ");

                    if (paramMap.containsKey("vframes")) {
                        String vframes = (String) paramMap.get("vframes");
                        comm.append(" -vframes " + vframes);
                    } else {
                        comm.append(" -vframes 1 ");
                    }

                    comm.append(" -y " + output);
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