/**
 * 
 */
package me.huding.ccf;



/**
 *
 *
 * @author JianhongHu
 * @version 1.0
 * @date 2015年12月19日
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class C2014034 {
	public static int MAX = 201;
	
	public static class Node {
		public long x;
		public long y;
		public int t;
		public boolean f;
		public int rd = 0;
		public Node(long x, long y, int t, boolean f) {
			this.x = x;
			this.y = y;
			this.t = t;
			this.f = f;
		}
	}
	
	public static Node[] nodes = new Node[MAX];
	public static boolean [] mark = new boolean[MAX];
	
	static int n,m,k;
	static long r;
	static Queue<Node> queue = new LinkedList<Node>();
	static int x,y;
	
	public static boolean isCan(Node node1,Node node2){
		long d1 = (node1.x - node2.x);
		long d2 = (node1.y - node2.y);
		return  (d1 * d1 + d2 * d2) <= (r * r);
	}
	
	public static int YY = Integer.MAX_VALUE;
	
	static void bfs(){
		while(!queue.isEmpty()){
			Node node = queue.poll();
			for(int i = 1;i < m + n;i ++){
				if(mark[i]) continue;
				Node node2 = nodes[i];
				if(node.rd == k && node2.f) continue;
				if(isCan(node, node2)){
					node2.t = node.t + 1;
					node2.rd = node.rd;
					queue.add(node2);
					mark[i] = true;
					if(node2.f) node2.rd ++;
					if(node2.x == x && node2.y == y) {
						if(node.t < YY){
							YY = node.t;
						}
					}
				}
			}
		}
	}
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		k = scanner.nextInt();
		r = scanner.nextInt();
		long x1 = scanner.nextInt();
		long y1 = scanner.nextInt();
		
		Node node1 = new Node(x1, y1, 0, false);
		nodes[0] = node1;
		mark[0] = true;
		queue.add(node1);
		x = scanner.nextInt();
		y = scanner.nextInt();
		Node node2 = new Node(x, y, 0, false);
		nodes[1]= node2;
		for(int i = 2;i < n;i ++){
			int nx = scanner.nextInt();
			int ny = scanner.nextInt();
			Node node = new Node(nx, ny, 0, false);
			nodes[i]= node;
		}
		for(int i = n;i < m + n;i ++){
			int nx = scanner.nextInt();
			int ny = scanner.nextInt();
			Node node = new Node(nx, ny, 0, true);
			nodes[i]= node;
		}
		bfs();
		System.out.println(YY);
		scanner.close();
	}

}
