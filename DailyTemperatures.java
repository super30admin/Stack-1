// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
public class DailyTemperatures{
    public int[] dailyTemperatures(int[] t) {
        int[] res = new int[t.length];
        Stack<Integer> s = new Stack<>();
        
        for(int i = 0; i < t.length; i++){
            while(!s.empty() && t[i] > t[s.peek()]){
                int top = s.pop();
                res[top] = i - top;
            }
            s.push(i);
        }
        return res;
    
        
//         int[] res = new int[t.length];
//         for(int i = 0; i < t.length; i++){
//             for(int j = i + 1; j < t.length; j++){
//                 if(t[j] > t[i]){
//                     res[i] = j - i;
//                     break;
//                 }
//             }
//         }
//         return res;
    }
}