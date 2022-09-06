package com.lizhihai.juejin.domain.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class Xiangqin {

    @JSONField(name = "err_no")
    private Integer errNo;
    @JSONField(name = "err_msg")
    private String errMsg;
    @JSONField(name = "data")
    private List<DataDTO> data;
    @JSONField(name = "cursor")
    private String cursor;
    @JSONField(name = "count")
    private Integer count;
    @JSONField(name = "has_more")
    private Boolean hasMore;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JSONField(name = "msg_id")
        private String msgId;
        @JSONField(name = "msg_Info")
        private MsgInfoDTO msgInfo;
        @JSONField(name = "author_user_info")
        private AuthorUserInfoDTO authorUserInfo;
        @JSONField(name = "hot_comment")
        private HotCommentDTO hotComment;
        @JSONField(name = "digg_user")
        private List<?> diggUser;

        @NoArgsConstructor
        @Data
        public static class MsgInfoDTO {
            @JSONField(name = "id")
            private Integer id;
            @JSONField(name = "msg_id")
            private String msgId;
            @JSONField(name = "user_id")
            private String userId;
            @JSONField(name = "topic_id")
            private String topicId;
            @JSONField(name = "content")
            private String content;
            @JSONField(name = "pic_list")
            private List<String> picList;
            @JSONField(name = "url")
            private String url;
            @JSONField(name = "url_title")
            private String urlTitle;
            @JSONField(name = "url_pic")
            private String urlPic;
            @JSONField(name = "verify_status")
            private Integer verifyStatus;
            @JSONField(name = "status")
            private Integer status;
            @JSONField(name = "ctime")
            private String ctime;
            @JSONField(name = "mtime")
            private String mtime;
            @JSONField(name = "rtime")
            private String rtime;
            @JSONField(name = "comment_count")
            private Integer commentCount;
            @JSONField(name = "digg_count")
            private Integer diggCount;
            @JSONField(name = "hot_index")
            private Double hotIndex;
            @JSONField(name = "rank_index")
            private Double rankIndex;
            @JSONField(name = "comment_score")
            private Integer commentScore;
            @JSONField(name = "is_advert_recommend")
            private Boolean isAdvertRecommend;
            @JSONField(name = "audit_status")
            private Integer auditStatus;
            @JSONField(name = "theme_id")
            private String themeId;
        }

        @NoArgsConstructor
        @Data
        public static class AuthorUserInfoDTO {
            @JSONField(name = "user_id")
            private String userId;
            @JSONField(name = "user_name")
            private String userName;
            @JSONField(name = "company")
            private String company;
            @JSONField(name = "job_title")
            private String jobTitle;
            @JSONField(name = "avatar_large")
            private String avatarLarge;
            @JSONField(name = "level")
            private Integer level;
            @JSONField(name = "description")
            private String description;
            @JSONField(name = "followee_count")
            private Integer followeeCount;
            @JSONField(name = "follower_count")
            private Integer followerCount;
            @JSONField(name = "post_article_count")
            private Integer postArticleCount;
            @JSONField(name = "digg_article_count")
            private Integer diggArticleCount;
            @JSONField(name = "got_digg_count")
            private Integer gotDiggCount;
            @JSONField(name = "got_view_count")
            private Integer gotViewCount;
            @JSONField(name = "post_shortmsg_count")
            private Integer postShortmsgCount;
            @JSONField(name = "digg_shortmsg_count")
            private Integer diggShortmsgCount;
            @JSONField(name = "isfollowed")
            private Boolean isfollowed;
            @JSONField(name = "favorable_author")
            private Integer favorableAuthor;
            @JSONField(name = "power")
            private Integer power;
            @JSONField(name = "study_point")
            private Integer studyPoint;

            @JSONField(name = "student_status")
            private Integer studentStatus;
            @JSONField(name = "select_event_count")
            private Integer selectEventCount;
            @JSONField(name = "select_online_course_count")
            private Integer selectOnlineCourseCount;
            @JSONField(name = "identity")
            private Integer identity;
            @JSONField(name = "is_select_annual")
            private Boolean isSelectAnnual;
            @JSONField(name = "select_annual_rank")
            private Integer selectAnnualRank;
            @JSONField(name = "annual_list_type")
            private Integer annualListType;

            @JSONField(name = "is_logout")
            private Integer isLogout;
            @JSONField(name = "annual_info")
            private List<?> annualInfo;
            @JSONField(name = "account_amount")
            private Integer accountAmount;
            @JSONField(name = "user_growth_info")
            private UserGrowthInfoDTO userGrowthInfo;
            @JSONField(name = "is_vip")
            private Boolean isVip;
            @JSONField(name = "become_author_days")
            private Integer becomeAuthorDays;
            @JSONField(name = "collection_set_article_count")
            private Integer collectionSetArticleCount;



            @NoArgsConstructor
            @Data
            public static class UserGrowthInfoDTO {
                @JSONField(name = "user_id")
                private Long userId;
                @JSONField(name = "jpower")
                private Integer jpower;
                @JSONField(name = "jscore")
                private Double jscore;
                @JSONField(name = "jpower_level")
                private Integer jpowerLevel;
                @JSONField(name = "jscore_level")
                private Integer jscoreLevel;
                @JSONField(name = "jscore_title")
                private String jscoreTitle;
                @JSONField(name = "author_achievement_list")
                private List<?> authorAchievementList;
                @JSONField(name = "vip_level")
                private Integer vipLevel;
                @JSONField(name = "vip_title")
                private String vipTitle;
                @JSONField(name = "jscore_next_level_score")
                private Long jscoreNextLevelScore;
            }
        }


        @NoArgsConstructor
        @Data
        public static class HotCommentDTO {
            @JSONField(name = "comment_id")
            private String commentId;
            @JSONField(name = "comment_info")
            private CommentInfoDTO commentInfo;
            @JSONField(name = "user_info")
            private UserInfoDTO userInfo;
            @JSONField(name = "reply_infos")
            private List<?> replyInfos;
            @JSONField(name = "is_author")
            private Boolean isAuthor;

            @NoArgsConstructor
            @Data
            public static class CommentInfoDTO {
                @JSONField(name = "comment_id")
                private String commentId;
                @JSONField(name = "user_id")
                private String userId;
                @JSONField(name = "item_id")
                private String itemId;
                @JSONField(name = "item_type")
                private Integer itemType;
                @JSONField(name = "comment_content")
                private String commentContent;
                @JSONField(name = "comment_pics")
                private List<?> commentPics;
                @JSONField(name = "comment_status")
                private Integer commentStatus;
                @JSONField(name = "ctime")
                private Long ctime;
                @JSONField(name = "comment_replys")
                private List<CommentReplysDTO> commentReplys;
                @JSONField(name = "digg_count")
                private Integer diggCount;
                @JSONField(name = "bury_count")
                private Integer buryCount;
                @JSONField(name = "reply_count")
                private Integer replyCount;
                @JSONField(name = "is_digg")
                private Boolean isDigg;
                @JSONField(name = "is_bury")
                private Boolean isBury;
                @JSONField(name = "level")
                private Integer level;

                @NoArgsConstructor
                @Data
                public static class CommentReplysDTO {
                    @JSONField(name = "reply_id")
                    private String replyId;
                    @JSONField(name = "reply_comment_id")
                    private String replyCommentId;
                    @JSONField(name = "user_id")
                    private String userId;
                    @JSONField(name = "reply_to_reply_id")
                    private String replyToReplyId;
                    @JSONField(name = "reply_to_user_id")
                    private String replyToUserId;
                    @JSONField(name = "item_id")
                    private String itemId;
                    @JSONField(name = "item_type")
                    private Integer itemType;
                    @JSONField(name = "reply_content")
                    private String replyContent;
                    @JSONField(name = "reply_pics")
                    private List<?> replyPics;
                    @JSONField(name = "reply_status")
                    private Integer replyStatus;
                    @JSONField(name = "ctime")
                    private Long ctime;
                    @JSONField(name = "digg_count")
                    private Integer diggCount;
                    @JSONField(name = "burry_count")
                    private Integer burryCount;
                }
            }

            @NoArgsConstructor
            @Data
            public static class UserInfoDTO {
                @JSONField(name = "user_id")
                private String userId;
                @JSONField(name = "user_name")
                private String userName;
                @JSONField(name = "company")
                private String company;
                @JSONField(name = "job_title")
                private String jobTitle;
                @JSONField(name = "avatar_large")
                private String avatarLarge;
                @JSONField(name = "level")
                private Integer level;
                @JSONField(name = "description")
                private String description;
                @JSONField(name = "followee_count")
                private Integer followeeCount;
                @JSONField(name = "follower_count")
                private Integer followerCount;
                @JSONField(name = "post_article_count")
                private Integer postArticleCount;
                @JSONField(name = "digg_article_count")
                private Integer diggArticleCount;
                @JSONField(name = "got_digg_count")
                private Integer gotDiggCount;
                @JSONField(name = "got_view_count")
                private Integer gotViewCount;
                @JSONField(name = "post_shortmsg_count")
                private Integer postShortmsgCount;
                @JSONField(name = "digg_shortmsg_count")
                private Integer diggShortmsgCount;
                @JSONField(name = "isfollowed")
                private Boolean isfollowed;
                @JSONField(name = "favorable_author")
                private Integer favorableAuthor;
                @JSONField(name = "power")
                private Integer power;
                @JSONField(name = "study_point")
                private Integer studyPoint;
                @JSONField(name = "university")
                private Object university;
                @JSONField(name = "major")
                private Object major;
                @JSONField(name = "student_status")
                private Integer studentStatus;
                @JSONField(name = "select_event_count")
                private Integer selectEventCount;
                @JSONField(name = "select_online_course_count")
                private Integer selectOnlineCourseCount;
                @JSONField(name = "identity")
                private Integer identity;
                @JSONField(name = "is_select_annual")
                private Boolean isSelectAnnual;
                @JSONField(name = "select_annual_rank")
                private Integer selectAnnualRank;
                @JSONField(name = "annual_list_type")
                private Integer annualListType;
                @JSONField(name = "extraMap")
                private Object extraMap;
                @JSONField(name = "is_logout")
                private Integer isLogout;
                @JSONField(name = "annual_info")
                private Object annualInfo;
                @JSONField(name = "account_amount")
                private Integer accountAmount;
                @JSONField(name = "user_growth_info")
                private Object userGrowthInfo;
                @JSONField(name = "is_vip")
                private Boolean isVip;
                @JSONField(name = "become_author_days")
                private Integer becomeAuthorDays;
                @JSONField(name = "collection_set_article_count")
                private Integer collectionSetArticleCount;
            }


        }
    }
}
