package com.happok.xiyan.livecenter.mapper;

import com.happok.xiyan.livecenter.entity.MediaCenterEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MediaCenterMapper {

    boolean CreateMediaCenter(MediaCenterEntity mediaCenterEntity);

    List<MediaCenterEntity> getMediaCenters();

    MediaCenterEntity getMediaCenter(@Param("id") Integer id);

    boolean updateMediaCenter(MediaCenterEntity mediaCenterEntity);

    boolean deleteMediaCenter(@Param("id") Integer id);

    Integer getOnlineCenter();
}
