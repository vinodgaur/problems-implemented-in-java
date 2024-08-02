//MS: Given a stream of integers. you have to select a data structure such that 
//you can add number and find median


import java.util.PriorityQueue;

public class MedianIntStream {
    static PriorityQueue<Integer> p1 = new PriorityQueue<>( (a,b)->{
        return b-a;
    });// min heap
    static PriorityQueue<Integer> p2 = new PriorityQueue<>();

    public static void main(String[] args) {
        addNum(3);
        addNum(2);
        addNum(7);
        System.out.println(findMedian());
        addNum(2);
        System.out.println(findMedian());
    }

    private static double findMedian() {
        if(p1.size() == p2.size())
            return (double) (p1.peek()+p2.peek())/2;
        else if(p1.size()>p2.size())
            return p1.peek();
        return p2.peek();
    }

    public static void addNum(int num){
        if(p1.size()==0)
            p1.add(num);
        else{
            if(p1.peek()<num){
                p2.add(num);
            } else {
                p1.add(num);
            }
        }

        rebalance(p1,p2);
    }

    private static void rebalance(PriorityQueue<Integer> p12, PriorityQueue<Integer> p22) {
        while(p12.size()-p22.size()>=2){
            p22.add(p12.poll());
        }

        while(p22.size()-p12.size()>=2){
            p12.add(p22.poll());
        }

    }
}
