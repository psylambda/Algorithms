import java.lang.*;
import java.util.*;


public class MaximumDistanceInATree {
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        root.left.right.right = new TreeNode(4);
        System.out.println(distance(root)[0]);
        System.out.println(distance(root)[1]);
    }


    //res[0] = distance res[1] = height
    private static int[] distance(TreeNode root)
    {
        int[] res = new int[2];
        if(root == null) return res;
        int[] left = distance(root.left);
        int[] right = distance(root.right);
        res[1] = Math.max(left[1], right[1])+1;
        res[0] = Math.max(Math.max(left[0], right[0]), left[1]+right[1]+1);
        return res;
    }
}
