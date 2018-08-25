package com.happok.xiyan.livecenter.service.stream;

import com.happok.xiyan.livecenter.moudle.PullMoudle;


/**
 * @author xiayo
 * 拉流方式处理
 */
public interface PullService {

    boolean startPull(PullMoudle pullMoudle) throws Exception;

    boolean stopPull(Integer pull_id) throws Exception;

    boolean updatePull(Integer pull_id, PullMoudle pullMoudle) throws Exception;
}
