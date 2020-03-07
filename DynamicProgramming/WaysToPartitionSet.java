import java.util.*;

public class WaysToPartitionSet{
	public static int findWays(int n){
		findWays(n-1);
	}
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		System.out.println(findWays(n));
	}
}

