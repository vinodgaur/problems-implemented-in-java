package fibonacci;

import java.util.ArrayList;

//0 1 1 2 3 5 8 13, 21, 34
public class Fibonaci {
    public static void main(String[] args) {

        int n=6;

        Fibonaci f = new Fibonaci();
        int num = f.getFn(n);
        System.out.println(n+"th number ="+num);

        ArrayList<Integer> fib = f.getFibonacciSeries(n);
        System.out.println("fibonacci series for n="+n+":"+fib);
    }

    Integer getFn(int n){
        if(n<=1){
            return n;
        }
        return getFn(n-1) + getFn(n-2);
    }

    ArrayList<Integer> getFibonacciSeries(int n){
        ArrayList<Integer> fibSeries = new ArrayList<Integer>();

        if(n==1){
            fibSeries.add(0);
        } else if(n==2){
            fibSeries.add(0);
            fibSeries.add(1);
        } else {
            int f0=0, f1=1, sum;
            int count = 2;
            fibSeries.add(0);
            fibSeries.add(1);
            //loop
            while (count < n){
                sum = f0+f1;
                f0=f1;
                f1=sum;

                fibSeries.add(sum);
                count++;
            }
        }
        return fibSeries;
    }
}
