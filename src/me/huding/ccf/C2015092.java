/**
 * 
 */
package me.huding.ccf;

import java.util.Scanner;

public class C2015092 {

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
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		int m = 1;
		int y = scanner.nextInt();
		int d = scanner.nextInt();
		boolean isLeap = isLeap(y);
		while(m <= 12){
			int day = monthDays(isLeap, m);
			count += day;
			if(count > d){
				count = count - day;
				System.out.println(m);
				System.out.println(d - count);
				break;
			}
			if(count == d){
				System.out.println(m);
				System.out.println(day);
				break;
			}
			m ++;
		}
		scanner.close();
	}

}
