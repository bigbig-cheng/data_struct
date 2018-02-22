package cn.cy.data_struct.tree.huffman;

import java.nio.charset.Charset;
import java.util.Map;

/**
 * Created by jiangyi on 2017/6/28.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        String str = "ajodajwajdowajao中iwdwodwaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaxxxxxxxxxxxxxxxxawwap" +
                "qqqqqqqqqqqqamokaaoamosoasjaojsoaijsoijaoisajaoisjaoiuoiauaoinqdkjqnoqbq;zzmmamaam中国jaoa";

        // 统计各字符频率
        Map<Character, Integer> rateMap =
                StatisticUtils.statisticCharNums(str.toCharArray());
        if(rateMap==null || rateMap.isEmpty()){
            throw new Exception("字符分析异常...");
        }

        System.out.println(StringByteConvertUtils.getStringOfByte(str, Charset.forName("UTF-8")));

        String compressionStr =
                CompressionUtils.compression(rateMap, str);
        System.out.println(compressionStr);

        String deCompressionStr =
                CompressionUtils.deCompression(rateMap, compressionStr);
        System.out.println(deCompressionStr);
    }

}
