/*time compleixty O(2n)
space complexity o(n)
approach: we are using stack data str because all the elements should be compared with their next elements and not previous elemnts
push the element into stack if the pointer is at lesser element than that and process remaining elements if pointer is at greater element than top element of stack then subtract the indices append to result
*/

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result=new int[T.length];
        Arrays.fill(result,0);
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<T.length;i++){
            while(!st.isEmpty() && T[st.peek()]<T[i]){
                    int idx=st.pop();
                    result[idx]=i-idx;
            }
            st.push(i);
            
        }
        return result;
    }
}