package com.thaiitwork.basic;

public class printPeramit {
    public static void main(String[] args) {
        int num = 21;//Integer.valueOf(args[0]);
        int line = (num+1)/2;
       // int start = layer-1;
        for(int i=0;i<line;i++){
            // print space
            int space = line-i-1;
            for(int j=0;j<space;j++){
                System.out.print(" ");
            }
            // print star
            for(int k=0;k<((i*2)+1);k++) {
                System.out.print("*");
            }
            // new line
            System.out.println("");
        }
    }
}
