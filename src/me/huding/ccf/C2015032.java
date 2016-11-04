package me.huding.ccf;



/**
 * 
 题编号：    201503-2

试题名称：    数字排序
时间限制：    1.0s
内存限制：    256.0MB
问题描述：    
问题描述
　　给定n个整数，请统计出每个整数出现的次数，按出现次数从多到少的顺序输出。
输入格式
　　输入的第一行包含一个整数n，表示给定数字的个数。
　　第二行包含n个整数，相邻的整数之间用一个空格分隔，表示所给定的整数。
输出格式
　　输出多行，每行包含两个整数，分别表示一个给定的整数和它出现的次数。按出现次数递减的顺序输出。如果两个整数出现的次数一样多，则先输出值较小的，然后输出值较大的。
样例输入
12
5 2 3 3 1 3 4 2 5 2 3 5
样例输出
3 4
2 3
5 3
1 1
4 1
评测用例规模与约定
　　1 ≤ n ≤ 1000，给出的数都是不超过1000的非负整数。
 *
 *
 * @author JianhongHu
 * @version 1.0
 */

import java.util.Arrays;
import java.util.Scanner;

public class C2015032 {
	
	public static class Num implements Comparable<Num>{
		public int val;
		public int t;
		
		@Override
		public int compareTo(Num o) {
			if(t > o.t) {
				return -1;
			}
			else if(t == o.t){
				if(val > o.val){
					return 1;
				}
				return -1;
			}
			return 1;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Num nums[] = new Num[1001];
		for(int i =0; i < 1001;i ++) {
			Num num = new Num();
			num.val = i;
			num.t = 0;
			nums[i] = num;
		}
		int n = scanner.nextInt();
		for(int i = 0;i < n; i ++){
			nums[scanner.nextInt()].t ++;
		}
		Arrays.sort(nums);
		for(int i =0;i <= n; i ++ ){
			if(nums[i].t == 0){
				break;
			}
			System.out.println(nums[i].val + " " + nums[i].t);
		}
		scanner.close();
	}

}
