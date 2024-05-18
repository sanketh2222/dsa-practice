package sorting;

public class LargestNumberComparable implements Comparable<LargestNumberComparable> {

    private Integer num;

    public LargestNumberComparable(Integer num) {
        this.num = num;
    }
    

    @Override
    public int compareTo(LargestNumberComparable o) {
        String first = String.valueOf(this.num)+ String.valueOf(o.num);
        String second = String.valueOf(o.num) + String.valueOf(this.num);
        return first.compareTo(second);
    }



  
}
