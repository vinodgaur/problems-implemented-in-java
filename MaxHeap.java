package com.programming;

public class MaxHeap {
    private int[] heap= new int[20];
    private int size=0;
    public static void main(String[] args) {
        MaxHeap mh = new MaxHeap();
        mh.add(15);
        mh.add(13);
        mh.add(14);
        mh.add(11);
        mh.add(12);
        mh.add(2);
        mh.add(3);
        mh.add(5);
        mh.add(40);
        mh.add(35);

        mh.list();

        System.out.println(mh.poll());

        mh.list();
    }

     void add(int n){
        heap[size]=n;
        size++;
        heapifyUp(size-1);
    }

    int poll(){
        int m=heap[0];
        heap[0]=heap[size-1];
        size--;
        heapifyDown(0);
        return m;
    }

    void heapifyDown(int i){
        if(hasLeftChild(i)) {
            int smallChildIndex = leftChildIndex(i);
            if (hasRightChild(i) && heap[leftChildIndex(i)] < heap[rightChildIndex(i)]) {
                smallChildIndex = rightChildIndex(i);
            }

            if (heap[smallChildIndex] > heap[i]) {
                swap(smallChildIndex, i);
                heapifyDown(smallChildIndex);
            }
        }
    }

    boolean hasLeftChild(int i){
        return leftChildIndex(i) < size;
    }

    boolean hasRightChild(int i){
        return rightChildIndex(i) < size;
    }

    int leftChildIndex(int i){
        return (2*i+1);
    }

    int rightChildIndex(int i){
        return (2*i+2);
    }

    int getMax(){
        return heap[0];
    }

    void list(){
        for (int i=0;i<size;i++){
            System.out.print(heap[i]);
            if(size-i > 1) System.out.print(", ");
        }
        System.out.println("");
    }

     void heapifyUp(int index){
        if(index!=0 && parent(index) < heap[index]){
            int parentIndex=parentIndex(index);
            swap(parentIndex,index);
            index=parentIndex;
            heapifyUp(index);
        }
     }

    void swap(int a, int b){
        int temp=heap[a];
        heap[a]=heap[b];
        heap[b]=temp;
    }

    int parent(int i){
        return heap[parentIndex(i)];
    }

    int parentIndex(int i){
        return (i-1)/2;
    }
}
