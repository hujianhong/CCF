/**
 * 
 */
package me.huding.ccf;



/**
 *
 *
 * @author JianhongHu
 * @version 1.0
 * @date 2015年12月18日
 */

import java.util.Scanner;
public class C2014092 {
	
	public static int[][] a = new int[101][101];
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for(int i = 0;i < n;i ++){
			int x1 = scanner.nextInt();
			int y1 = scanner.nextInt();
			int x2 = scanner.nextInt();
			int y2 = scanner.nextInt();
			for(int k = x1; k < x2;k ++){
				for(int j = y1;j < y2; j++){
					a[k][j] = 1;
				}
			}
		}
		int count = 0;
		for(int i = 0; i < 101;i ++) {
			for(int j = 0;j < 101;j ++){
				if(a[i][j] == 1){
					count ++;
				}
			}
		}
		System.out.println(count);
		scanner.close();
	}

}
