package com.xiaofeng.config;

import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class SignatureUtil {
    public static final char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f' };
    /**
     * 创建SHA1签名
     * @param params
     * @return SHA1签名
     */
    public static String createSignature(SortedMap<String, String> params) {
        return sha1Encrypt(sortParams(params));
    }

    /**
     * 使用SHA1算法对字符串进行加密
     * @param str
     * @return
     */
    public static String sha1Encrypt(String str) {

        if (str == null || str.length() == 0) {
            return null;
        }

        try {

            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j * 2];
            int k = 0;

            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }

            return new String(buf);

        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 根据参数名称对参数进行字典排序
     * @param params
     * @return
     */
    private static String sortParams(SortedMap<String, String> params) {
        StringBuffer sb = new StringBuffer();
        Set<Entry<String, String>> es = params.entrySet();
        Iterator<Entry<String, String>> it = es.iterator();
        while (it.hasNext()) {
            Entry<String, String> entry = it.next();
            String k = entry.getKey();
            String v = entry.getValue();
            sb.append(k + "=" + v + "&");
        }
        return sb.substring(0, sb.lastIndexOf("&"));
    }

    private boolean checkSignature(String signature,String timeStamp,String nonce){
        String token = "zNrydShD";
        SortedMap<String, String> params = new TreeMap<>();
        params.put("token", token);
        params.put("timeStamp", timeStamp);
        params.put("nonce", nonce);
        String valSign = SignatureUtil.createSignature(params);
        return valSign.equals(signature);
    }

    public static void main(String[] args) {
        SignatureUtil signatureUtil = new SignatureUtil();
        boolean bool = signatureUtil.checkSignature("9428476930bdd7fc16db064b0ad9ee6033aef32a", "1756954334239", "lvk24msZFQ");
        System.out.println(bool);
    }
}
