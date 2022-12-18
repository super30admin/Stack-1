class Solution {
    public int[] nextGreaterElements(int[] nums) {
      int n = nums.length;
        int[] r = new int[n];
        Arrays.fill(r, -1);
        Stack<Integer> s = new Stack<>();
        for(int x = 0; x<2*n; ++x){
            int i = x%n;
            while(!s.isEmpty()){
                if(nums[s.peek()] < nums[i]){
                    int j = s.pop();
                    r[j] = nums[i];
                } else {
                    break;
                }
            }
            s.push(i);
        }
        return r;
    }  
    }
//tc = O(n)
//sc=)(n)
