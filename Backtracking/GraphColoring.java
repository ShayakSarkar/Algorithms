// Given a Graph  and an integer m, find if it is possible to colour the graph with m colours or not

import java.util.*;

public class GraphColoring{
	public static class Node{
		String name;
		public Node(String name){
			this.name=name;
		}
	}
	public static HashMap<Node,LinkedList<Node>> graph=new HashMap<Node,<LinkedList<Node>>();
	public void addNode(String name){
		Node obj=new Node(name);
		graph.put(obj,new LinkedList<Node>());
	}
	public static void addNeighbour(Node node1,Node node2){
		graph[node1].add(node2);
	}
	public static boolean isPossible(int max,int current){
		

	public static void main(String args[]){
		addNode("A");
		addNode("B");
		addNode("C");
		addNode("D");
		addNode("E");
	}
}

	


