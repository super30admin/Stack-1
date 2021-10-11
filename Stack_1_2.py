class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
    	L = len(nums)
    	N, H, I = [-1]*L, [], nums.index(max(nums)) if L > 0 else 0
    	for i in range(I,I-L,-1):
    		while len(H) != 0 and nums[H[-1]] <= nums[i]: del H[-1]
    		if len(H) > 0: N[i] = nums[H[-1]]
    		H.append(i)
    	return(N)

%TC:O(n)
%SC:O(n)