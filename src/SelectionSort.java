public class SelectionSort {
    public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {   //n
            int minIndex = i;                    //n-1
            int j = i + 1;                       //n-1
            while (  j < arr.length) {           //n-1   +  n-2 +   n-2  +  n-n = (n^2 + n)/2
                if(arr[j] < arr[minIndex]){      //(n^2 + n)/2 - n-1
                    minIndex = j;                //(n^2 + n)/2 - n-1
                }
                ++j;                             ////(n^2 + n)/2 - n-1
            }
            Main.swap(arr , i ,minIndex );       //n-1
        }
    }
}

//Big O(n^2)