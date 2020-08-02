package com.programming;

import java.util.*;

public class RearrangeStringCharNoTwoAdjacentCharAreSame {
    public static void main(String[] args) {
        String str= "aaabc";
        RearrangeStringCharNoTwoAdjacentCharAreSame obj = new RearrangeStringCharNoTwoAdjacentCharAreSame();

        System.out.println(str);
        String s = obj.reArrange(str);
        System.out.println(s);
    }

    String reArrange(String str){
        int n=str.length();
        HashMap<Character, Integer> hm= new HashMap<Character, Integer>();
        for(int i=0;i<str.length();i++){
            char ch= str.charAt(i);
            if(hm.containsKey(ch)){
                int freq=hm.get(ch);
                freq++;
                hm.put(ch,freq);
            } else {
                hm.put(ch,1);
            }
        }

        Iterator it = hm.entrySet().iterator();
        PriorityQueue pq = new PriorityQueue( new KeyComparator());
        while (it.hasNext()){
            Map.Entry me = (Map.Entry) it.next();
            pq.add(new Key((char)me.getKey(),(int)me.getValue()));
        }

        Key prev=null;
        str="";
        while(pq.size()>0){
            Key pk= (Key) pq.peek();
            pq.poll();
            str=str+pk.ch;

            if(prev!=null && prev.freq >0){
                pq.add(prev);
            }
            pk.freq--;
            prev=pk;
        }

        if(n!=str.length()){
            return "Not possible";
        } else {
            return str;
        }
    }

    class KeyComparator implements Comparator<Key>{
        @Override
        public int compare(Key k1, Key k2) {
            if (k1.freq < k2.freq)
                return 1;
            else if (k1.freq > k2.freq)
                return -1;
            return 0;
        }
    }

    class Key{
        char ch;
        int freq;
        Key(char ch, int freq){
            this.ch=ch;
            this.freq=freq;
        }
    }
}
