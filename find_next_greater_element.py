'''S30:

The crux of the problem is the follow up of the daily temperatures, you have to run one more loop to figure out the unresolved elements present in the loop.

Although I am not doing additional optimization in the code, such as in the second loop you dont enter any elements in the stack.
TC: O(2n)
SC.: O(n)'''

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:

        result_array =[-1 for i in range(len(nums))]

        st =[]

        for i in range( 2*len(nums)):

            while(len(st)>0 and nums[i%len(nums)]>nums[st[-1]]):

                popped_index = st.pop()

                result_array[popped_index] = nums[i%len(nums)]



            st.append(i%len(nums))

        return result_array
