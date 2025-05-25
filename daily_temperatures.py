'''
The key in solving the problem is using the stack, and popping the elements when you find the elements greater than the element on the top of the stack.

TC: O(n)
SC: O(n)
'''

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:

        result_array = [0 for i in range(len(temperatures))]

        st=[]

        for i in range(0, len(temperatures)):

            while(len(st)>0 and temperatures[i]>temperatures[st[-1]]):

                popped = st.pop()

                result_array[popped] = i-popped

            st.append(i)

        return result_array



