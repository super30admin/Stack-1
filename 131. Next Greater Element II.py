class Solution:
    def nextGreaterElements(self, nums):
        temp = nums[:] + nums[:]
       # print(temp)
        result = [-1 for i in range(len(nums))]
        st = []

        for i in range(len(temp)):
            while st and temp[i] > temp[st[-1]]:
                result[st.pop()] = temp[i]

            if i < len(nums):
                st.append(i)
                #print(st)
        return result


L = [9,6,7,10,21,-5,-3,18]
obj = Solution()
print(obj.nextGreaterElements(L))
