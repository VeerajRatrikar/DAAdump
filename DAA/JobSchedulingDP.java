import java.util.*;

class Job {
    int start, end, profit;
    Job(int s, int e, int p) {
        start = s;
        end = e;
        profit = p;
    }
}

public class JobSchedulingDP {
    public static void main(String[] args) {
        Job[] jobs = {
            new Job(1, 2, 100),
            new Job(2, 1, 19),
            new Job(3, 2, 27),
            new Job(4, 1, 25),
            new Job(5, 3, 15)
        };

        Arrays.sort(jobs, Comparator.comparingInt(j -> j.end));

        int n = jobs.length;
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {
            int incl = jobs[i].profit;
            int l = lastNonConflict(jobs, i);
            if (l != -1) incl += dp[l];
            dp[i] = Math.max(incl, dp[i - 1]);
        }

        System.out.println("Max Profit = " + dp[n - 1]);
    }

    static int lastNonConflict(Job[] jobs, int i) {
        for (int j = i - 1; j >= 0; j--) {
            if (jobs[j].end <= jobs[i].start)
                return j;
        }
        return -1;
    }
}
