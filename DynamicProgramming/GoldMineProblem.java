import java.util.*;

public class GoldMineProblem{
	public static HashMap<ArrayList<Integer>,Integer> map=new HashMap<ArrayList<Integer>,Integer>();
	public static boolean isSafe(int posr,int posc,int r,int c){
		return !(posr<0 || posr>=r || posc<0 || posc>=c);
	}
	public static int findMaxGold(int posr,int posc,int r,int c,int[][] arr){
		if(!isSafe(posr,posc,r,c)){
			return 0;
		}
		
		ArrayList<Integer> position=new ArrayList<Integer>();
		position.add(posr);
		position.add(posc);

		if(map.containsKey(position)){
			return map.get(position);
		}
		int amt1=findMaxGold(posr+1,posc+1,r,c,arr);
		int amt2=findMaxGold(posr-1,posc+1,r,c,arr);
		int max=(int)Math.max(amt1,amt2);
		map.put(position,max+arr[posr][posc]);

		return max+arr[posr][posc];
	}

	public static void main(String args[]){
		Scanner in=new Scanner(System.in);

		int n,m;
		n=in.nextInt();
		m=in.nextInt();
		int[][] arr=new int[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				arr[i][j]=in.nextInt();
			}
		}
		int maxGold=0;
		for(int i=0;i<n;i++){
			int temp=findMaxGold(i,0,n,m,arr);
			if(temp>maxGold){
				maxGold=temp;
			}
		}
		System.out.println(maxGold);
		System.out.println(map);
	}
}
