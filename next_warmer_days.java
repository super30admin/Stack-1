//TC: O(n)
//SC: O(n) if all the array elemets are decreasing except the last element

//approach: push the index into the stack if the value is lesser than the stack peek element
//pop it if the reverse and assign it the differenece in the indexes
class Solution {
    public int[] dailyTemperatures(int[] t) {
        int n = t.length;
        if(t==null || t.length==0){
            return new int[0];
        }
        int [] arr = new int[n];
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && t[i] > t[st.peek()]){
                arr[st.peek()] = i- st.peek();
                st.pop();
            }
            st.push(i);
        }
        return arr;
    }
}