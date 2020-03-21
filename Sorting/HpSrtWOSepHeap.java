import java.util.*;

// Heap Sort Without additional space. Here the sorting is 
// done in place for the array

public class HpSrtWOSepHeap{

	public static void heapSort(int[] arr){
		int length=arr.length;
		heapify(arr,0,length);
		while(length>=1){
			if(length!=arr.length)
				siftDown(arr,0,length);
			int temp=arr[0];
			arr[0]=arr[length-1];
			arr[length-1]=temp;
			length--;
		}
	}
	public static void heapify(int[] arr,int rootInd,int length){
		if(rootInd>=length)
			return;
		heapify(arr,rootInd*2+1,length);
		heapify(arr,rootInd*2+2,length);
		int leftChild=rootInd*2+1;
		int rightChild=rootInd*2+2;

		if(leftChild<length && rightChild<length){
			if(arr[leftChild]>arr[rootInd] && arr[leftChild]>=arr[rightChild]){
				int temp=arr[rootInd];
				arr[rootInd]=arr[leftChild];
				arr[leftChild]=temp;
				siftDown(arr,leftChild,length);
			}
			else if(arr[rightChild]>arr[rootInd]){
				int temp=arr[rootInd];
				arr[rootInd]=arr[rightChild];
				arr[rightChild]=temp;
				siftDown(arr,rightChild,length);
			}
		}

		else if(leftChild<length){
			if(arr[leftChild]>arr[rootInd]){
				int temp=arr[leftChild];
				arr[leftChild]=arr[rootInd];
				arr[rootInd]=temp;
				siftDown(arr,leftChild,length);
			}
		}

	}
	public static void siftDown(int[] arr,int index,int length){
		if(index>=arr.length)
			return;
		int leftChild=index*2+1;
		int rightChild=index*2+2;
		if(leftChild<length && rightChild<length){
			if(arr[leftChild]>arr[index] && arr[leftChild]>arr[rightChild]){
				int temp=arr[leftChild];
				arr[leftChild]=arr[index];
				arr[index]=temp;
				siftDown(arr,leftChild,length);
			}
			else if(arr[rightChild]>arr[index]){
				int temp=arr[rightChild];
				arr[rightChild]=arr[index];
				arr[index]=temp;
				siftDown(arr,rightChild,length);
			}
		}
		else if (leftChild<length){
			if(arr[leftChild]>arr[index]){
				int temp=arr[leftChild];
				arr[leftChild]=arr[index];
				arr[index]=temp;
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
		int[] arr={3,2,4,1,5,6,7,5,4,8,1,9};
		heapSort(arr);
		printArray(arr);
	}
}

