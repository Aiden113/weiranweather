package org.kylin.weiranweather.gson;


import com.google.gson.annotations.SerializedName;

/**
 * Created by hello on 2017/10/23.
 */

    public class Suggestion {
        /**
         * air : {"brf":"较差","txt":"气象条件较不利于空气污染物稀释、扩散和清除，请适当减少室外活动时间。"}
         * comf : {"brf":"舒适","txt":"今天夜间不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。"}
         * cw : {"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"}
         * drsg : {"brf":"舒适","txt":"建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。"}
         * flu : {"brf":"少发","txt":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。"}
         * sport : {"brf":"较适宜","txt":"天气较好，户外运动请注意防晒。推荐您进行室内运动。"}
         * trav : {"brf":"适宜","txt":"天气较好，温度适宜，是个好天气哦。这样的天气适宜旅游，您可以尽情地享受大自然的风光。"}
         * uv : {"brf":"强","txt":"紫外线辐射强，建议涂擦SPF20左右、PA++的防晒护肤品。避免在10点至14点暴露于日光下。"}
         */
    @SerializedName("air")
        public AirBean air;
        @SerializedName("comf")
        public ComfBean comf;
        @SerializedName("cw")
        public CwBean cw;
        @SerializedName("drsg")
        public DrsgBean drsg;
        @SerializedName("flu")
        public FluBean flu;
        @SerializedName("sport")
        public SportBean sport;
        @SerializedName("trav")
        public TravBean trav;
        @SerializedName("uv")
        public UvBean uv;

//        public AirBean getAir() {
//            return air;
//        }
//
//        public void setAir(AirBean air) {
//            this.air = air;
//        }
//
//        public ComfBean getComf() {
//            return comf;
//        }
//
//        public void setComf(ComfBean comf) {
//            this.comf = comf;
//        }
//
//        public CwBean getCw() {
//            return cw;
//        }
//
//        public void setCw(CwBean cw) {
//            this.cw = cw;
//        }
//
//        public DrsgBean getDrsg() {
//            return drsg;
//        }
//
//        public void setDrsg(DrsgBean drsg) {
//            this.drsg = drsg;
//        }
//
//        public FluBean getFlu() {
//            return flu;
//        }
//
//        public void setFlu(FluBean flu) {
//            this.flu = flu;
//        }
//
//        public SportBean getSport() {
//            return sport;
//        }
//
//        public void setSport(SportBean sport) {
//            this.sport = sport;
//        }
//
//        public TravBean getTrav() {
//            return trav;
//        }
//
//        public void setTrav(TravBean trav) {
//            this.trav = trav;
//        }
//
//        public UvBean getUv() {
//            return uv;
//        }
//
//        public void setUv(UvBean uv) {
//            this.uv = uv;
//        }

        public static class AirBean {
            /**
             * brf : 较差
             * txt : 气象条件较不利于空气污染物稀释、扩散和清除，请适当减少室外活动时间。
             */

            public String brf;
            public String txt;

//            public String getBrf() {
//                return brf;
//            }
//
//            public void setBrf(String brf) {
//                this.brf = brf;
//            }
//
//            public String getTxt() {
//                return txt;
//            }
//
//            public void setTxt(String txt) {
//                this.txt = txt;
//            }
        }

        public static class ComfBean {
            /**
             * brf : 舒适
             * txt : 今天夜间不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。
             */

            public String brf;
            public String txt;

//            public String getBrf() {
//                return brf;
//            }
//
//            public void setBrf(String brf) {
//                this.brf = brf;
//            }
//
//            public String getTxt() {
//                return txt;
//            }
//
//            public void setTxt(String txt) {
//                this.txt = txt;
//            }
        }

        public static class CwBean {
            /**
             * brf : 较适宜
             * txt : 较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。
             */

            public String brf;
            public String txt;

//            public String getBrf() {
//                return brf;
//            }
//
//            public void setBrf(String brf) {
//                this.brf = brf;
//            }
//
//            public String getTxt() {
//                return txt;
//            }
//
//            public void setTxt(String txt) {
//                this.txt = txt;
//            }
        }

        public static class DrsgBean {
            /**
             * brf : 舒适
             * txt : 建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。
             */

            public String brf;
            public String txt;

//            public String getBrf() {
//                return brf;
//            }
//
//            public void setBrf(String brf) {
//                this.brf = brf;
//            }
//
//            public String getTxt() {
//                return txt;
//            }
//
//            public void setTxt(String txt) {
//                this.txt = txt;
//            }
        }

        public static class FluBean {
            /**
             * brf : 少发
             * txt : 各项气象条件适宜，无明显降温过程，发生感冒机率较低。
             */

            public String brf;
            public String txt;
//
//            public String getBrf() {
//                return brf;
//            }
//
//            public void setBrf(String brf) {
//                this.brf = brf;
//            }
//
//            public String getTxt() {
//                return txt;
//            }
//
//            public void setTxt(String txt) {
//                this.txt = txt;
//            }
        }

        public static class SportBean {
            /**
             * brf : 较适宜
             * txt : 天气较好，户外运动请注意防晒。推荐您进行室内运动。
             */

            public String brf;
            public String txt;

//            public String getBrf() {
//                return brf;
//            }
//
//            public void setBrf(String brf) {
//                this.brf = brf;
//            }
//
//            public String getTxt() {
//                return txt;
//            }
//
//            public void setTxt(String txt) {
//                this.txt = txt;
//            }
        }

        public static class TravBean {
            /**
             * brf : 适宜
             * txt : 天气较好，温度适宜，是个好天气哦。这样的天气适宜旅游，您可以尽情地享受大自然的风光。
             */

            public String brf;
            public String txt;

//            public String getBrf() {
//                return brf;
//            }
//
//            public void setBrf(String brf) {
//                this.brf = brf;
//            }
//
//            public String getTxt() {
//                return txt;
//            }
//
//            public void setTxt(String txt) {
//                this.txt = txt;
//            }
        }

        public static class UvBean {
            /**
             * brf : 强
             * txt : 紫外线辐射强，建议涂擦SPF20左右、PA++的防晒护肤品。避免在10点至14点暴露于日光下。
             */

            public String brf;
            public String txt;
//
//            public String getBrf() {
//                return brf;
//            }
//
//            public void setBrf(String brf) {
//                this.brf = brf;
//            }
//
//            public String getTxt() {
//                return txt;
//            }
//
//            public void setTxt(String txt) {
//                this.txt = txt;
//            }
        }
    }

