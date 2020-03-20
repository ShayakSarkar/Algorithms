import java.util.*;

// This is an imporvement over Bubble sort algorithm
// Bubble sort compares every element with the next adjacent 
// element. Comb sort compares every element arr[i] with the 
// element at arr[i+gap]. This value of gap is initially equal
// to the length of the array. But is reduced at iteration to
// gap/1.3. This reduction is done until the gap becomes 1 at 
// which point it is essentially bubble sort. Doing this 
// improves the run time of the algorithm and it becomes faster than
// bubble sort since many exchanges are elimanted in this process,
// although the worst case complexity remains O(n^2). 
//
// Loop invariant: Unknown

public class CombSort{

	public static void combSort(int[] arr,int gap){
		if(gap<1)
			return;
		for(int i=0;i+gap<arr.length;i++){
			if(arr[i]>arr[i+gap]){
				int t=arr[i];
				arr[i]=arr[i+gap];
				arr[i+gap]=t;
			}
		}
		combSort(arr,(int)(gap/1.3));
	}

	public static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}

	public static void main(String args[]){
		int[] arr={1,4,2,5,3,4,5,6,5,4,3,7,1};
		combSort(arr,arr.length);
		printArray(arr);
	}
}
