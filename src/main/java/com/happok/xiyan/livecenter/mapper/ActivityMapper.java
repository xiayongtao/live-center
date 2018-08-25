package com.happok.xiyan.livecenter.mapper;

import com.happok.xiyan.livecenter.entity.ActivityEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityMapper {
    boolean insertActivity(ActivityEntity activityEntity);

    boolean updateActivity(ActivityEntity activityEntity);

    List<ActivityEntity> getActivitys();

    ActivityEntity getActivity(@Param("id") Integer id);

    boolean deleteActivity(@Param("id") Integer id);

    List<ActivityEntity> getActivitysByStatus(@Param("status") String status);

    List<ActivityEntity> getBroadcastsByStatus(@Param("status") String status);

    ActivityEntity getActivityNoStatus(@Param("id") Integer id, @Param("status") String status);

    // 查询id是否存在
    Integer isExistsId(@Param("id") Integer id);

    // 给删除活动使用
    ActivityEntity getActivityEntityByStatus(@Param("id") Integer id, @Param("status") String status);
}
