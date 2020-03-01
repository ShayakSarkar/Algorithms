// Given 3 numbers sum S, prime P, and N, find all N prime numbers after
// prime P such that their sum is equal to S

import java.util.*;

public class PrimeSum{
	public static Scanner in=new Scanner(System.in);
	public static boolean isPrime(int n){
		int limit=(int)Math.sqrt(n);
		for(int i=2;i<=limit;i++)
			if(n%i==0)
				return false;
		return true;
	}
	public static HashSet<HashSet<Integer>> findPrimes(int n,int p,int s,String indent){
		HashSet<HashSet<Integer>> hs=new HashSet<HashSet<Integer>>();
		if(n<0)
			return null;
		if(s==0 && n==0){
			HashSet<Integer> temp=new HashSet<Integer>();
			temp.add(p);
			hs.add(temp);
			return hs;
		}
		if(s<0)
			return null;

		for(int i=p+1;i<=s;i++){
			if(isPrime(i)){
				HashSet<HashSet<Integer>> retArr=findPrimes(n-1,i,s-i,indent+"\t");
				if(retArr==null)
					continue;
				for(HashSet<Integer> set : retArr){
					HashSet<Integer> temp=new HashSet<Integer>();
					temp.add(i);
					for(Integer elm : set)
						temp.add(elm);
					hs.add(temp);
				}
			}
		}
		return hs;

	}

	public static void main(String args[]){
		int n,p,s;
		n=in.nextInt();
		p=in.nextInt();
		s=in.nextInt();
		String indent="\t";
		System.out.println(findPrimes(n,p,s,indent));
	}
}

