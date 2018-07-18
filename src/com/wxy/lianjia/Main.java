package com.wxy.lianjia;
/**
 * Created by Cser_W on 2018/3/19.
 */


/*
* 小红去参观跑步比赛了，场上一共有n个人在赛跑，所有人的速度都不一样。

由于规则的原因，第i个人在第i米的位置起跑。如果第i个人被别人超过的时候，第i个人就会被淘汰。

假设跑无限长时间，最开始n个人站位从n个人的所有排列中等概率选出一种，那么留在场上的人的数量的期望是多少呢？


本题包含若干组测试数据。

每组测试数据：

第一行一个整数n，表示有n个人在进行赛跑比赛。

满足 1<=n<=1000

??

*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        double res = 0.0;
        while (sc.hasNextInt()) {
            n = sc.nextInt();
            for (int i =1 ; i <= n ; i++) {
                res += 1.0 / i;
            }
            System.out.printf("%.2f", res);
            res = 0.0;
        }
    }
}


/*
* 第一行一个数N，表示树的大小

接下来N-1行，每行三个整数u,v,c，表示u,v之间有一条权值为c的边，输入保证是棵树

接下来一行一个整数Q，表示询问个数

接下来每行一对整数(u,v)，表示一次查询

输出
对于每个查询，输出答案


样例输入
5

2 1 3

3 2 2

4 3 5

5 4 1

5

2 1

3 1

3 5

1 2

4 2

样例输出
3

3

5

3

5


Hint
数据范围：
20%的数据保证：1<=N,Q<=1000,|a[i]|<=10^9
100%的数据保证：1<=N,Q<=100000,|a[i]|<=10^9

*/