package com.zmm.utlis;

import android.widget.EditText;

import java.util.Calendar;
import java.util.Random;

/**
 * @fileName TextUtils.java
 * @package szu.wifichat.android.util
 * @description 文本工具类
 */
public class MyTextUtils {

    /**
     * 根据月日获取星座
     * 
     * @param month
     *            月
     * @param day
     *            日
     * @return
     */
    public static String getConstellation(int month, int day) {
        String[] constellationArr = { "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座",
                "天秤座", "天蝎座", "射手座", "魔羯座" };
        int[] constellationEdgeDay = { 20, 19, 21, 21, 21, 22, 23, 23, 23, 23, 22, 22 };
        if (day < constellationEdgeDay[month]) {
            month = month - 1;
        }
        if (month >= 0) {
            return constellationArr[month];
        }
        // default to return 摩羯座
        return constellationArr[11];
    }

    /**
     * 根据年月日获取年龄
     * 
     * @param year
     *            年
     * @param month
     *            月
     * @param day
     *            日
     * @return
     */
    public static int getAge(int year, int month, int day) {
        int age = 0;
        Calendar calendar = Calendar.getInstance();
        if (calendar.get(Calendar.YEAR) == year) {
            if (calendar.get(Calendar.MONTH) == month) {
                if (calendar.get(Calendar.DAY_OF_MONTH) >= day) {
                    age = calendar.get(Calendar.YEAR) - year + 1;
                }
                else {
                    age = calendar.get(Calendar.YEAR) - year;
                }
            }
            else if (calendar.get(Calendar.MONTH) > month) {
                age = calendar.get(Calendar.YEAR) - year + 1;
            }
            else {
                age = calendar.get(Calendar.YEAR) - year;
            }
        }
        else {
            age = calendar.get(Calendar.YEAR) - year;
        }
        if (age < 0) {
            return 0;
        }
        return age;
    }

    /**
     * 判断文本框的内容是否为空
     * 
     * @param editText
     *            需要判断是否为空的EditText对象
     * @return boolean 返回是否为空,空(true),非空(false)
     */
    public static boolean isNull(EditText editText) {
        String text = editText.getText().toString().trim();
        if (text != null && text.length() > 0) {
            return false;
        }
        return true;
    }

    /**
     * 返回指定长度的一串数字
     * 
     * @param NumLen
     *            数字串位数
     * @return
     */
    public static String getRandomNumStr(int NumLen) {
        Random random = new Random(System.currentTimeMillis());
        StringBuffer str = new StringBuffer();
        int i, num;
        for (i = 0; i < NumLen; i++) {
            num = random.nextInt(10); // 0-10的随机数
            str.append(num);
        }
        return str.toString();
    }
	/** 
 * 验证手机格式 
 */  
public static boolean isMobileNO(String mobiles) {  
    /* 
    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188 
    联通：130、131、132、152、155、156、185、186 
    电信：133、153、180、189、（1349卫通） 
    总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9 
    */  
    String telRegex = "[1][358]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。  
    if (android.text.TextUtils.isEmpty(mobiles)) return false;
    else return mobiles.matches(telRegex);  
   }  

}
