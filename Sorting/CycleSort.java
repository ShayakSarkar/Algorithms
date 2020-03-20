
import java.util.*;

// Needs Work, Not correct for duplicate elements

public class CycleSort{
	public static void cycleSort(int[] arr,int start){
		if(start>=arr.length-1)
			return;
		
		int offset=0;
		boolean firstCycle=true;
		int elm=arr[start];
		do{
			offset=0;
			for(int i=start+1;i<arr.length;i++){
				if(arr[i]<elm)
					offset++;
			}
			if(firstCycle && offset==0)
				break;
			int temp=arr[start+offset];
			while(arr[start+offset]==elm)
				offset++;
			if(start+offset<arr.length){
				arr[start+offset]=elm;
				elm=temp;
			}
			firstCycle=false;

		}while(offset!=0);

		cycleSort(arr,start+1);
	}
	public static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	public static void main(String args[]){
		int[] arr={2,4,5,1,3,5,3};
		cycleSort(arr,0);
		printArray(arr);
	}
}



