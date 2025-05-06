public class JApractice {
    static int N=4;
    static int[][] cost={ {9, 2, 7, 8},
    {6, 4, 3, 7},
    {5, 8, 1, 8},
    {7, 6, 9, 4}};

    static boolean[] used=new boolean[N];
    static int min=Integer.MAX_VALUE;

    static void assign(int job,int total){
        if(job==N){
            if(total<min){min=total;}
            return;
        }
        for(int person=0;person<N;person++){
            if(!used[person]){
                used[person]=true;
                assign(job+1,total+cost[job][person]);
                used[person]=false;
            }
        }
    }
    public static void main(String[] args) {
        assign(0,0);
        System.out.println("The minimum cost is : "+min);
    }
    
}