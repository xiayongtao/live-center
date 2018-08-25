package com.happok.xiyan.livecenter.service.activity;

import com.happok.xiyan.livecenter.moudle.ActivityMoudle;

/**
 * @author xiayt
 * 活动业务接口
 */
public interface ActivityService {
    boolean createActivity(ActivityMoudle activityMoudle) throws Exception;

    boolean updateActiviyt(ActivityMoudle activityMoudle) throws Exception;

    boolean deleteActivity(Integer act_id) throws Exception;

    boolean startActivity(Integer act_id) throws Exception;

    boolean puaseActivity(Integer act_id) throws Exception;

    boolean stopActivity(Integer act_id) throws Exception;

    boolean continueActivity(Integer act_id) throws Exception;

    boolean getActivityPerView(Integer act_id) throws Exception;

    boolean getActScreenShot(Integer act_id) throws Exception;

    boolean getActBroadcast(Integer act_id) throws Exception;
}
