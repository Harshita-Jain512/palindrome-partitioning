import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class subsetSum {
    public static List<Integer> findSubsetSum(int[] arr, int n){
        List<Integer> sums = new ArrayList<>();
        Backtracks(arr, n, sums, 0, 0);
        Collections.sort(sums);
        return sums;
    }
    public static void Backtracks(int[] arr,int n,List<Integer> sums,int idx, int currentSum){
        if(idx==n){
            sums.add(currentSum);
            return;
        }
        Backtracks(arr,n,sums,idx + 1,currentSum + arr[idx]);
        Backtracks(arr,n,sums,idx + 1,currentSum );
    }
    public static void main(String[] args) {
        int []arr = {3,1,2};
        int n=arr.length;
        List<Integer> res = findSubsetSum(arr,n);
        for(int i=0;i<res.size();i++){
        System.out.println(res.get(i));
        }
    }
}