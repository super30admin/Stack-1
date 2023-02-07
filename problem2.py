#time complexity: O(n)
#space complexity:O(n)
# ran on leetcode: yes
#Use a stack and maintain elements in decfeasing order. If top of the stack is less than current element, then porcess the element at top of the stack. Also note down the indexes present in the stack with a hash set. If current index index is present in hashset, then break the loop
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if(len(nums)==1):
            return [-1]
        L=[-1]*len(nums)
        stk=[(nums[0],0)]
        in_stk=set()
        in_stk.add(0)
        i=1
        
        while(True):
            while(stk and stk[-1][0]<nums[i]):
                if(L[stk[-1][1]]==-1):
                    L[stk[-1][1]]=nums[i]
                in_stk.remove(stk[-1][1])
                del(stk[-1])
                
            if(i in in_stk):
                break
            stk.append((nums[i],i))
            in_stk.add(i)
            i=(i+1)%len(nums)
        return L
