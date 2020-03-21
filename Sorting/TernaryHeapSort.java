public class TernaryHeapSort{
	public static void heapify(int[] arr,int rootInd,int d,int length){
		if(rootInd>=length)
			return;
		for(int i=0;i<d;i++)
			heapify(arr,rootInd*d+(i+1),d,length);
		siftDown(arr,rootInd,d,length);
	}
	public static void siftDown(int[] arr,int rootInd,int d,int length){
		if(rootInd>=length)
			return;
		int childInd=getValidChildIndex(arr,rootInd,d,length);
		if(childInd==-1)
			return;
		swap(arr,childInd,rootInd);
		siftDown(arr,childInd,d,length);
	}
	public static void swap(int[] arr,int ind1,int ind2){
		int temp=arr[ind1];
		arr[ind1]=arr[ind2];
		arr[ind2]=temp;
	}
	public static int getValidChildIndex(int[] arr,int rootInd,int d,int length){
		int bestChild=-1;
		for(int i=0;i<d;i++){
			if(rootInd*d+(i+1)>=length)
				break;
			if(bestChild==-1){
				bestChild=rootInd*d+(i+1);
				continue;
			}
			if(arr[rootInd*d+(i+1)]>arr[bestChild])
				bestChild=rootInd*d+(i+1);
		}
		if(bestChild==-1)
			return -1;
		if(arr[bestChild]>arr[rootInd])
			return bestChild;
		return -1;
			
	}
	public static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	public static void heapSort(int[] arr){
		heapify(arr,0,3,arr.length);	// Create ternary heap for teranry sort
		int length=arr.length;
		while(length>=1){
			if(length!=arr.length)
				siftDown(arr,0,3,length);
			swap(arr,0,length-1);
			length--;
		}
	}
	public static void main(String args[]){
		int arr[]={1,2,31,21,6,5,2,4,8,2,10,16,44};
		heapSort(arr);
		printArray(arr);
	}
}

