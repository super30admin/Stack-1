//Brute Force approach
//Time : O(n*n)
//Space : O(n)

//Approach:
//1 . For each temperature check its next higher value and store it in new array , else store -1.
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        for(int i = 0;i<T.length;i++){
            int count = 1;
            int j = i+1;
            while(j<T.length){
                if(T[j]>T[i]){
                    result[i] = count;
                    break;
                }
                count++; 
                j++;
            }
            if(j == T.length)
                result[i] = 0;
        }
        return result;
    }
}
