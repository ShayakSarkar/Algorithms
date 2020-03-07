import java.util.*;

public class BinomialCoefficient{
	public static HashMap<ArrayList<Integer>,Integer> hm=new HashMap<ArrayList<Integer>,Integer>();
	public static int findCoeff(int n,int k){
		if(n==k)
			return 1;
		if(k==0)
			return 1;
		ArrayList<Integer> pair=new ArrayList<Integer>();
		pair.add(n);
		pair.add(k);
		if(hm.containsKey(pair)){
			return hm.get(pair);
		}

		int ans=findCoeff(n-1,k)+findCoeff(n-1,k-1);
		hm.put(pair,ans);
		return ans;
	}
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		System.out.println(findCoeff(n,k));
	}
}
