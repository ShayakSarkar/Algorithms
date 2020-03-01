import java.util.*;

public class MagnetPuzzle{
	public static Scanner obj=new Scanner(System.in);
	public static void acceptArray(int[] arr,Scanner in){
		for(int i=0;i<arr.length;i++)
			arr[i]=in.nextInt();
	}

	public static void acceptArray(char[][] arr,int m,int n,Scanner in){
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				arr[i][j]=in.next().charAt(0);
	}

	public static void initialiseArray(int[] arr){
		for(int i=0;i<arr.length;i++)
			arr[i]=0;
	}
	public static void printArray(char[][] arr,int m,int n){
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
	}
			
	public static boolean solveMagneticPuzzle(char[][] rules,int m,int n,int[] top,int[] bottom,int[] left,int[] right,int[] curTop,int[] curBottom,int[] curLeft,int[] curRight,int i,int j){
		if(j>=n){
			i++;
			j=0;
		}
		if(i==m && j==n)
			return true;
		if(curTop[j]>top[j])
			return false;
		if(curBottom[j]>bottom[j])
			return false;
		if(curLeft[i]>left[i])
			return false;
		if(curRight[i]>right[i])
			return false;

		printArray(rules,m,n);
		

		if(rules[i][j]=='T'){
			
			rules[i][j]='+';
			curLeft[i]++;
			curTop[j]++;
			rules[i+1][j]='-';
			curRight[i+1]++;
			curBottom[j]++;
			if(solveMagneticPuzzle(rules,m,n,top,bottom,left,right,curTop,curBottom,curLeft,curRight,i,j+1))
				return true;
			curLeft[i]--;
			curTop[j]--;
			curRight[i+1]--;
			curBottom[j]--;

			rules[i][j]='-';
			curRight[i]++;
			curBottom[j]++;
			rules[i+1][j]='+';
			curLeft[i+1]++;
			curTop[j]++;
			if(solveMagneticPuzzle(rules,m,n,top,bottom,left,right,curTop,curBottom,curLeft,curRight,i,j+1))
				return true;
			curRight[i]--;
			curBottom[j]--;
			curLeft[j]--;
			curTop[j]--;

		}

		if(rules[i][j]=='L'){

			rules[i][j]='+';
			curLeft[i]++;
			curTop[j]++;
			rules[i][j+1]='-';
			curRight[i]++;
			curBottom[j+1]++;
			if(solveMagneticPuzzle(rules,m,n,top,bottom,left,right,curTop,curBottom,curLeft,curRight,i,j+1))
				return true;
			curLeft[i]--;
			curTop[j]--;
			curRight[i]--;
			curBottom[j+1]--;

			rules[i][j]='-';
			curRight[i]++;
			curBottom[j]++;
			rules[i][j+1]='+';
			curLeft[i]++;
			curBottom[j+1]++;
			if(solveMagneticPuzzle(rules,m,n,top,bottom,left,right,curTop,curBottom,curLeft,curRight,i,j+1))
				return true;
			curRight[i]--;
			curBottom[j]--;
			curLeft[i]--;
			curBottom[j+1]--;
		}
		return false;

	}	
	
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int m,n;
		m=in.nextInt();
		n=in.nextInt();
		int[] top=new int[n];
		int[] left=new int[m];
		int[] right=new int[m];
		int[] bottom=new int[n];
		
		acceptArray(top,in);
		acceptArray(left,in);
		acceptArray(right,in);
		acceptArray(bottom,in);
		
		char[][] rules=new char[m][n];
		acceptArray(rules,m,n,in);

		int[] curTop=new int[n];
		int[] curBottom=new int[n];
		int[] curLeft=new int[m];
		int[] curRight=new int[m];
		
		initialiseArray(curTop);  //Initialisw the arrays as no magnets have been placed as of now
		initialiseArray(curLeft);
		initialiseArray(curRight);
		initialiseArray(curBottom);
		
		System.out.println("Shayak Sarkar is my name: ");
		System.out.println(solveMagneticPuzzle(rules,m,n,top,bottom,left,right,curTop,curBottom,curLeft,curRight,0,0));

	}
}
