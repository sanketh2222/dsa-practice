

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SortStack {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        Stack<Integer> baseStack = new Stack<>();
        Stack<Integer> intermediatoryStack = new Stack<>();
        ArrayList<Integer> sortedList = new ArrayList<>();
        
        A.forEach(x -> baseStack.push(x));

        while (!baseStack.isEmpty()) {
            int baseTos = baseStack.pop();

            if (!intermediatoryStack.isEmpty() && baseTos < intermediatoryStack.peek()) {
                int intermediatoryTos = intermediatoryStack.pop();
                intermediatoryStack.push(baseTos);
                baseStack.push(intermediatoryTos);

            } else {
                intermediatoryStack.push(baseTos);
            }
        }
        intermediatoryStack.stream().forEach(x -> sortedList.add(x));
        return sortedList;
    }

    public static void main(String[] args) {
        SortStack sortStack = new SortStack();
        List<Integer> ans = sortStack.solve(new ArrayList<>(
                Arrays.asList(1,3,2,4)));
        ans.forEach(System.out::println);

    }

}
