package revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Job {
    int startTime;
    int endTime;

    Job(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

public class MaximumJobs {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        List<Job> jobs = createJobs(A, B);
        jobs.sort((a, b) -> a.endTime - b.endTime);
        int totalJobs = 1;
        Job prevJob = jobs.get(0);

        for (int i = 1; i < jobs.size(); i++) {
            if (jobs.get(i).startTime >= prevJob.endTime) {
                totalJobs += 1;
                prevJob = jobs.get(i);
            }
        }

        return totalJobs;

    }

    private List<Job> createJobs(ArrayList<Integer> A, ArrayList<Integer> B) {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            jobs.add(new Job(A.get(i), B.get(i)));
        }
        return jobs;
    }

    public static void main(String[] args) {
        MaximumJobs jobs = new MaximumJobs();
        List<Integer> A = Arrays.asList(1,5,7,1);
        List<Integer> B = Arrays.asList(7,8,8,8);
        jobs.solve(new ArrayList<>(A), new ArrayList<>(B));
    }
}
