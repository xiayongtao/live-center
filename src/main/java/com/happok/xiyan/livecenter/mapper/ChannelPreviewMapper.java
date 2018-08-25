package com.happok.xiyan.livecenter.mapper;


import com.happok.xiyan.livecenter.entity.ChannelPerViewEntity;

import java.util.List;

public interface ChannelPreviewMapper {

    boolean insertPreview(ChannelPerViewEntity channelPreviewEntity);

    List<ChannelPerViewEntity> getPreviews(Integer channel_id);

    boolean deletePreview(Integer channel_id);
}
