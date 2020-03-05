// Shortest safe route in a grid filled with landmines, where landmines are marked with 0.
// We cannot step in any of the cells adjacent to the landmines also.

import java.util.*;
 
public class ShortestSafeRoute{
	public static boolean isSafe(int i,int j,int r,int c){
		if(i<0 || i>=r || j<0 || j>=c)
			return false;
		return true;
	}
	public static void printArray(int[][] arr,int r,int c){
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
	}

	public static ArrayList<ArrayList<Integer>> findMin(ArrayList<ArrayList<ArrayList<Integer>>> pathList){
		ArrayList<ArrayList<Integer>> min=null;
		for(ArrayList<ArrayList<Integer>> path : pathList){
			if(path!=null){
				if(min==null)
					min=path;
				else if(min.size()>path.size())
					min=path;
			}
		}
		return min;
	}

	public static ArrayList<ArrayList<Integer>> findShortestPath(int i,int j,int r,int c,int[][] arr){
		if(!isSafe(i,j,r,c))
			return null;
		if(arr[i][j]==0)
			return null;
		if(arr[i][j]==2)
			return null;
		if(i==r-1){
			ArrayList<Integer> position=new ArrayList<Integer>();
			position.add(i);
			position.add(j);
			ArrayList<ArrayList<Integer>> path=new ArrayList<ArrayList<Integer>>();
			path.add(position);
			return path;
		}
		arr[i][j]=2;
		ArrayList<ArrayList<Integer>> path1=findShortestPath(i-1,j,r,c,arr);
		ArrayList<ArrayList<Integer>> path2=findShortestPath(i+1,j,r,c,arr);
		ArrayList<ArrayList<Integer>> path3=findShortestPath(i,j-1,r,c,arr);
		ArrayList<ArrayList<Integer>> path4=findShortestPath(i,j+1,r,c,arr);
		ArrayList<ArrayList<ArrayList<Integer>>> pathList=new ArrayList<ArrayList<ArrayList<Integer>>>();

		pathList.add(path1);pathList.add(path2);pathList.add(path3);pathList.add(path4);
		ArrayList<ArrayList<Integer>> minPath=findMin(pathList);

		if(minPath==null){
			return null;
		}
		ArrayList<Integer> position=new ArrayList<Integer>();
		position.add(i);
		position.add(j);
		minPath.add(0,position);
		arr[i][j]=1;
		return minPath;
	}

			
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int r,c;
		r=in.nextInt();
		c=in.nextInt();
		int arr[][]=new int[r][c];
		ArrayList<ArrayList<Integer>> minePos=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				arr[i][j]=in.nextInt();
				if(arr[i][j]==0){
					ArrayList<Integer> position=new ArrayList<Integer>();
					position.add(i);
					position.add(j);
					minePos.add(position);
				}

			}
		}
		for(ArrayList<Integer> position : minePos){
			int x=position.get(0);
			int y=position.get(1);
			if(isSafe(x-1,y,r,c)){
				arr[x-1][y]=0;
			}
			if(isSafe(x+1,y,r,c)){
				arr[x+1][y]=0;
			}
			if(isSafe(x,y+1,r,c)){
				arr[x][y+1]=0;
			}
			if(isSafe(x,y-1,r,c)){
				arr[x][y-1]=0;
			}
		}	
		//System.out.println(minePos);
		printArray(arr,r,c);
		System.out.println(findShortestPath(3,0,r,c,arr));
	}
}

