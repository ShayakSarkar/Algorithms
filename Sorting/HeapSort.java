import java.util.*;
public class HeapSort{
	static class MaxHeap{
		int[] arr;
		int insertionIndex=0;
		public MaxHeap(int n){
			arr=new int[n];
		}
		public void offer(int elm){
			arr[insertionIndex]=elm;
			insertionIndex++;
			siftUp(insertionIndex-1);
		}
		public int poll(){
			int returnValue=arr[0];
			arr[0]=arr[insertionIndex-1];
			insertionIndex--;
			siftDown(0);
			return returnValue;
		}
		public void siftDown(int index){
			if(leftChild(index)<insertionIndex && rightChild(index)<insertionIndex){
				if(arr[leftChild(index)]>arr[index] && arr[leftChild(index)]>arr[rightChild(index)]){
					int temp=arr[leftChild(index)];
					arr[leftChild(index)]=arr[index];
					arr[index]=temp;
					siftDown(leftChild(index));
				}
				else if(arr[rightChild(index)]>arr[index]){
					int temp=arr[rightChild(index)];
					arr[rightChild(index)]=arr[index];
					arr[index]=temp;
					siftDown(rightChild(index));
				}
			}
			else if(leftChild(index)<insertionIndex){
				if(arr[index]<arr[leftChild(index)]){
					int temp=arr[index];
					arr[index]=arr[leftChild(index)];
					arr[leftChild(index)]=temp;
				}
			}
			
		}
		public void siftUp(int index){
			if(index==0)	// If root, no need to sift Up
				return;

			while(index!=0 && arr[index]>arr[parentOf(index)]){
				int temp=arr[index];
				arr[index]=arr[parentOf(index)];
				arr[parentOf(index)]=temp;
				index=parentOf(index);
			}
		}
		public void showHeap(){
			for(int i=0;i<insertionIndex;i++)
				System.out.print(arr[i]+" ");
			System.out.println();
		}

		public void heapify(int[] arr){
			insertionIndex=0;
			for(int i=0;i<arr.length;i++)
				offer(arr[i]);
		}
		public int size(){
			return insertionIndex;
		}
		private int leftChild(int index){
			return index*2+1;
		}

		private int rightChild(int index){
			return index*2+2;
		}

		private int parentOf(int index){
			if(index==0)
				return -1;
			if(index%2==0)
				return (index/2)-1;
			return (index/2);
		}
	}
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		MaxHeap heap=new MaxHeap(20);
		int[] arr={8,81,48,53,46,70,98,42,27,76,33,24,2,76,62,89,90,5,13,21};
		heap.heapify(arr);
		heap.showHeap();
		while(heap.size()!=0){
			System.out.print(heap.poll()+" ");
			//heap.showHeap();
			//System.out.println();
		}
		System.out.println();
	}

}
