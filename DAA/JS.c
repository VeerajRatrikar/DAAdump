#include <stdio.h>
#include <stdlib.h>

struct Job {
    int id, deadline, profit;
};

// Comparator function to sort jobs by profit in descending order
int compare(const void *a, const void *b) {
    return ((struct Job*)b)->profit - ((struct Job*)a)->profit;
}

void jobSequence(struct Job jobs[], int n) {
    qsort(jobs, n, sizeof(jobs[0]), compare);  // Sort jobs by profit

    int slot[10] = {0};  // Array to keep track of filled slots
    printf("Selected jobs: ");

    for (int i = 0; i < n; i++) {
        // Try to schedule the job at the latest available slot
        for (int j = jobs[i].deadline - 1; j >= 0; j--) {
            if (!slot[j]) {  // Slot is available
                slot[j] = 1;  // Mark slot as filled
                printf("Job%d ", jobs[i].id);
                break;  // Job is scheduled, move to the next job
            }
        }
    }

    printf("\n");
}

int main() {
    struct Job jobs[] = {
        {1, 2, 100}, {2, 1, 19}, {3, 2, 27}, {4, 1, 25}, {5, 3, 15}
    };
    jobSequence(jobs, 5);  // Call job sequence function
    return 0;
}
