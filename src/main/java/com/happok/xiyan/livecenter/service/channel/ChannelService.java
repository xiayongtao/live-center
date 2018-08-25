package com.happok.xiyan.livecenter.service.channel;

import com.happok.xiyan.livecenter.entity.ChannelEntity;
import com.happok.xiyan.livecenter.entity.ChannelPerViewEntity;
import com.happok.xiyan.livecenter.moudle.ChannelMoudle;

import java.util.List;

public interface ChannelService {
    boolean createChannel(ChannelMoudle channelMoudle) throws Exception;

    boolean updateChannel(Integer channel_id, ChannelMoudle channelMoudle) throws Exception;

    boolean deleteChannel(Integer channel_id) throws Exception;

    List<ChannelEntity> getChannels() throws Exception;

    List<ChannelPerViewEntity> getChannelPerVies(Integer channel_id) throws Exception;

    ChannelEntity getChannel(Integer channel_id) throws Exception;
}
