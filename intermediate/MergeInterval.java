import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class MergeInterval {

    // Correct optimized approach
    public ArrayList<Interval> mergeCorrect(ArrayList<Interval> intervals) {
        int n = intervals.size();
        intervals.sort(Comparator.comparingInt(a -> a.start));
        ArrayList<Interval> mergedIntervals = new ArrayList<>();
        int i = 1;
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        while (i < n) {
            int newStart = intervals.get(i).start;
            int newEnd = intervals.get(i).end;
            if (newStart <= end) {
                end = Math.max(end, newEnd);
            } else {
                mergedIntervals.add(new Interval(start, end));
                start = newStart;
                end = newEnd;
            }
            i++;
        }
        mergedIntervals.add(new Interval(start, end));
        return mergedIntervals;
    }

    public ArrayList<Interval> mergeBf(ArrayList<Interval> intervals) {
        return null;
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        return null;
    }

    public static void main(String[] args) {
        MergeInterval intervalMerger = new MergeInterval();
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        intervals.add(new Interval(4, 8));

        ArrayList<Interval> mergedIntervals = intervalMerger.mergeCorrect(intervals);

        for (Interval interval : mergedIntervals) {
            System.out.println(interval.start + " " + interval.end);
        }
        List<String> lst = new ArrayList<>();
        lst.addAll(lst);
    }

}
