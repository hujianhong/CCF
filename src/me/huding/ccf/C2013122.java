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

import java.util.Scanner;
/**
 * 
 *
 *
 * @author JianhongHu
 * @version 1.0
 * @date 2016年11月4日
 */
public class C2013122 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		String[] ss = string.split("-");
		String k = "";
		for(int i =0;i < ss.length - 1;i ++){
			k+= ss[i];
		}
		int c = 0;
		for(int i = 0;i < k.length();i ++){
			char ch = k.charAt(i);
			int b = Integer.parseInt(ch + "") * (i + 1);
			c += b;
		}
		int d = c % 11;
		String hh = String.valueOf(d);
		if(d == 10){
			hh = "X";
		}
		if(ss[ss.length-1].equals(hh)){
			System.out.println("Right");
		}
		else {
			System.out.println(string.substring(0,string.length() - 1) + hh);
		}
		scanner.close();
	}

}
