package com.jb.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DingDanHaoUtil {
    /**
     * 当前时间戳
     */
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");


    /**
     * 生成订单号      一
     * @param pre
     * @param museId
     * @return
     */
    public static String gens(String pre, Long museId) {
        //生成
        String orderNo = pre + sdf.format(new Date()) + (1 + (int) (Math.random() * 10000)) + museId;
        return orderNo;
    }

    /**
     * 生成订单号     二
     *
     * @param pre 订单号前缀  museId 用户Id
     * @return
     */
    public static String gen(String pre, Long museId) {
        //生成
        String orderNo = pre + ((int)((Math.random()*9+1)*10000)) + museId + (System.currentTimeMillis() / 1000);
        return orderNo;
    }

}
