import java.util.*;

public class UniqueSubsets{

	// function to generate all possible unique subsets from an array, arr, starting from a particular index, index

	public static HashSet<ArrayList<Integer>> findUniqueSubsets(ArrayList<Integer> arr,int index){
		
		// if index == arr.size(), the only possible subset is an empty set
		// Since the function returns a power set, the return value
		// should be a set containing the empty set instead of the empty 
		// set itself.

		if(index==arr.size()){
			HashSet<ArrayList<Integer>> temp=new HashSet<ArrayList<Integer>>();    // create the power set
			temp.add(new ArrayList<Integer>()); 	// add the empty set 
			return temp;	// return the power set
		}

		// ans --> the power set obtained from the array starting at index+1
		// retSet --> the power set to be returned by the function
		
		HashSet<ArrayList<Integer>> ans=findUniqueSubsets(arr,index+1);	
		HashSet<ArrayList<Integer>> retSet=new HashSet<ArrayList<Integer>>();

		// for each subset present in ans, we can form two subsets,
		// one by including the element at arr[index], and one by 
		// not including the element at arr[index]

		for(ArrayList<Integer> set : ans){
			ArrayList<Integer> temp=new ArrayList<Integer>(set);  // temp -> copy of set in which we add arr[index]
			temp.add(arr.get(index));	// add arr[index] to temp
			retSet.add(set);	// add the set without the arr[index] to the power set to be returned, i.e retSet
			retSet.add(temp);	// add the set with arr[index] to retSet
		}
		return retSet;	
	}
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		ArrayList<Integer> arr=new ArrayList<Integer>();
		for(int i=0;i<n;i++)
			arr.add(in.nextInt());
		System.out.println(arr);
		HashSet<ArrayList<Integer>> ans=findUniqueSubsets(arr,0);
		System.out.println(ans);

		// This source code has been provided by Shayak Sarkar
	}
}


