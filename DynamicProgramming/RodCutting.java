import java.util.*;

public class RodCutting{

	public static Scanner in=new Scanner(System.in);
	public static HashMap<Integer,Integer>maxMap=new HashMap<Integer,Integer>();

	public static void populate(HashMap<Integer,Integer> hm){
		System.out.println("Enter the lengths and the corresponding prices: ");
		int length,price;
		while(true){
			System.out.print("Enter the length: ");
			length=in.nextInt();
			if(length==-1)
				break;
			System.out.print("Enter the price: ");
			price=in.nextInt();
			hm.put(length,price);
		}
	}
	public static int findMax(int length,HashMap<Integer,Integer> hm){
		if(maxMap.containsKey(length))
			return maxMap.get(length);
		int maxPrice=hm.get(length);
		for(int i=1;i<=length/2;i++){
			int price=findMax(i,hm)+findMax(length-i,hm);
			if(price>maxPrice)
				maxPrice=price;
		}
		maxMap.put(length,maxPrice);
		return maxPrice;
	}

	public static void main(String args[]){
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		int length;
		System.out.print("Enter the length of the rod: ");
		length=in.nextInt();
		System.out.println(length);
		populate(map);
		System.out.println(map);
		int price=findMax(length,map);
		System.out.println("The max price of the rod is: "+price);
	}
}
