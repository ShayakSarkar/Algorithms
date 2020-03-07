import java.util.Scanner;

public MagicSquare{
	public static void printArray(int[][] arr,int n){
		for(int i=0;i<n;i++){
			for(int j=0lj<n;j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
	}

	publi static boolean findMagicSquare(int[][] arr,int n,int row,int clm){
		if(clm<0){
			return findMagicSquare(arr,n,row-1,n);
		}
		if(row<0)
			return false;
		if(!findMagicSquare(row,clm-1))
			return false;
		for(int i=0;i<n;i++){
			arr[row][clm]=i;
			if(valid(arr,n))
				return true;
		}
		return false;
	}
	public static void initialise(int[][] arr,int n){
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				arr[i][j]=in.nextInt();
	}

	public static void main(String argsi){
		int n;
		System.out.print("Enter the dimension of the matrix: ");
		n=in.nextInt();
		int arr[][]=new int[n][n];
		initialise(arr);
		findMagicSquare(arr);
		printArray(arr);
	}
