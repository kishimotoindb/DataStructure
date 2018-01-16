package com.example.chapter3.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BigFaceBear on 2018.01.16
 * <p>
 * 给定两个已排序的表L1和L2，只是用基本的表操作求L1与L2的交集
 */

public class No3 {
    static List<Integer> l1 = new ArrayList<>();
    static List<Integer> l2 = new ArrayList<>();

    static {
//        for (int i = 0; i < 100; i++) {
//            if (i % 5 == 0) {
//                array1.add(i);
//            }
//        }
//
//        for (int i = 0; i < 100; i++) {
//            if (i % 8 == 0) {
//                array2.add(i);
//            }
//        }

        l1.add(1);
        l1.add(10);
        l1.add(10);
        l1.add(15);

        l2.add(10);
        l2.add(10);

    }

    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();
        int indexOfTarget = 0;
        Integer target = l2.get(indexOfTarget);
        int l2Size = l2.size();
        //以L1为基准
        for (Integer elem1 : l1) {
            if (target < elem1) {
                do {
                    if (++indexOfTarget < l2Size) {
                        target = l2.get(indexOfTarget);
                    } else {
                        break;
                    }
                } while (target < elem1);
            }

            if (target.equals(elem1)) {
                result.add(elem1);

                do {
                    if (++indexOfTarget < l2Size) {
                        target = l2.get(indexOfTarget);
                    } else {
                        break;
                    }
                } while (target.equals(elem1));
            }

            //如果L2中的所有元素都比当前元素小，那么退出
            if (indexOfTarget >= l2Size) {
                break;
            }
        }

        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

}
