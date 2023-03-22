package Patterns;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main m1 = new Main();
        m1.pattern1(5,0);
        //m1.pattern2(5,0);
        int[] arr = {1,5,4,3,7,-1};
        System.out.println(Arrays.toString(m1.bubbleSort(arr,0,1)));
        //m1.recBubbleSort(arr,0,1);


//        int n  =5;
//
//
//        for( int i = 0;i<n;i++){
//            for(int j =0;j<n-i;j++){
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
    }

    public void pattern1(int row , int col){
        if(row==0){
            return;
        }

        if(col<row){
            System.out.print("* ");
            pattern1(row,col+1);
        }else{
            System.out.println();
            pattern1(row-1,0);
        }

    }

    public void pattern2(int r, int c){
        if(r==0){
            return ;
        }

        if(r<c){
            pattern2(r,c+1);
            System.out.print("* ");
        }else{
            pattern2(r-1,0);
            System.out.println();
        }
    }

    // iterative bubble sort
//    public void bubbleSort(int[] arr){
//
//        for(int i = 0;i<arr.length;i++){
//            for(int j =i+1;j<arr.length;j++){
//                if(arr[i] >arr[j]){
//                    int temp;
//                    temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//    }

    // recursive bubble sort
    public int[] bubbleSort(int[] arr,int i,int j ){
        if(i == arr.length-1){
            return arr;
        }

        if(i<j && j <= arr.length-1){
            if(arr[i] > arr[j]){
                // swap
                int temp =arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            bubbleSort(arr,i,j+1);

        }
        bubbleSort(arr,i+1,j+1);

        return arr;



    }



}
