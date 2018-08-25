package com.happok.xiyan.livecenter.ffmpeg.service;

import com.happok.xiyan.livecenter.ffmpeg.entity.TaskEntity;

public interface TaskHandler {

    public TaskEntity process(String id, String command);

    public boolean stop(Process process);

    public boolean stop(Thread thread);

    public boolean stop(Process process, Thread thread);

    public TaskEntity reStart(String id, String commond);
}
