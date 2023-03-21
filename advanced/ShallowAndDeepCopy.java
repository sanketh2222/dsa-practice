package advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShallowAndDeepCopy {
    private void testLst() {
        List<Integer> arrlst = Arrays.asList(1, 2, 3, 4);
        // List<Integer> cpList = arrlst;// shallow copy
        // all the below are deep copy
        List<Integer> cpList = new ArrayList<>(arrlst);
        List<Integer> cpList2 = new ArrayList<>();
        cpList2.addAll(arrlst);
        List<Integer> cpList3 = List.copyOf(arrlst);// immutable copy
        // Collections.copy(cpList3, arrlst);
        arrlst.set(0, 100);
        cpList.set(0, 100);
        cpList2.set(0, 100);
        // cpList3.set(0, 100); java.lang.UnsupportedOperationException
        System.out.println(arrlst.get(0));
        System.out.println(cpList.get(0));
        System.out.println(cpList2.get(0));
        System.out.println(cpList3.get(0));
        testArr();
    }

    private void testArr() {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] shallowCopyArr = arr;
        int[] deepCopy = Arrays.copyOf(arr, 10);// Deep copy
        arr[0] = 100;
        System.out.println(deepCopy[0]);
        System.out.println(shallowCopyArr[0]);
    }

    public static void main(String[] args) {
        ShallowAndDeepCopy andDeepCopy = new ShallowAndDeepCopy();
        andDeepCopy.testLst();
    }
}
