package cn.cy.data_struct.tree.huffman;

import java.util.*;

/**
 * Created by jiangyi on 2017/6/28.
 */
public class CompressionUtils {

    private static final String LEFT_CODE = "0";
    private static final String RIGHT_CODE = "1";

    public static String compression(Map<Character, Integer> rateMap, String str) throws Exception {

        if(str==null || str.equals("")){
            throw new Exception("请检查待压缩字符...");
        }
        if(rateMap==null || rateMap.isEmpty()){
            throw new Exception("请检查压缩字典...");
        }

        HuffmanTree<Character> huffmanTree = new HuffmanTree<>();
        List<HuffmanTree<Character>.Node> leafNodeList = huffmanTree.buildTree(rateMap);
        Map<Character, String> encodingMap = encoding(leafNodeList);
        System.out.println(encodingMap);

        // 遍历charArr开始压缩编码
        char[] charArr = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<charArr.length; i++){
            sb.append(encodingMap.get(charArr[i]));
        }

        return sb.toString();
    }


    public static String deCompression(Map<Character, Integer> rateMap, String encodingStr) throws Exception {

        if(encodingStr==null || encodingStr.equals("")){
            throw new Exception("请检查待压缩字符...");
        }
        if(rateMap==null || rateMap.isEmpty()){
            throw new Exception("请检查压缩字典...");
        }

        HuffmanTree<Character> huffmanTree = new HuffmanTree<>();
        List<HuffmanTree<Character>.Node> leafNodeList = huffmanTree.buildTree(rateMap);

        char[] charArr = encodingStr.toCharArray();
        LinkedList<Character> binaryList = new LinkedList<>();
        for (int i=0; i<charArr.length; i++){
            binaryList.add(charArr[i]);
        }

        StringBuffer sb = new StringBuffer();
        while(!binaryList.isEmpty()){
            HuffmanTree<Character>.Node temp = huffmanTree.getRoot();
            do{
                Character c = binaryList.removeFirst();
                if(c.charValue() == '0'){
                    temp = temp.getLeft();
                }else{
                    temp = temp.getRight();
                }
            }while(!temp.isLeaf());

            sb.append(temp.getData());
        }

        return sb.toString();
    }

    private static Map<Character, String> encoding(List<HuffmanTree<Character>.Node> leafNodeList){

        Map<Character, String> encodingMap = new HashMap<>();

        StringBuffer sb = null;
        HuffmanTree<Character>.Node temp;
        for (HuffmanTree<Character>.Node node : leafNodeList){
            sb = new StringBuffer();
            temp = node;
            do{
                if(temp.isLeft()){
                    sb.append(LEFT_CODE);
                }
                if(temp.isRight()){
                    sb.append(RIGHT_CODE);
                }
                temp = temp.getParent();
            }while (temp.getParent() != null);

            // 反转并保存编码
            encodingMap.put(node.getData(), sb.reverse().toString());
        }

        return encodingMap;
    }

}
