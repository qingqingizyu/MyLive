package com.zmm;

import com.zmm.app.MyApp;

/**
 * Created by Administrator on 2016/10/9 0009.
 */

public class Constant {
    public static final String [] TITLES = {"推荐","热门","附近"};
    public static final String [] DEVOTE_TITLES = {"日榜","总榜"};
    //热门界面的接口
    public static final String [] HOT_PATH = {
            "http://120.55.238.158/api/live/simpleall?mtxid=021e64d987a3&devi=862845027820666&uid=238316360&sid=20i20cOVAOc9vpHdKNKPxD4OcHIQWi2dEZ7fNx3l9vH4v8VCIFcr&conn=WIFI&imei=862845027820666&mtid=bb1f3a585466722ae1d7404e00588d81&aid=796f2d53f974841e&cv=IK3.2.10_Android&smid=DuCBPsLybshBOS8XKxvZm8yDJKLqC5y0tiR1hfZ4HekMwJkFXQUPoG5r8ykodxZwdU9%2FCGtrt%2FqvHjLBpVte7pWw&osversion=android_19&proto=4&vv=1.0.3-201609021643.android&icc=89860050161400025312&ua=MeizuM351&lc=3000000000013001&imsi=460003925485312&cc=TG36000&multiaddr="
            ,"http://120.55.238.158/api/live/aggregation?mtxid=021e64d987a3&devi=862845027820666&uid=237474841&sid=20pwHuc9LtgtpHGYHJ5ahYH8X42Dq8JblsD6VSBnei2VpaWbaZ8&conn=WIFI&imei=862845027820666&mtid=e5ba5238b3145c5ad6fed973acdb3298&aid=796f2d53f974841e&cv=IK3.2.10_Android&smid=DuCBPsLybshBOS8XKxvZm8yDJKLqC5y0tiR1hfZ4HekMwJkFXQUPoG5r8ykodxZwdU9%2FCGtrt%2FqvHjLBpVte7pWw&osversion=android_19&proto=4&vv=1.0.3-201609021643.android&icc=89860050161400025312&ua=MeizuM351&lc=3000000000013001&imsi=460003925485312&cc=TG36000&location=0&interest=1&s_sg=e69cdd9c9a4492b78e66a40a2821d04d&s_sc=100&s_st=1476281896"
            ,"http://120.55.238.158/api/live/aggregation?mtxid=021e64d987a3&devi=862845027820666&uid=237474841&sid=20pwHuc9LtgtpHGYHJ5ahYH8X42Dq8JblsD6VSBnei2VpaWbaZ8&conn=WIFI&imei=862845027820666&mtid=e5ba5238b3145c5ad6fed973acdb3298&aid=796f2d53f974841e&cv=IK3.2.10_Android&smid=DuCBPsLybshBOS8XKxvZm8yDJKLqC5y0tiR1hfZ4HekMwJkFXQUPoG5r8ykodxZwdU9%2FCGtrt%2FqvHjLBpVte7pWw&osversion=android_19&proto=4&vv=1.0.3-201609021643.android&icc=89860050161400025312&ua=MeizuM351&lc=3000000000013001&imsi=460003925485312&cc=TG36000&location=0&interest=2&s_sg=e69cdd9c9a4492b78e66a40a2821d04d&s_sc=100&s_st=1476281896"};
    public static final String [] LIKE_TITLE = {"看全部","只看女","只看男"};
    //热门界面跳转到 城市界面的地址头部
    public static final String HOT_CITY_HEAD_PATH = "http://120.55.238.158/api/live/citysearch?mtxid=021e64d987a3&devi=862845027820666&uid=237474841&sid=20i2ewnKSRJAuXHXn5InZsp3Nn8HVnF1y1Ji14u3ZCdnmYbutVCX&conn=WIFI&imei=862845027820666&mtid=bb1f3a585466722ae1d7404e00588d81&aid=796f2d53f974841e&cv=IK3.2.10_Android&smid=DuCBPsLybshBOS8XKxvZm8yDJKLqC5y0tiR1hfZ4HekMwJkFXQUPoG5r8ykodxZwdU9%2FCGtrt%2FqvHjLBpVte7pWw&osversion=android_19&proto=4&vv=1.0.3-201609021643.android&icc=89860050161400025312&ua=MeizuM351&lc=3000000000013001&imsi=460003925485312&cc=TG36000&keyword=";
    //中间部分需要把城市（中文）转码  %E7%81%AB%E6%98%9F";
    //热门界面跳转到 城市界面的地址尾部
    public static final String HOT_CITY_BEHIND_PATH = "&s_sg=ef96310de664fc1d9a813209f7020079&s_sc=100&s_st=1476090610";

    //今日推荐 该接口数据相当 复杂。。。。
//    public static final String RECOMMEND_PATH = "http://120.55.238.158/api/recommend/aggregate?mtxid=021e64d987a3&devi=862845027820666&uid=238316360&sid=20i20cOVAOc9vpHdKNKPxD4OcHIQWi2dEZ7fNx3l9vH4v8VCIFcr&conn=WIFI&imei=862845027820666&mtid=bb1f3a585466722ae1d7404e00588d81&aid=796f2d53f974841e&cv=IK3.2.10_Android&smid=DuCBPsLybshBOS8XKxvZm8yDJKLqC5y0tiR1hfZ4HekMwJkFXQUPoG5r8ykodxZwdU9%2FCGtrt%2FqvHjLBpVte7pWw&osversion=android_19&proto=4&vv=1.0.3-201609021643.android&icc=89860050161400025312&ua=MeizuM351&lc=3000000000013001&imsi=460003925485312&cc=TG36000&interest=2&longitude=116.34505&latitude=40.063213&s_sg=64ae298b2d12e700776ba8149e999659&s_sc=100&s_st=1475983883";
    public static final String RECOMMEND_PATH = "http://service.inke.com/api/recommend/aggregate?mtxid=&devi=862845027820666&uid=237474841&sid=204e0opFBCZuzY8YDi2w4Ofl7HMf0i1Jwtki1zmCsKjn1Vi27smpDQ&conn=WIFI&imei=862845027820666&mtid=&aid=796f2d53f974841e&cv=IK3.2.10_Android&smid=DuCBPsLybshBOS8XKxvZm8yDJKLqC5y0tiR1hfZ4HekMwJkFXQUPoG5r8ykodxZwdU9%2FCGtrt%2FqvHjLBpVte7pWw&osversion=android_19&proto=4&vv=1.0.3-201609021643.android&icc=89860050161400025312&ua=MeizuM351&lc=3000000000013001&imsi=460003925485312&cc=TG36000&interest=2&longitude="+ MyApp.getLongitude()+"&latitude="+MyApp.getLatitude()+"s_sg=d0d5629cdb4dc647f2dc5c832f87d00f&s_sc=100&s_st=1476249177";
    //http://120.55.238.158/api/live/themesearch?mtxid=021e64d987a3&devi=862845027820666&uid=238316360&sid=20i20cOVAOc9vpHdKNKPxD4OcHIQWi2dEZ7fNx3l9vH4v8VCIFcr&conn=WIFI&imei=862845027820666&mtid=bb1f3a585466722ae1d7404e00588d81&aid=796f2d53f974841e&cv=IK3.2.10_Android&smid=DuCBPsLybshBOS8XKxvZm8yDJKLqC5y0tiR1hfZ4HekMwJkFXQUPoG5r8ykodxZwdU9%2FCGtrt%2FqvHjLBpVte7pWw&osversion=android_19&proto=4&vv=1.0.3-201609021643.android&icc=89860050161400025312&ua=MeizuM351&lc=3000000000013001&imsi=460003925485312&cc=TG36000&interest=2&longitude=116.34505&latitude=40.063213&keyword=%E5%A5%BD%E5%A3%B0%E9%9F%B3&s_sg=f4e3649704b86480839ce0900da75341&s_sc=100&s_st=1475983883""
    //今日推荐界面跳转到 更多界面的地址头部
    public static final String RECOMMEND_MORE_HEAD_PATH = "http://120.55.238.158/api/live/themesearch?mtxid=021e64d987a3&devi=862845027820666&uid=238316360&sid=20i20cOVAOc9vpHdKNKPxD4OcHIQWi2dEZ7fNx3l9vH4v8VCIFcr&conn=WIFI&imei=862845027820666&mtid=bb1f3a585466722ae1d7404e00588d81&aid=796f2d53f974841e&cv=IK3.2.10_Android&smid=DuCBPsLybshBOS8XKxvZm8yDJKLqC5y0tiR1hfZ4HekMwJkFXQUPoG5r8ykodxZwdU9%2FCGtrt%2FqvHjLBpVte7pWw&osversion=android_19&proto=4&vv=1.0.3-201609021643.android&icc=89860050161400025312&ua=MeizuM351&lc=3000000000013001&imsi=460003925485312&cc=TG36000&interest=2&longitude="+ MyApp.getLongitude()+"&latitude="+MyApp.getLatitude()+"&keyword=";
    //今日推荐界面跳转到 更多界面的地址尾部
    public static final String RECOMMEND_MORE_BEHIND_PATH = "&s_sg=f4e3649704b86480839ce0900da75341&s_sc=100&s_st=1475983883";
    //图片前边的链接
    public static final String IMG = "http://image.scale.inke.com/imageproxy2/dimgm/scaleImage?url=http%3A%2F%2Fimg.meelive.cn%2F";
    //图片的大小
    public static final String IMG_XIAO = "&w=100&h=100&s=80&c=0&o=0";
    public static final String IMG_ZHONG = "&w=540&h=540&s=80&c=0&o=0";
    public static final String IMG_DA = "&w=800&h=800&s=80&c=0&o=0";
    //主播详情链接
    public static final String START_HEAD_PATH = " http://120.55.238.158/api/user/info?lc=3000000000013001&cv=IK3.2.10_Android&cc=TG36000&ua=MeizuM351&uid=237474841&sid=20wxPEjHjKybIiLxCti0jRB01VSIMpA3gFgO7sOr2DpD02sNkSt&devi=862845027820666&imsi=460003925485312&imei=862845027820666&icc=89860050161400025312&conn=WIFI&vv=1.0.3-201609021643.android&aid=796f2d53f974841e&osversion=android_19&mtid=bb1f3a585466722ae1d7404e00588d81&mtxid=021e64d987a3&proto=4&smid=DuCBPsLybshBOS8XKxvZm8yDJKLqC5y0tiR1hfZ4HekMwJkFXQUPoG5r8ykodxZwdU9%2FCGtrt%2FqvHjLBpVte7pWw&id=";
    public static final String START_BEHIND_PATH = "&s_sg=f3a81c43e65fff7aedfa7bb121686b75&s_sc=100&s_st=146170405";
    //推荐界面主播详情链接
    public static final String START_HEAD_PATH_RECOM ="http://116.211.167.106/api/user/info?lc=3000000000013001&cv=IK3.2.10_Android&cc=TG36000&ua=MeizuM351&uid=237474841&sid=20pwHuc9LtgtpHGYHJ5ahYH8X42Dq8JblsD6VSBnei2VpaWbaZ8&devi=862845027820666&imsi=460003925485312&imei=862845027820666&icc=89860050161400025312&conn=WIFI&vv=1.0.3-201609021643.android&aid=796f2d53f974841e&osversion=android_19&mtid=e5ba5238b3145c5ad6fed973acdb3298&mtxid=021e64d987a3&proto=4&smid=DuCBPsLybshBOS8XKxvZm8yDJKLqC5y0tiR1hfZ4HekMwJkFXQUPoG5r8ykodxZwdU9%2FCGtrt%2FqvHjLBpVte7pWw&id=";
    public static final String START_BEHIND_PATH_RECOM ="&s_sg=5bb180ff2b921e6dbe38e02c11cdd28b&s_sc=100&s_st=1476347209";

    //id 第三方登陆的ID
    public static final String APP_ID = "1105750426";
}
