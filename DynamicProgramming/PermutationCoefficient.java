import java.util.*;
public class PermutationCoefficient{
	public static HashMap<ArrayList<Integer>,Integer> map=new HashMap<ArrayList<Integer>,Integer>();
	public static int fact(int n){
		int f=1;
		for(int i=1;i<=n;i++)
			f*=i;
		return f;
	}
	public static int findPerm(int n,int k){
		if(k==0)
			return 1;
		ArrayList<Integer> pair=new ArrayList<Integer>();
		pair.add(n);
		pair.add(k);
		if(n==k){
			int ans=fact(n);
			map.put(pair,ans);
			return ans;
		}
		if(map.containsKey(pair)){
			return map.get(pair);
		}
		int ans=findPerm(n-1,k)+k*findPerm(n-1,k-1);
		map.put(pair,ans);
		return ans;
	}
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		System.out.println(findPerm(n,k));
		System.out.println(map);
	}
}

