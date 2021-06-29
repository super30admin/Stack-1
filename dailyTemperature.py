class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        if temperatures is None: return -1
        callstack = []
        out = [0] * len(temperatures)

        for id in range(len(temperatures)):

            while callstack.__len__() > 0 and temperatures[id] > temperatures[callstack[-1]]:
                st = callstack.pop()
                out[st] = id - st

            callstack.append(id)
        return out



