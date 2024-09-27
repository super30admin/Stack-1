class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T == null || T.length == 0 ) return null;
        
        int n = T.length;
        
       int[] result = new int[n] ;
        
          return addTemp(T,result,0) ;
        
    }
    
    
    private int[]  addTemp(int[] T, int[] result, int index) {
        
        int cnt = 0;
        int maxPerm = T.length -1; 
        if(index == maxPerm ) {
            result[index] = 0;
            return result; 
        }
        for( int i = index +1 ; i < T.length; i ++ ) {
            cnt ++;
            if ( T[i] > T[index] ) {
                result[index] = cnt;
                break;
            }
        }
       return addTemp( T,  result,  index + 1) ;
    }
}
