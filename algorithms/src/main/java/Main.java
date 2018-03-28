

import java.util.*;
import java.lang.*;

public class Main {
//    public static void main(String[] args)
//    {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNextInt()) {
//
//            int n = sc.nextInt();
//            int m = sc.nextInt();
//            //0难度 1报酬
//            int[][] input = new int[n][2];
//            for (int i = 0; i < n; i++) {
//                input[i][0] = sc.nextInt();
//                input[i][1] = sc.nextInt();
//            }
//            Arrays.sort(input, (x, y) -> y[1] - x[1]);
//
//            int index = 0;
//            for (int i = 1; i < n; i++) {
//                if (input[i][0] < input[index][0]) {
//                    index++;
//                    input[index][0] = input[i][0];
//                    input[index][1] = input[i][1];
//                }
//            }
//            index++;
//            int[] cur = new int[2];
//            for (int i = 0; i < m; i++) {
//                cur[0] = sc.nextInt();
//                int cur_index = Arrays.binarySearch(input, 0, index, cur, (x, y)->(y[0] - x[0]));
//                System.out.println(input[cur_index][1]);
//            }
//
//        }
//    }
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()) {

        //int n = 5;
        //0难度 1报酬
        int[][] input = {{1, 100}, {10, 1000}, {1000, 1001}};
        Arrays.sort(input, (x, y) -> y[1] - x[1]);

        int index = 0;
        for (int i = 1; i < input.length; i++) {
            if (input[i][0] < input[index][0]) {
                index++;
                input[index][0] = input[i][0];
                input[index][1] = input[i][1];
            }
        }
        index++;
        int[] cur = new int[2];
        for (int i = 0; i < 5; i++) {
            cur[0] = sc.nextInt();
            int cur_index = Arrays.binarySearch(input, 0, index, cur, (x, y) -> (y[0] - x[0]));
            if (cur_index < 0) cur_index = -(cur_index + 1);
            System.out.println(input[cur_index][1]);
        }

    }
}
}
