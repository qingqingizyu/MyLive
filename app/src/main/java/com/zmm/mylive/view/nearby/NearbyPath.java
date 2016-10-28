package com.zmm.mylive.view.nearby;

import com.zmm.app.MyApp;

/**
 * Created by Administrator on 2016/10/13 0013.
 */

public class NearbyPath {
    public String getNearbyPath(int i){
        return NEARBY_PATH[i];
    }
    //附近界面的接口
    private    String [] NEARBY_PATH ={"http://120.55.238.158/api/live/near_recommend?lc=3000000000013001&cv=IK3.2.10_Android&cc=TG36000&ua=MeizuM351&uid=237474841&sid=20i2ewnKSRJAuXHXn5InZsp3Nn8HVnF1y1Ji14u3ZCdnmYbutVCX&devi=862845027820666&imsi=460003925485312&imei=862845027820666&icc=89860050161400025312&conn=WIFI&vv=1.0.3-201609021643.android&aid=796f2d53f974841e&osversion=android_19&mtid=bb1f3a585466722ae1d7404e00588d81&mtxid=021e64d987a3&proto=4&smid=DuCBPsLybshBOS8XKxvZm8yDJKLqC5y0tiR1hfZ4HekMwJkFXQUPoG5r8ykodxZwdU9%2FCGtrt%2FqvHjLBpVte7pWw&interest=0&longitude="+ MyApp.getLongitude()+"&latitude="+MyApp.getLatitude()+"&s_sg=c1c620e9d9c5dafbe111633565f20927&s_sc=100&s_st="+System.currentTimeMillis()/1000
            ,"http://120.55.238.158/api/live/near_recommend?lc=3000000000013001&cv=IK3.2.10_Android&cc=TG36000&ua=MeizuM351&uid=238316360&sid=20i20cOVAOc9vpHdKNKPxD4OcHIQWi2dEZ7fNx3l9vH4v8VCIFcr&devi=862845027820666&imsi=460003925485312&imei=862845027820666&icc=89860050161400025312&conn=WIFI&vv=1.0.3-201609021643.android&aid=796f2d53f974841e&osversion=android_19&mtid=bb1f3a585466722ae1d7404e00588d81&mtxid=021e64d987a3&proto=4&smid=DuCBPsLybshBOS8XKxvZm8yDJKLqC5y0tiR1hfZ4HekMwJkFXQUPoG5r8ykodxZwdU9%2FCGtrt%2FqvHjLBpVte7pWw&interest=1&longitude="+ MyApp.getLongitude()+"&latitude="+MyApp.getLatitude()+"&s_sg=699623e346a58f55b7eb37ac78026ed7&s_sc=100&s_st="+System.currentTimeMillis()/1000
            ,"http://120.55.238.158/api/live/near_recommend?lc=3000000000013001&cv=IK3.2.10_Android&cc=TG36000&ua=MeizuM351&uid=238316360&sid=20i20cOVAOc9vpHdKNKPxD4OcHIQWi2dEZ7fNx3l9vH4v8VCIFcr&devi=862845027820666&imsi=460003925485312&imei=862845027820666&icc=89860050161400025312&conn=WIFI&vv=1.0.3-201609021643.android&aid=796f2d53f974841e&osversion=android_19&mtid=bb1f3a585466722ae1d7404e00588d81&mtxid=021e64d987a3&proto=4&smid=DuCBPsLybshBOS8XKxvZm8yDJKLqC5y0tiR1hfZ4HekMwJkFXQUPoG5r8ykodxZwdU9%2FCGtrt%2FqvHjLBpVte7pWw&interest=2&longitude="+ MyApp.getLongitude()+"&latitude="+MyApp.getLatitude()+"&s_sg=7df967357a8847601e7a3ed13c8a5e5e&s_sc=100&s_st="+System.currentTimeMillis()/1000};

}
