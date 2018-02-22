package cn.cy.search.binarytree;

/**
 * Created by jiangyi on 2017/9/14.
 */
public class Main {

    public static void main(String[] args) {

        Integer[] intArr = new Integer[]{62,33,24,36,37,47,21,10,99,78,88};
        BinarySortTree<Integer> binarySortTree = new BinarySortTree<>();
        // 插入
        for(Integer i : intArr){
            binarySortTree.insert(i);
        }
        // 遍历
        System.out.println(binarySortTree.ergodic());
        // 查找
        System.out.println(binarySortTree.search(10));
        // 删除
        System.out.println(binarySortTree.delete(99));
        // 遍历
        System.out.println(binarySortTree.ergodic());
        System.out.println("-----------------");

        Integer[] leftArr = new Integer[]{62,33,24,36,37,47,21,10};
        BinarySortTree<Integer> leftTree = new BinarySortTree<>();
        // 插入
        for(Integer i : leftArr){
            leftTree.insert(i);
        }
        // 遍历
        System.out.println(leftTree.ergodic());
        // 删除
        System.out.println(leftTree.delete(62));
        // 遍历
        System.out.println(leftTree.ergodic());
        System.out.println("-----------------");

        Integer[] rightArr = new Integer[]{62,99,78,88};
        BinarySortTree<Integer> rightTree = new BinarySortTree<>();
        // 插入
        for(Integer i : rightArr){
            rightTree.insert(i);
        }
        // 遍历
        System.out.println(rightTree.ergodic());
        // 删除
        System.out.println(rightTree.delete(62));
        // 遍历
        System.out.println(rightTree.ergodic());
    }

}
