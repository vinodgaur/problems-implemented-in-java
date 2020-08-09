package com.programming;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicateCharInStringInPlace {
    private char[] string = {'a','b','a','c','d','d'};
    public static void main(String[] args) {
        RemoveDuplicateCharInStringInPlace dc = new RemoveDuplicateCharInStringInPlace();
        dc.removeDuplicate(dc.string);
    }

    int removeDuplicate(char[] arr){
        int j=0, i=0;
        HashSet<Character> hs = new HashSet<Character>();
        for (i=0;j<arr.length;){
            if(hs.contains(arr[j])){
               j++;
            } else {
                hs.add(arr[i]); // add unique char into hashset
                arr[i++]=arr[j++];
            }
        }
        i--; // now i would be the index to end the array
        char[] newArr = Arrays.copyOf(arr,i);
        System.out.println("Final Array="+ Arrays.toString(newArr));
        System.out.println("Final arr after duplicate removed is = "+i);
        return i;
    }
}
