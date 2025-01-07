package com.niyaj.neetcode

/**
 * Car Fleet
 * There are n cars traveling to the same destination on a one-lane highway.
 *
 * You are given two arrays of integers position and speed, both of length n.
 *
 * position[i] is the position of the ith car (in miles)
 * speed[i] is the speed of the ith car (in miles per hour)
 * The destination is at position target miles.
 *
 * A car can not pass another car ahead of it. It can only catch up to another car and then drive at the same speed as the car ahead of it.
 *
 * A car fleet is a non-empty set of cars driving at the same position and same speed. A single car is also considered a car fleet.
 *
 * If a car catches up to a car fleet the moment the fleet reaches the destination, then the car is considered to be part of the fleet.
 *
 * Return the number of different car fleets that will arrive at the destination.
 *
 * Example 1:
 *
 * Input: target = 10, position = [1,4], speed = [3,2]
 *
 * Output: 1
 * Explanation: The cars starting at 1 (speed 3) and 4 (speed 2) become a fleet, meeting each other at 10, the destination.
 *
 * Example 2:
 *
 * Input: target = 10, position = [4,1,0,7], speed = [2,2,1,1]
 *
 * Output: 3
 * Explanation: The cars starting at 4 and 7 become a fleet at position 10. The cars starting at 1 and 0 never catch up to the car ahead of them. Thus, there are 3 car fleets that will arrive at the destination.
 *
 * Constraints:
 *
 * n == position.length == speed.length.
 * 1 <= n <= 1000
 * 0 < target <= 1000
 * 0 < speed[i] <= 100
 * 0 <= position[i] < target
 * All the values of position are unique.
 *
 */
private object CarFleet {
    /**
     * Return the number of different car fleets that will arrive at the destination.
     * Step1: Sort the cars by position
     * Step2: Create a mutable list to store the stack
     * Step3: Iterate through the cars
     * Step4: Calculate the time taken for each car to reach the target
     * Step5: Check if the stack is not empty and the current time is less than the time at the top of the stack
     * Step6: Add the time to the stack
     * Step7: Check if the stack is not empty and the current time is less than the time at the top of the stack
     * Step8: Remove the last element from the stack
     * Step9: Return the size of the stack
     * @param target the destination
     * @param position an array of integers
     * @param speed an array of integers
     * @return the number of different car fleets that will arrive at the destination
     * Space Complexity: O(n)
     * Time Complexity: O(n)
     */
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        // Sort the cars by position
        val pair = position.zip(speed).sortedByDescending { it.first }
        val stack = mutableListOf<Double>()

        // Calculate the time taken for each car to reach the target
        for ((pos, spd) in pair) {
            // Calculate the time taken for the car to reach the target
            val time = (target - pos).toDouble() / spd

            // Check if the stack is not empty and the current time is less than the time at the top of the stack
            stack.add(time)

            // Check if the stack is not empty and the current time is less than the time at the top of the stack
            if (stack.size >= 2 && stack[stack.size - 1] <= stack[stack.size - 2]) {
                stack.remove(stack[stack.size - 1])
            }
        }

        return stack.size
    }
}

fun main() {
    val target = 10
    val position = intArrayOf(1, 4)
    val speed = intArrayOf(3, 2)
    val result = CarFleet.carFleet(target, position, speed)
    println(result) // Output: 1

    val target2 = 10
    val position2 = intArrayOf(4, 1, 0, 7)
    val speed2 = intArrayOf(2, 2, 1, 1)
    val result2 = CarFleet.carFleet(target2, position2, speed2)
    println(result2) // Output: 3

    val target3 = 10
    val position3 = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val speed3 = intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1)
    val result3 = CarFleet.carFleet(target3, position3, speed3)
    println(result3) // Output: 9
}