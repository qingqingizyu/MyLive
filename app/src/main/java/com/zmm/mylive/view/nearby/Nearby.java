package com.zmm.mylive.view.nearby;

/**
 * 附近的实体对象
 */

public class Nearby {

    /**
     * id : 2537234
     * level : 6
     * gender : 0
     * nick : 缁欎笉浜嗕綘鎯宠鐨勷煈嬸煆�
     * portrait : OTc1NDQxNDY5Mzc1NjEy.jpg
     */

    private CreatorBean creator;
    /**
     * creator : {"id":2537234,"level":6,"gender":0,"nick":"缁欎笉浜嗕綘鎯宠鐨勷煈嬸煆�","portrait":"OTc1NDQxNDY5Mzc1NjEy.jpg"}
     * id : 1476100966428792
     * name :
     * city : 鍖椾含甯�
     * share_addr : http://mlive6.inke.cn/share/live.html?uid=2537234&liveid=1476100966428792&ctime=1476100966
     * stream_addr : http://pull2.a8.com/live/1476100966428792.flv
     * version : 0
     * slot : 3
     * optimal : 0
     * group : 67
     * distance : 4.3km
     * link : 0
     * multi : 0
     */

    private String id;
    private String name;
    private String city;
    private String share_addr;
    private String stream_addr;
    private int version;
    private int slot;
    private int optimal;
    private int group;
    private String distance;
    private int link;
    private int multi;

    public CreatorBean getCreator() {
        return creator;
    }

    public void setCreator(CreatorBean creator) {
        this.creator = creator;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getShare_addr() {
        return share_addr;
    }

    public void setShare_addr(String share_addr) {
        this.share_addr = share_addr;
    }

    public String getStream_addr() {
        return stream_addr;
    }

    public void setStream_addr(String stream_addr) {
        this.stream_addr = stream_addr;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public int getOptimal() {
        return optimal;
    }

    public void setOptimal(int optimal) {
        this.optimal = optimal;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public int getLink() {
        return link;
    }

    public void setLink(int link) {
        this.link = link;
    }

    public int getMulti() {
        return multi;
    }

    public void setMulti(int multi) {
        this.multi = multi;
    }

    public static class CreatorBean {
        private int id;
        private int level;
        private int gender;
        private String nick;
        private String portrait;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public String getPortrait() {
            return portrait;
        }

        public void setPortrait(String portrait) {
            this.portrait = portrait;
        }
    }
}
