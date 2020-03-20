import java.util.*;

// We start from the starting position i of the array. If arr[i] < arr[i-1], we 
// move swap the element with the previous one. We decrement i and again check 
// for the same condition. Once the condition is satisfied, we increment i. This
// is almost the same as insertion sort, except that in this case, we compare the 
// correctly sorted too.
//
// Invariant: for every position in the array, the element to the left is smaller 
// 	      than the current position.

public class GnomeSort{
	public static void gnomeSort(int[] arr,int start){
		if(start>=arr.length)
			return;
		if(start==0){
			gnomeSort(arr,start+1);
			return;
		}
		while(arr[start]<arr[start-1]){
			int t=arr[start];
			arr[start]=arr[start-1];
			arr[start-1]=t;
			start--;
			if(start==0)
				break;
		}
		gnomeSort(arr,start+1);
	}
	public static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}

	public static void main(String args[]){
		int[] arr={4,2,6,7,4,3,2,1,0,10,45,6,57,33};
		gnomeSort(arr,0);
		printArray(arr);
	}
}

