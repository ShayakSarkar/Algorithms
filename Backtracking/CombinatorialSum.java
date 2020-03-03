// Given a number x and a list of numbers, we need to find all possible ways of forming the number

import java.util.Collections;
import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;

public class CombinatorialSum{
	public static HashSet<ArrayList<Integer>> findWays(int sum,int[] arr){
		if(sum<0)
			return null;
		if(sum==0){
			HashSet<ArrayList<Integer>> temp=new HashSet<ArrayList<Integer>>();
			temp.add(new ArrayList<Integer>());
			return temp;
		}
		HashSet<ArrayList<Integer>> hs=new HashSet<ArrayList<Integer>>();
		for(int i=0;i<arr.length;i++){
			HashSet<ArrayList<Integer>> tempHs=findWays(sum-arr[i],arr);
			//System.out.println(tempHs);
			if(tempHs==null)
				continue;
			for(ArrayList<Integer> set: tempHs){
				set.add(0,arr[i]);
				Collections.sort(set);
				hs.add(set);
			}
		}
		return hs;
	}

	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int x=in.nextInt();
		int n=in.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=in.nextInt();
		HashSet<ArrayList<Integer>> set=findWays(x,arr);
		System.out.println("Number of ways: "+set);
	}
}

