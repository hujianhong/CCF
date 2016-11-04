/**
 * 
 */
package me.huding.ccf;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 *试题编号：    201503-4
试题名称：    网络延时
时间限制：    1.0s
内存限制：    256.0MB
问题描述：    
问题描述
　　给定一个公司的网络，由n台交换机和m台终端电脑组成，交换机与交换机、交换机与电脑之间使用网络连接。交换机按层级设置，编号为1的交换机为根交换 机，层级为1。其他的交换机都连接到一台比自己上一层的交换机上，其层级为对应交换机的层级加1。所有的终端电脑都直接连接到交换机上。
　　当信息在电脑、交换机之间传递时，每一步只能通过自己传递到自己所连接的另一台电脑或交换机。请问，电脑与电脑之间传递消息、或者电脑与交换机之间传递消息、或者交换机与交换机之间传递消息最多需要多少步。
输入格式
　　输入的第一行包含两个整数n, m，分别表示交换机的台数和终端电脑的台数。
　　第二行包含n - 1个整数，分别表示第2、3、……、n台交换机所连接的比自己上一层的交换机的编号。第i台交换机所连接的上一层的交换机编号一定比自己的编号小。
　　第三行包含m个整数，分别表示第1、2、……、m台终端电脑所连接的交换机的编号。
输出格式
　　输出一个整数，表示消息传递最多需要的步数。
样例输入
4 2
1 1 3
2 1
样例输出
4
 *
 * @author JianhongHu
 * @version 1.0
 */
public class C2015034 {

	public static Map<Integer, Node> routeMap = new HashMap<Integer, Node>();

	//public static Map<Integer, Node> computerMap = new HashMap<Integer, Node>();

	public static final int TR = 1;

	public static final int TC = 2;

	public static int TTMAX = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 交换机数目
		int n = scanner.nextInt();
		// 电脑数目
		int m = scanner.nextInt();
		// 初始化根结点
		Node rootNode = new Node(1, TR);

		routeMap.put(1, rootNode);
		// 读取交换机结点
		for(int i = 2;i <= n; i ++){
			int k = scanner.nextInt();
			Node routeNode = new Node(i, TR);
			routeMap.get(k).add(routeNode);
			routeMap.put(i, routeNode);
		}
		// 读取电脑结点
		for (int i = 0; i < m;i++) {
			int k = scanner.nextInt();
			Node cNode = new Node(i, TC);
			routeMap.get(k).add(cNode);
		}
		rootNode.compute();
		System.out.println(TTMAX);
		scanner.close();
	}

	public static class Node {

		public void compute(){
			if(getType() == TR){
				int m[] = new int[subNodes.size()];
				for(int i =0;i < subNodes.size();i ++){
					Node node = subNodes.get(i);
					node.compute();
					int c = node.getMax();
					m[i] = c;
				}
				int max1 = 0,max2 = 0;
				if(m.length > 1){
					Arrays.sort(m);
					max1 = m[m.length - 1];
					max2 = m[m.length - 2];
				}
				else {
					max1 = m[0];
				}
				if((max1 + max2) > TTMAX){
					TTMAX = max1 + max2;
				}
				max += max1;
			}
		}

		public int tag;

		public int type;

		public int max = 1;

		public int getMax() {
			return max;
		}

		public void setMax(int max) {
			this.max = max;
		}

		public Node(int tag, int type) {
			this.tag = tag;
			this.type = type;
		}

		public Vector<Node> subNodes = new Vector<Node>();

		public void add(Node node){
			subNodes.add(node);
		}

		public int getTag() {
			return tag;
		}

		public void setTag(int tag) {
			this.tag = tag;
		}

		public int getType() {
			return type;
		}

		public void setType(int type) {
			this.type = type;
		}

		public Vector<Node> getSubNodes() {
			return subNodes;
		}

		public void setSubNodes(Vector<Node> subNodes) {
			this.subNodes = subNodes;
		}



	}
}
