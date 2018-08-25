package com.happok.xiyan.livecenter.service.channel;

import com.happok.xiyan.livecenter.entity.ChannelEntity;
import com.happok.xiyan.livecenter.entity.ChannelPerViewEntity;
import com.happok.xiyan.livecenter.moudle.ChannelMoudle;

import java.util.List;

/**
 * Created by xiayt on 2018/8/25/025 8:26
 */
public class ChannelServiceImpl implements ChannelService {
    @Override
    public boolean createChannel(ChannelMoudle channelMoudle) throws Exception {
        return false;
    }

    @Override
    public boolean updateChannel(Integer channel_id, ChannelMoudle channelMoudle) throws Exception {
        return false;
    }

    @Override
    public boolean deleteChannel(Integer channel_id) throws Exception {
        return false;
    }

    @Override
    public List<ChannelEntity> getChannels() throws Exception {
        return null;
    }

    @Override
    public List<ChannelPerViewEntity> getChannelPerVies(Integer channel_id) throws Exception {
        return null;
    }

    @Override
    public ChannelEntity getChannel(Integer channel_id) throws Exception {
        return null;
    }
}
