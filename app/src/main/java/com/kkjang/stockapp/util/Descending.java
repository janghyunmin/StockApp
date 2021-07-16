package com.kkjang.stockapp.util;

import java.util.Comparator;

/**
 * jhm
 * @class Ascending
 * @date 2021-07-07
 * @time 오후 3:49
 * ArrayList 정렬시 desc 기능
 **/

public class Descending implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}
