
/*Given a pattern containing only I's and D's. I for increasing and D for decreasing.
 Devise an algorithm to print the minimum number following that pattern.
 Digits from 1-9 and digits can't repeat.*/
// LEETCODE PROBLEM 2375

import java.lang.*;
import java.util.*;
public class MinNumFollowingDIpattern {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the pattern: ");
        String str=sc.nextLine();
        str=printMinNumberForPattern(str);
        System.out.print("Output: ");
        System.out.println(str);
    }
    static String printMinNumberForPattern(String S) {
        //Starting from scratch
        if(S.isEmpty()) return null;
        int i=1,latest=0,first=-1,last=-1,temp=0;
        char previous='a';
        int[] arr=new int[S.length()+1];
        if(S.charAt(0)=='D'){
            first=0;
            last=0;
            previous='D';
        }
        else{
            latest++;
            arr[0]=latest;
            previous='I';
        }
        for(i=1;i<S.length();i++){
            if(S.charAt(i)=='I'){
                if(previous=='I'){
                    latest++;
                    arr[i]=latest;
                }
                else{
                    for(temp=last+1;temp>=first;temp--){
                        latest++;
                        arr[temp]=latest;
                    }
                    first=-1;
                }
                previous='I';
            }
            else{
                if(previous=='D'){
                    last=i;
                }
                else{
                    first=i;
                    last=i;
                }
                previous='D';
            }
        }
        i=S.length()-1;
        if(S.charAt(i)=='I'){
            latest++;
            arr[S.length()]=latest;
        }
        else{
            for(temp=last+1;temp>=first;temp--){
                latest++;
                arr[temp]=latest;
            }
        }
        String str="";
        i=0;
        while(i<arr.length){
            str=str+(char)(arr[i]+48);
            i++;
        }
        return str;
    }
}
