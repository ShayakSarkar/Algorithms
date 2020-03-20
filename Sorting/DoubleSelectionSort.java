import java.util.*;

// This is exactly similar to selection sort except that,
// instead of only finding the index of the smallest element
// in an iteration, it also finds the index of the largest 
// element. It then puts them in the starting and ending locations
// of the array and then continues the same procedure for the 
// remaining portion of the array.
//
// Loop invariant: the starting and ending locations of the array
// 		   have the smallest and largest elements
// 		   respectively

public class DoubleSelectionSort{

	public static void doubleSelectionSort(int[] arr,int start,int end){
		printArray(arr,start,end);
		if(start>=end)
			return;
		int minPos=start,maxPos=start;
		for(int i=start;i<=end;i++){
			if(arr[i]<arr[minPos])
				minPos=i;
			if(arr[i]>arr[maxPos])
				maxPos=i;
		}
		
		int temp;
		if(minPos!=start){
			temp=arr[minPos];
			arr[minPos]=arr[start];
			arr[start]=temp;
		}
		
		if(maxPos==start)
			maxPos=minPos;

		if(maxPos!=end){
			temp=arr[maxPos];
			arr[maxPos]=arr[end];
			arr[end]=temp;
		}

		doubleSelectionSort(arr,start+1,end-1);
	}

	public static void printArray(int[] arr,int start,int end){
		for(int i=start;i<=end;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	public static void main(String args[]){
		int[] arr={3,2,5,1,6,3,6,3,8,9,10,4,50,34,23,45,11};
		int[] arr2={64,25,12,22,11};
		doubleSelectionSort(arr2,0,arr2.length-1);
		printArray(arr2,0,arr2.length-1);
	}
}
