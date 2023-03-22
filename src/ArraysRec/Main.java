package ArraysRec;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Main m2 = new Main();
        int[] arr = {1,2,4,5,6,7,8,0,1,2,1,1,1};
         System.out.println(m2.ifSorted(arr,0,1));
        System.out.println(m2.linearSearch(arr,10,0));
        System.out.println(m2.findAllIndex(arr,1));

        // finding all index in an array

        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> res1 = m2.findAllIndex1(arr,1,0,res);
        System.out.println(res1);
        System.out.println(m2.findAllIndex2(arr,1,0));
        ///

        // rotated Binary Search
        int[] arr1= {5,6,7,8,9,10,1,2,3,4};
        System.out.println(m2.rotatedBinSearch(arr1,7,0, arr1.length-1));
        System.out.println(m2.rotatedBinSearch(arr1,10,0, arr1.length-1));
        System.out.println(m2.rotatedBinSearch(arr1,3,0, arr1.length-1));
    }

    // check if an array is sorted .
    public boolean ifSorted(int[] arr,int i,int j ){

        if((j==arr.length-1&&arr[i]<arr[j])|| arr.length==0||arr.length==1){
            return true;
        }

        if(arr[i] <arr[j]){
            return ifSorted(arr,i+1,j+1);
        }else{
            return false;
        }

    }

    public int linearSearch(int[] arr,int x,int index){

        if(index == arr.length-1 && arr[index] != x){
            return -1;
        }

        if(arr[index]==x){
            return index;
        }
        return linearSearch(arr,x,index+1);


    }

    // find all occurance of an int in an array using linear search

    // arr= {1,2,3,1,4,5,6,1,7,8,1,1,1,1}

    public int findAllIndex(int[] arr,int x){
        if(arr.length==0){
            return -1;
        }
        int index = 0;
        int counter=0;

        return helperFunc1(arr,x,index,counter);
    }

    private int helperFunc1(int[] arr, int x, int index, int counter) {
        if(index == arr.length){
            return counter;
        }
        if(arr[index] == x){
            return helperFunc1(arr,x,index+1,counter+1);
        }
        return helperFunc1(arr,x,index+1,counter);

    }

   // passing an arraylist in the function argument
    public ArrayList<Integer> findAllIndex1(int[] arr,int target,int index,ArrayList<Integer> result){
        if(index == arr.length){
            return result;
        }

        if(arr[index] == target){
            result.add(index);
            return findAllIndex1(arr,target,index+1,result);
        }
        return findAllIndex1(arr,target,index+1,result);
    }



    public ArrayList<Integer> findAllIndex2(int[] arr,int target,int index){
        ArrayList<Integer> list = new ArrayList<>();

        if(index == arr.length){
            return list;
        }

        if(arr[index] == target){
            list.add(index);
        }

        ArrayList<Integer> restRec = findAllIndex2(arr,target,index+1);

        list.addAll(restRec);
        return list;
    }

    public int rotatedBinSearch(int[] arr, int target, int start, int end){

        if(start>end ){
            return -1;
        }
        int mid = start +(end-start)/2;

        if(arr[mid] == target){
            return mid;
        }

        if(arr[start]<= arr[mid]){
            if(target >= arr[start] && target<= arr[mid]){
                return rotatedBinSearch(arr,target,start,mid-1);
            }else{
                return rotatedBinSearch(arr,target,mid+1,end);
            }
        }


            if(target>= arr[mid] && target <= arr[end]){
                return rotatedBinSearch(arr,target,mid+1,end);
            }


        return rotatedBinSearch(arr,target,start,mid-1);



    }


}
