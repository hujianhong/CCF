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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class C2015124 {
	
	static int n,m;
	
	public static List<Integer> best = new ArrayList<Integer>();
	
	static class Node {
		int k;
		List<Integer> list = new ArrayList<Integer>();
	}
	
	static boolean mark[][] = new boolean[10001][10001];
	
	static Vector<Integer>[] vectors;
	
	
	static boolean dfs(Node node){
		int k = node.k;
		if(node.list.size() > m){
			best = node.list;
			return true;
		}
		for(int i = 0,len = vectors[k].size();i < len;i ++){
			int a = vectors[k].get(i);
			if(!best.isEmpty()){
				int l = node.list.size();
				if(a > best.get(l)){
					continue;
				}
			}
			if(mark[k][a] || mark[a][k]){
				continue;
			}
			Node node2 = new Node();
			mark[k][a] = true;
			mark[a][k] = true;
			node2.k = a;
			node2.list.addAll(node.list);
			node2.list.add(a);
			boolean status = dfs(node2);
			if(status){
				return true;
			}
			mark[k][a] = false;
			mark[a][k] = false;
		}
		return false;
	}
	
	
	public static void solve(){
		for(int i = 1;i <= n;i ++){
			Vector<Integer> vector = vectors[i];
			Integer[] array = vector.toArray(new Integer[0]);
			Arrays.sort(array);
			vector.clear();
			for(int j = 0,len = array.length;j < len;j ++){
				vector.add(array[j]);
			}
		}
		Node node = new Node();
		node.k = 1;
		node.list.add(1);
		dfs(node);
		if(best.isEmpty()){
			System.out.println(-1);
		} else {
			for(int i = 0;i < best.size();i ++){
				if(i == 0){
					System.out.print(best.get(i));
				} else {
					System.out.print(" " + best.get(i));
				}
			}
			System.out.println();
		}
	}
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		vectors = new Vector[n + 1];
		for(int i = 1;i <= n; i ++){
			vectors[i] = new Vector<Integer>();
		}
		m = scanner.nextInt();
		for(int i = 0;i < m;i ++){
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			vectors[a].add(b);
			vectors[b].add(a);
		}
		int sign = 0;
		for(int i = 1;i <= n;i ++){
			int len = vectors[i].size();
			if((len & 1) == 1){
				sign ++;
			}
		}
		if(sign == 0 || sign == 2){
			if(sign == 2){
				if((vectors[1].size() & 1) == 1){
					solve();
				} else {
					System.out.println(-1);
				}
			} else {
				solve();
			}
		} else {
			System.out.println(-1);
		}
		scanner.close();
	}
}
