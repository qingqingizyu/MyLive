package com.zmm.activity.actor.model;

/**
 * Created by Administrator on 2016/10/11 0011.
 */

public class User {

    /**
     * dm_error : 0
     * error_msg : 鎿嶄綔鎴愬姛
     * user : {"emotion":"淇濆瘑","inke_verify":0,"verified":0,"description":"鎴戞湁涓\u20ac鏍逛粰濂虫銆佸彉闀� 鍙樼煭 鍙樻紓浜綖锛堜竴鍙湁鐢风楗插吇鍛樼殑瀹跺厰鍎匡級","gender":0,"profession":"","id":61154095,"verified_reason":"","nick":"庐锔� 鍏斿効馃尓锔�","location":"鑸规ˉ甯�","birth":"1993-12-13","hometown":"","portrait":"MTQ3NTA4NDIwNjY5OSMyNjYjanBn.jpg","gmutex":0,"third_platform":"0","level":36,"rank_veri":6,"veri_info":"鐜夊コ"}
     */

    private int dm_error;
    private String error_msg;
    /**
     * emotion : 淇濆瘑
     * inke_verify : 0
     * verified : 0
     * description : 鎴戞湁涓€鏍逛粰濂虫銆佸彉闀� 鍙樼煭 鍙樻紓浜綖锛堜竴鍙湁鐢风楗插吇鍛樼殑瀹跺厰鍎匡級
     * gender : 0
     * profession :
     * id : 61154095
     * verified_reason :
     * nick : 庐锔� 鍏斿効馃尓锔�
     * location : 鑸规ˉ甯�
     * birth : 1993-12-13
     * hometown :
     * portrait : MTQ3NTA4NDIwNjY5OSMyNjYjanBn.jpg
     * gmutex : 0
     * third_platform : 0
     * level : 36
     * rank_veri : 6
     * veri_info : 鐜夊コ
     */

    private UserBean user;

    public int getDm_error() {
        return dm_error;
    }

    public void setDm_error(int dm_error) {
        this.dm_error = dm_error;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        private String emotion;
        private int inke_verify;
        private int verified;
        private String description;
        private int gender;
        private String profession;
        private int id;
        private String verified_reason;
        private String nick;
        private String location;
        private String birth;
        private String hometown;
        private String portrait;
        private int gmutex;
        private String third_platform;
        private int level;
        private int rank_veri;
        private String veri_info;

        public String getEmotion() {
            return emotion;
        }

        public void setEmotion(String emotion) {
            this.emotion = emotion;
        }

        public int getInke_verify() {
            return inke_verify;
        }

        public void setInke_verify(int inke_verify) {
            this.inke_verify = inke_verify;
        }

        public int getVerified() {
            return verified;
        }

        public void setVerified(int verified) {
            this.verified = verified;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getProfession() {
            return profession;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getVerified_reason() {
            return verified_reason;
        }

        public void setVerified_reason(String verified_reason) {
            this.verified_reason = verified_reason;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getBirth() {
            return birth;
        }

        public void setBirth(String birth) {
            this.birth = birth;
        }

        public String getHometown() {
            return hometown;
        }

        public void setHometown(String hometown) {
            this.hometown = hometown;
        }

        public String getPortrait() {
            return portrait;
        }

        public void setPortrait(String portrait) {
            this.portrait = portrait;
        }

        public int getGmutex() {
            return gmutex;
        }

        public void setGmutex(int gmutex) {
            this.gmutex = gmutex;
        }

        public String getThird_platform() {
            return third_platform;
        }

        public void setThird_platform(String third_platform) {
            this.third_platform = third_platform;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getRank_veri() {
            return rank_veri;
        }

        public void setRank_veri(int rank_veri) {
            this.rank_veri = rank_veri;
        }

        public String getVeri_info() {
            return veri_info;
        }

        public void setVeri_info(String veri_info) {
            this.veri_info = veri_info;
        }
    }
}
