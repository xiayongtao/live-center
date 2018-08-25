package com.happok.xiyan.livecenter.ffmpeg.api;

import com.happok.xiyan.livecenter.ffmpeg.entity.TaskEntity;
import com.happok.xiyan.livecenter.ffmpeg.service.CommandAssembly;
import com.happok.xiyan.livecenter.ffmpeg.service.CommandAssemblyLive;
import com.happok.xiyan.livecenter.ffmpeg.service.CommandAssemblyShot;

import java.util.Collection;
import java.util.Map;

public class FFmpegCmdApi {


    private FFmpegManager fFmpegManager = new FFmpegManagerImpl();
    private CommandAssembly commandAssembly = null;
    private String type;


    public String getType() {
        return type;
    }

    public FFmpegCmdApi(String type) {
        this.type = type;

        switch (type) {
            case "shot": {

                commandAssembly = new CommandAssemblyShot();
                fFmpegManager.setCommandAssembly(commandAssembly);
                break;
            }
            case "live": {

                commandAssembly = new CommandAssemblyLive();
                fFmpegManager.setCommandAssembly(commandAssembly);
                break;
            }
            default:
                break;
        }
    }

    public String start(String id, String command) {
        return fFmpegManager.start(id, command);
    }

    public String start(String id, String commond, boolean hasPath) {
        return fFmpegManager.start(id, commond, hasPath);
    }

    public String start(Map<String, String> assembly) {
        return fFmpegManager.start(assembly);
    }

    public boolean stop(String id) {
        return fFmpegManager.stop(id);
    }

    public int stopAll() {
        return fFmpegManager.stopAll();
    }

    public TaskEntity query(String id) {
        return fFmpegManager.query(id);
    }

    public Collection<TaskEntity> queryAll() {
        return fFmpegManager.queryAll();
    }

    public String restart(TaskEntity taskEntity) {
        return fFmpegManager.restart(taskEntity);
    }
}
