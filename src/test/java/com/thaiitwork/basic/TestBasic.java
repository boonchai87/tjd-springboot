package com.thaiitwork.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestBasic {
    public static void main(String[] args) {
        /*System.out.println(System.getenv());
        System.out.println(System.getProperties());*/
       /* ArrayList<Integer>
                arrlist = new ArrayList<Integer>();

        // Populating arrlist1
        arrlist.add(1);
        arrlist.add(3);
        arrlist.add(6);
        arrlist.add(1);
        arrlist.add(6);
        arrlist.add(6);
        arrlist.add(9);
        arrlist.add(9);


        // print arrlist
        *//*System.out.println("Original arrlist: "
                + arrlist.subList(2, 4));*//*
        int max =0;
        for( int size=2;size<arrlist.size()+1;size++){
            for(int i=0;i<arrlist.size();i++) {
                if( size+i<= arrlist.size()) {
                    List<Integer> array = arrlist.subList(i, size + i);
                    if( array.get(0) == array.get(array.size()-1)) {
                        System.out.println(array);
                        int sum =0;
                        for(int j=0;j<array.size();j++){
                            sum+=array.get(j);
                        }
                        if( sum>max ){
                            max = sum;
                        }
                    }
                }
            }
        }
        System.out.println(max);*/

        //String[] array = {"-", "H", "-", "H", "H","-","-"};
        //String[] array = {"H", "H", "-", "H", "H"};
        String str = "HH-HH";
        str = "-H-HH--";// -HTHHT-
        //System.out.println(str.replaceAll("H-", "HT"));

        //List<String> arrlist = Arrays.asList(array);
        //System.out.println(arrlist);
        /*boolean foundHouse = false;
        int result =-1;
        int tank =0;
        for(int i=0;i<arrlist.size();i++){
            String str = arrlist.get(i);
            if( foundHouse &&  str.equals("-") ){
                tank++;
                foundHouse = false;
                System.out.println("tank"+tank);
            }else
                foundHouse = false;
            if( str.equalsIgnoreCase("H") ) {
                foundHouse = true;
            }
            System.out.println(foundHouse);

        }
        if( tank>0 ) {
            result = tank;
        }
        System.out.println(result);*/

/*
        Integer[] R = {2, 1, 0, 2};
        Integer[] C = {0, 2, 1, 2};
        List bomb = new ArrayList();
        for(int i=0;i<R.length;i++){
            bomb.add(String.valueOf(R[i])+String.valueOf(C[i]));
        }
        //System.out.println(bomb);
        List<Integer> r = Arrays.asList(R);
        List<Integer> c = Arrays.asList(C);

        int N=3;
        String[][] data = new String[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                String latlng = String.valueOf(i)+String.valueOf(j);
                //System.out.print(String.valueOf(i)+String.valueOf(j)+"\t");
                if( bomb.contains(latlng) ) {
                    //System.out.print("B");
                    data[i][j] = "B";
                }else {
                    //System.out.print("*");
                    data[i][j] = "*";
                }
            }
            //System.out.println("");
        }
        // calculate
        for(int i=0;i<N;i++){
            for(int j=0;j< N;j++){
                if( !data[i][j].equals("B") ){
                    int sum =0;
                    // i=1, j= 1
                    // left
                    if( j-1>=0 && data[i][j-1].equals("B") ){
                        sum++;
                    }
                    // left up
                    if( j-1>=0 && i-1>=0 && data[i-1][j-1].equals("B") ){
                        sum++;
                    }

                    // right
                    if( j+1< data.length && data[i][j+1].equals("B") ){
                        sum++;
                    }
                    //right up
                    if( j+1< data.length && i-1>=0 && data[i-1][j+1].equals("B") ){
                        sum++;
                    }

                    // up
                    if( i-1>=0 && data[i-1][j].equals("B") ){
                        sum++;
                    }

                    // down
                    if( i+1<data.length && data[i+1][j].equals("B") ){
                        sum++;
                    }
                    // down left
                    if( i+1<data.length && j-1>=0 && data[i+1][j-i].equals("B") ){
                        sum++;
                    }
                    // down right
                    if( i+1<data.length && j+1<data.length && data[i+1][j+1].equals("B") ){
                        sum++;
                    }
                    System.out.print(sum);
                }else{
                    System.out.print("B");
                }
            }
            System.out.println("");
        }*/
    }
}
