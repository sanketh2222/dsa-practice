import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Definition for binary tree
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) {
 * val = x;
 * left=null;
 * right=null;
 * }
 * }
 */
public class Solution {

    public class Student {
        int age;
        int height;
        String name;

        public Student(int age, int height, String name) {
            this.age = age;
            this.height = height;
            this.name = name;
        }

    }

    private Map<Integer, List<Integer>> map = new HashMap<>();
    private int maxDist = Integer.MIN_VALUE;
    private int minDist = Integer.MAX_VALUE;

    public class TreeInfo {
        TreeNode treeNode;
        int distance;

        TreeInfo(TreeNode treeNode, int distance) {
            this.treeNode = treeNode;
            this.distance = distance;
        }
    }

    public void test() {
        List<Student> stList = new ArrayList<>();
  
        stList.add(new Student(12, 15, "bnc"));
        stList.add(new Student(14, 15, "xnc"));
        stList.add(new Student(10, 12, "anc"));

        Collections.sort(stList, (a, b) -> (a.age - b.age));
        stList.forEach(x -> System.out.println(x.age));
        System.out.println((int)(Math.log(256)/Math.log(2)));
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        // preOrder(A, 0);
        // System.out.println(maxDist);
        // System.out.println(minDist);
        getVerticalViewMap(A);
        for (int i = minDist; i <= maxDist; i++) {
            list.add(new ArrayList<>(map.get(i)));
        }
        return list;
    }

    private void getVerticalViewMap(TreeNode root) {
        Queue<TreeInfo> queue = new LinkedList<>();

        queue.add(new TreeInfo(root, 0));
        map.put(0, new ArrayList<Integer>());
        map.get(0).add(root.val);
        while (!queue.isEmpty()) {

            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeInfo treeInfo = queue.poll();

                if (treeInfo.treeNode.left != null) {
                    queue.add(new TreeInfo(treeInfo.treeNode.left, treeInfo.distance - 1));

                    if (!map.containsKey(treeInfo.distance)) {
                        map.put(treeInfo.distance, new ArrayList<>());
                    }
                    map.get(treeInfo.distance).add(treeInfo.treeNode.left.val);
                    minDist = Math.min(treeInfo.distance, minDist);
                }

                if (treeInfo.treeNode.right != null) {
                    queue.add(new TreeInfo(treeInfo.treeNode.right, treeInfo.distance + 1));

                    if (!map.containsKey(treeInfo.distance)) {
                        map.put(treeInfo.distance, new ArrayList<>());
                    }
                    map.get(treeInfo.distance).add(treeInfo.treeNode.right.val);
                    maxDist = Math.max(maxDist, treeInfo.distance);
                }
            }
        }

    }

    public int solve(ArrayList<Integer> A) {
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        A.forEach(x -> priorityQueue.add(x));
        int minCost = 0;
        Iterator<Integer> it = priorityQueue.iterator();

        while (priorityQueue.size() > 1) {
            int firstMin = priorityQueue.poll();
            int secondMin = priorityQueue.poll();
            minCost += (firstMin + secondMin);
            priorityQueue.add((firstMin + secondMin));
        }

        return minCost;

        // priorityQueue.add(10);
        // priorityQueue.add(1);
        // priorityQueue.add(3);
        // priorityQueue.add(4);

        // System.out.println(priorityQueue.isEmpty());

        // System.out.println(priorityQueue.poll());//1
        // System.out.println(priorityQueue.poll());//3
        // System.out.println(priorityQueue.peek());//4
        // return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.left.left.left = new TreeNode(5);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);

        // solution.verticalOrderTraversal(root).forEach(System.out::print);
        // int ans = solution.solve(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
        // System.out.println(ans);
        // List<Integer> lst = new ArrayList<>();
        // lst.add(1);
        // lst.add(2);
        // lst.set(0, 2);
        // lst.set(1, 1);
        // lst.forEach(System.out::println);

        solution.test();
        String str = "123";
        int index = 2;
        char ch = 'q';
        str = str.substring(0, index) + ch + str.substring(index + 1);
        System.out.println(str);

        StringBuffer buffer = new StringBuffer("abc");
        buffer.setCharAt(index, ch);
        System.out.println(buffer);

    }

}
