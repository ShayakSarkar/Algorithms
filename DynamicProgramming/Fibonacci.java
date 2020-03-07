import java.util.*;

public class Fibonacci{
	public static HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
	public static int fib(int n){
		if(map.containsKey(n)){
			return map.get(n);
		}

		if(n==0)
			return 1;
		if(n==1)
			return 2;
		int prev1=fib(n-1);
		int prev2=fib(n-2);
		map.put(n,prev1+prev2);
		return prev1+prev2;
	}
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		for(int i=0;i<20;i++)
			System.out.print(fib(i)+" ");
		System.out.println();
	}
}

