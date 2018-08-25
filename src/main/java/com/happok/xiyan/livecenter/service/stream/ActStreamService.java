package com.happok.xiyan.livecenter.service.stream;

import com.happok.xiyan.livecenter.moudle.ActStreamMoudle;

/**
 * @author xiayo
 * 活动流控制接口
 */
public interface ActStreamService {

    String start(ActStreamMoudle actStreamMoudle) throws Exception;

    boolean stop(Integer act_id) throws Exception;

    String getStatus(Integer act_id) throws Exception;

    void stopAll() throws Exception;

    boolean paused(Integer act_id, ActStreamMoudle actStreamMoudle) throws Exception;

    boolean continued(Integer act_id) throws Exception;

    boolean startBroadcast(Integer act_id) throws Exception;

    boolean stopBroadcast(Integer act_id) throws Exception;

    boolean restart(Integer act_id) throws Exception;

    boolean checkStatus() throws Exception;
}
