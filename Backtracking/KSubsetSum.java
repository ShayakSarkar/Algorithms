// Given a set of integers, divide set of integers into K subsets such that the sum of subset is equal.

import java.util.*;
public class KSubsetSum{
	public static boolean isEqual(ArrayList<ArrayList<Integer>> sets){
		Integer sumPrev=null;
		Integer sumCur=null;
		for(ArrayList<Integer> set : sets){
			sumCur=0;
			for(Integer it : set){
				sumCur+=it;
			}
			if(sumPrev==null){
				sumPrev=sumCur;
				continue;
			}
			if(sumPrev!=sumCur)
				return false;
		}
		return true;
	}

	public static boolean makeSubsets(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> sets, int index){
		if(index==arr.size()){
			if(isEqual2(sets))
				return true;
			return false;
		}
		int target=arr.get(index);
		for(ArrayList<Integer> set : sets){
			set.add(target);
			if(makeSubsets(arr,sets,index+1)==true)
				return true;
			set.remove(set.size()-1);
		}
		return false;

	}

	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		System.out.print("Enter the number of Subsets: ");
		int k=in.nextInt();
		System.out.print("Enter the number of elements: ");
		int n=in.nextInt();
		ArrayList<Integer> arr=new ArrayList<Integer>(n);
		for(int i=0;i<n;i++){
			int temp=in.nextInt();
			arr.add(temp);
		}
		System.out.println(arr);
		ArrayList<ArrayList<Integer>> sets=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<k;i++){
			sets.add(new ArrayList<Integer>());
		}
		if(makeSubsets(arr,sets,0)){
			System.out.println(sets);
		}
		else
			System.out.println("false");
	}
}

