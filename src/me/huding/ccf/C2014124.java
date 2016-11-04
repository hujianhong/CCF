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

import java.util.Arrays;
import java.util.Scanner;

public class C2014124 {
	
	public static class Edge implements Comparable<Edge> {

		public int a,b;
		public int cost;
		@Override
		public int compareTo(Edge o) {
			if(cost > o.cost){
				return 1;
			} 
			else if (cost == o.cost){
				return 0;
			}
			return -1;
		}
	}
	
	public static final int N = 1001;
	
	static int [] tree = new int[N];
	
	static {
		for (int i = 0; i < N; i ++){
			tree[i] = -1;
		}
	}
	
	static int findRoot(int x){
		if(tree[x] == -1) return x;
		else {
			int temp = findRoot(tree[x]);
			tree[x] = temp;
			return temp;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		Edge [] edges = new Edge[m];
		for(int i =0 ;i <m; i ++){
			Edge edge = new Edge();
			edge.a = scanner.nextInt();
			edge.b = scanner.nextInt();
			edge.cost = scanner.nextInt();
			edges[i] = edge;
		}
		Arrays.sort(edges);
		int ans = 0;
		for(int i = 0;i < m;i ++){
			int a = findRoot(edges[i].a);
			int b = findRoot(edges[i].b);
			if(a != b){
				tree[a] = b;
				ans += edges[i].cost;
			}
		}
		System.out.println(ans);
		scanner.close();
	}
}
