package com.happok.xiyan.livecenter.service.stream;

import com.happok.xiyan.livecenter.entity.MediaCenterEntity;
import com.happok.xiyan.livecenter.moudle.MediaCenterMoudle;

import java.util.List;

public interface MediaCenterService {

    // boolean checkMediaCenterStatus(String ip, Integer port) throws Exception;

    Object getClients(Integer media_id, String media_type) throws Exception;

    Object getClient(Integer media_id, Integer client_id) throws Exception;

    Object getStreams(Integer media_id, Integer client_id) throws Exception;

    Object getStream(Integer media_id, Integer client_id, String stream_name) throws Exception;

    boolean addMediaCenter(MediaCenterMoudle mediaCenterMoudle) throws Exception;

    boolean updateMediaCenter(Integer media_id, MediaCenterMoudle mediaCenterMoudle) throws Exception;

    boolean delMediaCenter(Integer media_id) throws Exception;

    List<MediaCenterEntity> getMediaCenters() throws Exception;

    MediaCenterEntity getMediaCenter(Integer media_id) throws Exception;

    // Object getMediaCenterUrl(Integer media_id, String media_type) throws Exception;

}
