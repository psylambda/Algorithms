//小Q今天在上厕所时想到了这个问题：有n个数，两两组成二元组，差最小的有多少对呢？差最大呢？

import java.util.*;
import java.lang.*;
public class NumOfMaxAndMinDifferences {
    public static void main(String[] args)
    {
        List<Integer> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt())
            list.add(sc.nextInt());
        int[] res = compute(list);
        System.out.println(res[0]+" "+res[1]);
    }

    private static int[] compute(List<Integer> list)
    {
        int[] res = new int[2];
        if(list.size() <= 1) return res;
        Collections.sort(list);

        Map<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i < list.size()-1; i++)
        {
            int diff = list.get(i+1)-list.get(i-1);
            m.put(diff, m.getOrDefault(diff, 0)+1);
        }
        int minval = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> en : m.entrySet())
        {
            int val = en.getKey();
            int count = en.getValue();
            if(val < minval)
                res[0] = count;
        }
        return res;
    }
}
