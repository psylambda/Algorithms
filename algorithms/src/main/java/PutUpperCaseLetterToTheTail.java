//小Q最近遇到了一个难题：把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。
//        你能帮帮小Q吗？


import java.util.*;
import java.lang.*;
public class PutUpperCaseLetterToTheTail {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            String s = sc.next();
            System.out.println(compute(s));
        }
    }

    private static String compute(String s)
    {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(char c : s.toCharArray())
        {
            if(Character.isLowerCase(c))
                sb1.append(c);
            else sb2.append(c);
        }
        return sb1.append(sb2).toString();
    }
}
