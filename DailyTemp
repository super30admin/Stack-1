//Time:O(N)
//Space:O(N)
class Solution {
    
    HashMap<Integer,Integer> higher= new HashMap<>();
    
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Integer>st= new Stack<>();
        
        
        for( int i=0;i<temperatures.length;i++){
            if(!st.isEmpty()){
                
                if(temperatures[st.peek()]>=temperatures[i]){
                 
                 
                }else{
                    while(!st.isEmpty()&&temperatures[st.peek()]<temperatures[i]){
                    int out =st.pop();
                    temperatures[out]=i-out;
                       }
                    
                }
                 
            } st.push(i);
    
    }
        
        while(!st.isEmpty()){
            temperatures[st.pop()]=0;
        }
        return temperatures;
    }
    
}
