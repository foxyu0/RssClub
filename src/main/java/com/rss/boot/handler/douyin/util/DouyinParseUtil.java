package com.rss.boot.handler.douyin.util;

import com.rss.boot.bean.rss.RssChannel;
import com.rss.boot.bean.rss.RssImage;
import com.rss.boot.bean.rss.RssItem;
import com.rss.boot.handler.douyin.bean.DouyinUserAwemeV1DTO;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author:
 * @Description:
 * @Date: 2021/8/16 下午3:15
 * @Modified By:
 */
@Slf4j
public class DouyinParseUtil {

    /**
     * 最新视频
     *
     * @param dto
     * @return
     */
    public static RssChannel douyinRecentVideo(DouyinUserAwemeV1DTO dto, String title, String url) {
        RssChannel rssChannel = new RssChannel();
        rssChannel.setTitle(title);
        rssChannel.setUri(url);
        rssChannel.setLink(url);

        List<RssItem> rssItemList = new ArrayList<>(10);
        rssChannel.setItems(rssItemList);

        DouyinUserAwemeV1DTO.C12DTO c12DTO = dto.getC_12();
        if (c12DTO != null) {
            if (c12DTO.getUser() != null) {
                String nickname = c12DTO.getUser().getUser().getNickname();
                String desc = c12DTO.getUser().getUser().getDesc();
                String avatarUrl = c12DTO.getUser().getUser().getAvatarUrl();
                avatarUrl = DouyinUtil.checkUrlAddHttp(avatarUrl);

                rssChannel.setDescription(desc);

                RssImage rssImage = new RssImage();
                rssImage.setTitle(nickname);
                rssImage.setUrl(avatarUrl);
                rssChannel.setImage(rssImage);
            }

            if (c12DTO.getPost() != null) {
                List<DouyinUserAwemeV1DTO.C12DTO.PostDTO.DataDTO> data = c12DTO.getPost().getData();
                if (data != null) {
                    for (DouyinUserAwemeV1DTO.C12DTO.PostDTO.DataDTO dataDTO : data) {
                        String nickname = dataDTO.getAuthorInfo().getNickname();
                        String desc = dataDTO.getDesc();

                        String description = "";
                        if (dataDTO.getVideo() != null) {
                            String originCover = dataDTO.getVideo().getOriginCover();
                            originCover = DouyinUtil.checkUrlAddHttp(originCover);

                            String playAddrVideo = "";
                            if (dataDTO.getVideo().getPlayAddr() != null) {
                                int num = dataDTO.getVideo().getPlayAddr().size();
                                playAddrVideo = dataDTO.getVideo().getPlayAddr().get(num - 1).getSrc();
                                playAddrVideo = DouyinUtil.checkUrlAddHttp(playAddrVideo);
                            }

                            String imgInfo = String.format("<img src = '%s' >", originCover);
                            String videoInfo = String.format("<video src = '%s' >", playAddrVideo);
                            description = nickname + "<br>" + desc + "<br>" + imgInfo + "<br><br>" + videoInfo;
                        }

                        String shareurl = dataDTO.getShareInfo().getShareUrl();
                        Integer createTime = dataDTO.getCreateTime();

                        RssItem rssItem = new RssItem();
                        rssItem.setTitle(desc);
                        rssItem.setAuthor(nickname);
                        rssItem.setLink(shareurl);
                        rssItem.setUri(shareurl);
                        rssItem.setPubDate(new Date(createTime));
                        rssItem.setDescription(description);
                        rssItemList.add(rssItem);
                    }
                }
            }
        }

        return rssChannel;
    }
}
