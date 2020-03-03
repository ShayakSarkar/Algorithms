import java.util.*;
public class FindSubsets{
	public static HashSet<ArrayList<Integer>> findSubsets(ArrayList<Integer> arr,int index){
		if(index==arr.size()){
			HashSet<ArrayList<Integer>> temp=new HashSet<ArrayList<Integer>>();
			temp.add(new ArrayList<Integer>());
			return temp;
		}
		HashSet<ArrayList<Integer>> hs=new HashSet<ArrayList<Integer>>();
		HashSet<ArrayList<Integer>> retSet=findSubsets(arr,index+1);
		
		for(ArrayList<Integer> it : retSet){
			hs.add(it);
			ArrayList<Integer> temp=new ArrayList<Integer>(it);
			temp.add(arr.get(index));
			hs.add(temp);
		}
		return hs;

	}
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		ArrayList<Integer> arr=new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			int temp=in.nextInt();
			arr.add(temp);
		}
		System.out.println(findSubsets(arr,0));
	}
}


			
