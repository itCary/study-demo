package online.goudan.pojo;

import java.util.List;

/**
 * @author chenglongliu
 * @date 2021/4/9 21:17
 * @desc 背包里的礼物
 */
public class BackPack {

    /**
     * data : {"list":[{"batchInfo":{"10":{"batchNum":10,"name":"亲密度+10"},"15":{"batchNum":15,"name":"亲密度+15"},"20":{"batchNum":20,"name":"亲密度+20"},"50":{"batchNum":50,"name":"亲密度+50"},"100":{"batchNum":100,"name":"亲密度+100"}},"bizTag":"","borderColor":"#f76300","chatPic":"/1705/c78bd03226f8cc00d60122bf9260490c.gif","count":54,"description":"","description2":"","devote":0,"effectInfo":{"0":{"animation":{},"banner":{},"face":{},"spine":{}},"20052":{"animation":{},"banner":{},"face":{},"spine":{}}},"exp":1,"expiry":4,"focusPic":"/1705/92c614debee11c3db11f853f3c02ed91.gif","hitInterval":5000,"id":268,"intimate":1,"intro":"粉丝们，挥舞起你们的荧光棒~","isClick":1,"isFace":0,"isValuable":0,"level":0,"levelTime":0,"met":1618156800,"name":"粉丝荧光棒","picUrlPrefix":"https://gfs-op.douyucdn.cn/dygift","price":10,"priceType":2,"propPic":"/1705/7db9beee246848252f1c7fe916259f4e.png","propType":2,"returnNum":0,"sendPic":"/1705/b63e879f49db157a4f17e6a3ab5c9e19.png"}],"totalNum":60,"unlockLevel":10,"validNum":60}
     * error : 0
     * msg : success
     */

    private DataDTO data;
    private int error;
    private String msg;

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataDTO {
        @Override
        public String toString() {
            return "DataDTO{" +
                    "list=" + list +
                    ", totalNum=" + totalNum +
                    ", unlockLevel=" + unlockLevel +
                    ", validNum=" + validNum +
                    '}';
        }

        /**
         * list : [{"batchInfo":{"10":{"batchNum":10,"name":"亲密度+10"},"15":{"batchNum":15,"name":"亲密度+15"},"20":{"batchNum":20,"name":"亲密度+20"},"50":{"batchNum":50,"name":"亲密度+50"},"100":{"batchNum":100,"name":"亲密度+100"}},"bizTag":"","borderColor":"#f76300","chatPic":"/1705/c78bd03226f8cc00d60122bf9260490c.gif","count":54,"description":"","description2":"","devote":0,"effectInfo":{"0":{"animation":{},"banner":{},"face":{},"spine":{}},"20052":{"animation":{},"banner":{},"face":{},"spine":{}}},"exp":1,"expiry":4,"focusPic":"/1705/92c614debee11c3db11f853f3c02ed91.gif","hitInterval":5000,"id":268,"intimate":1,"intro":"粉丝们，挥舞起你们的荧光棒~","isClick":1,"isFace":0,"isValuable":0,"level":0,"levelTime":0,"met":1618156800,"name":"粉丝荧光棒","picUrlPrefix":"https://gfs-op.douyucdn.cn/dygift","price":10,"priceType":2,"propPic":"/1705/7db9beee246848252f1c7fe916259f4e.png","propType":2,"returnNum":0,"sendPic":"/1705/b63e879f49db157a4f17e6a3ab5c9e19.png"}]
         * totalNum : 60
         * unlockLevel : 10
         * validNum : 60
         */

        private List<ListDTO> list;
        private int totalNum;
        private int unlockLevel;
        private int validNum;

        public List<ListDTO> getList() {
            return list;
        }

        public void setList(List<ListDTO> list) {
            this.list = list;
        }

        public int getTotalNum() {
            return totalNum;
        }

        public void setTotalNum(int totalNum) {
            this.totalNum = totalNum;
        }

        public int getUnlockLevel() {
            return unlockLevel;
        }

        public void setUnlockLevel(int unlockLevel) {
            this.unlockLevel = unlockLevel;
        }

        public int getValidNum() {
            return validNum;
        }

        public void setValidNum(int validNum) {
            this.validNum = validNum;
        }

        public static class ListDTO {
            @Override
            public String toString() {
                return "ListDTO{" +
                        "batchInfo=" + batchInfo +
                        ", bizTag='" + bizTag + '\'' +
                        ", borderColor='" + borderColor + '\'' +
                        ", chatPic='" + chatPic + '\'' +
                        ", count=" + count +
                        ", description='" + description + '\'' +
                        ", description2='" + description2 + '\'' +
                        ", devote=" + devote +
                        ", effectInfo=" + effectInfo +
                        ", exp=" + exp +
                        ", expiry=" + expiry +
                        ", focusPic='" + focusPic + '\'' +
                        ", hitInterval=" + hitInterval +
                        ", id=" + id +
                        ", intimate=" + intimate +
                        ", intro='" + intro + '\'' +
                        ", isClick=" + isClick +
                        ", isFace=" + isFace +
                        ", isValuable=" + isValuable +
                        ", level=" + level +
                        ", levelTime=" + levelTime +
                        ", met=" + met +
                        ", name='" + name + '\'' +
                        ", picUrlPrefix='" + picUrlPrefix + '\'' +
                        ", price=" + price +
                        ", priceType=" + priceType +
                        ", propPic='" + propPic + '\'' +
                        ", propType=" + propType +
                        ", returnNum=" + returnNum +
                        ", sendPic='" + sendPic + '\'' +
                        '}';
            }

            /**
             * batchInfo : {"10":{"batchNum":10,"name":"亲密度+10"},"15":{"batchNum":15,"name":"亲密度+15"},"20":{"batchNum":20,"name":"亲密度+20"},"50":{"batchNum":50,"name":"亲密度+50"},"100":{"batchNum":100,"name":"亲密度+100"}}
             * bizTag :
             * borderColor : #f76300
             * chatPic : /1705/c78bd03226f8cc00d60122bf9260490c.gif
             * count : 54
             * description :
             * description2 :
             * devote : 0
             * effectInfo : {"0":{"animation":{},"banner":{},"face":{},"spine":{}},"20052":{"animation":{},"banner":{},"face":{},"spine":{}}}
             * exp : 1
             * expiry : 4
             * focusPic : /1705/92c614debee11c3db11f853f3c02ed91.gif
             * hitInterval : 5000
             * id : 268
             * intimate : 1
             * intro : 粉丝们，挥舞起你们的荧光棒~
             * isClick : 1
             * isFace : 0
             * isValuable : 0
             * level : 0
             * levelTime : 0
             * met : 1618156800
             * name : 粉丝荧光棒
             * picUrlPrefix : https://gfs-op.douyucdn.cn/dygift
             * price : 10
             * priceType : 2
             * propPic : /1705/7db9beee246848252f1c7fe916259f4e.png
             * propType : 2
             * returnNum : 0
             * sendPic : /1705/b63e879f49db157a4f17e6a3ab5c9e19.png
             */

            private BatchInfoDTO batchInfo;
            private String bizTag;
            private String borderColor;
            private String chatPic;
            private int count;
            private String description;
            private String description2;
            private int devote;
            private EffectInfoDTO effectInfo;
            private int exp;
            private int expiry;
            private String focusPic;
            private int hitInterval;
            private int id;
            private int intimate;
            private String intro;
            private int isClick;
            private int isFace;
            private int isValuable;
            private int level;
            private int levelTime;
            private int met;
            private String name;
            private String picUrlPrefix;
            private int price;
            private int priceType;
            private String propPic;
            private int propType;
            private int returnNum;
            private String sendPic;

            public BatchInfoDTO getBatchInfo() {
                return batchInfo;
            }

            public void setBatchInfo(BatchInfoDTO batchInfo) {
                this.batchInfo = batchInfo;
            }

            public String getBizTag() {
                return bizTag;
            }

            public void setBizTag(String bizTag) {
                this.bizTag = bizTag;
            }

            public String getBorderColor() {
                return borderColor;
            }

            public void setBorderColor(String borderColor) {
                this.borderColor = borderColor;
            }

            public String getChatPic() {
                return chatPic;
            }

            public void setChatPic(String chatPic) {
                this.chatPic = chatPic;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getDescription2() {
                return description2;
            }

            public void setDescription2(String description2) {
                this.description2 = description2;
            }

            public int getDevote() {
                return devote;
            }

            public void setDevote(int devote) {
                this.devote = devote;
            }

            public EffectInfoDTO getEffectInfo() {
                return effectInfo;
            }

            public void setEffectInfo(EffectInfoDTO effectInfo) {
                this.effectInfo = effectInfo;
            }

            public int getExp() {
                return exp;
            }

            public void setExp(int exp) {
                this.exp = exp;
            }

            public int getExpiry() {
                return expiry;
            }

            public void setExpiry(int expiry) {
                this.expiry = expiry;
            }

            public String getFocusPic() {
                return focusPic;
            }

            public void setFocusPic(String focusPic) {
                this.focusPic = focusPic;
            }

            public int getHitInterval() {
                return hitInterval;
            }

            public void setHitInterval(int hitInterval) {
                this.hitInterval = hitInterval;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getIntimate() {
                return intimate;
            }

            public void setIntimate(int intimate) {
                this.intimate = intimate;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public int getIsClick() {
                return isClick;
            }

            public void setIsClick(int isClick) {
                this.isClick = isClick;
            }

            public int getIsFace() {
                return isFace;
            }

            public void setIsFace(int isFace) {
                this.isFace = isFace;
            }

            public int getIsValuable() {
                return isValuable;
            }

            public void setIsValuable(int isValuable) {
                this.isValuable = isValuable;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public int getLevelTime() {
                return levelTime;
            }

            public void setLevelTime(int levelTime) {
                this.levelTime = levelTime;
            }

            public int getMet() {
                return met;
            }

            public void setMet(int met) {
                this.met = met;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPicUrlPrefix() {
                return picUrlPrefix;
            }

            public void setPicUrlPrefix(String picUrlPrefix) {
                this.picUrlPrefix = picUrlPrefix;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getPriceType() {
                return priceType;
            }

            public void setPriceType(int priceType) {
                this.priceType = priceType;
            }

            public String getPropPic() {
                return propPic;
            }

            public void setPropPic(String propPic) {
                this.propPic = propPic;
            }

            public int getPropType() {
                return propType;
            }

            public void setPropType(int propType) {
                this.propType = propType;
            }

            public int getReturnNum() {
                return returnNum;
            }

            public void setReturnNum(int returnNum) {
                this.returnNum = returnNum;
            }

            public String getSendPic() {
                return sendPic;
            }

            public void setSendPic(String sendPic) {
                this.sendPic = sendPic;
            }

            public static class BatchInfoDTO {
                @Override
                public String toString() {
                    return "BatchInfoDTO{" +
                            "_$10=" + _$10 +
                            ", _$15=" + _$15 +
                            ", _$20=" + _$20 +
                            ", _$50=" + _$50 +
                            ", _$100=" + _$100 +
                            '}';
                }

                /**
                 * 10 : {"batchNum":10,"name":"亲密度+10"}
                 * 15 : {"batchNum":15,"name":"亲密度+15"}
                 * 20 : {"batchNum":20,"name":"亲密度+20"}
                 * 50 : {"batchNum":50,"name":"亲密度+50"}
                 * 100 : {"batchNum":100,"name":"亲密度+100"}
                 */

                @com.google.gson.annotations.SerializedName("10")
                private DataDTO.ListDTO.BatchInfoDTO._$10DTO _$10;
                @com.google.gson.annotations.SerializedName("15")
                private DataDTO.ListDTO.BatchInfoDTO._$15DTO _$15;
                @com.google.gson.annotations.SerializedName("20")
                private DataDTO.ListDTO.BatchInfoDTO._$20DTO _$20;
                @com.google.gson.annotations.SerializedName("50")
                private DataDTO.ListDTO.BatchInfoDTO._$50DTO _$50;
                @com.google.gson.annotations.SerializedName("100")
                private DataDTO.ListDTO.BatchInfoDTO._$100DTO _$100;

                public _$10DTO get_$10() {
                    return _$10;
                }

                public void set_$10(_$10DTO _$10) {
                    this._$10 = _$10;
                }

                public _$15DTO get_$15() {
                    return _$15;
                }

                public void set_$15(_$15DTO _$15) {
                    this._$15 = _$15;
                }

                public _$20DTO get_$20() {
                    return _$20;
                }

                public void set_$20(_$20DTO _$20) {
                    this._$20 = _$20;
                }

                public _$50DTO get_$50() {
                    return _$50;
                }

                public void set_$50(_$50DTO _$50) {
                    this._$50 = _$50;
                }

                public _$100DTO get_$100() {
                    return _$100;
                }

                public void set_$100(_$100DTO _$100) {
                    this._$100 = _$100;
                }

                public static class _$10DTO {
                    /**
                     * batchNum : 10
                     * name : 亲密度+10
                     */

                    private int batchNum;
                    private String name;

                    public int getBatchNum() {
                        return batchNum;
                    }

                    public void setBatchNum(int batchNum) {
                        this.batchNum = batchNum;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }

                public static class _$15DTO {
                    /**
                     * batchNum : 15
                     * name : 亲密度+15
                     */

                    private int batchNum;
                    private String name;

                    public int getBatchNum() {
                        return batchNum;
                    }

                    public void setBatchNum(int batchNum) {
                        this.batchNum = batchNum;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }

                public static class _$20DTO {
                    /**
                     * batchNum : 20
                     * name : 亲密度+20
                     */

                    private int batchNum;
                    private String name;

                    public int getBatchNum() {
                        return batchNum;
                    }

                    public void setBatchNum(int batchNum) {
                        this.batchNum = batchNum;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }

                public static class _$50DTO {
                    /**
                     * batchNum : 50
                     * name : 亲密度+50
                     */

                    private int batchNum;
                    private String name;

                    public int getBatchNum() {
                        return batchNum;
                    }

                    public void setBatchNum(int batchNum) {
                        this.batchNum = batchNum;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }

                public static class _$100DTO {
                    /**
                     * batchNum : 100
                     * name : 亲密度+100
                     */

                    private int batchNum;
                    private String name;

                    public int getBatchNum() {
                        return batchNum;
                    }

                    public void setBatchNum(int batchNum) {
                        this.batchNum = batchNum;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }
            }

            public static class EffectInfoDTO {
                /**
                 * 0 : {"animation":{},"banner":{},"face":{},"spine":{}}
                 * 20052 : {"animation":{},"banner":{},"face":{},"spine":{}}
                 */

                @com.google.gson.annotations.SerializedName("0")
                private DataDTO.ListDTO.EffectInfoDTO._$0DTO _$0;
                @com.google.gson.annotations.SerializedName("20052")
                private DataDTO.ListDTO.EffectInfoDTO._$20052DTO _$20052;

                public _$0DTO get_$0() {
                    return _$0;
                }

                public void set_$0(_$0DTO _$0) {
                    this._$0 = _$0;
                }

                public _$20052DTO get_$20052() {
                    return _$20052;
                }

                public void set_$20052(_$20052DTO _$20052) {
                    this._$20052 = _$20052;
                }

                public static class _$0DTO {
                    /**
                     * animation : {}
                     * banner : {}
                     * face : {}
                     * spine : {}
                     */

                    private AnimationDTO animation;
                    private BannerDTO banner;
                    private FaceDTO face;
                    private SpineDTO spine;

                    public AnimationDTO getAnimation() {
                        return animation;
                    }

                    public void setAnimation(AnimationDTO animation) {
                        this.animation = animation;
                    }

                    public BannerDTO getBanner() {
                        return banner;
                    }

                    public void setBanner(BannerDTO banner) {
                        this.banner = banner;
                    }

                    public FaceDTO getFace() {
                        return face;
                    }

                    public void setFace(FaceDTO face) {
                        this.face = face;
                    }

                    public SpineDTO getSpine() {
                        return spine;
                    }

                    public void setSpine(SpineDTO spine) {
                        this.spine = spine;
                    }

                    public static class AnimationDTO {
                    }

                    public static class BannerDTO {
                    }

                    public static class FaceDTO {
                    }

                    public static class SpineDTO {
                    }
                }

                public static class _$20052DTO {
                    /**
                     * animation : {}
                     * banner : {}
                     * face : {}
                     * spine : {}
                     */

                    private AnimationDTO animation;
                    private BannerDTO banner;
                    private FaceDTO face;
                    private SpineDTO spine;

                    public AnimationDTO getAnimation() {
                        return animation;
                    }

                    public void setAnimation(AnimationDTO animation) {
                        this.animation = animation;
                    }

                    public BannerDTO getBanner() {
                        return banner;
                    }

                    public void setBanner(BannerDTO banner) {
                        this.banner = banner;
                    }

                    public FaceDTO getFace() {
                        return face;
                    }

                    public void setFace(FaceDTO face) {
                        this.face = face;
                    }

                    public SpineDTO getSpine() {
                        return spine;
                    }

                    public void setSpine(SpineDTO spine) {
                        this.spine = spine;
                    }

                    public static class AnimationDTO {
                    }

                    public static class BannerDTO {
                    }

                    public static class FaceDTO {
                    }

                    public static class SpineDTO {
                    }
                }
            }
        }
    }
}
