import java.util.*;

public class SudokuSolver{
	public static boolean isValid(int[][] grid,int row,int clm){
		HashSet<Integer> hs=new HashSet<Integer>();
		for(int i=0;i<9;i++){
			if(grid[row][i]!=0 && hs.contains(grid[row][i]))
				return false;
			hs.add(grid[row][i]);
		}
		hs.clear();
		for(int i=0;i<9;i++){
			if(grid[i][clm]!=0 && hs.contains(grid[i][clm]))
				return false;
			hs.add(grid[i][clm]);
		}
		hs.clear();
		//----Validating the Box----

		int startRow=(row/3)*3;
		int startClm=(clm/3)*3;
		for(int i=startRow;i<startRow+3;i++){
			for(int j=startClm;j<startClm;j++){
				if(grid[i][j]!=0 && hs.contains(grid[i][j]))
					return false;
				hs.add(grid[i][j]);
			}
		}
		return true;
	}
	public static void printGrid(int[][] grid){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++)
				System.out.print(grid[i][j]+" ");
			System.out.println();
		}
	}
	public static int[][] copyGrid(int[][] grid){
		int[][] newGrid=new int[9][9];
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++)
				newGrid[i][j]=grid[i][j];
		return newGrid;
	}
	public static void solve(int[][] grid,int row,int clm){
		if(clm==9){
			clm=0;
			row++;
			if(row>=9){
				Scanner in=new Scanner(System.in);
				in.next();
				printGrid(grid);
				return;
			}
		}
		if(grid[row][clm]!=0){
			System.out.println("Skipped: "+row+" "+clm);
			solve(grid,row,clm+1);
		}
		for(int i=1;i<=9;i++){
			int[][] newGrid=copyGrid(grid);
			newGrid[row][clm]=i;
			if(!isValid(newGrid,row,clm))
				continue;
			solve(newGrid,row,clm+1);
		}
	}
	public static int[][] initialiseGrid(int[][] grid){
		int [][] arr={{2,4,9,0,7,6,0,0,0},
			      {8,3,0,0,0,0,0,6,9},
			      {0,0,0,0,8,9,5,2,4},
			      {3,6,0,2,4,0,0,5,0},
			      {0,9,0,0,5,0,4,1,0},
			      {0,5,4,6,0,0,0,3,0},
			      {0,1,6,9,0,0,2,0,8},
			      {0,0,7,1,6,8,0,0,5},
			      {9,0,0,0,0,5,0,0,1}};
		return arr;
	}
	public static void populateGrid(int[][] grid){
		Scanner in=new Scanner(System.in);
		System.out.println("Enter 0 for empty cell");
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				System.out.println("grid["+(i+1)+"]"+"["+(j+1)+"]: ");
				grid[i][j]=in.nextInt();
			}
		}
	}

	public static void main(String args[]){
		int[][] grid=new int[9][9];
		grid=initialiseGrid(grid);
		printGrid(grid);
		solve(grid,0,0);
	}
}
