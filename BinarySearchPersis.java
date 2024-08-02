public class BinarySearchPersis {

    public static void main(String[] args) {
        BinarySearchPersis binarySearchPersis = new BinarySearchPersis();
        int[] arr = new int[]{2,5,7,9};
        int out = binarySearchPersis.binarySearch(arr, 5);
        int nextNum = out+1;
        if(nextNum < arr.length)
            System.out.println(arr[nextNum]);

        System.out.println(out);
    }

    private int binarySearch(int[] arr, int search){
        int left = 0;
        int right = arr.length-1;
        
        while(left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid] == search){
                return mid;
            } else if(search < arr[mid]){
                right = mid-1;
            } else
                left = mid+1;
        }
        return -1;
    }

    public Object getInstance(){
        BinarySearchPersis binarySearchPersis = new BinarySearchPersis();
        return binarySearchPersis;
    }

    
}