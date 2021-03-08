class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        if(T == null || T.length == 0) return new int[]{};
        int[] result = new int[T.length];

        int currentPointer = 0;
        
        for(int i = currentPointer; i < T.length; i++){
            int currSum = T[i];
            int days = 1;
            // System.out.println("CurrSum is: " + currSum);
            for(int j = i+1; j < T.length; j++){
                // System.out.println("Start comparison at: " + T[j]);
                if(T[j] > currSum){
                    result[i] = days;
                    days = 0;
                    break;
                }else{
                    days++;
                }
            }
        }
        
        return result;
    }
}


//Current pointer
//Iterate till wew find something
//