import java.util.*;

// Uses a MinHeap to perform the sorting

public class MinHeapSort{

	public static void swap(int[] arr,int ind1,int ind2){
		int temp=arr[ind1];
		arr[ind1]=arr[ind2];
		arr[ind2]=temp;
	}

	public static void revert(int[] arr){
		int mid=(arr.length-1)/2;
		for(int i=0;i<=mid;i++)
			swap(arr,i,arr.length-1-i);
	}

	public static void heapSort(int[] arr){
		heapify(arr,0,arr.length);
		int length=arr.length;
		while(length>=1){
			if(length!=arr.length)
				siftDown(arr,0,length);
			swap(arr,length-1,0);
			length--;
		}
		revert(arr);
	}

	public static void heapify(int[] arr,int rootInd,int length){
		if(rootInd>=length)
			return;

		int leftChild=rootInd*2+1;
		int rightChild=rootInd*2+2;

		heapify(arr,leftChild,length);
		heapify(arr,rightChild,length);
		
		siftDown(arr,rootInd,length);
	}

	public static void siftDown(int[] arr,int index,int length){
		if(index>=length)
			return;

		int leftChild=index*2+1;
		int rightChild=index*2+2;

		if(leftChild<length && rightChild<length){
			if(arr[leftChild]<arr[index] && arr[leftChild]<arr[rightChild]){
				swap(arr,leftChild,index);
				siftDown(arr,leftChild,length);
			}
			else if(arr[rightChild]<arr[index]){
				swap(arr,rightChild,index);
				siftDown(arr,rightChild,length);
			}
		}
		else if(leftChild<length){
			if(arr[leftChild]<arr[index]){
				swap(arr,leftChild,index);
				siftDown(arr,leftChild,length);
			}
		}

	}

	public static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}

	public static void main(String args[]){
		int[] arr={3,2,5,6,31,7,8,5,9,20,13,5,16,12,11};
		heapSort(arr);
		printArray(arr);
	}
}
