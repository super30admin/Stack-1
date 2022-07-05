'''
Funda: Use monotomic stack concept and iterate in circular way!!
Time Complexity: 0(n) + 0(n) [Iterate the list in a circular way]
Space Complexity: 0(n) [Result List]
Run on leetcode: --
'''
class Solution:
    
    def __init__(self):
        self.__output = []
    
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        
        # initialize max length
        maxLen = len(nums)
        
        # initialize ptr1 and ptr2
        # ptr2 will iterate in a circular way
        ptr1 = 0
        ptr2 = 1
        
        # iterate the nums list
        while ptr1 != maxLen:
            # base-case
            if ptr2 == maxLen:
                # reset ptr2 to 0 -- circular nums list
                ptr2 = 0
            
            
            # logic-case
            if ptr1 == ptr2:
                # I don't have the match
                self.__output.append(-1)
                ptr1 += 1
                ptr2 = ptr1+1
                continue
            
            elif nums[ptr1] < nums[ptr2]:
                # I have my immediate max number
                self.__output.append(nums[ptr2])
                ptr1 += 1
                ptr2 = ptr1+1
                continue
            
            else:
                ptr2 += 1
                continue
        '''end of while loop'''
        
        # return the output list
        # print(f"Output list is:\t {self.__output}")
        return self.__output