import java.lang.*;
import java.util.*;

class RecursiveBinarySearch{
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
        index=binarysearch(arr,0,n-1,target);
        if(index==-1) System.out.println("Target not found!!");
        else System.out.println("Target found at index "+index+".");
    }
    private static int binarysearch(int[] arr,int left,int right,int target){
        if(left>=right) return -1;
        int mid=left+(right-left)/2;
        if(arr[mid]==target) return mid;
        else if(target<arr[mid]) return binarysearch(arr,left,mid-1,target);
        else return binarysearch(arr,mid+1,right,target);
    }
}
