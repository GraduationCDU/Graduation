package cdu.gu.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.DigestUtils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class HelperUtil {
    public static List<Integer> zeroIntegerList() {
        return new ArrayList<>() {
            {
                add(0);
            }
        };
    }
    public static String MD5(String text) {
        return DigestUtils.md5DigestAsHex(text.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 生成uuid
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    }

    /**
     * 返回随机字符串
     * @param length 要生成的字符长度
     * @return
     */
    public static String randomString(int length) {
        Random random = new Random();
        StringBuilder stringBuffer = new StringBuilder();
        String str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int strLength = str.length();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(strLength);
            stringBuffer.append(str.charAt(index));
        }
        return stringBuffer.toString();
    }

    /**
     * 返回随机数字字符串
     * @param length
     * @return
     */
    public static String randomInt(int length) {
        Random random = new Random();
        StringBuilder stringBuffer = new StringBuilder();
        String str = "0123456789";
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(10);
            stringBuffer.append(str.charAt(index));
        }
        return stringBuffer.toString();
    }

    /**
     * 转换存储单位 KB MB GB TB
     * @param size
     * @return
     */
    public static String storageUnit(Long size) {
        if (size == null) {
            return "0B";
        }
        if (size < 1024) {
            return size + "B";
        } else {
            size = size / 1024;
        }
        if (size < 1024) {
            return size + "KB";
        } else {
            size = size / 1024;
        }
        if (size < 1024) {
            size = size * 100;
            return (size / 100) + "." + (size % 100) + "MB";
        } else {
            size = size * 100 / 1024;
            return (size / 100) + "." + (size % 100) + "GB";
        }
    }

    /**
     * 下载文件
     * @param urlString （文件网址）
     * @param savePath （保存路径）
     * @param filename （保存名称）
     * @throws IOException
     */
    public static void download(String urlString, String savePath, String filename)
            throws IOException {
        URL url = new URL(urlString);
        URLConnection con = url.openConnection();
        con.setConnectTimeout(20 * 1000);
        File sf = new File(savePath);
        if (!sf.exists()) {
            if (sf.mkdirs()) {
                throw new IOException("创建目录失败");
            }
        }
        try (InputStream in = con.getInputStream();
             OutputStream out = new FileOutputStream(sf.getPath() + "\\" + filename)) {
            byte[] buff = new byte[1024];
            int n;
            while ((n = in.read(buff)) >= 0) {
                out.write(buff, 0, n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 对面类型Map合并
     * @param map
     * @param map1
     * @return
     */
    public static Map<String, Object> mergeMapByObj(
            Map<String, Object> map, Map<String, Object> map1) {
        HashMap<String, Object> map2 = new HashMap<>();
        map2.putAll(map);
        map2.putAll(map1);
        return map2;
    }

    /**
     * 转换json
     * @param obj
     * @return
     * @throws JsonProcessingException
     */
    public static String toJsonStr(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        /**获取序列化器并使用writeValueAsString传入java对象*/
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
    }

    /**
     * 返回文件类型（扩展名）
     * @param filename
     * @return
     */
    public static String fileExt(String filename) {
        String[] array = filename.split("\\.");
        return array[array.length - 1].toLowerCase();
    }
}
