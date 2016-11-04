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

import java.util.Scanner;

public class C2014121 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int num[] = new int[n];
		for(int i = 0; i < n; i ++){
			int k = scanner.nextInt();
			num[k] ++;
			if(i != n - 1){
				System.out.print(num[k] + " ");
			} else {
				System.out.print(num[k]);
			}
		}
		System.out.println();
		scanner.close();
	}
}
