import java.util.Comparator;

class CompareMarks implements Comparator<String> {
    //        List<String> arr = Arrays.asList("100",adarsh80","harsh95","shivam95");//adarsh80
    public int compare(String a, String b) {
        int num1 = Integer.parseInt(a.replaceAll("[^0-9]", ""));
        int num2 = Integer.parseInt(b.replaceAll("[^0-9]", ""));
        return num1 - num2;
    }
}