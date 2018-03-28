//小易准备去魔法王国采购魔法神器,购买魔法神器需要使用魔法币,但是小易现在一枚魔法币都没有,但是小易有两台魔法机器可以通过投入x(x可以为0)个魔法币产生更多的魔法币。
//魔法机器1:如果投入x个魔法币,魔法机器会将其变为2x+1个魔法币
//魔法机器2:如果投入x个魔法币,魔法机器会将其变为2x+2个魔法币
//小易采购魔法神器总共需要n个魔法币,所以小易只能通过两台魔法机器产生恰好n个魔法币,小易需要你帮他设计一个投入方案使他最后恰好拥有n个魔法币。

import java.util.*;
import java.lang.*;

public class MagicCoin {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            String s = sc.next();
            double m =compute(s);

            System.out.println(String.format("%.2f",m));
        }
    }

    private static double compute(String s)
    {
        int sum = 0, num = 0;
        int count = 0;
        char last = '\0';
        for(char c : s.toCharArray())
        {

            if(c != last)
            {
                last = c;
                sum+=count;
                num++;
                count=1;
            } else
                count++;
        }
        sum += count;
        //System.out.println(sum+" "+num);
        return (double)sum/num;

    }
}
