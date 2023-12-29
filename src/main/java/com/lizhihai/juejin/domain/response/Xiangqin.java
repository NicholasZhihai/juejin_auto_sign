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
        @JSONField(name = "topic")
        private TopicDTO topic;
        @JSONField(name = "user_interact")
        private UserInteractDTO userInteract;
        @JSONField(name = "org")
        private OrgDTO org;
        @JSONField(name = "theme")
        private ThemeDTO theme;
        @JSONField(name = "hot_comment")
        private HotCommentDTO hotComment;
        @JSONField(name = "digg_user")
        private List<DiggUserDTO> diggUser;
        @JSONField(name = "is_selected")
        private Boolean isSelected;

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
            @JSONField(name = "jcode_id")
            private String jcodeId;
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
            @JSONField(name = "university")
            private UniversityDTO university;
            @JSONField(name = "major")
            private MajorDTO major;
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
            private ExtraMapDTO extraMap;
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
            @JSONField(name = "recommend_article_count_daily")
            private Integer recommendArticleCountDaily;
            @JSONField(name = "article_collect_count_daily")
            private Integer articleCollectCountDaily;
            @JSONField(name = "user_priv_info")
            private Object userPrivInfo;

            @NoArgsConstructor
            @Data
            public static class UniversityDTO {
                @JSONField(name = "university_id")
                private String universityId;
                @JSONField(name = "name")
                private String name;
                @JSONField(name = "logo")
                private String logo;
            }

            @NoArgsConstructor
            @Data
            public static class MajorDTO {
            }

            @NoArgsConstructor
            @Data
            public static class ExtraMapDTO {
            }

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
                private Integer jscoreNextLevelScore;
                @JSONField(name = "jscore_this_level_mini_score")
                private Integer jscoreThisLevelMiniScore;
                @JSONField(name = "vip_score")
                private Integer vipScore;
            }
        }

        @NoArgsConstructor
        @Data
        public static class TopicDTO {
            @JSONField(name = "topic_id")
            private String topicId;
            @JSONField(name = "title")
            private String title;
            @JSONField(name = "description")
            private String description;
            @JSONField(name = "icon")
            private String icon;
            @JSONField(name = "msg_count")
            private Integer msgCount;
            @JSONField(name = "follower_count")
            private Integer followerCount;
            @JSONField(name = "attender_count")
            private Integer attenderCount;
            @JSONField(name = "notice")
            private String notice;
            @JSONField(name = "admin_ids")
            private List<String> adminIds;
            @JSONField(name = "theme_ids")
            private List<?> themeIds;
            @JSONField(name = "cate_id")
            private String cateId;
            @JSONField(name = "is_rec")
            private Boolean isRec;
            @JSONField(name = "rec_rank")
            private Integer recRank;
        }

        @NoArgsConstructor
        @Data
        public static class UserInteractDTO {
            @JSONField(name = "id")
            private Long id;
            @JSONField(name = "omitempty")
            private Integer omitempty;
            @JSONField(name = "user_id")
            private Long userId;
            @JSONField(name = "is_digg")
            private Boolean isDigg;
            @JSONField(name = "is_follow")
            private Boolean isFollow;
            @JSONField(name = "is_collect")
            private Boolean isCollect;
            @JSONField(name = "collect_set_count")
            private Integer collectSetCount;
        }

        @NoArgsConstructor
        @Data
        public static class OrgDTO {
            @JSONField(name = "org_info")
            private Object orgInfo;
            @JSONField(name = "is_followed")
            private Boolean isFollowed;
        }

        @NoArgsConstructor
        @Data
        public static class ThemeDTO {
            @JSONField(name = "theme_id")
            private String themeId;
            @JSONField(name = "name")
            private String name;
            @JSONField(name = "cover")
            private String cover;
            @JSONField(name = "brief")
            private String brief;
            @JSONField(name = "is_lottery")
            private Boolean isLottery;
            @JSONField(name = "is_rec")
            private Boolean isRec;
            @JSONField(name = "rec_rank")
            private Integer recRank;
            @JSONField(name = "topic_ids")
            private List<?> topicIds;
            @JSONField(name = "hot")
            private Integer hot;
            @JSONField(name = "view_cnt")
            private Integer viewCnt;
            @JSONField(name = "user_cnt")
            private Integer userCnt;
            @JSONField(name = "status")
            private Integer status;
            @JSONField(name = "ctime")
            private Integer ctime;
            @JSONField(name = "mtime")
            private Integer mtime;
            @JSONField(name = "lottery_begin_time")
            private Integer lotteryBeginTime;
            @JSONField(name = "lottery_end_time")
            private Integer lotteryEndTime;
            @JSONField(name = "theme_type")
            private Integer themeType;
            @JSONField(name = "last_hot")
            private Integer lastHot;
        }

        @NoArgsConstructor
        @Data
        public static class HotCommentDTO {
            @JSONField(name = "comment_id")
            private String commentId;
            @JSONField(name = "comment_info")
            private Object commentInfo;
            @JSONField(name = "user_info")
            private Object userInfo;
            @JSONField(name = "user_interact")
            private Object userInteract;
            @JSONField(name = "reply_infos")
            private Object replyInfos;
            @JSONField(name = "is_author")
            private Boolean isAuthor;
            @JSONField(name = "root_item")
            private Object rootItem;
            @JSONField(name = "is_hot")
            private Boolean isHot;
        }

        @NoArgsConstructor
        @Data
        public static class DiggUserDTO {
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
            private UniversityDTO university;
            @JSONField(name = "major")
            private MajorDTO major;
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
            private ExtraMapDTO extraMap;
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
            @JSONField(name = "recommend_article_count_daily")
            private Integer recommendArticleCountDaily;
            @JSONField(name = "article_collect_count_daily")
            private Integer articleCollectCountDaily;
            @JSONField(name = "user_priv_info")
            private Object userPrivInfo;

            @NoArgsConstructor
            @Data
            public static class UniversityDTO {
                @JSONField(name = "university_id")
                private String universityId;
                @JSONField(name = "name")
                private String name;
                @JSONField(name = "logo")
                private String logo;
            }

            @NoArgsConstructor
            @Data
            public static class MajorDTO {
            }

            @NoArgsConstructor
            @Data
            public static class ExtraMapDTO {
            }

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
                private Integer jscoreNextLevelScore;
                @JSONField(name = "jscore_this_level_mini_score")
                private Integer jscoreThisLevelMiniScore;
                @JSONField(name = "vip_score")
                private Integer vipScore;
            }
        }
    }
}
