
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i = 0;  i<n; i++){
            while(!s.isEmpty() && temperatures[s.peek()] < temperatures[i]){
                int popped = s.pop();
                System.out.println("popped: "+popped);
                ans[popped] = i-popped;
                System.out.println("ans[popped]: "+ans[popped]);
            }

        s.push(i);
        System.out.println("s-->"+s);
        }
        

    return ans;   
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)