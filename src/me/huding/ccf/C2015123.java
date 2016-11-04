/**
 * Copyright (c) 2015-2016, Silly Boy 胡建洪(1043244432@qq.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.huding.ccf;



/**
 *
 *
 * @author JianhongHu
 * @version 1.0
 * @date 2016年4月7日
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class C2015123 {

	public static int[][] go = {{1,0},{-1,0},{0,1},{0,-1}};
	public static int[][] mark = new int[101][101];
	public static char[][] chars = new char[101][101];

	public static int m,n;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		m = scanner.nextInt();
		n = scanner.nextInt();
		for(int i = 0;i < m;i ++){
			for(int j = 0;j < n;j ++){
				chars[i][j] = '.';
			}
		}
		int q = scanner.nextInt();
		for(int i = 0;i < q;i++){
			int op = scanner.nextInt();
			if(op == 1){
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				char ch = scanner.next().charAt(0);
				fill(x,y,ch);
			} else {
				int x1 = scanner.nextInt();
				int y1 = scanner.nextInt();
				int x2 = scanner.nextInt();
				int y2 = scanner.nextInt();
				draw(x1,y1,x2,y2);
			}
		}
		for(int j = n - 1;j >= 0; j --){
			for(int i = 0;i < m ;i ++){
				System.out.print(chars[i][j]);
			}
			System.out.println();
		}
		scanner.close();
	}

	private static void draw(int x1, int y1, int x2, int y2) {
		if(x1 == x2){
			if(y1 > y2){
				int t = y1;
				y1 = y2;
				y2 = t;
			}
			for(int i = y1;i <= y2;i ++){
				if(mark[x1][i] == 0){
					chars[x1][i] = '|';
					mark[x1][i]  = 1;
				}
				else if(mark[x1][i] == 2){
					chars[x1][i] = '+';
					mark[x1][i]  = 3;
				}
			}
		} else {
			if(x1 > x2){
				int t = x1;
				x1 = x2;
				x2 = t;
			}
			for(int i = x1;i <= x2;i ++){
				if(mark[i][y1] == 0){
					chars[i][y1] = '-';
					mark[i][y1]  = 2;
				}
				else if(mark[i][y1] == 1){
					chars[i][y1] = '+';
					mark[i][y1]  = 3;
				}
			}
		}
	}
	
	public static Queue<Integer[]> queue = new LinkedList<Integer[]>();
	
	private static void fill(int x, int y, char ch) {
		boolean markb[][] = new boolean[m][n];
		if(mark[x][y] == 0 && markb[x][y] == false){
			chars[x][y] = ch;
			markb[x][y] = true;
			for(int i = 0;i < 4;i ++){
				int nx = x + go[i][0];
				int ny = y + go[i][1];
				if(nx < 0 || nx >= m || ny < 0 || ny >= n){
					continue;
				}
				if(mark[nx][ny] != 0){
					continue;
				}
				queue.add(new Integer[]{nx,ny});
			}
		}
		while(!queue.isEmpty()){
			Integer[] node = queue.poll();
			int x1 = node[0];
			int y1 = node[1];
			if(mark[x1][y1] == 0 && markb[x1][y1] == false){
				chars[x1][y1] = ch;
				markb[x1][y1] = true;
				for(int i = 0;i < 4;i ++){
					int nx = x1 + go[i][0];
					int ny = y1 + go[i][1];
					if(nx < 0 || nx >= m || ny < 0 || ny >= n){
						continue;
					}
					if(mark[nx][ny] != 0){
						continue;
					}
					queue.add(new Integer[]{nx,ny});
				}
			}
		}
	}
}
