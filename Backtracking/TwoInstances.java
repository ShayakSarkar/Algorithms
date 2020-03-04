// Fill two instances of numbers from 1 to n such that there are i numbers between two instances of i E [1,n]
// The solution here uses linear space complexity whereas the optimal solution could use constant space complexity

import java.util.*;

public class TwoInstances{
	public static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	public static boolean findArray(int n,int[] retArr,int index,boolean[] isIncluded, String indent){
		if(index==retArr.length)
			return true;
		if(retArr[index]!=0){
			return findArray(n,retArr,index+1,isIncluded,indent+"\t");
		}

		for(int i=1;i<=n;i++){
			if(index+i+1>=retArr.length)
				return false;
			if(isIncluded[i] || retArr[index+i+1]!=0)
				continue;
			retArr[index]=i;
			retArr[index+i+1]=i;
			isIncluded[i]=true;
			if(findArray(n,retArr,index+1,isIncluded,indent+"\t"))
				return true;
			isIncluded[i]=false;
			retArr[index]=0;
			retArr[index+i+1]=0;
		}
		return false;
	}
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int retArr[]=new int[2*n];
		boolean isIncluded[]=new boolean[n+1];
		for(int i=0;i<n;i++){
			retArr[i]=0;
			isIncluded[i]=false;
		}
		boolean isFound=findArray(n,retArr,0,isIncluded,"");
		if(isFound)
			printArray(retArr);
		else
			System.out.println("Sorry array could not be formed");

	}
}

