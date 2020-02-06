
// Given a set of integers and a required sum, find all possible subsets within the given set that have the required sum


import java.util.*;

public class SubsetSum{
	public static LinkedList<LinkedList<Integer>> finalList=new LinkedList<LinkedList<Integer>>();
	public static void findSubsets(int[] arr,int index,int reqSum,int curSum,LinkedList<Integer> ll){
		if(curSum>reqSum)
			return;
		if(curSum==reqSum){
			//System.out.println(ll);
			finalList.add(ll);
			return;
		}
		if(index>=arr.length)
			return;
		LinkedList<Integer> newList=new LinkedList<Integer>(ll);
		findSubsets(arr,index+1,reqSum,curSum,newList);
		newList.add(arr[index]);
		findSubsets(arr,index+1,reqSum,curSum+arr[index],newList);
		
	}

	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int[] arr={1,2,3,4,5,6,7};
		int reqSum=11;
		LinkedList<Integer> ll=new LinkedList<Integer>();
		findSubsets(arr,0,reqSum,0,ll);
		System.out.println(finalList);
	}
}
