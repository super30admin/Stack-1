//Time Complexity:O(n)
//Space Complexity:O(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n =temperatures.length;
        int[] res= new int[n];
        Stack<Integer> s= new Stack();
        for(int i=0;i<n;i++){
            if(s.isEmpty()) s.push(i);
            else if(temperatures[i]>temperatures[s.peek()]){
                while(!s.isEmpty()&&temperatures[i]>temperatures[s.peek()]){
                    int p= s.pop();
                    res[p]=i-p; 
                }
                s.push(i);
            }
            else{
                s.push(i);
            }
        }
        return res;
    }
}