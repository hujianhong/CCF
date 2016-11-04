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


        albw:x
		4
		ls -a -l -a documents -b
		ls
		ls -w 10 -x -w 15
		ls -a -b -c -d -e -l

 *
 * @author JianhongHu
 * @version 1.0
 * @date 2016年3月23日
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class C2014033 {

	public static class Node implements Comparable<Node> {
		String c;
		String p;
		boolean flag;

		public Node(String c, String p) {
			this.c = c;
			this.p = p;
			this.flag = true;
		}

		public Node(String c) {
			this.c = c;
			this.p = "";
			this.flag = false;
		}

		@Override
		public int compareTo(Node o) {
			return this.c.charAt(1) > o.c.charAt(1) ? 1: -1;
		}
	}


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String chars = scanner.nextLine();
		int n = Integer.parseInt(scanner.nextLine().trim());
		for(int i = 0;i < n;i ++){
			String command = scanner.nextLine();
			String[] cmds = command.split(" ");
			Map<String, Node> map = new HashMap<String, Node>();
			for(int j = 1,len = cmds.length; j < len;j ++ ){
				String str = cmds[j];
				if(str.length() != 2){
					break;
				}
				char ch = str.charAt(0);
				if(ch == '-'){
					int index = chars.indexOf(str.charAt(1));
					if(index < 0){
						break;
					}
					int b = index + 1;
					boolean flag = false;
					if(b < len){
						flag = chars.charAt(b) == ':';
					}
					if(flag){
						j ++;
						if(j < len){
							String cc = cmds[j].trim();
							if(cc.length() > 0){
								Node node = new Node(str,cc);
								map.put(str, node);
							}
							else if(cc.startsWith("-")) {
								break;
							}
							else {
								break;
							}
						} else {
							break;
						}
					} else {
						Node node = new Node(str);
						map.put(str, node);
					}
				} else {
					break;
				}
			}
			System.out.print("Case " + (i + 1) + ":");
			if(!map.isEmpty()){
				List<Node> list = new ArrayList<Node>();
				for(Entry<String, Node> entry : map.entrySet()){
					list.add(entry.getValue());
				}
				Collections.sort(list);
				for(int k = 0,le = list.size(); k < le;k ++){
					Node node = list.get(k);
					System.out.print(" ");
					if(node.flag){
						System.out.print(node.c + " " + node.p);
					} else {
						System.out.print(node.c);
					}
				}
			} else {
				System.out.print(" ");
			}
			System.out.println();
		}
		scanner.close();
	}

}
