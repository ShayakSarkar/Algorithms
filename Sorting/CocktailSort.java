import java.util.*;

// Cocktail Sort is a different version bubble sort. In this, each iteration is decomposed
// into two phases. In the first phase, the largest element is bubbled up to the end of the 
// array. In the second phase, the smallest element is bubbled down to the first position
// of the array. This is then performed for the rest of the array.
//
// Invariant: For every Subarray, the first and last elements are the smallest and the largest
//            elements respectively.

public class CocktailSort{
	public static void cocktailSort(int[] arr,int start,int end){
		if(start>=end)
			return;
		for(int i=start;i<end;i++){
			if(arr[i]>arr[i+1]){
				int t=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=t;
			}
		}
		for(int i=end;i>start;i--){
			if(arr[i]<arr[i-1]){
				int t=arr[i];
				arr[i]=arr[i-1];
				arr[i-1]=t;
			}
		}
		cocktailSort(arr,start+1,end-1);
	}
	public static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	public static void main(String args[]){
		int[] arr={4,2,5,6,7,3,21,1,4,2,8,10};
		cocktailSort(arr,0,arr.length-1);
		printArray(arr);
	}
}
