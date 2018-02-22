package cn.cy.data_struct.tree.huffman;

import java.nio.charset.Charset;

/**
 * Created by jiangyi on 2017/6/29.
 */
public class StringByteConvertUtils {

    public static String getStringOfByte(String str, Charset charset) {

        if (str == null || str.equals("")) {
            return "";
        }

        byte[] byteArray = str.getBytes(charset);
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            byte temp = byteArray[i];
            buffer.append(byte2Bit(temp));
        }

        return buffer.toString();
    }

    public static String byte2Bit(byte b) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 7; i >= 0; i--) {
            byte temp = (byte) ((b >> i) & 0x1);
            buffer.append(String.valueOf(temp));
        }
        return buffer.toString();
    }

}
