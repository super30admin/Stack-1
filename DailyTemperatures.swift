//
//  DailyTemperatures.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 3/3/26.
//


class DailyTemperatures {
    struct Stack<T> {
        var elements: [T] = []

        mutating func push(_ element: T) {
            elements.append(element)
        }

        mutating func pop() -> T? {
            if (elements.isEmpty) {
                return nil
            }
            return elements.removeLast()
        }

        func peek() -> T? {
            return elements.last
        }

        var isEmpty: Bool {
            return elements.isEmpty
        }

        var size: Int {
            return elements.count
        }
    }
    
    init() {
        let result = dailyTemperatures([73, 70, 68, 67, 69, 65, 72, 74, 78])
        print("result \(result)")
    }

    /*
     worst case - space cmoplexity - O(n)
     time complexity -> O(2n) every element is touched twice. Once it will be pushed, then it will be popped.
     */
    func dailyTemperatures(_ temperatures: [Int]) -> [Int] {
        
        var stack = Stack<Int>()
        var result = Array(repeating: 0, count: temperatures.count)
        for i in 0..<temperatures.count {
            while (!stack.isEmpty && temperatures[i] > temperatures[stack.peek()!]) {
                //resolve
                let poppedIdx = stack.pop()!
                result[poppedIdx] = i - poppedIdx
            }
            stack.push(i)
        }
        return result
    }
}
