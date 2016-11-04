/**
 * 
 */
package me.huding.ccf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class C2015093 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		scanner.nextLine();
		
		for(int i = 0;i < m ;i ++ ){
			String string = scanner.nextLine();
			list.add(string);
			
		}
		Map<String, String> map = new HashMap<String, String>();
		for(int i = 0;i < n;i ++){
			String string = scanner.nextLine();
			int index = string.indexOf("\"");
			String name = string.substring(0,index).trim();
			String value = string.substring(index+1,string.length() -2);
			map.put(name, value);
		}
		for(int i = 0; i < m; i ++){
			String string = list.get(i);
			String out = "";
			while(true){
				int i1 = string.indexOf("{{");
				int i2 = string.indexOf("}}");
				if(i1 < 0 || i2 < 0) break;
				String name = string.substring(i1 + 3,i2-1);
				char ch = name.charAt(0);
				if(Character.isDigit(ch)){
					String string2 = string.substring(0,i2 + 2);
					string = string.substring(i2 + 2);
					out += string2;
				} else {
					String value = map.get(name);
					if(value == null){
						value = "";
					}
					String string2 = string.substring(0,i1);
					string = string.substring(i2 + 2);
					out += string2 + value;
				}
			}
			out = out + string;
			System.out.println(out);
		}
		scanner.close();
	}

}
