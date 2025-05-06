///Practice for Fractional Knapsack
import java.util.*;
public class Fk {
    public static double gmv(int[] values,int[] weights,int capacity){
        int n=values.length;
        double totalval=0.0;
        Double ratios[]=new Double[n];
        for(int i=0;i<n;i++){
            ratios[i]=(double)values[i]/weights[i];
        }
        Arrays.sort(ratios,Collections.reverseOrder());
        for(int i=0;i<n;i++){
            if(capacity >= weights[i]){
                capacity -= weights[i];
                totalval += values[i];
            }
            else{
                totalval+=values[i]*((double)capacity/weights[i]);
                break;
            }
        }
        return totalval;
    }
    public static void main(String[] args) {
        int[] values={60,100,120};
        int[] weights={10,20,30};
        int capacity=50;
        System.out.println("THe max value is:"+gmv(values,weights,capacity));
    }
}