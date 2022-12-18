import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortMarksDriver {


    
    public static void main(String[] args) {
        
        List<String> arr = Arrays.asList("100","adarsh80","harsh95","shivam95");//adars
        
        Collections.sort(arr,new CompareMarks());

        arr.forEach(System.out::println);
    }
}
