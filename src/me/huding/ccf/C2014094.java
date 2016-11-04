/**
 * 
 */
package me.huding.ccf;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class C2014094 {
	
	// 地图数组
	static int[][] map = new int[1001][1001];
	
	// 标记数组
	static boolean[][] mark = new boolean[1001][1001];
	
	public static class Node {
		public int x;
		public int y;
		public int t;
		
		public Node(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}
	
	public static Queue<Node> queue = new LinkedList<Node>();
	
	public static int[][] dir = { {0,1},
								  {1,0},
								  {-1,0},
								  {0,-1}
								 };
	
	static int n,m,k,d;
	
	
	public static long bfs(){
		long ans = 0;
		int cnt = 0;
		while(!queue.isEmpty()){
			Node node = queue.poll();
			// 依次扩展器相邻4个结点
			for(int i = 0;i < 4;i ++){
				int nx = node.x + dir[i][0];
				int ny = node.y + dir[i][1];
				if(nx <= 0 || nx > n || ny <= 0 || ny > n){
					continue;
				}
				if(map[nx][ny] == -1) continue;
				if(mark[nx][ny]) continue;
				// 新的状态
				Node node2 = new Node(nx, ny, node.t + 1);
				queue.add(node2);
				mark[nx][ny] = true;
				if(map[nx][ny] > 0){
					ans = ans + map[nx][ny] * node2.t;
					cnt ++;
					if(cnt == k) return ans;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		k = scanner.nextInt();
		d = scanner.nextInt();
		for(int i =0;i < m; i ++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			queue.add(new Node(x,y,0));
			map[x][y] = -1;
		}
		// 值大于0表示该点为客户位置
		for(int i = 0;i < k; i ++){
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			int f = scanner.nextInt();
			map[x][y] += f;
		}
		// -1 表示该点不可以通过
		for(int i =0; i < d; i ++){
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			map[x][y] = -1;
		}
		System.out.println(bfs());
		scanner.close();
	}

}
