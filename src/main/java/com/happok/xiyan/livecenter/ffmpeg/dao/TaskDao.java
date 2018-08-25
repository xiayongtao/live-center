package com.happok.xiyan.livecenter.ffmpeg.dao;


import com.happok.xiyan.livecenter.ffmpeg.entity.TaskEntity;

import java.util.Collection;

public interface TaskDao {

	public TaskEntity get(String id);

	public Collection<TaskEntity> getAll();

	public int add(TaskEntity taskEntity);

	public int remove(String id);

	public int removeAll();

	public boolean isHave(String id);
}
