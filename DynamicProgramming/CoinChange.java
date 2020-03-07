import java.util.*;

public class CoinChange{
	public static int findWays(int n,int[] arr){
		if(n==1){
			return 1;
		}
		if(n<0){
			return 0;
		}
		int ways=0;
		for(int i=0;i<arr.length;i++){
			ways+=findWays(n-arr[i],arr);
		}
		return ways;
	}
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		int[] arr=new int[m];
		for(int i=0;i<m;i++)
			arr[i]=in.nextInt();
		System.out.println(findWays(n,arr));
	}
}

