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

public class C2014122 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] nums = new int[n][n];
		for(int i = 0; i < n;i ++){
			for(int j = 0;j < n;j ++){
				nums[i][j] = scanner.nextInt();
			}
		}
		int i = 0,j = 0;
		boolean flag1 = true;
		while(i < n && j < n){
			if(i + 1 == n && j + 1 == n){
				System.out.print(nums[i][j]);
			} else {
				System.out.print(nums[i][j] + " ");
			}
			if(flag1) {
				if(i - 1 < 0){
					if(j + 1 == n){
						i ++;
					} else {
						j ++;
					}
					flag1 = false;
				} else if(j + 1 == n) {
					i ++; 
					flag1 = false;
				} else {
					i --;j ++;
				}
			}
			else if(!flag1){
				if(j - 1 < 0){
					if(i + 1 == n){
						j ++;
					} else {
						i ++;
					}
					flag1 = true;
				} else if(i + 1 == n){
					j ++;
					flag1 = true;
				} else {
					i ++; j --;
				}
			}
		}
		scanner.close();
	}
}
