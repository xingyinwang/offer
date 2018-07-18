import org.junit.Test;

import java.sql.Driver;
import java.util.*;

/**
 * Created by Cser_W on 2018/1/29.
 */
class threadDemo extends Thread {

    ArrayList<test> list = new ArrayList<>();
    long count = 1;
    public void run() {
        System.out.println(Thread.currentThread().getName()+"----------------");
        while (count < 1000000) {
            list.add(new test());
            count ++;
            System.out.println(count);
        }
    }
}
public class test {

    public String LeftRotateString(String str,int n) {
        if (str == "" || str  == null || n < 0 )
            return "";
        int len = str.length();
        String res = str + str;
        System.out.println();
        return res.substring(n ,  len + n);
    }
   /* @Test
    public void test(){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, i * i);
        }
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            System.out.println(iterator.next().getKey());
        }
        Set<Integer> integers = map.keySet();
        Iterator<Integer> iterator1 = integers.iterator();
        while (iterator1.hasNext()) System.out.println(iterator1.next());

        Collection<Integer> values = map.values();
        Iterator<Integer> iterator2 = values.iterator();
        while (iterator2.hasNext())
            System.out.println(iterator2.next());
    }*/
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        String[] ts = (String[]) list.toArray(new String[list.size()]);


    }
}
/**
 *先来看一个简单的例子:
 import java.util.*;
 public class ScannerTest {

 public static void main(String[] args){
 Scanner scanner=new Scanner(System.in);
 double a=scanner.nextDouble();
 System.out.println(a);
 }
 }
 运行
 输入 一个任意数然后输出这个数

 注意粗体字的地方，这一行就实现了从控制台输入数字的功能，如果要输入字符串
 可以用
 String a=scanner.next();//注意不是nextString()
 Scanner还可以直接扫描文件。比如（有点长，耐心一点）：
 import java.util.*;
 import java.io.*;
 public class ScannerTest {
 public static void main(String[] args) throws IOException{//这里涉及到文件io操作
 double sum=0.0;
 int count=0;
 FileWriter fout=new FileWriter("text.txt");
 fout.write("2 2.2 3 3.3 4 4.5 done");//往文件里写入这一字符串
 fout.close();
 FileReader fin=new FileReader("text.txt");
 Scanner scanner=new Scanner(fin);//注意这里的参数是FileReader类型的fin
 while(scanner.hasNext()){//如果有内容
 if(scanner.hasNextDouble()){//如果是数字
 sum=sum+scanner.nextDouble();
 count++;
 }else{
 String str=scanner.next();
 if(str.equals("done")){
 break;
 }else{
 System.out.println("文件格式错误!");
 return;
 }
 }
 }
 fin.close();
 System.out.println("文件中数据的平均数是:"+sum/count);
 }
 }
 结果输出文件中数据的平均数是:3.1666666666666665
 这段程序的功能是将"2 2.2 3 3.3 4 4.5 done"写入文件scanner读取文件中的数直到done结束。并求出数字的平均值，比较有意思的是scanner会自动一空格作为分割符区分不同数字。当然也可以通过scanner.useDelimiter(Pattern pattern)来设置不同的分割符，比如 scanner.useDelimiter(",*");
 如果你感兴趣，更多强大的功能可以参看jdk 5 的帮助文档。


 Java代码：


 //构造方法(常用的三个)
 //Scanner(File source)
 //Scanner(InputStream source)
 //Scanner(String source)

 //对比两种方式的比较
 //Scanner sc=new Scanner(System.in);
 //BufferedReader br=new BufferedReader(new InputStreamReader(System.in))

 //方法
 //useDelimiter(Pattern pattern)改变token的分割方式,默认的是空格,传Pattern对象
 //useDelimiter(String pattern)改变token的分割方式,默认的是空格,传String

 //hasNext();查看是否有token的分割段
 //hasNextInt();查看是否有int类型的token的分割段
 //nextInt();返回下一个int的数值
 //nextLine();返回一行

 //hasNext(Pattern pattern);返回下一个pattern类型的token

 public class ScannerTest {
 public static void main(String[] args){
 String str = "1.1 22.2 s 4 5.3 6 7.5 8 9";
 Scanner scanner = new Scanner(str);
 //scanner.useDelimiter("\\.");
 while(scanner.hasNext()){
 if(scanner.hasNext(Pattern.compile("\\d\\.\\d"))){
 System.out.println(scanner.next());
 }else{
 scanner.next();//要调用一下next()相关的方法才会到下一个token
 }
 }
 }
 }

 结果：
 1.1
 5.3
 7.5


 public class ScannerTest {
 public static void main(String[] args){
 String str = "1.2 s.4 5 6.7 8 9";
 Scanner scanner = new Scanner(str);
 //token以.分割
 scanner.useDelimiter("\\.");
 while(scanner.hasNext()){
 System.out.println(scanner.next());
 }
 }
 }

 登录帐号：lianjia
 登录密码：akfbjq
 https://lianjia.acmcoder.com/cand/login


 最后说明一下，在java开发中基本很少用到Scanner，因为不需要动态输入一个数。
 */
