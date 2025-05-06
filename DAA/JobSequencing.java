import java.util.*;

class Job {
    int id, deadline, profit;
    Job(int i, int d, int p) {
        id = i; deadline = d; profit = p;
    }
}

public class JobSequencing {
    public static void main(String[] args) {
        Job[] jobs = {
            new Job(1, 2, 100),
            new Job(2, 1, 19),
            new Job(3, 2, 27),
            new Job(4, 1, 25),
            new Job(5, 3, 15)
        };

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit); // Sort by profit

        int time = 0;
        for (Job j : jobs)
            if (j.deadline > time) time = j.deadline;

        int[] slot = new int[time];
        Arrays.fill(slot, -1);

        int profit = 0;
        for (Job j : jobs) {
            for (int i = j.deadline - 1; i >= 0; i--) {
                if (slot[i] == -1) {
                    slot[i] = j.id;
                    profit += j.profit;
                    break;
                }
            }
        }

        System.out.println("Total Profit: " + profit);
        System.out.print("Jobs: ");
        for (int id : slot)
            if (id != -1)
                System.out.print("Job" + id + " ");
    }
}
