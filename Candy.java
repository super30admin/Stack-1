import java.util.Arrays;

//Time Complexity=O(n)
//Space Complexity=O(n)
public class Candy {

    public int candy(int[] ratings) {

        if(ratings==null || ratings.length==0 ) return 0;
        int n=ratings.length;
        if(n==1) return 1;

        int[] result=new int[n];
        int sum;
        Arrays.fill(result,1);

        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                result[i]=result[i-1]+1;
            }
        }
        sum=result[n-1];

        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                result[i]=Math.max(result[i],result[i+1]+1);
            }
            sum+=result[i];
        }

        return sum;
    }
}
