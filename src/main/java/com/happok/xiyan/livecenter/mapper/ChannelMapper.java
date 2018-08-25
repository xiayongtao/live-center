package com.happok.xiyan.livecenter.mapper;

import com.happok.xiyan.livecenter.entity.ChannelEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChannelMapper {
    boolean insertChannel(ChannelEntity channelEntity);

    boolean updateChannel(ChannelEntity channelEntity);

    List<ChannelEntity> getChannels();

    ChannelEntity getChannel(@Param("id") Integer id);

    boolean deleteChannel(@Param("id") Integer id);

    ChannelEntity getChannelByLiveSrc(@Param("live_src") String live_src);
}
