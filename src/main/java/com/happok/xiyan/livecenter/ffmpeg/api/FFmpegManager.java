package com.happok.xiyan.livecenter.ffmpeg.api;


import com.happok.xiyan.livecenter.ffmpeg.config.FFmpegConfig;
import com.happok.xiyan.livecenter.ffmpeg.config.FFmpegConfigStatic;
import com.happok.xiyan.livecenter.ffmpeg.dao.TaskDao;
import com.happok.xiyan.livecenter.ffmpeg.entity.TaskEntity;
import com.happok.xiyan.livecenter.ffmpeg.service.CommandAssembly;
import com.happok.xiyan.livecenter.ffmpeg.service.TaskHandler;

import java.util.Collection;
import java.util.Map;

public interface FFmpegManager {

    public static FFmpegConfig config = FFmpegConfigStatic.getFFmpegConfig();

    public void setTaskDao(TaskDao taskDao);

    public void setTaskHandler(TaskHandler taskHandler);

    public void setCommandAssembly(CommandAssembly commandAssembly);

    public String start(String id, String command);

    public String restart(TaskEntity taskEntity);

    public String start(String id, String commond, boolean hasPath);

    public String start(Map<String, String> assembly);

    public boolean stop(String id);

    public int stopAll();

    public TaskEntity query(String id);

    public Collection<TaskEntity> queryAll();

}
