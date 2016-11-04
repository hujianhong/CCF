package me.huding.ccf;

import java.util.Scanner;

/**
 * 
试题编号：    201503-1
试题名称：    图像旋转
时间限制：    5.0s
内存限制：    256.0MB
问题描述：    
问题描述
　　旋转是图像处理的基本操作，在这个问题中，你需要将一个图像逆时针旋转90度。
　　计算机中的图像表示可以用一个矩阵来表示，为了旋转一个图像，只需要将对应的矩阵旋转即可。
输入格式
　　输入的第一行包含两个整数n, m，分别表示图像矩阵的行数和列数。
　　接下来n行每行包含m个整数，表示输入的图像。
输出格式
　　输出m行，每行包含n个整数，表示原始矩阵逆时针旋转90度后的矩阵。
样例输入
2 3
1 5 3
3 2 4
样例输出
3 4
5 2
1 3
评测用例规模与约定
　　1 ≤ n, m ≤ 1,000，矩阵中的数都是不超过1000的非负整数。
 *
 *
 * @author JianhongHu
 * @version 1.0
 */
public class C2015031 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		// 读取
		int[][] a = new int[n][m];
		for(int i = 0;i < n;i ++){
			for(int j = 0; j < m; j ++){
				a[i][j] = scanner.nextInt();
			}
		}
		// 输出
		for(int j = m - 1; j >= 0;j --){
			for(int i = 0; i < n; i ++){
				if(i == n - 1){
					System.out.print(a[i][j]);
				} else {
					//System.out.println(i + " " +  j);
					System.out.print(a[i][j] + " ");
				}
			}
			System.out.println();
		}
		scanner.close();
	}

}
