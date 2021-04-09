package online.goudan.domain;

import java.util.List;

/**
 * @author chenglongliu
 * @date 2021/4/9 20:23
 * @desc Room
 */
public class Room {

    /**
     * error : 0
     * data : {"allColumn":[{"cate_id":1,"cate_name":"网游竞技","short_name":"PCgame","push_vertical_screen":0,"is_show_rank_list":1,"is_audio":0},{"cate_id":2,"cate_name":"娱乐天地","short_name":"yl","push_vertical_screen":0,"is_show_rank_list":1,"is_audio":0}],"list":[{"room_id":7107176,"chanid":0,"room_src":"https://rpic.douyucdn.cn/asrpic/210409/7107176_2014.png/dy1","vertical_src":"https://rpic.douyucdn.cn/asrpic/210409/7107176_2014.png/dy2","isVertical":0,"is_special":0,"cate_id":194,"child_id":0,"room_name":"【持续更新】大口吃肉，大口吃蒜！","nickname":"徐大sao","avatar_small":"https://apic.douyucdn.cn/upload/avatar_v3/201906/b21443fc92d343539452ef4673157e6b_big.jpg","status":0,"show_status":1,"show_time":1616911992,"nrt":0,"url":"/7107176","jumpUrl":"","game_name":"美食","online":"47.5万","hasvid":0,"vurl":"","close_notice":"","close_notice_ctime":"","sub_rt":0,"rpos":0,"icon_outing":0,"videoLoop":1,"isShowUp":1},{"room_id":6566716,"chanid":0,"room_src":"https://rpic.douyucdn.cn/live-cover/roomCover/2020/12/07/6e528875fd9550ef01f2b3ea3406ac22_big.png/dy1","vertical_src":"https://rpic.douyucdn.cn/live-cover/roomCover/2020/12/07/6e528875fd9550ef01f2b3ea3406ac22_small.png/dy2","isVertical":0,"is_special":0,"cate_id":1008,"child_id":0,"room_name":"全角度舞姬伊娃月","nickname":"伊娃月evayue","avatar_small":"https://apic.douyucdn.cn/upload/avatar_v3/202102/a43092b62c264288b21f23cc4eb63333_big.jpg","status":0,"show_status":1,"show_time":1617969050,"nrt":0,"url":"/6566716","jumpUrl":"","game_name":"舞蹈","online":"39.3万","hasvid":0,"vurl":"","close_notice":"","close_notice_ctime":"","sub_rt":0,"rpos":0,"icon_outing":0,"videoLoop":0,"isShowUp":0},{"room_id":528583,"chanid":0,"room_src":"https://rpic.douyucdn.cn/live-cover/roomCover/cover_update/2021/03/26/89b94d48b78ab154c340b12c819406f3.jpg/dy1","vertical_src":"https://rpic.douyucdn.cn/live-cover/roomCover/cover_update/2021/03/26/89b94d48b78ab154c340b12c819406f3.jpg/dy2","isVertical":0,"is_special":0,"cate_id":65,"child_id":0,"room_name":"武林争霸赛 8进4 OB 528583","nickname":"忆旧年丶","avatar_small":"https://apic.douyucdn.cn/upload/avatar_v3/202006/975c5eabc3ad4449926356c48f02507c_big.jpg","status":0,"show_status":1,"show_time":1617970123,"nrt":0,"url":"/528583","jumpUrl":"","game_name":"剑网3","online":"30.6万","hasvid":0,"vurl":"","close_notice":"","close_notice_ctime":"","sub_rt":0,"rpos":0,"icon_outing":0,"videoLoop":0,"isShowUp":0},{"room_id":8852876,"chanid":0,"room_src":"https://rpic.douyucdn.cn/asrpic/210409/8852876_2019.png/dy1","vertical_src":"https://rpic.douyucdn.cn/asrpic/210409/8852876_2019.png/dy2","isVertical":0,"is_special":0,"cate_id":65,"child_id":0,"room_name":"一二三四五.....","nickname":"柳词歌妤丶","avatar_small":"https://apic.douyucdn.cn/upload/avatar/default/07_big.jpg","status":0,"show_status":1,"show_time":1617966390,"nrt":0,"url":"/8852876","jumpUrl":"","game_name":"剑网3","online":"27.0万","hasvid":0,"vurl":"","close_notice":"","close_notice_ctime":"","sub_rt":0,"rpos":0,"icon_outing":0,"videoLoop":0,"isShowUp":0},{"room_id":5842150,"chanid":0,"room_src":"https://rpic.douyucdn.cn/asrpic/210409/5842150_2019.png/dy1","vertical_src":"https://rpic.douyucdn.cn/asrpic/210409/5842150_2019.png/dy2","isVertical":0,"is_special":0,"cate_id":65,"child_id":0,"room_name":"新手奶秀 就勉强奶个鲸丐吧！","nickname":"鲤九v","avatar_small":"https://apic.douyucdn.cn/upload/avatar_v3/202004/941901080bba439f90ec09f56c554ee1_big.jpg","status":0,"show_status":1,"show_time":1617966623,"nrt":0,"url":"/5842150","jumpUrl":"","game_name":"剑网3","online":"20.9万","hasvid":0,"vurl":"","close_notice":"","close_notice_ctime":"","sub_rt":0,"rpos":0,"icon_outing":0,"videoLoop":0,"isShowUp":0},{"room_id":4262598,"chanid":0,"room_src":"https://rpic.douyucdn.cn/asrpic/210409/4262598_2014.png/dy1","vertical_src":"https://rpic.douyucdn.cn/asrpic/210409/4262598_2014.png/dy2","isVertical":0,"is_special":0,"cate_id":194,"child_id":0,"room_name":"山药视频已更新，请放心食用~","nickname":"山药视频","avatar_small":"https://apic.douyucdn.cn/upload/avanew/face/201805/4c4aefb998df19c3e18f85f0fa287c67_big.jpg","status":0,"show_status":1,"show_time":1617943646,"nrt":0,"url":"/4262598","jumpUrl":"","game_name":"美食","online":"10.8万","hasvid":0,"vurl":"","close_notice":"","close_notice_ctime":"","sub_rt":0,"rpos":0,"icon_outing":0,"videoLoop":1,"isShowUp":1},{"room_id":533756,"chanid":0,"room_src":"https://rpic.douyucdn.cn/live-cover/roomCover/cover_update/2021/03/26/b7d24bfee6a0730f087522c904ed770b.jpg/dy1","vertical_src":"https://rpic.douyucdn.cn/live-cover/roomCover/cover_update/2021/03/26/b7d24bfee6a0730f087522c904ed770b.jpg/dy2","isVertical":0,"is_special":0,"cate_id":65,"child_id":0,"room_name":"单排绝境~跟恶势力做斗争","nickname":"雨雨雨雨豪","avatar_small":"https://apic.douyucdn.cn/upload/avatar_v3/201807/895bbe5947d7403689e29f83db8daf9b_big.jpg","status":0,"show_status":2,"show_time":1617941730,"nrt":0,"url":"/533756","jumpUrl":"","game_name":"剑网3","online":"0","hasvid":1,"vurl":"https://v.douyu.com/show/jwzOvpOPDaLWZVRm","close_notice":"每天2场直播中午12点-3点，晚上9点到凌晨一点","close_notice_ctime":"06.17","sub_rt":0,"rpos":0,"icon_outing":0,"videoLoop":0,"isShowUp":0},{"room_id":6704733,"chanid":0,"room_src":"https://rpic.douyucdn.cn/live-cover/appCovers/2021/01/25/6704733_20210125140254_small.jpg/dy1","vertical_src":"https://rpic.douyucdn.cn/live-cover/appCovers/2021/01/25/6704733_20210125140254_big.jpg/dy2","isVertical":0,"is_special":0,"cate_id":311,"child_id":0,"room_name":"全斗鱼最凉直播间","nickname":"小小圣熙","avatar_small":"https://apic.douyucdn.cn/upload/avatar_v3/201906/ec00d04dd0eb4bc0a9891aadb0f76c2c_big.jpg","status":0,"show_status":2,"show_time":1614511224,"nrt":0,"url":"/6704733","jumpUrl":"","game_name":"颜值","online":"0","hasvid":0,"vurl":"","close_notice":"","close_notice_ctime":"","sub_rt":0,"rpos":0,"icon_outing":0,"videoLoop":0,"isShowUp":0},{"room_id":1647590,"chanid":0,"room_src":"https://rpic.douyucdn.cn/asrpic/210322/1647590_2228.png/dy1","vertical_src":"https://rpic.douyucdn.cn/asrpic/210322/1647590_2228.png/dy2","isVertical":0,"is_special":0,"cate_id":65,"child_id":0,"room_name":"◤小軟◢ 月播主播上线了嗷~~","nickname":"小阿軟","avatar_small":"https://apic.douyucdn.cn/upload/avanew/face/201702/04/18/8ec6bb1154d5b79c8654374429e875f4_big.jpg","status":0,"show_status":2,"show_time":1616417474,"nrt":0,"url":"/1647590","jumpUrl":"","game_name":"剑网3","online":"0","hasvid":0,"vurl":"","close_notice":"剑三PVP吃鸡 JJC  唱歌","close_notice_ctime":"03.19","sub_rt":0,"rpos":0,"icon_outing":0,"videoLoop":0,"isShowUp":0},{"room_id":9246722,"chanid":0,"room_src":"https://rpic.douyucdn.cn/live-cover/appCovers/2020/12/25/9246722_20201225172649_small.jpg/dy1","vertical_src":"https://rpic.douyucdn.cn/live-cover/appCovers/2020/12/25/9246722_20201225172649_big.jpg/dy2","isVertical":0,"is_special":0,"cate_id":311,"child_id":0,"room_name":"某年某月我还在等着你出现","nickname":"漉雪千山丶","avatar_small":"https://apic.douyucdn.cn/upload/avatar_v3/202011/f51d228f4ad94d05bf4c3b61079315d8_big.jpg","status":0,"show_status":2,"show_time":1609319271,"nrt":0,"url":"/9246722","jumpUrl":"","game_name":"颜值","online":"0","hasvid":0,"vurl":"","close_notice":"","close_notice_ctime":"","sub_rt":0,"rpos":0,"icon_outing":0,"videoLoop":0,"isShowUp":0}],"limit":0,"pageCount":1,"nowPage":1,"total":10,"has_special":0}
     * msg : ok
     */

    private int error;
    private DataDTO data;
    private String msg;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataDTO {
        /**
         * allColumn : [{"cate_id":1,"cate_name":"网游竞技","short_name":"PCgame","push_vertical_screen":0,"is_show_rank_list":1,"is_audio":0},{"cate_id":2,"cate_name":"娱乐天地","short_name":"yl","push_vertical_screen":0,"is_show_rank_list":1,"is_audio":0}]
         * list : [{"room_id":7107176,"chanid":0,"room_src":"https://rpic.douyucdn.cn/asrpic/210409/7107176_2014.png/dy1","vertical_src":"https://rpic.douyucdn.cn/asrpic/210409/7107176_2014.png/dy2","isVertical":0,"is_special":0,"cate_id":194,"child_id":0,"room_name":"【持续更新】大口吃肉，大口吃蒜！","nickname":"徐大sao","avatar_small":"https://apic.douyucdn.cn/upload/avatar_v3/201906/b21443fc92d343539452ef4673157e6b_big.jpg","status":0,"show_status":1,"show_time":1616911992,"nrt":0,"url":"/7107176","jumpUrl":"","game_name":"美食","online":"47.5万","hasvid":0,"vurl":"","close_notice":"","close_notice_ctime":"","sub_rt":0,"rpos":0,"icon_outing":0,"videoLoop":1,"isShowUp":1},{"room_id":6566716,"chanid":0,"room_src":"https://rpic.douyucdn.cn/live-cover/roomCover/2020/12/07/6e528875fd9550ef01f2b3ea3406ac22_big.png/dy1","vertical_src":"https://rpic.douyucdn.cn/live-cover/roomCover/2020/12/07/6e528875fd9550ef01f2b3ea3406ac22_small.png/dy2","isVertical":0,"is_special":0,"cate_id":1008,"child_id":0,"room_name":"全角度舞姬伊娃月","nickname":"伊娃月evayue","avatar_small":"https://apic.douyucdn.cn/upload/avatar_v3/202102/a43092b62c264288b21f23cc4eb63333_big.jpg","status":0,"show_status":1,"show_time":1617969050,"nrt":0,"url":"/6566716","jumpUrl":"","game_name":"舞蹈","online":"39.3万","hasvid":0,"vurl":"","close_notice":"","close_notice_ctime":"","sub_rt":0,"rpos":0,"icon_outing":0,"videoLoop":0,"isShowUp":0},{"room_id":528583,"chanid":0,"room_src":"https://rpic.douyucdn.cn/live-cover/roomCover/cover_update/2021/03/26/89b94d48b78ab154c340b12c819406f3.jpg/dy1","vertical_src":"https://rpic.douyucdn.cn/live-cover/roomCover/cover_update/2021/03/26/89b94d48b78ab154c340b12c819406f3.jpg/dy2","isVertical":0,"is_special":0,"cate_id":65,"child_id":0,"room_name":"武林争霸赛 8进4 OB 528583","nickname":"忆旧年丶","avatar_small":"https://apic.douyucdn.cn/upload/avatar_v3/202006/975c5eabc3ad4449926356c48f02507c_big.jpg","status":0,"show_status":1,"show_time":1617970123,"nrt":0,"url":"/528583","jumpUrl":"","game_name":"剑网3","online":"30.6万","hasvid":0,"vurl":"","close_notice":"","close_notice_ctime":"","sub_rt":0,"rpos":0,"icon_outing":0,"videoLoop":0,"isShowUp":0},{"room_id":8852876,"chanid":0,"room_src":"https://rpic.douyucdn.cn/asrpic/210409/8852876_2019.png/dy1","vertical_src":"https://rpic.douyucdn.cn/asrpic/210409/8852876_2019.png/dy2","isVertical":0,"is_special":0,"cate_id":65,"child_id":0,"room_name":"一二三四五.....","nickname":"柳词歌妤丶","avatar_small":"https://apic.douyucdn.cn/upload/avatar/default/07_big.jpg","status":0,"show_status":1,"show_time":1617966390,"nrt":0,"url":"/8852876","jumpUrl":"","game_name":"剑网3","online":"27.0万","hasvid":0,"vurl":"","close_notice":"","close_notice_ctime":"","sub_rt":0,"rpos":0,"icon_outing":0,"videoLoop":0,"isShowUp":0},{"room_id":5842150,"chanid":0,"room_src":"https://rpic.douyucdn.cn/asrpic/210409/5842150_2019.png/dy1","vertical_src":"https://rpic.douyucdn.cn/asrpic/210409/5842150_2019.png/dy2","isVertical":0,"is_special":0,"cate_id":65,"child_id":0,"room_name":"新手奶秀 就勉强奶个鲸丐吧！","nickname":"鲤九v","avatar_small":"https://apic.douyucdn.cn/upload/avatar_v3/202004/941901080bba439f90ec09f56c554ee1_big.jpg","status":0,"show_status":1,"show_time":1617966623,"nrt":0,"url":"/5842150","jumpUrl":"","game_name":"剑网3","online":"20.9万","hasvid":0,"vurl":"","close_notice":"","close_notice_ctime":"","sub_rt":0,"rpos":0,"icon_outing":0,"videoLoop":0,"isShowUp":0},{"room_id":4262598,"chanid":0,"room_src":"https://rpic.douyucdn.cn/asrpic/210409/4262598_2014.png/dy1","vertical_src":"https://rpic.douyucdn.cn/asrpic/210409/4262598_2014.png/dy2","isVertical":0,"is_special":0,"cate_id":194,"child_id":0,"room_name":"山药视频已更新，请放心食用~","nickname":"山药视频","avatar_small":"https://apic.douyucdn.cn/upload/avanew/face/201805/4c4aefb998df19c3e18f85f0fa287c67_big.jpg","status":0,"show_status":1,"show_time":1617943646,"nrt":0,"url":"/4262598","jumpUrl":"","game_name":"美食","online":"10.8万","hasvid":0,"vurl":"","close_notice":"","close_notice_ctime":"","sub_rt":0,"rpos":0,"icon_outing":0,"videoLoop":1,"isShowUp":1},{"room_id":533756,"chanid":0,"room_src":"https://rpic.douyucdn.cn/live-cover/roomCover/cover_update/2021/03/26/b7d24bfee6a0730f087522c904ed770b.jpg/dy1","vertical_src":"https://rpic.douyucdn.cn/live-cover/roomCover/cover_update/2021/03/26/b7d24bfee6a0730f087522c904ed770b.jpg/dy2","isVertical":0,"is_special":0,"cate_id":65,"child_id":0,"room_name":"单排绝境~跟恶势力做斗争","nickname":"雨雨雨雨豪","avatar_small":"https://apic.douyucdn.cn/upload/avatar_v3/201807/895bbe5947d7403689e29f83db8daf9b_big.jpg","status":0,"show_status":2,"show_time":1617941730,"nrt":0,"url":"/533756","jumpUrl":"","game_name":"剑网3","online":"0","hasvid":1,"vurl":"https://v.douyu.com/show/jwzOvpOPDaLWZVRm","close_notice":"每天2场直播中午12点-3点，晚上9点到凌晨一点","close_notice_ctime":"06.17","sub_rt":0,"rpos":0,"icon_outing":0,"videoLoop":0,"isShowUp":0},{"room_id":6704733,"chanid":0,"room_src":"https://rpic.douyucdn.cn/live-cover/appCovers/2021/01/25/6704733_20210125140254_small.jpg/dy1","vertical_src":"https://rpic.douyucdn.cn/live-cover/appCovers/2021/01/25/6704733_20210125140254_big.jpg/dy2","isVertical":0,"is_special":0,"cate_id":311,"child_id":0,"room_name":"全斗鱼最凉直播间","nickname":"小小圣熙","avatar_small":"https://apic.douyucdn.cn/upload/avatar_v3/201906/ec00d04dd0eb4bc0a9891aadb0f76c2c_big.jpg","status":0,"show_status":2,"show_time":1614511224,"nrt":0,"url":"/6704733","jumpUrl":"","game_name":"颜值","online":"0","hasvid":0,"vurl":"","close_notice":"","close_notice_ctime":"","sub_rt":0,"rpos":0,"icon_outing":0,"videoLoop":0,"isShowUp":0},{"room_id":1647590,"chanid":0,"room_src":"https://rpic.douyucdn.cn/asrpic/210322/1647590_2228.png/dy1","vertical_src":"https://rpic.douyucdn.cn/asrpic/210322/1647590_2228.png/dy2","isVertical":0,"is_special":0,"cate_id":65,"child_id":0,"room_name":"◤小軟◢ 月播主播上线了嗷~~","nickname":"小阿軟","avatar_small":"https://apic.douyucdn.cn/upload/avanew/face/201702/04/18/8ec6bb1154d5b79c8654374429e875f4_big.jpg","status":0,"show_status":2,"show_time":1616417474,"nrt":0,"url":"/1647590","jumpUrl":"","game_name":"剑网3","online":"0","hasvid":0,"vurl":"","close_notice":"剑三PVP吃鸡 JJC  唱歌","close_notice_ctime":"03.19","sub_rt":0,"rpos":0,"icon_outing":0,"videoLoop":0,"isShowUp":0},{"room_id":9246722,"chanid":0,"room_src":"https://rpic.douyucdn.cn/live-cover/appCovers/2020/12/25/9246722_20201225172649_small.jpg/dy1","vertical_src":"https://rpic.douyucdn.cn/live-cover/appCovers/2020/12/25/9246722_20201225172649_big.jpg/dy2","isVertical":0,"is_special":0,"cate_id":311,"child_id":0,"room_name":"某年某月我还在等着你出现","nickname":"漉雪千山丶","avatar_small":"https://apic.douyucdn.cn/upload/avatar_v3/202011/f51d228f4ad94d05bf4c3b61079315d8_big.jpg","status":0,"show_status":2,"show_time":1609319271,"nrt":0,"url":"/9246722","jumpUrl":"","game_name":"颜值","online":"0","hasvid":0,"vurl":"","close_notice":"","close_notice_ctime":"","sub_rt":0,"rpos":0,"icon_outing":0,"videoLoop":0,"isShowUp":0}]
         * limit : 0
         * pageCount : 1
         * nowPage : 1
         * total : 10
         * has_special : 0
         */

        private List<AllColumnDTO> allColumn;
        private List<ListDTO> list;
        private int limit;
        private int pageCount;
        private int nowPage;
        private int total;
        private int has_special;

        public List<AllColumnDTO> getAllColumn() {
            return allColumn;
        }

        public void setAllColumn(List<AllColumnDTO> allColumn) {
            this.allColumn = allColumn;
        }

        public List<ListDTO> getList() {
            return list;
        }

        public void setList(List<ListDTO> list) {
            this.list = list;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getNowPage() {
            return nowPage;
        }

        public void setNowPage(int nowPage) {
            this.nowPage = nowPage;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getHas_special() {
            return has_special;
        }

        public void setHas_special(int has_special) {
            this.has_special = has_special;
        }

        public static class AllColumnDTO {
            /**
             * cate_id : 1
             * cate_name : 网游竞技
             * short_name : PCgame
             * push_vertical_screen : 0
             * is_show_rank_list : 1
             * is_audio : 0
             */

            private int cate_id;
            private String cate_name;
            private String short_name;
            private int push_vertical_screen;
            private int is_show_rank_list;
            private int is_audio;

            public int getCate_id() {
                return cate_id;
            }

            public void setCate_id(int cate_id) {
                this.cate_id = cate_id;
            }

            public String getCate_name() {
                return cate_name;
            }

            public void setCate_name(String cate_name) {
                this.cate_name = cate_name;
            }

            public String getShort_name() {
                return short_name;
            }

            public void setShort_name(String short_name) {
                this.short_name = short_name;
            }

            public int getPush_vertical_screen() {
                return push_vertical_screen;
            }

            public void setPush_vertical_screen(int push_vertical_screen) {
                this.push_vertical_screen = push_vertical_screen;
            }

            public int getIs_show_rank_list() {
                return is_show_rank_list;
            }

            public void setIs_show_rank_list(int is_show_rank_list) {
                this.is_show_rank_list = is_show_rank_list;
            }

            public int getIs_audio() {
                return is_audio;
            }

            public void setIs_audio(int is_audio) {
                this.is_audio = is_audio;
            }
        }

        public static class ListDTO {
            /**
             * room_id : 7107176
             * chanid : 0
             * room_src : https://rpic.douyucdn.cn/asrpic/210409/7107176_2014.png/dy1
             * vertical_src : https://rpic.douyucdn.cn/asrpic/210409/7107176_2014.png/dy2
             * isVertical : 0
             * is_special : 0
             * cate_id : 194
             * child_id : 0
             * room_name : 【持续更新】大口吃肉，大口吃蒜！
             * nickname : 徐大sao
             * avatar_small : https://apic.douyucdn.cn/upload/avatar_v3/201906/b21443fc92d343539452ef4673157e6b_big.jpg
             * status : 0
             * show_status : 1
             * show_time : 1616911992
             * nrt : 0
             * url : /7107176
             * jumpUrl :
             * game_name : 美食
             * online : 47.5万
             * hasvid : 0
             * vurl :
             * close_notice :
             * close_notice_ctime :
             * sub_rt : 0
             * rpos : 0
             * icon_outing : 0
             * videoLoop : 1
             * isShowUp : 1
             */

            private int room_id;
            private int chanid;
            private String room_src;
            private String vertical_src;
            private int isVertical;
            private int is_special;
            private int cate_id;
            private int child_id;
            private String room_name;
            private String nickname;
            private String avatar_small;
            private int status;
            private int show_status;
            private int show_time;
            private int nrt;
            private String url;
            private String jumpUrl;
            private String game_name;
            private String online;
            private int hasvid;
            private String vurl;
            private String close_notice;
            private String close_notice_ctime;
            private int sub_rt;
            private int rpos;
            private int icon_outing;
            private int videoLoop;
            private int isShowUp;

            public int getRoom_id() {
                return room_id;
            }

            public void setRoom_id(int room_id) {
                this.room_id = room_id;
            }

            public int getChanid() {
                return chanid;
            }

            public void setChanid(int chanid) {
                this.chanid = chanid;
            }

            public String getRoom_src() {
                return room_src;
            }

            public void setRoom_src(String room_src) {
                this.room_src = room_src;
            }

            public String getVertical_src() {
                return vertical_src;
            }

            public void setVertical_src(String vertical_src) {
                this.vertical_src = vertical_src;
            }

            public int getIsVertical() {
                return isVertical;
            }

            public void setIsVertical(int isVertical) {
                this.isVertical = isVertical;
            }

            public int getIs_special() {
                return is_special;
            }

            public void setIs_special(int is_special) {
                this.is_special = is_special;
            }

            public int getCate_id() {
                return cate_id;
            }

            public void setCate_id(int cate_id) {
                this.cate_id = cate_id;
            }

            public int getChild_id() {
                return child_id;
            }

            public void setChild_id(int child_id) {
                this.child_id = child_id;
            }

            public String getRoom_name() {
                return room_name;
            }

            public void setRoom_name(String room_name) {
                this.room_name = room_name;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getAvatar_small() {
                return avatar_small;
            }

            public void setAvatar_small(String avatar_small) {
                this.avatar_small = avatar_small;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getShow_status() {
                return show_status;
            }

            public void setShow_status(int show_status) {
                this.show_status = show_status;
            }

            public int getShow_time() {
                return show_time;
            }

            public void setShow_time(int show_time) {
                this.show_time = show_time;
            }

            public int getNrt() {
                return nrt;
            }

            public void setNrt(int nrt) {
                this.nrt = nrt;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getJumpUrl() {
                return jumpUrl;
            }

            public void setJumpUrl(String jumpUrl) {
                this.jumpUrl = jumpUrl;
            }

            public String getGame_name() {
                return game_name;
            }

            public void setGame_name(String game_name) {
                this.game_name = game_name;
            }

            public String getOnline() {
                return online;
            }

            public void setOnline(String online) {
                this.online = online;
            }

            public int getHasvid() {
                return hasvid;
            }

            public void setHasvid(int hasvid) {
                this.hasvid = hasvid;
            }

            public String getVurl() {
                return vurl;
            }

            public void setVurl(String vurl) {
                this.vurl = vurl;
            }

            public String getClose_notice() {
                return close_notice;
            }

            public void setClose_notice(String close_notice) {
                this.close_notice = close_notice;
            }

            public String getClose_notice_ctime() {
                return close_notice_ctime;
            }

            public void setClose_notice_ctime(String close_notice_ctime) {
                this.close_notice_ctime = close_notice_ctime;
            }

            public int getSub_rt() {
                return sub_rt;
            }

            public void setSub_rt(int sub_rt) {
                this.sub_rt = sub_rt;
            }

            public int getRpos() {
                return rpos;
            }

            public void setRpos(int rpos) {
                this.rpos = rpos;
            }

            public int getIcon_outing() {
                return icon_outing;
            }

            public void setIcon_outing(int icon_outing) {
                this.icon_outing = icon_outing;
            }

            public int getVideoLoop() {
                return videoLoop;
            }

            public void setVideoLoop(int videoLoop) {
                this.videoLoop = videoLoop;
            }

            public int getIsShowUp() {
                return isShowUp;
            }

            public void setIsShowUp(int isShowUp) {
                this.isShowUp = isShowUp;
            }
        }
    }
}
