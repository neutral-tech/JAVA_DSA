import java.lang.*;
import java.util.*;

class IterativeBinarySearch{
    public static void main(String[] args){
        int n,i,target,index;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements:");
        for(i=0;i<n;i++){
           arr[i]=sc.nextInt();
        }
        System.out.print("Enter the target to be searched: ");
        target=sc.nextInt();
        sc.close();
        index=binarysearch(arr,target);
        if(index==-1) System.out.println("Target not found!!");
        else System.out.println("Target found at index "+index+".");
    }
    private static int binarysearch(int[] arr,int target){
        int left=0,right=arr.length-1,mid;
        while(left<right){
            mid=left+(right-left)/2;
            if(target==arr[mid]) return mid;
            else if(target<arr[mid]) right=mid-1;
            else left=mid+1;
        }
        return -1;
    }
}
