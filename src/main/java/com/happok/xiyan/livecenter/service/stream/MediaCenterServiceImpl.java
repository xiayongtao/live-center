package com.happok.xiyan.livecenter.service.stream;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.happok.xiyan.livecenter.entity.MediaCenterEntity;
import com.happok.xiyan.livecenter.mapper.MediaCenterMapper;
import com.happok.xiyan.livecenter.moudle.MediaCenterMoudle;
import com.happok.xiyan.livecenter.moudle.MediaClientMoudle;
import com.happok.xiyan.livecenter.moudle.MediaStreamMoudle;
import com.happok.xiyan.livecenter.result.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by xiayt on 2018/8/25/025 8:39
 */

@Service
public class MediaCenterServiceImpl implements MediaCenterService {

    private Logger logger = LoggerFactory.getLogger(MediaCenterServiceImpl.class);
    private RestTemplate restTemplate = new RestTemplate();

    private Integer media_id;

    @Autowired
    private MediaCenterMapper mediaCenterMapper;

    @PostConstruct
    public void init() {
        media_id = mediaCenterMapper.getOnlineCenter();
    }

    private List<MediaStreamMoudle> getMediaStreams(Integer client_id) throws Exception {
        MediaCenterEntity mediaCenterEntity = mediaCenterMapper.getMediaCenter(media_id);
        if (ObjectUtils.isEmpty(mediaCenterEntity)) {
            throw new NotFoundException(StreamError.MEDIA_CENTER_NOT_FOUND);
        }

        try {
            String ip = mediaCenterEntity.getServer_ip();
            Integer port = mediaCenterEntity.getPort();

            String url = "http://" + ip + ":" + port + "/mediaservice/client/" + client_id + "/streams";
            JSONObject restTemplateForObject = restTemplate.getForObject(url, JSONObject.class);
            JSONArray result = restTemplateForObject.getJSONArray("result");
            if (!ObjectUtils.isEmpty(result)) {
                List<MediaStreamMoudle> mediaClientMoudles = result.toJavaList(MediaStreamMoudle.class);
                return mediaClientMoudles;
            }
            throw new NotFoundException(StreamError.MEDIA_STREAM_NOT_FOUND);
        } catch (RestClientException e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    private MediaStreamMoudle getMediaStream(Integer client_id, String name) throws Exception {
        MediaCenterEntity mediaCenterEntity = mediaCenterMapper.getMediaCenter(media_id);
        if (ObjectUtils.isEmpty(mediaCenterEntity)) {
            throw new NotFoundException(StreamError.MEDIA_CENTER_NOT_FOUND);
        }

        try {
            String ip = mediaCenterEntity.getServer_ip();
            Integer port = mediaCenterEntity.getPort();

            String url = "http://" + ip + ":" + port + "/mediaservice/client/" + client_id + "/streams/" + name;
            JSONObject restTemplateForObject = restTemplate.getForObject(url, JSONObject.class);
            JSONObject result = restTemplateForObject.getJSONObject("result");
            if (!ObjectUtils.isEmpty(result)) {
                MediaStreamMoudle mediaClientMoudle = result.toJavaObject(MediaStreamMoudle.class);
                return mediaClientMoudle;
            }
            throw new NotFoundException(StreamError.MEDIA_STREAM_NOT_FOUND);
        } catch (RestClientException e) {
            logger.error(e.getMessage());
            throw e;
        }
    }


    private MediaClientMoudle getMediaClient(Integer client_id) throws Exception {
        MediaCenterEntity mediaCenterEntity = mediaCenterMapper.getMediaCenter(media_id);
        if (ObjectUtils.isEmpty(mediaCenterEntity)) {
            throw new NotFoundException(StreamError.MEDIA_CENTER_NOT_FOUND);
        }

        String ip = mediaCenterEntity.getServer_ip();
        Integer port = mediaCenterEntity.getPort();
        String url = "http://" + ip + ":" + port + "/mediaservice/clients/" + client_id;

        try {
            JSONObject res = restTemplate.getForObject(url, JSONObject.class);
            JSONObject result = res.getJSONObject("result");
            if (!ObjectUtils.isEmpty(result)) {
                MediaClientMoudle mediaClientMoudle = result.toJavaObject(MediaClientMoudle.class);
                return mediaClientMoudle;
            }

            throw new NotFoundException(StreamError.MEDIA_CLIENT_NOT_FOUND);

        } catch (RestClientException e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    private List<MediaClientMoudle> getMediaClients(String media_type) throws Exception {

        MediaCenterEntity mediaCenterEntity = mediaCenterMapper.getMediaCenter(media_id);
        if (ObjectUtils.isEmpty(mediaCenterEntity)) {
            throw new NotFoundException(StreamError.MEDIA_CENTER_NOT_FOUND);
        }

        String ip = mediaCenterEntity.getServer_ip();
        Integer port = mediaCenterEntity.getPort();
        String url = "http://" + ip + ":" + port + "/mediaservice/clients";
        url += "?type=" + media_type;

        try {
            JSONObject res = restTemplate.getForObject(url, JSONObject.class);
            JSONArray result = res.getJSONArray("result");
            if (!ObjectUtils.isEmpty(result)) {
                List<MediaClientMoudle> mediaClientMoudles = result.toJavaList(MediaClientMoudle.class);
                return mediaClientMoudles;
            }

            throw new NotFoundException(StreamError.MEDIA_CLIENT_NOT_FOUND);

        } catch (RestClientException e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public Object getClients(@NotNull(message = "中心服务ID不能为空") @Validated Integer mediaId,
                             @NotBlank(message = "流媒体类型不能为空") @Validated String media_type) throws Exception {

        media_id = mediaId != null ? mediaId : this.media_id;
        return getMediaClients(media_type);
    }

    @Override
    public Object getClient(Integer mediaId, Integer client_id) throws Exception {
        media_id = mediaId != null ? mediaId : this.media_id;
        return getMediaClient(client_id);
    }

    @Override
    public Object getStreams(@NotNull(message = "中心服务ID不能为空") @Validated Integer mediaId,
                             @NotNull(message = "流媒体ID不能为空") @Validated Integer client_id) throws Exception {
        media_id = mediaId != null ? mediaId : this.media_id;
        return getMediaStreams(client_id);
    }

    @Override
    public Object getStream(@NotNull(message = "中心服务ID不能为空") @Validated Integer mediaId,
                            @NotNull(message = "流媒体ID不能为空") @Validated Integer client_id,
                            @NotBlank(message = "流名称不能为空") @Validated String stream_name) throws Exception {

        media_id = mediaId != null ? mediaId : this.media_id;
        return getMediaStream(client_id, stream_name);
    }

    @Override
    public boolean addMediaCenter(@Validated MediaCenterMoudle mediaCenterMoudle) throws Exception {

        try {
            MediaCenterEntity mediaCenterEntity = JSON.parseObject(mediaCenterMoudle.toString(), MediaCenterEntity.class);
            return mediaCenterMapper.CreateMediaCenter(mediaCenterEntity);
        } catch (DuplicateKeyException e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public boolean updateMediaCenter(@NotNull(message = "中心服务ID不能为空") @Validated Integer media_id,
                                     @Validated MediaCenterMoudle mediaCenterMoudle) throws Exception {
        try {
            MediaCenterEntity mediaCenterEntity = JSON.parseObject(mediaCenterMoudle.toString(), MediaCenterEntity.class);
            mediaCenterEntity.setId(media_id);
            return mediaCenterMapper.CreateMediaCenter(mediaCenterEntity);
        } catch (DuplicateKeyException e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public boolean delMediaCenter(@NotNull(message = "中心服务ID不能为空") @Validated Integer media_id) throws Exception {
        return mediaCenterMapper.deleteMediaCenter(media_id);
    }

    @Override
    public List<MediaCenterEntity> getMediaCenters() throws Exception {
        return mediaCenterMapper.getMediaCenters();
    }

    @Override
    public MediaCenterEntity getMediaCenter(@NotNull(message = "中心服务ID不能为空") @Validated Integer media_id) throws Exception {
        MediaCenterEntity mediaCenterEntity = mediaCenterMapper.getMediaCenter(media_id);
        if (ObjectUtils.isEmpty(mediaCenterEntity)) {
            throw new NotFoundException(StreamError.MEDIA_CENTER_NOT_FOUND);
        }
        return mediaCenterMapper.getMediaCenter(media_id);
    }
}
