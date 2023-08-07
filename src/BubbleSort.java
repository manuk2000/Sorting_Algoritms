public class BubbleSort {
    public static void sort(int[] arr){
        for (int i = 0; i < arr.length ; i++) {         //n
            for (int j = 1; j < arr.length - i; j++) {  //n     n-1     n-2...  n-n   = (n^2)/2
                if(arr[j - 1] > arr[j]){                //n+1   n+1-1   n+1-2   n+1-n = n+ ((n^2)/2)
                    Main.swap(arr, j - 1 , j);        //n+1   n+1-1   n+1-2   n+1-n = n+ ((n^2)/2)
                }
            }
        }
    }
}

//Big O =O(n^2)