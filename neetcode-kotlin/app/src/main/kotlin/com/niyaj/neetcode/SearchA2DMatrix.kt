package com.niyaj.neetcode

/**
 * Search a 2D Matrix
 * You are given an m x n 2-D integer array matrix and an integer target.
 *
 * Each row in matrix is sorted in non-decreasing order.
 * The first integer of every row is greater than the last integer of the previous row.
 * Return true if target exists within matrix or false otherwise.
 *
 * Can you write a solution that runs in O(log(m * n)) time?
 *
 * Example 1:
 *
 *
 *
 * Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 10
 *
 * Output: true
 * Example 2:
 *
 *
 *
 * Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 15
 *
 * Output: false
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -10000 <= matrix[i][j], target <= 10000
 *
 */
object SearchA2DMatrix {
    /**
     * Search for target within matrix. If it exists, then return true, otherwise, return false.
     * Step1: Initialize the top pointer to 0 and the bottom pointer to the last index of the array
     * Step2: Iterate through the array until the top pointer is less than or equal to the bottom pointer
     * Step3: Calculate the row index
     * Step4: Check if the target is greater than the last element of the row
     * Step5: Update the top pointer to the row index + 1
     * Step6: Check if the target is less than the first element of the row
     * Step7: Update the bottom pointer to the row index - 1
     * Step8: Break if the target is within the row
     * Step9: Return false if the target is not found
     * Step10: Calculate the row index
     * Step11: Initialize the left pointer to 0 and the right pointer to the last index of the row
     * Step12: Iterate through the row until the left pointer is less than or equal to the right pointer
     * Step13: Calculate the middle index
     * Step14: Check if the middle element is greater than the target
     * Step15: Update the right pointer to the middle index - 1
     * Step16: Check if the middle element is less than the target
     * Step17: Update the left pointer to the middle index + 1
     * Step18: Return true if the middle element is equal to the target
     * Step19: Return false if the target is not found
     * @param matrix a 2D integer array
     * @param target an integer
     * @return true if the target exists within matrix, otherwise, return false
     * Time complexity: O(log(m) + log(n))
     * Space complexity: O(1)
     */
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val rows = matrix.size
        val cols = matrix[0].size

        var top = 0
        var bottom = rows - 1

        while (top <= bottom){
            val row = top + ((bottom - top) / 2)
            if (target > matrix[row][cols - 1]){
                top = row + 1
            }else if(target < matrix[row][0]) {
                bottom = row - 1
            }else {
                break
            }
        }

        if (top > bottom) return false

        var row = (top + bottom) / 2
        var left = 0
        var right = cols - 1

        while (left <= right){
            val m = left + ((right - left) / 2)
            when {
                matrix[row][m] > target -> right = m - 1
                matrix[row][m] < target -> left = m + 1
                else -> return true
            }
        }

        return false
    }

    /**
     * Search for target within matrix. If it exists, then return true, otherwise, return false.
     * Step1: Initialize the left pointer to 0 and the right pointer to the last index of the array
     * Step2: Iterate through the array until the left pointer is less than or equal to the right pointer
     * Step3: Calculate the middle index
     * Step4: Calculate the row and column of the middle index
     * Step5: Check if the middle element is greater than the target
     * Step6: Update the right pointer to the middle index - 1
     * Step7: Check if the middle element is less than the target
     * Step8: Update the left pointer to the middle index + 1
     * Step9: Return true if the middle element is equal to the target
     * Step10: Return false if the target is not found
     * @param matrix a 2D integer array
     * @param target an integer
     * @return true if the target exists within matrix, otherwise, return false
     * Time Complexity: O(log(m * n)) time.
     * Space Complexity: O(1) space.
     */
    fun searchMatrixBS(matrix: Array<IntArray>, target: Int): Boolean {
        val rows = matrix.size
        val cols = matrix[0].size

        var left = 0
        var right = rows * cols - 1

        while (left <= right){
            val mid = left + ((right -left) / 2)
            val row = mid / cols
            val col = mid % cols

            when {
                matrix[row][col] == target -> return true
                matrix[row][col] < target -> left = mid + 1
                else -> right = mid - 1
            }
        }

        return false
    }
}

fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 2, 4, 8),
        intArrayOf(10, 11, 12, 13),
        intArrayOf(14, 20, 30, 40)
    )
    val target = 10
    println(SearchA2DMatrix.searchMatrix(matrix, target)) // true

    val target2 = 15
    println(SearchA2DMatrix.searchMatrix(matrix, target2)) // false

    val matrix2 = arrayOf(
        intArrayOf(1, 2, 4, 8),
        intArrayOf(10, 11, 12, 13),
        intArrayOf(14, 20, 30, 40)
    )
    val target3 = 1
    println(SearchA2DMatrix.searchMatrix(matrix2, target3)) // true

    val target4 = 40
    println(SearchA2DMatrix.searchMatrix(matrix2, target4)) // true

    val target5 = 100
    println(SearchA2DMatrix.searchMatrix(matrix2, target5)) // false

    val target6 = 10
    println(SearchA2DMatrix.searchMatrixBS(matrix, target6)) // true

    val target7 = 15
    println(SearchA2DMatrix.searchMatrixBS(matrix, target7)) // false

    val target8 = 1
    println(SearchA2DMatrix.searchMatrixBS(matrix2, target8)) // true
}