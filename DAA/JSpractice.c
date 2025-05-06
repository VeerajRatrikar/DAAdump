#include<stdio.h>
#include<stdlib.h>
struct Job{
    int id,deadline,profit;
};
int compare(const void *a,const void *b){
    return ((struct Job*)b)->profit - ((struct Job*)a)->profit;
}

int jobSequence(struct Job jobs[],int n){
    qsort(jobs,n,sizeof(jobs[0]),compare);
    int slot[10]={0};
    printf("Job sequence is :");
    for(int i=0;i<n;i++){
        for(int j=jobs[i].deadline-1;j>=0;j--){
            if(!slot[j]){
                slot[j]=1;
                printf("Job%d ",jobs[i].id);
                break;
            }
        }
    }
    printf("\n");
}

int main(){
    struct Job jobs[]={
        {1, 2, 100}, {2, 1, 19}, {3, 2, 27}, {4, 1, 25}, {5, 3, 15}};
    jobSequence(jobs,5);
    return 0;
}