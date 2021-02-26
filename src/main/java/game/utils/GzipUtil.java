package game.utils;

import game.base.Logs;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * @author Yunzhe.Jin
 * 2021/2/26 19:07
 */
public class GzipUtil {


    private static Logger log = Logs.C;

    /**
     * 压缩
     * @param unzip
     * @return
     */
    public static String zipString(String unzip) {
        return Base64.getEncoder().encodeToString(zipByte(unzip));
    }

    /**
     * 对cpspJson进行解压
     * @param zip
     * @return
     */
    public static String unzipString(String zip) {
        byte[] decode = Base64.getDecoder().decode(zip);
        String unziqStr = unzipByte(decode);
        //如果解压缩失败，返回原数据
        if (StringUtils.isEmpty(unziqStr)) {
            return zip;
        }
        return unziqStr;
    }


    public static String unzipString1(String zip) {
        try {
            byte[] decode = new sun.misc.BASE64Decoder().decodeBuffer(zip);
            return unzipByte(decode);
        } catch (IOException ex) {
            log.error("解压文件失败", ex);
            return null;
        }
    }

    /**
     * 压缩
     * @param unzip
     * @return
     */
    public static byte[] zipByte(String unzip) {
        Deflater deflater = new Deflater(9);
        deflater.setInput(unzip.getBytes());
        deflater.finish();
        final byte[] bytes = new byte[256];
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(256);
        while (!deflater.finished()) {
            int length = deflater.deflate(bytes);
            outputStream.write(bytes, 0, length);
        }
        deflater.end();
        return outputStream.toByteArray();
    }

    /**
     * 解压缩
     * @param decode
     * @return
     */
    public static String unzipByte(byte[] decode) {
        Inflater inflater = new Inflater();
        inflater.setInput(decode);
        final byte[] bytes = new byte[256];
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(256);
        try {
            while (!inflater.finished()) {
                int length = inflater.inflate(bytes);
                outputStream.write(bytes, 0, length);
            }
        } catch (DataFormatException e) {
            log.error("解压缩失败", e);
            return null;
        } finally {
            inflater.end();
        }
        return outputStream.toString();
    }

    public static void main(String[] args) {
        String str = "{\"amount\":999,\"orderTime\":1592623367000,\"tradeNo\":\"20200620010000000023\",\"orderId\":3487660,\"payTime\":1592623430000,\"goodsId\":2503,\"payWay\":\"alipay\",\"goodsName\":\"章鱼哥派出所1：镇长失踪事件\",\"payStatus\":\"alipay\",\"goodsType\":\"work\"}";
        String s = zipString(str);
        System.out.println(s);
        String s1 = unzipString(s);
        System.out.println(s1);
    }

}
