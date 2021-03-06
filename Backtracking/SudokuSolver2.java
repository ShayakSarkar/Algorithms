
//Given a 9 X 9 Sudoku Grid, find a solution for the same.

import java.util.*;
public class SudokuSolver2{
	public static final String RED="\u001b[31m";
	public static final String RESET="\u001b[0m";
	public static final String YELLOW="\u001b[32m";
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
			for(int j=startClm;j<startClm+3;j++){
				if(grid[i][j]!=0 && hs.contains(grid[i][j]))
					return false;
				hs.add(grid[i][j]);
			}
		}
		return true;
	}
	public static void printGrid(int[][] grid){
		for(int i=0;i<9;i++){
			if(i%3==0 && i!=0){
				for(int j=0;j<9;j++)
					System.out.print(YELLOW+"~~"+RESET);
				System.out.println();
			}
		
			for(int j=0;j<9;j++){
				if(j%3==0 && j!=0)
					System.out.print(YELLOW+"|"+RESET);
				if(grid[i][j]==0)
					System.out.print(RED+"_ "+RESET);
				else
					System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void printSolution(int[][] sol,int[][] initGrid){
		for(int i=0;i<9;i++){
			if(i%3==0 && i!=0){
				for(int j=0;j<9;j++)
					System.out.print(YELLOW+"~~"+RESET);
				System.out.println();
			}
			for(int j=0;j<9;j++){
				if(j%3==0 && j!=0)
					System.out.print(YELLOW+"|"+RESET);
				if(initGrid[i][j]==0)
					System.out.print(RED+sol[i][j]+RESET+" ");
				else
					System.out.print(sol[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static boolean solve(int[][] grid,int row,int clm,int[][] initGrid){
		if(clm==9){
			clm=0;
			row++;
			if(row==9){
				printSolution(grid,initGrid);
				return true;
			}
		}
		if(grid[row][clm]!=0){
			if(solve(grid,row,clm+1,initGrid))
				return true;
			return false;
		}
		for(int i=1;i<=9;i++){
			grid[row][clm]=i;
			if(!isValid(grid,row,clm))
				continue;
			if(solve(grid,row,clm+1,initGrid))
				return true;
		}
		grid[row][clm]=0;
		return false;
	}
	public static int[][] initialiseGrid(int[][] grid){
		int [][] arr={{3,0,0,8,0,1,0,0,2},
			      {2,0,1,0,3,0,6,0,4},
			      {0,0,0,2,0,4,0,0,0},
			      {8,0,9,0,0,0,1,0,6},
			      {0,6,0,0,0,0,0,5,0},
			      {7,0,2,0,0,0,4,0,9},
			      {0,0,0,5,0,9,0,0,0},
			      {9,0,4,0,8,0,7,0,5},
			      {6,0,0,1,0,7,0,0,3}};
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

	public static int[][] copyGrid(int[][] grid){
		int[][] newGrid=new int[9][9];
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++)
				newGrid[i][j]=grid[i][j];
		return newGrid;
	}

	public static void main(String args[]){
		int[][] grid=new int[9][9];
		grid=initialiseGrid(grid);
		int[][] initGrid=copyGrid(grid);
		System.out.println();
		printGrid(grid);
		System.out.println();
		System.out.println();
		System.out.println();
		solve(grid,0,0,initGrid);

	}
}
