package com.cos.base.utils;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class CommonUtils {

    public static void main(String[] args) {
        String mac = "NTg6NTY6YzI6ZDQ6ZjQ6OWM";
        System.out.println(strToBase64Decoded(mac));
        String progress = String.format("%.2f", 100.00).replaceAll("\\.0*$", "");
        System.out.println(progress);

    }

    /**
     * 字符串base64编码
     * @param str
     * @return
     */
    public static String strToBase64Encodeds(String str){
        // 将MAC地址字符串转换为字节数组
        byte[] macBytes = str.getBytes();
        // 使用Base64进行编码
        return Base64.getEncoder().encodeToString(macBytes);
    }

    /**
     * 字符串base64解码
     * @param base64Encoded
     * @return
     */
    public static String strToBase64Decoded(String base64Encoded){
        // 使用Base64进行解码
        byte[] decodedBytes = Base64.getDecoder().decode(base64Encoded);
        // 将字节数组转换回字符串
        return new String(decodedBytes);
    }

    /**
     * 文件哈希计算
     * @param buffer
     * @return
     */
    public static String getFileCheckHash(ByteBuffer buffer){
        StringBuilder hexString = new StringBuilder("");
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(buffer); // data为要校验的字节数组
            byte[] hash = md.digest();
            // 将字节数组转换为十六进制字符串
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return hexString.toString();
    }

    /**
     * hash计算
     * @param input
     * @return
     */
    public static String calculateMD5(String input) {
        try {
            // 获取 MD5 摘要算法的实例
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算摘要
            byte[] messageDigest = md.digest(input.getBytes());
            // 将摘要转换为十六进制字符串
            BigInteger number = new BigInteger(1, messageDigest);
            String md5String = number.toString(16);
            // 补齐前导零
            while (md5String.length() < 32) {
                md5String = "0" + md5String;
            }
            return md5String;
        } catch (NoSuchAlgorithmException e) {
            // 处理异常
            e.printStackTrace();
            return null;
        }
    }

    @SneakyThrows
    public static String inputStreamToString(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }
        reader.close();
        return stringBuilder.toString();
    }

}
