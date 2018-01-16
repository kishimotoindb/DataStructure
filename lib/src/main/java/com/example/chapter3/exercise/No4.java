package com.example.chapter3.exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by BigFaceBear on 2018.01.16
 */

public class No4 {
    static List<Integer> array1 = new ArrayList<>();
    static List<Integer> array2 = new ArrayList<>();
    static List<Integer> link1 = new LinkedList<>();
    static List<Integer> link2 = new LinkedList<>();

    static {
        for (int i = 0; i < 100; i++) {
            if (i % 10 == 0) {
                array1.add(i);
            }
        }


        array2.add(-1);
        for (int i = 0; i < 100; i++) {
            if (i % 5 == 0) {
                array2.add(i);
            }
        }
        array2.add(200);

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                link1.add(i);
            }
        }

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1) {
                link2.add(i);
            }
        }

//        array1.add(1);
//        array1.add(10);
//        array1.add(10);
//        array1.add(15);
//
//        array2.add(10);
//        array2.add(10);

    }

    public static void main(String[] args) {
        /*mergeListForArray();
        for (Integer integer : array1) {
            System.out.println(integer);
        }*/

        getUnionSet();
        for (Integer integer : array1) {
            System.out.println(integer);
        }
    }

    //合并两个ArrayList，并且不去重
    static void mergeListForArray() {
        int sourceIndex = 0;
        Integer source = array2.get(sourceIndex);
        int sourceListSize = array2.size();
        for (int i = 0; i < array1.size(); i++) {
            Integer target = array1.get(i);

            int sourceIndexOld = sourceIndex;
            while (source <= target) {
                sourceIndex++;
                if (sourceIndex < sourceListSize) {
                    source = array2.get(sourceIndex);
                } else {
                    break;
                }
            }

            if (sourceIndex >= sourceListSize) {
                break;
            }

            for (int j = sourceIndexOld; j < sourceIndex; j++) {
                array1.add(i++, array2.get(j));
            }
        }

        if (sourceIndex < sourceListSize) {
            for (int i = sourceIndex; i < sourceListSize; i++) {
                array1.add(array2.get(i));
            }

        }
    }

    static void getUnionSet() {
        int sourceIndex = 0;
        Integer source = array2.get(sourceIndex);
        int sourceListSize = array2.size();
        for (int i = 0; i < array1.size(); i++) {
            Integer target = array1.get(i);

            //非重复元素合并
            int sourceIndexOld = sourceIndex;
            while (source < target) {
                sourceIndex++;
                if (sourceIndex < sourceListSize) {
                    source = array2.get(sourceIndex);
                } else {
                    break;
                }
            }

            for (int j = sourceIndexOld; j < sourceIndex; j++) {
                array1.add(i++, array2.get(j));
            }

            //去除重复
            while (source.equals(target)) {
                sourceIndex++;

                if (sourceIndex < sourceListSize) {
                    source = array2.get(sourceIndex);
                } else {
                    break;
                }
            }

            if (sourceIndex >= sourceListSize) {
                break;
            }

        }

        if (sourceIndex < sourceListSize) {
            for (int i = sourceIndex; i < sourceListSize; i++) {
                array1.add(array2.get(i));
            }

        }
    }
}
