package cn.cy.data_struct.tree.huffman;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiangyi on 2017/6/27.
 */
public class StatisticUtils {

    /**
     * 统计字符出现频率
     * @param charArr
     * @return
     */
    public static Map<Character, Integer> statisticCharNums(char[] charArr){
        Map<Character, Integer> result = new HashMap<>();
        for(int i=0; i< charArr.length; i++){
            Character character = new Character(charArr[i]);
            if(result.containsKey(character)){
                result.put(character, result.get(character)+1);
            }else{
                result.put(character, 1);
            }
        }
        return result;
    }

}
