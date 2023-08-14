// TC=SC= O(n)
class Solution {
    public int[] dailyTemperatures(int[] temps) {
        if(temps==null ||temps.length<2) return new int[]{0};
        
        int arr[]= new int[temps.length];
        Stack<Integer> st= new Stack<>();
        
        for(int i=0;i<temps.length;i++){
            
            while(!st.isEmpty() && temps[i]> temps[st.peek()]){
                int index= st.pop();
                arr[index]= i-index;
            }st.push(i);
        }
        return arr;
    }
}
