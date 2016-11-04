/**
 * 
 */
package me.huding.ccf;

import java.util.Scanner;

public class C2015091 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int count =0;
		int temp = -1;
		for(int i = 0; i < n ;i ++){
			int a = scanner.nextInt();
			if(a != temp){
				temp = a;
				count ++;
			}
		}
		System.out.println(count);
		scanner.close();
	}

}
