package com.happok.xiyan.livecenter.service.stream;

import com.happok.xiyan.livecenter.moudle.PullMoudle;

/**
 * Created by xiayt on 2018/8/25/025 8:40
 */
public class PullServiceImpl implements PullService {
    @Override
    public boolean startPull(PullMoudle pullMoudle) throws Exception {
        return false;
    }

    @Override
    public boolean stopPull(Integer pull_id) throws Exception {
        return false;
    }

    @Override
    public boolean updatePull(Integer pull_id, PullMoudle pullMoudle) throws Exception {
        return false;
    }
}
