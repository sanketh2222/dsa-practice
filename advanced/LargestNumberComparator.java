package advanced;

import java.util.Comparator;

public class LargestNumberComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        String num1 = String.valueOf(o1);
        String num2 = String.valueOf(o2);

        String first = num1 + num2;
        String second = num2 + num1;
        return first.compareTo(second);
    }
    
}
