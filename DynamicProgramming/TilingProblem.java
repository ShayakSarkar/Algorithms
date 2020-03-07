// Given  a grid of dimensions n * 2, we need to find the number of ways of
// filling it with tiles of dimension 2 * 1

import java.util.*;
public class TilingProblem{
	public static HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
	public static int countWays(int n){
		if(n==0){
			return 1;
		}
		if(n<0)
			return 0;
		if(map.containsKey(n)){
			return map.get(n);
		}
		int c1=countWays(n-1);
		int c2=countWays(n-2);
		map.put(n,c1+c2);
		return c1+c2;
	}
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		System.out.println(countWays(n));
		System.out.println(map);
	}
}

