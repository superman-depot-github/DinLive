package com.dinlive.din.baselib.net.service;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by superman on 2019/6/28.
 */
public class ParmsUtils {
//    private static String SHA1_KEY = "K;9)Bq|ScMF1h=Vp5uA-G87d(_fi[aP,.w^{vQ:W";

    public static Map<String, String> getParmsMap() {
        Map<String, String> map = new HashMap();
//        String nonce = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
//        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
//        try {
//            map.put("signature", getSHA1(SHA1_KEY, timestamp, nonce));
//            map.put("timestamp", timestamp);
//            map.put("nonce", nonce);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return map;
    }

    /**
     * 用SHA1算法生成安全签名
     *
     * @param key       秘钥
     * @param timestamp 时间戳
     * @param nonce     随机字符串
     * @return 安全签名
     */
    public static String getSHA1(String key, String timestamp, String nonce) throws Exception {
        try {
            String[] array = new String[]{key, timestamp, nonce};
            StringBuffer sb = new StringBuffer();
            // 字符串排序
            Arrays.sort(array);
            for (int i = 0; i < 3; i++) {
                sb.append(array[i]);
            }
            String str = sb.toString();
            // SHA1签名生成
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(str.getBytes());
            byte[] digest = md.digest();

            StringBuffer hexstr = new StringBuffer();
            String shaHex = "";
            for (int i = 0; i < digest.length; i++) {
                shaHex = Integer.toHexString(digest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexstr.append(0);
                }
                hexstr.append(shaHex);
            }
            return hexstr.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }
}
