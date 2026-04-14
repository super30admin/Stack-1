//
//  NextGreaterElementsII.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 3/3/26.
//

class NextGreaterElementII {
    struct Stack<T> {
        var elements = [T]()

        mutating func push(_ element: T) {
            elements.append(element)
        }

        mutating func pop() -> T? {
            return elements.removeLast()
        }

        func peek() -> T? {
            return elements.last
        }

        var isEmpty: Bool {
            return elements.isEmpty
        }
    }

    //time compelxity - O(3n), space compelxity - O(n)
    func nextGreaterElements(_ nums: [Int]) -> [Int] {
        let n = nums.count
        var result = Array(repeating: -1, count: nums.count)
        var stack = Stack<Int>() //monotonic drecreasing stack

        for i in 0..<2*n {
                //resolve
            while(!stack.isEmpty && nums[i%n] > nums[stack.peek()!]) {
                let poppedIndex = stack.pop()!
                result[poppedIndex] = nums[i%n]
            }
            if (i < n) {
                stack.push(i)
            }
        }
        return result
    }
}
