import java.util.*;

// This is a sorting algorithm that is effective on parallel processors
// Every iteraiton is divided in two phases: The odd phase, in which the 
// the pairs in the odd indices are bubble sorted. In second pass, the 
// pairs in the even indices are bubble sorted. This is continued until
// the array is sorted.
//
// Invariant: No invariant
//
// The algorithm continues until every arr[i] < arr[i+1] where i is either 
// even or odd

public class OddEvenSort{
	public static void oddEvenSort(int[] arr){
		boolean swapped=true;
		while(swapped){
			swapped=false;
			for(int i=0;i+1<arr.length;i+=2){
				if(arr[i]>arr[i+1]){
					swapped=true;
					int t=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=t;
				}
			}
			for(int i=1;i+1<arr.length;i+=2){
				if(arr[i]>arr[i+1]){
					swapped=true;
					int t=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=t;
				}
			}
		}
	}


	public static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	public static void main(String args[]){
		int[] arr={3,4,2,1,6,5,7,8,6,9,10,11,14,22,18,15};
		oddEvenSort(arr);
		printArray(arr);
	}
}

