package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // Queue<Integer> pq = new PriorityQueue<>((a , b) -> map.get(b) - map.get(a));
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> ans = new ArrayList<>(map.keySet());
        ans.sort((a, b) -> map.get(b) - map.get(a));
        // ans.forEach(x -> pq.offer(x));
        // List<Integer> lst = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return ans.stream().mapToInt(Integer::intValue).limit(k).toArray();

    }

    // TC -> O(N) + O(N log N)
    // SC -> O(N)

    public static Date getNextDayDate(Date date, int noOfDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // Set the calendar to the current date
        calendar.add(Calendar.DAY_OF_MONTH, noOfDays);
        return calendar.getTime();
    }

    public static void main(String[] args) {
        TopKFrequentElements kFrequentElements = new TopKFrequentElements();
        int[] arr = { 1, 1, 1, 2, 2, 3 };
        kFrequentElements.topKFrequent(arr, 2);
        Date date = getNextDayDate(new Date(), -1);
        System.out.println(date);

    }
}
