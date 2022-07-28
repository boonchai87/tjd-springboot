package com.thaiitwork.basic;

import java.util.Arrays;
import java.util.List;

public class Sorting {
    public static void main(String[] args) {
        List<Integer> nums = (List<Integer>)Arrays.asList(new Integer[]{15,-1,10,50,-3,0});
        for(int i=0;i<nums.size();i++) {
            for(int j=i;j<nums.size();j++){
                if(  nums.get(i)>nums.get(j) ){
                    //System.out.println(i+","+j);
                    //System.out.println(nums.get(i)+","+nums.get(j));
                    int temp = nums.get(i);//lower value
                    nums.set(i,nums.get(j));
                    nums.set(j,temp);
                    //System.out.println(nums);
                }
            }
        }
        System.out.println(nums);
    }
}
