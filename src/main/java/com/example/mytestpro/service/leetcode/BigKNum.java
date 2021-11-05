package com.example.mytestpro.service.leetcode;

import java.util.Arrays;
import java.util.Date;

public class BigKNum {
    private Integer[] array=new Integer[100000003];
    public static void main(String[] args) {
        BigKNum bigKNum=new BigKNum();
        Integer[] array = bigKNum.array;
        for (int i = 0; i <100000000 ; i++) {
            array[i]=(int) (Math.random()*(100-0)+0);
        }
        array[100000000]=100;
        array[100000001]=103;
        array[100000002]=102;
        Long time=System.currentTimeMillis();
        System.out.println(new Date());
        Arrays.stream(array).sorted(Integer::compareTo);
        System.out.println(new Date());
        System.out.println(System.currentTimeMillis()-time);
    }
}
