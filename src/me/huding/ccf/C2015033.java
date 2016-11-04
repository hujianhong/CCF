/**
 * 
 */
package me.huding.ccf;

/**
 *

 试题编号：    201503-3
试题名称：    节日
时间限制：    1.0s
内存限制：    256.0MB
问题描述：    
问题描述
　　有一类节日的日期并不是固定的，而是以“a月的第b个星期c”的形式定下来的，比如说母亲节就定为每年的五月的第二个星期日。
　　现在，给你a，b，c和y1, y2(1850 ≤ y1, y2 ≤ 2050)，希望你输出从公元y1年到公元y2年间的每年的a月的第b个星期c的日期。
　　提示：关于闰年的规则：年份是400的整数倍时是闰年，否则年份是4的倍数并且不是100的倍数时是闰年，其他年份都不是闰年。例如1900年就不是闰年，而2000年是闰年。
　　为了方便你推算，已知1850年1月1日是星期二。
输入格式
　　输入包含恰好一行，有五个整数a, b, c, y1, y2。其中c=1, 2, ……, 6, 7分别表示星期一、二、……、六、日。
输出格式
　　对于y1和y2之间的每一个年份，包括y1和y2，按照年份从小到大的顺序输出一行。
　　如果该年的a月第b个星期c确实存在，则以"yyyy/mm/dd"的格式输出，即输出四位数的年份，两位数的月份，两位数的日期，中间用斜杠“/”分隔，位数不足时前补零。
　　如果该年的a月第b个星期c并不存在，则输出"none"（不包含双引号)。
 样例输入
5 2 7 2014 2015
样例输出
2014/05/11
2015/05/10
评测用例规模与约定
　　所有评测用例都满足：1 ≤ a ≤ 12，1 ≤ b ≤ 5，1 ≤ c ≤ 7，1850 ≤ y1, y2 ≤ 2050

***********************************
* 解题思路
****************************
*
*首先来分析一下该题，本题稍微有些难度，属于Medium难度类型。
*从题目描述中我们可以知道1850年1月1日是星期二，并且year的取值范围是在[1850,2050]内，所以可以将1850年1月1日（星期二）作为一个参照标准。
*那么当知道某一具体日期时，比如样例给出的2015年5月的第二个星期的星期日，
*我们可以将2015年5月1日是星期几先计算出来，然后计算第二个星期的周日距离当月开始的天数days。
*最后我们可以让days+1，就可以得到当天的日期。
*
 * @author JianhongHu
 * @version 1.0
 * @date 2015年12月16日
 */

import java.util.Scanner;

public class C2015033 {

	public static boolean isLeap(int year){
		return(year % 400 == 0) || (year % 100 != 0 && year % 4 == 0);
	}

	public static int monthDays(boolean isLeap,int month){
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		default:
			return isLeap ? 29 : 28;
		}
	}
	
	public static int bmDays(boolean isLeap,int month){
		int count = 0;
		int m = 1;
		while(m < month){
			count += monthDays(isLeap, m);
			m ++;
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		int y1 = scanner.nextInt();
		int y2 = scanner.nextInt();
		int leapCount = 0;
		for(int i = 1850;i < y1;i ++){
			if(isLeap(i)){
				leapCount ++;
			}
		}
		
		for(int i = y1; i <= y2;i ++){
			boolean isLeap = isLeap(i);
			if(isLeap){
				leapCount ++;
			}
			int totalDays = (i - 1850) * 365 + leapCount + bmDays(isLeap, a);
			int weekDay = (totalDays % 7 + 2) % 7;
			if(b == 1 && c < weekDay){
				System.out.println("none");
			} else {
				int weekCount = c < weekDay ? 1 : 2;
				int days = (b - weekCount) * 7 + (c - weekDay) + 8;
				if(days <= monthDays(isLeap, a) && days > 0){
					System.out.println(i + "/" + (a < 10 ? "0" + a: a) + "/" + (days < 10 ? "0" + days : days)) ;
				} else {
					System.out.println("none");
				}
			}
		}
		scanner.close();
	}

}
