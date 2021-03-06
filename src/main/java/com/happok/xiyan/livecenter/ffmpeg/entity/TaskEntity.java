package com.happok.xiyan.livecenter.ffmpeg.entity;

public class TaskEntity {
    private final String id;//任务id
    private final Process process;//任务主进程
    private final Thread thread;//任务输出线程

    private final String command;

    public TaskEntity(String id, Process process, Thread thread, String command) {
        this.id = id;
        this.process = process;
        this.thread = thread;
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public String getId() {
        return id;
    }

    public Process getProcess() {
        return process;
    }

    public Thread getThread() {
        return thread;
    }

    @Override
    public String toString() {
        return "TaskEntity [id=" + id + ", process=" + process + ", thread=" + thread + "]";
    }
}
