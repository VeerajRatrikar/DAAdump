public class tspractice {

    static int[][] cost={
    {0,10,15,20},
    {10,0,35,25},
    {15,35,0,30},
    {20,25,30,0}
};
    static boolean[] vis=new boolean[4];
    static int min=Integer.MAX_VALUE;
    public static void tsp(int city,int cnt,int sum){
        if(cnt==4){
            min=Math.min(min,sum+cost[city][0]);
            return;
        }
        for(int i=0;i<4;i++){
            if(!vis[i]){
                vis[i]=true;
                tsp(i,cnt+1,sum+cost[city][i]);
                vis[i]=false;
            }
        }
    }
    public static void main(String[] args) {
        vis[0]=true;
        tsp(0,1,0);
        System.out.println("The minimum cost is :"+min);
    }
}