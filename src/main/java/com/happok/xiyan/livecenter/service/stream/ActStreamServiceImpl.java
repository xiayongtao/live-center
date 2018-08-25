package com.happok.xiyan.livecenter.service.stream;

import com.happok.xiyan.livecenter.moudle.ActStreamMoudle;

/**
 * Created by xiayt on 2018/8/25/025 8:39
 */
public class ActStreamServiceImpl implements ActStreamService {
    @Override
    public String start(ActStreamMoudle actStreamMoudle) throws Exception {
        return null;
    }

    @Override
    public boolean stop(Integer act_id) throws Exception {
        return false;
    }

    @Override
    public String getStatus(Integer act_id) throws Exception {
        return null;
    }

    @Override
    public void stopAll() throws Exception {

    }

    @Override
    public boolean paused(Integer act_id, ActStreamMoudle actStreamMoudle) throws Exception {
        return false;
    }

    @Override
    public boolean continued(Integer act_id) throws Exception {
        return false;
    }

    @Override
    public boolean startBroadcast(Integer act_id) throws Exception {
        return false;
    }

    @Override
    public boolean stopBroadcast(Integer act_id) throws Exception {
        return false;
    }

    @Override
    public boolean restart(Integer act_id) throws Exception {
        return false;
    }

    @Override
    public boolean checkStatus() throws Exception {
        return false;
    }
}
