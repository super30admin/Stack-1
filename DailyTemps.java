// TC: Asymptotic O(n) // worst case O(2n) because at most we can pop (n-1) elements from the stack i.e. O(n)
// another O(n) for array traversal
// SC: O(1)


// We compare if the current element can resolve elements inside the stack one by one 
// Meaning if the current element is > than the top element in stack
// If it is, get the difference in the indices between the popped element and i, put it in result[popped] i.e.
// the element you resolved
// Your current element can resolve upto n-1 elements 
// If current element is < than topmmost element, put that element in stack and go to next
// If stack is empty, put the current element


class Solution {
    public int[] dailyTemperatures(int[] T) {
        int n=T.length;
        int[] result=new int[n];
        Stack<Integer> st=new Stack<>(); //you will store indices in stack
        for(int i=0;i<T.length;i++){
            
            //while stack is not empty and the temp of i is > the top element of stack
            while(!st.isEmpty() && T[i]>T[st.peek()]){
            
                int popIndex=st.pop(); //T[i] is able to resolve your top element
                
                result[popIndex]=i-popIndex; //put the value in the result array at index which you resolved
            }
            st.push(i); //Push the index
        
        }
        
        return result;
        }
        
    }
