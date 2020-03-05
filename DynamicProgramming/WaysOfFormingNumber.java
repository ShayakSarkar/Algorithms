// Given a number n and a set of numbers arr, we need to find the number of ways in
// which we can form n by using the numbers in arr.

import java.util.*;

public class WaysOfFormingNumber{
	public static HashMap<Integer,Integer> minWays=new HashMap<Integer,Integer>();
	public static int findWays(int n,int[] arr,String indent){
		//System.out.println(indent+n);
		if(n<0)
			return 0;
		if(n==0)
			return 1;
		int ways=0;
		for(int i=0;i<arr.length;i++){
			if(minWays.containsKey(n-arr[i])){
				ways+=minWays.get(n-arr[i]);
				continue;
			}
			int delta=findWays(n-arr[i],arr,indent+"\t");
			ways+=delta;
			if(delta!=0)
				minWays.put(n-arr[i],delta);
		}
		return ways;
	}
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int length=in.nextInt();
		int arr[]=new int[length];
		for(int i=0;i<length;i++)
			arr[i]=in.nextInt();
		int ways=findWays(n,arr,"");
		System.out.println(minWays);
		System.out.println(ways);
	}
}
