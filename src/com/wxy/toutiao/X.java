package com.wxy.toutiao;

/**
 * Created by Cser_W on 2018/4/15.
 */
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class X {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[][] arr=new int[N][];
        for(int i=0;i<N;i++){
            int n=sc.nextInt();
            arr[i]=new int[n];
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<N;i++){
            int min=getMin(arr[i]);
            System.out.println(min);
        }

    }
    public static int getMin(int[] arr){
        if(arr ==null || arr.length==0){
            return 0;
        }
        int len=arr.length;
        int an=arr[len-1];
        int a1=arr[0];
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        for(int i=0;i<len-1;i++){
            if(map.containsKey(an-arr[i])){
                map.put(an-arr[i],2);
            }else{
                map.put(an-arr[i],1);
            }
        }
        for(int i=1;i<len;i++){
            if(map.containsKey(arr[i]-a1)){
                map.put(arr[i]-a1,2);
            }else{
                map.put(arr[i]-a1,1);
            }
        }
        int min=Integer.MAX_VALUE;
        for(Entry<Integer, Integer> entry:map.entrySet()){
            if(entry.getValue()==2){
                min= min>entry.getKey()? entry.getKey():min;
            }
        }
        return min;
    }

}