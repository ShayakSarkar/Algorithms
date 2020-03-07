import java.util.*;

public class UglyNumber{
	public static HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
	public static boolean isPrime(int n){
		for(int i=2;i<=n/2;i++)
			if(n%i==0)
				return false;
		return true;
	}
	public static boolean isUgly(int n){
		
		for(int i=2;i<=n/2;i++){
			if(isPrime(i) && i!=2 && i!=3 && i!=5 && n%i==0)
				return false;
		}
		if(isPrime(n) && n!=2 && n!=3 && n!=5)
			return false;
		return true;
	}
	public static int findUgly(int n){
		if(map.containsKey(n)){
			//System.out.println("found");
			return map.get(n);
		}
		if(n==0)
			return 1;
		int prev=findUgly(n-1);
		for(int i=prev+1;;i++){
			if(isUgly(i)){
				map.put(n,i);
				return i;
			}
		}
	}
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		for(int i=0;i<n;i++)
			System.out.print(" "+findUgly(i));
		System.out.println("\n"+map);
	}
}
