package com.thaiitwork.basic;

public class PrimeNumber {
    public static void main(String[] args) {
        isPrime(0);
        isPrime(1);
        isPrime(2);
        isPrime(5);
        isPrime(9);
    }
    private static void isPrime(int num){
       // System.out.println(num);
        boolean flag = false;
        if( num==0 || num==1){
            System.out.println("prime");
        }else{
            for(int i=2;i<num;i++){
                if( num%i==0  ){
                    flag =false;
                    break;
                }else{
                    flag =true;
                }
            }
            if( flag )
                System.out.println("prime");
            else
                System.out.println("not prime");
        }
    }
}
