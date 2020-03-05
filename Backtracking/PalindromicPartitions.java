import java.util.*;

public class PalindromicPartitions{
	public static boolean isPalin(String s){
		for(int i=0;i<s.length()/2;i++){
			for(int j=s.length()-1;j>=i;j--){
				if(s.charAt(i)!=s.charAt(j))
					return false;
			}
		}
		return true;
	}
	public static LinkedList<LinkedList<String>> findPalindromicPartitions(String s){
		if(s.length()==1){
			LinkedList<LinkedList<String>> ans=new LinkedList<LinkedList<String>>();
			LinkedList<String> ll=new LinkedList<String>();
			ll.add(Character.toString(s.charAt(0)));
			ans.add(ll);
			System.out.println("ans: "+ans);
			return ans;
		}
		LinkedList<LinkedList<String>> retSet=new LinkedList<LinkedList<String>>();
		LinkedList<LinkedList<String>> partitions=findPalindromicPartitions(s.substring(1));

		for(LinkedList<String> partition : partitions){
			LinkedList<String> tempPart1=new LinkedList<String>(partition);
			LinkedList<String> tempPart2=new LinkedList<String>(partition);
			tempPart1.add(0,Character.toString(s.charAt(0)));
			retSet.add(0,tempPart1);
			String first=partition.get(0);
			if(isPalin(s.charAt(0)+first)){
				tempPart2.remove(0);
				tempPart2.add(0,s.charAt(0)+first);
				retSet.add(0,tempPart2);
			}
		}
		return retSet;
	}

	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		String s=in.next();
		LinkedList<LinkedList<String>> ans=findPalindromicPartitions(s);
		System.out.println(ans);
	}
}
