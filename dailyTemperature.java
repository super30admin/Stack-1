class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result= new int[temperatures.length];
        if(temperatures.length==0)return result;
        Stack<Integer> s= new Stack<>();
        for(int i=0; i< temperatures.length; i++){
            while(!s.isEmpty() && temperatures[i]>temperatures[s.peek()] ){
                int popped= s.pop();
                result[popped]= i-popped;
            }
            s.push(i);
            
        }
        return result;
    }
}