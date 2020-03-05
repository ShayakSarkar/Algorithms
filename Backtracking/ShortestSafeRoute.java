// Shortest safe route in a grid filled with landmines, where landmines are maeked with 0.
// We cannot step in any of the cells adjacent to the landmines also.

import java.util.*;

public class ShortestSafeRoute{
	public static int lengthShortest=1000000;		// set to infinity

	public static boolean isSafe(int i,int j,int r,int c){
		if(i<0 || j<0 || i>=r || j>=c)
			return false;
		return true;
	}
	public static void printArray(int[][] map,int r,int c){
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static ArrayList<ArrayList<Integer>> findShortestRoute(int[][] map,int i,int j,int r,int c,int pathLength,ArrayList<ArrayList<Integer>> path){
		
	
	}
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int r,c;
		r=in.nextInt();
		c=in.nextInt();
		int map[][]=new int[r][c];
		int temp[][]=new int[r][c];
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				map[i][j]=in.nextInt();
				temp[i][j]=map[i][j];
			}
		}
		
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				if(temp[i][j]==0){
					if(isSafe(i-1,j,r,c)){
						map[i-1][j]=0;
					}
					if(isSafe(i+1,j,r,c)){
						map[i+1][j]=0;
					}
					if(isSafe(i,j+1,r,c)){
						map[i][j+1]=0;
					}
					if(isSafe(i,j-1,r,c)){
						map[i][j-1]=0;
					}
				}

			}
		}
		temp=null;
		ArrayList<ArrayList<Integer>> pathParam=new ArrayList<ArrayList<Integer>>();
		pathParam.add(new ArrayList<Integer>());
		ArrayList<ArrayList<Integer>> path=findShortestRoute(map,4,0,r,c,0,pathParam);
		System.out.println(path);
		printArray(map,r,c);
	}
}
		
