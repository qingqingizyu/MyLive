package com.zmm.utlis;

import android.net.Uri;

import com.zmm.Constant;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 格式化path的工具
 */

public class FormatPathUtil {
    //根据小图片文件名生成对应的Uri
    public static Uri getXiaoImg(String img){
        return  Uri.parse(Constant.IMG + img + Constant.IMG_XIAO);
    }
    //根据中图片文件名生成对应的Uri
    public static Uri getZhongImg(String img){
        return  Uri.parse(Constant.IMG + img + Constant.IMG_ZHONG);
    }
    //根据大图片文件名生成对应的Uri
    public static Uri getDaImg(String img){
        return  Uri.parse(Constant.IMG + img + Constant.IMG_DA);
    }
    //生成热门界面的对应市的 path
    public static String getCityPath(String city)  {
        try {
            return   Constant.HOT_CITY_HEAD_PATH+URLEncoder.encode(city, "UTF-8")+Constant.HOT_CITY_BEHIND_PATH;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return  null;
    }
    //生成推荐界面的对应条目下更多的 path
    public static String getMorePath(String type)  {
        try {
            return   Constant.RECOMMEND_MORE_HEAD_PATH+URLEncoder.encode(type, "UTF-8")+Constant.RECOMMEND_MORE_BEHIND_PATH;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return  null;
    }
    //根据主播id生成主播详情界面的网络请求路径
    public static String getStartPath(int id){
        return Constant.START_HEAD_PATH+id+Constant.START_BEHIND_PATH;
    }
    //根据主播id生成主播详情界面的网络请求路径
    public static String getStartRecomPath(int id){
        return Constant.START_HEAD_PATH_RECOM+id+Constant.START_BEHIND_PATH_RECOM;
    }

}
