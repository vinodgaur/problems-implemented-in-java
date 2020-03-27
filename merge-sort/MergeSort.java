import java.util.*;
public class MergeSort {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(5);
        arr.add(3);
        arr.add(7);
        arr.add(6);

        System.out.println(arr);

        ArrayList<Integer> mergedArr = mergeSort(arr);

        System.out.println(mergedArr);
    }

    static ArrayList mergeSort(ArrayList<Integer> arr) {
        //System.out.println(arr);
        //System.out.println(arr.size());
        if (arr.size() <= 1) {
            return arr;
        }

        int mid = (int) Math.floor(arr.size()) / 2;
        //System.out.println(mid);
        ArrayList<Integer> a = new ArrayList<Integer>(arr.subList(0, mid));
        ArrayList<Integer> b = new ArrayList<Integer>(arr.subList(mid, arr.size()));

        ArrayList<Integer> m1 = mergeSort(a);
        ArrayList<Integer> m2 = mergeSort(b);

        return mergeSortedArray(m1, m2);
    }

    static ArrayList<Integer> mergeSortedArray(ArrayList<Integer> m1, ArrayList<Integer> m2) {
        ArrayList<Integer> mergeArr = new ArrayList<Integer>();
        if (m1.size() == 0 && m1.size() == 0) {
            return mergeArr;
        }

        int i, j;
        for (i = 0, j = 0; i < m1.size() && j < m1.size(); ) {
            if (m1.get(i) < m2.get(j)) {
                mergeArr.add(m1.get(i));
                i++;
            } else {
                mergeArr.add(m2.get(j));
                j++;
            }
        }

        while (i < m1.size()) {
            mergeArr.add(m1.get(i));
            i++;
        }

        while (j < m2.size()) {
            mergeArr.add(m2.get(j));
            j++;
        }

        return mergeArr;
    }
}