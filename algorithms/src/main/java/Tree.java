import java.util.*;

//public class TreeNode {
    //    int val = 0;
//    TreeNode left = null;
//    TreeNode right = null;
//    public TreeNode(int val) {
//        this.val = val;
//    }
//}
//
public class Tree {
    public static void main(String[] args)
    {
        Tree tree = new Tree();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);

        root.right = new TreeNode(11);
        root.right.right = new TreeNode(7);
        System.out.println(tree.getDis(root));
    }
    public int getDis(TreeNode root) {
        // write code here
        if(root == null) return 0;
        TreeNode[] nodes= new TreeNode[2];
        nodes[0]=nodes[1]=root;
        getNodes(root, nodes);

        List<TreeNode> pathMin = new ArrayList<>();
        List<TreeNode> pathMax = new ArrayList<>();
        getPath(root, nodes[0], pathMin);
        getPath(root, nodes[1], pathMax);
        int i = 0;
        while(i<Math.min(pathMin.size(), pathMax.size()) && pathMin.get(i) == pathMax.get(i)) i++;
        //System.out.println(pathMin.size()+" "+pathMax.size()+" "+i);
        return pathMin.size()+pathMax.size()-i*2;
    }

    private void getNodes(TreeNode root, TreeNode[] nodes)
    {
        if(root == null) return;
        if(root.val < nodes[0].val) nodes[0] = root;
        if(root.val > nodes[1].val) nodes[1] = root;
        getNodes(root.left, nodes);
        getNodes(root.right, nodes);
    }

    private boolean getPath(TreeNode root, TreeNode cur, List<TreeNode> path)
    {
        if(root == null) return false;
        path.add(root);
        if(root == cur)
           return true;

        if(getPath(root.left, cur, path))
            return true;
        if(getPath(root.right, cur, path))
            return true;
        path.remove(path.size()-1);
        return false;
    }



}