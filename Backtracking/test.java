import java.util.*;
public class test{
	public static void initialiseGrid(int[][] arr){
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++)
				arr[i][j]=i+j;
	}
	public static void printGrid(int[][] arr){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
	}
	public static void main(String args[]){
		int[][] arr=new int[4][4];
		initialiseGrid(arr);
		printGrid(arr);
	}
}
