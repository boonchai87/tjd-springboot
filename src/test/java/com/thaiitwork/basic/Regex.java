package com.thaiitwork.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        //https://www.javatpoint.com/java-regex

        Pattern p = Pattern.compile(".s");//. represents single character
        Matcher m = p.matcher("a");
        boolean b = m.matches();
//        System.out.println(b);
//
//        System.out.println(Pattern.matches(".s", "as"));//true (2nd char is s)
//        System.out.println(Pattern.matches(".s", "mk"));//false (2nd char is not s)
//        System.out.println(Pattern.matches(".s", "mst"));//false (has more than 2 char)
//        System.out.println(Pattern.matches(".s", "amms"));//false (has more than 2 char)
//        System.out.println(Pattern.matches("..s", "mas"));//true (3rd char is s)

        /*System.out.println(Pattern.matches("\\d", "abc"));//false (non-digit)
        System.out.println(Pattern.matches("\\d", "1"));//true (digit and comes once)
        System.out.println(Pattern.matches("\\d", "4443"));//false (digit but comes more than once)
        System.out.println(Pattern.matches("\\d", "323abc"));//false (digit and char)

        System.out.println(Pattern.matches("\\D", "abc"));//false (non-digit but comes more than once)
        System.out.println(Pattern.matches("\\D", "1"));//false (digit)
        System.out.println(Pattern.matches("\\D", "4443"));//false (digit)
        System.out.println(Pattern.matches("\\D", "323abc"));//false (digit and char)
        System.out.println(Pattern.matches("\\D", "m"));//true (non-digit and comes once)
        System.out.println(Pattern.matches("\\D*", "mak"));//true (non-digit and may come 0 or more times)

        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "arun32"));// true
        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "kkvarun32"));//false
        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "JA2Uk2"));// true
        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "arun$2"));// false

        System.out.println(Pattern.matches("[789]{1}[0-9]{9}", "9953038949"));//true
        System.out.println(Pattern.matches("[789][0-9]{9}", "9953038949"));//true

        System.out.println(Pattern.matches("[789][0-9]{9}", "99530389490"));//false (11 characters)
        System.out.println(Pattern.matches("[789][0-9]{9}", "6953038949"));//false (starts from 6)
        System.out.println(Pattern.matches("[789][0-9]{9}", "8853038949"));//true

        System.out.println("by metacharacters ...");
        System.out.println(Pattern.matches("[789]{1}\\d{9}", "8853038949"));//true
        System.out.println(Pattern.matches("[789]{1}\\d{9}", "3853038949"));//false (starts from 3)*/


       /* Pattern pattern = Pattern.compile("java");
        Matcher matcher = pattern.matcher("this is java, do you know java");
        boolean found = false;
        while (matcher.find()) {
            System.out.println("I found the text "+matcher.group()+" starting at index "+
                    matcher.start()+" and ending at index "+matcher.end());
            found = true;
        }
        if(!found){
            System.out.println("No match found.");
        }*/

//        System.out.println(Pattern.matches("[amn]{1}", "abcd"));//false (not a or m or n)
//        System.out.println(Pattern.matches("[amn]{1}", "a"));//true (among a or m or n)
//        System.out.println(Pattern.matches("[amn]{1}", "ammmna"));//false (m and a comes more than once)
//        System.out.println("------1-------");
//        System.out.println(Pattern.matches("[amn]?", "a"));//true (a or m or n comes one time)
//        System.out.println(Pattern.matches("[amn]?", "aaa"));//false (a comes more than one time)
//        System.out.println(Pattern.matches("[amn]?", "aammmnn"));//false (a m and n comes more than one time)
//        System.out.println(Pattern.matches("[amn]?", "aazzta"));//false (a comes more than one time)
//        System.out.println(Pattern.matches("[amn]?", "am"));//false (a or m or n must come one time)
//        System.out.println("m");
//        System.out.println(Pattern.matches("[amn]?", "m"));//false
//        System.out.println("-----2--------");
//        System.out.println("+ quantifier ....");
//        System.out.println(Pattern.matches("[amn]+", "a"));//true (a or m or n once or more times)
//        System.out.println(Pattern.matches("[amn]+", "aaa"));//true (a comes more than one time)
//        System.out.println(Pattern.matches("[amn]+", "aammmnn"));//true (a or m or n comes more than once)
//        System.out.println(Pattern.matches("[amn]+", "aazzta"));//false (z and t are not matching pattern)
//        System.out.println(Pattern.matches("[amn]+", "nma"));//true
//        System.out.println("------3-------");
//        System.out.println("* quantifier ....");
//        System.out.println(Pattern.matches("[amn]*", "ammmna"));//true (a or m or n may come zero or more times)
//        System.out.println(Pattern.matches("[amn]*", "n"));//false

        System.out.println(Pattern.matches("[amn]*",""));
        System.out.println(Pattern.matches("[amn]*","n"));
        System.out.println(Pattern.matches("[amn]+",""));//false
        System.out.println(Pattern.matches("[amn]+","namnna"));
        System.out.println(Pattern.matches("[amn]?","n"));
        System.out.println(Pattern.matches("[amn]?","nanm"));// false
        System.out.println(Pattern.matches("[amn]?",""));
    }
}
