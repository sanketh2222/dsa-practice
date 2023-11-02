package greedy;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FinishMaxJobs {

    public class JobPair implements Comparable<JobPair> {
        int startTime;
        int endTime;

        JobPair(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(JobPair o) {
            return this.endTime - o.endTime;
        }
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        List<JobPair> jobPairs = new ArrayList<>();
        int maxJobs = 1;
        for (int i = 0; i < A.size(); i++) {
            jobPairs.add(new JobPair(A.get(i), B.get(i)));
        }

        Collections.sort(jobPairs);

        JobPair currJob = jobPairs.get(0);
        for (int i = 1; i < jobPairs.size(); i++) {
            if (jobPairs.get(i).startTime >= currJob.endTime) {
                currJob = jobPairs.get(i);
                maxJobs += 1;
            }
        }
        return maxJobs;
    }

    public static void main(String[] args) {
        // FinishMaxJobs finishMaxJobs = new FinishMaxJobs();
        // int maxJobs = finishMaxJobs.solve(new ArrayList<>(List.of(1, 5, 7, 1)),
        //         new ArrayList<>(List.of(7, 8, 8, 8)));
        
        // System.out.println(maxJobs);

    }
}
