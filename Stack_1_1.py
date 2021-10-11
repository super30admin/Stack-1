class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        ret = [0]*len(temperatures)
        mono_stack = []
        for i, t in enumerate(temperatures):
            while mono_stack and mono_stack[-1][0] < t:
                _, prev_i = mono_stack.pop()
                ret[prev_i] = i-prev_i
            mono_stack.append((t, i))
        return ret

%TC:O(n)
%SC:O(n)