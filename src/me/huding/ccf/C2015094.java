/**
 * 
 */
package me.huding.ccf;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

/**
 * 
 * 问题描述
　　某国有n个城市，为了使得城市间的交通更便利，该国国王打算在城市之间修一些高速公路，
由于经费限制，国王打算第一阶段先在部分城市之间修一些单向的高速公路。
　　现在，大臣们帮国王拟了一个修高速公路的计划。
看了计划后，国王发现，有些城市之间可以通过高速公路直接（不经过其他城市）
或间接（经过一个或多个其他城市）到达，而有的却不能。如果城市A可以通过高速公路到达城市B，
而且城市B也可以通过高速公路到达城市A，则这两个城市被称为便利城市对。
　　国王想知道，在大臣们给他的计划中，有多少个便利城市对。
输入格式
　　输入的第一行包含两个整数n, m，分别表示城市和单向高速公路的数量。
　　接下来m行，每行两个整数a, b，表示城市a有一条单向的高速公路连向城市b。
输出格式
　　输出一行，包含一个整数，表示便利城市对的数量。
样例输入
5 5
1 2
2 3
3 4
4 2
3 5
样例输出
3

解决方案：

先求强连通分量，再从各个元素大于1的强连通分量中选2个城市的组合，最后再相加。

强连通分量求法：Tarjan算法
 */
public class C2015094 {
	
	public static int MAX = 10005;
	
	public static Vector[] gra = new Vector[MAX];
			
	public static int[] dfn = new int[MAX];
	
	public static int[] low = new int[MAX];
	
	public static int[] InComponent = new int[MAX];
	
	public static int[] Instack = new int[MAX];
	
	public static Stack<Integer> sta = new Stack<Integer>();;
	
	public static Vector[] Component = new Vector[MAX];
	
	public static int index = 0,ComponentNumber = 0;
	
	
	public static void tarjan(int u)  
	{  
	    
	    low[u] = dfn[u] = ++ index;  
	    sta.push(u);  
	    Instack[u] = 2;  
	    for (int i = 0; gra[u] != null && i < gra[u].size(); ++ i)  
	    {  
	        int t = (int) gra[u].get(i);  
	        if (dfn[t] == 0)  
	        {  
	            tarjan(t);  
	            low[u] = Math.min(low[u], low[t]);  
	        }   
	        else if (Instack[t] == 2)  
	        {  
	            low[u] =  Math.min(low[u], dfn[t]);  
	        }  
	    }  
	  
	    if (low[u] == dfn[u])  
	    {  
	        ++ ComponentNumber;  
	        while (!sta.empty())  
	        {  
	            int j = sta.pop();  
	            Instack[j] = 1;  
	           /* if(Component[ComponentNumber] == null){
	            	Component[ComponentNumber] = new Vector();
	            }
	            Component[ComponentNumber].add(j);  */
	            InComponent[j]=ComponentNumber;  
	            if (j == u)  {
	               break;
	            }
	        }  
	    }  
	}  
	
	public static int[] v = new int[MAX];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		for(int i = 0; i < m ;i ++){
			int h = scanner.nextInt();
			int t = scanner.nextInt();
			if(gra[h] == null){
				gra[h] = new Vector();
			}
			gra[h].add(t);
		}
		for(int i = 1;i <= n; i ++){
			if(dfn[i] ==  0){
				tarjan(i);
			}
		}
		for(int i = 1; i <= n; i ++){
			v[InComponent[i]] ++;
		}
		
		int sum = 0;
		
		for(int i = 1;i <= n; i++){
			if(v[i] > 1){
				sum += (v[i] * (v[i] - 1)) / 2;
			}
		}
		System.out.println(sum);
		scanner.close();
	}

}
