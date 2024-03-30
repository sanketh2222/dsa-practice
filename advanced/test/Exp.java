package test;
import java.util.*;

public class Exp {
    
    public static void main(String[] args) {
        
        Map<Integer, Node> map = new HashMap<>();
        Node node = new Node(2);
        node.next = new Node(5);
        map.put(1, node);

        node.data = 3;
        node.next = null;
        System.out.println("node val is " + map.get(1).data);
        System.out.println("node val is " + map.get(1).next);
    }
}
