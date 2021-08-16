package com.rss.boot.handler.douyin.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author:
 * @Description:
 * @Date: 2021/8/16 下午2:38
 * @Modified By:
 */
@NoArgsConstructor
@Data
public class DouyinUserAwemeV1DTO {


    @JsonProperty("_location")
    private String _location;
    @JsonProperty("C_0")
    private C0DTO C_0;
    @JsonProperty("C_12")
    private C12DTO C_12;

    @NoArgsConstructor
    @Data
    public static class C0DTO {
        @JsonProperty("abTest")
        private AbTestDTO abTest;
        @JsonProperty("odin")
        private OdinDTO odin;
        @JsonProperty("user")
        private UserDTO user;

        @NoArgsConstructor
        @Data
        public static class AbTestDTO {
            @JsonProperty("navTabRecommendType")
            private Integer navTabRecommendType;
        }

        @NoArgsConstructor
        @Data
        public static class OdinDTO {
            @JsonProperty("user_id")
            private String user_id;
            @JsonProperty("user_type")
            private Integer user_type;
            @JsonProperty("user_is_auth")
            private Integer user_is_auth;
            @JsonProperty("user_unique_id")
            private String user_unique_id;
        }

        @NoArgsConstructor
        @Data
        public static class UserDTO {
            @JsonProperty("isLogin")
            private Boolean isLogin;
            @JsonProperty("statusCode")
            private Integer statusCode;
        }
    }

    @NoArgsConstructor
    @Data
    public static class C12DTO {
        @JsonProperty("uid")
        private String uid;
        @JsonProperty("user")
        private UserDTO user;
        @JsonProperty("mix")
        private MixDTO mix;
        @JsonProperty("post")
        private PostDTO post;

        @NoArgsConstructor
        @Data
        public static class UserDTO {
            @JsonProperty("statusCode")
            private Integer statusCode;
            @JsonProperty("statusMsg")
            private Object statusMsg;
            @JsonProperty("logPb")
            private LogPbDTO logPb;
            @JsonProperty("user")
            private User2DTO user;

            @NoArgsConstructor
            @Data
            public static class LogPbDTO {
                @JsonProperty("impr_id")
                private String impr_id;
            }

            @NoArgsConstructor
            @Data
            public static class User2DTO {
                @JsonProperty("uid")
                private String uid;
                @JsonProperty("secUid")
                private String secUid;
                @JsonProperty("shortId")
                private String shortId;
                @JsonProperty("nickname")
                private String nickname;
                @JsonProperty("desc")
                private String desc;
                @JsonProperty("avatarUrl")
                private String avatarUrl;
                @JsonProperty("followStatus")
                private Integer followStatus;
                @JsonProperty("followerStatus")
                private Integer followerStatus;
                @JsonProperty("awemeCount")
                private Integer awemeCount;
                @JsonProperty("followingCount")
                private Integer followingCount;
                @JsonProperty("followerCount")
                private Integer followerCount;
                @JsonProperty("mplatformFollowersCount")
                private Integer mplatformFollowersCount;
                @JsonProperty("favoritingCount")
                private Integer favoritingCount;
                @JsonProperty("totalFavorited")
                private Integer totalFavorited;
                @JsonProperty("uniqueId")
                private String uniqueId;
                @JsonProperty("customVerify")
                private String customVerify;
                @JsonProperty("enterpriseVerifyReason")
                private String enterpriseVerifyReason;
                @JsonProperty("secret")
                private Integer secret;
                @JsonProperty("userCanceled")
                private Boolean userCanceled;
                @JsonProperty("roomData")
                private RoomDataDTO roomData;
                @JsonProperty("shareQrcodeUrl")
                private String shareQrcodeUrl;
                @JsonProperty("roomId")
                private Integer roomId;
                @JsonProperty("isBlocked")
                private Boolean isBlocked;
                @JsonProperty("isBlock")
                private Boolean isBlock;
                @JsonProperty("favoritePermission")
                private Object favoritePermission;
                @JsonProperty("showFavoriteList")
                private Boolean showFavoriteList;

                @NoArgsConstructor
                @Data
                public static class RoomDataDTO {
                }
            }
        }

        @NoArgsConstructor
        @Data
        public static class MixDTO {
            @JsonProperty("statusCode")
            private Integer statusCode;
            @JsonProperty("hasMore")
            private Integer hasMore;
            @JsonProperty("cursor")
            private Integer cursor;
            @JsonProperty("total")
            private Object total;
            @JsonProperty("logPb")
            private String logPb;
            @JsonProperty("data")
            private List<?> data;
            @JsonProperty("consumerTime")
            private Integer consumerTime;
        }

        @NoArgsConstructor
        @Data
        public static class PostDTO {
            @JsonProperty("statusCode")
            private Integer statusCode;
            @JsonProperty("hasMore")
            private Integer hasMore;
            @JsonProperty("cursor")
            private Long cursor;
            @JsonProperty("maxCursor")
            private Long maxCursor;
            @JsonProperty("logPb")
            private LogPbDTO logPb;
            @JsonProperty("data")
            private List<DataDTO> data;
            @JsonProperty("consumerTime")
            private Integer consumerTime;

            @NoArgsConstructor
            @Data
            public static class LogPbDTO {
                @JsonProperty("impr_id")
                private String impr_id;
            }

            @NoArgsConstructor
            @Data
            public static class DataDTO {
                @JsonProperty("awemeId")
                private String awemeId;
                @JsonProperty("awemeType")
                private Integer awemeType;
                @JsonProperty("groupId")
                private String groupId;
                @JsonProperty("authorInfo")
                private AuthorInfoDTO authorInfo;
                @JsonProperty("desc")
                private String desc;
                @JsonProperty("createTime")
                private Integer createTime;
                @JsonProperty("textExtra")
                private List<?> textExtra;
                @JsonProperty("userDigged")
                private Boolean userDigged;
                @JsonProperty("video")
                private VideoDTO video;
                @JsonProperty("mixInfo")
                private MixInfoDTO mixInfo;
                @JsonProperty("isPrivate")
                private Boolean isPrivate;
                @JsonProperty("isFriendLimit")
                private Boolean isFriendLimit;
                @JsonProperty("download")
                private DownloadDTO download;
                @JsonProperty("impressionData")
                private String impressionData;
                @JsonProperty("tag")
                private TagDTO tag;
                @JsonProperty("stats")
                private StatsDTO stats;
                @JsonProperty("shareInfo")
                private ShareInfoDTO shareInfo;
                @JsonProperty("status")
                private StatusDTO status;

                @NoArgsConstructor
                @Data
                public static class AuthorInfoDTO {
                    @JsonProperty("uid")
                    private String uid;
                    @JsonProperty("secUid")
                    private String secUid;
                    @JsonProperty("nickname")
                    private String nickname;
                    @JsonProperty("avatarUri")
                    private String avatarUri;
                    @JsonProperty("followStatus")
                    private Integer followStatus;
                    @JsonProperty("followerStatus")
                    private Integer followerStatus;
                    @JsonProperty("enterpriseVerifyReason")
                    private String enterpriseVerifyReason;
                    @JsonProperty("customVerify")
                    private String customVerify;
                }

                @NoArgsConstructor
                @Data
                public static class VideoDTO {
                    @JsonProperty("width")
                    private Integer width;
                    @JsonProperty("height")
                    private Integer height;
                    @JsonProperty("ratio")
                    private String ratio;
                    @JsonProperty("duration")
                    private Integer duration;
                    @JsonProperty("playAddr")
                    private List<PlayAddrDTO> playAddr;
                    @JsonProperty("playApi")
                    private String playApi;
                    @JsonProperty("bitRateList")
                    private List<BitRateListDTO> bitRateList;
                    @JsonProperty("cover")
                    private String cover;
                    @JsonProperty("dynamicCover")
                    private String dynamicCover;
                    @JsonProperty("originCover")
                    private String originCover;

                    @NoArgsConstructor
                    @Data
                    public static class PlayAddrDTO {
                        @JsonProperty("src")
                        private String src;
                    }

                    @NoArgsConstructor
                    @Data
                    public static class BitRateListDTO {
                        @JsonProperty("width")
                        private Integer width;
                        @JsonProperty("height")
                        private Integer height;
                        @JsonProperty("playAddr")
                        private List<PlayAddrDTO> playAddr;
                        @JsonProperty("playApi")
                        private String playApi;
                        @JsonProperty("isH265")
                        private Integer isH265;
                        @JsonProperty("qualityType")
                        private Integer qualityType;
                        @JsonProperty("bitRate")
                        private Integer bitRate;
                        @JsonProperty("videoFormat")
                        private String videoFormat;

                        @NoArgsConstructor
                        @Data
                        public static class PlayAddrDTO {
                            @JsonProperty("src")
                            private String src;
                        }
                    }
                }

                @NoArgsConstructor
                @Data
                public static class MixInfoDTO {
                    @JsonProperty("cover")
                    private String cover;
                    @JsonProperty("status")
                    private Integer status;
                }

                @NoArgsConstructor
                @Data
                public static class DownloadDTO {
                    @JsonProperty("prevent")
                    private Boolean prevent;
                    @JsonProperty("url")
                    private String url;
                }

                @NoArgsConstructor
                @Data
                public static class TagDTO {
                    @JsonProperty("isTop")
                    private Boolean isTop;
                    @JsonProperty("relationLabels")
                    private Boolean relationLabels;
                    @JsonProperty("isStory")
                    private Boolean isStory;
                    @JsonProperty("reviewStatus")
                    private Integer reviewStatus;
                    @JsonProperty("inReviewing")
                    private Boolean inReviewing;
                }

                @NoArgsConstructor
                @Data
                public static class StatsDTO {
                    @JsonProperty("commentCount")
                    private Integer commentCount;
                    @JsonProperty("diggCount")
                    private Integer diggCount;
                    @JsonProperty("shareCount")
                    private Integer shareCount;
                    @JsonProperty("playCount")
                    private Integer playCount;
                }

                @NoArgsConstructor
                @Data
                public static class ShareInfoDTO {
                    @JsonProperty("shareUrl")
                    private String shareUrl;
                    @JsonProperty("shareLinkDesc")
                    private String shareLinkDesc;
                }

                @NoArgsConstructor
                @Data
                public static class StatusDTO {
                    @JsonProperty("allowShare")
                    private Boolean allowShare;
                    @JsonProperty("isReviewing")
                    private Boolean isReviewing;
                    @JsonProperty("isDelete")
                    private Boolean isDelete;
                    @JsonProperty("isProhibited")
                    private Boolean isProhibited;
                    @JsonProperty("privateStatus")
                    private Integer privateStatus;
                    @JsonProperty("reviewStatus")
                    private Integer reviewStatus;
                }
            }
        }
    }
}
