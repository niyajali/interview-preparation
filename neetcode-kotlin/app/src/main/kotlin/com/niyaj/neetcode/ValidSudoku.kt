package com.niyaj.neetcode

/**
 * Valid Sudoku
 * You are given a a 9 x 9 Sudoku board board. A Sudoku board is valid if the following rules are followed:
 *
 * Each row must contain the digits 1-9 without duplicates.
 * Each column must contain the digits 1-9 without duplicates.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without duplicates.
 * Return true if the Sudoku board is valid, otherwise return false
 *
 * Note: A board does not need to be full or be solvable to be valid.
 *
 * Example 1:
 *
 *
 *
 * Input: board =
 * [["1","2",".",".","3",".",".",".","."],
 *  ["4",".",".","5",".",".",".",".","."],
 *  [".","9","8",".",".",".",".",".","3"],
 *  ["5",".",".",".","6",".",".",".","4"],
 *  [".",".",".","8",".","3",".",".","5"],
 *  ["7",".",".",".","2",".",".",".","6"],
 *  [".",".",".",".",".",".","2",".","."],
 *  [".",".",".","4","1","9",".",".","8"],
 *  [".",".",".",".","8",".",".","7","9"]]
 *
 * Output: true
 * Example 2:
 *
 * Input: board =
 * [["1","2",".",".","3",".",".",".","."],
 *  ["4",".",".","5",".",".",".",".","."],
 *  [".","9","1",".",".",".",".",".","3"],
 *  ["5",".",".",".","6",".",".",".","4"],
 *  [".",".",".","8",".","3",".",".","5"],
 *  ["7",".",".",".","2",".",".",".","6"],
 *  [".",".",".",".",".",".","2",".","."],
 *  [".",".",".","4","1","9",".",".","8"],
 *  [".",".",".",".","8",".",".","7","9"]]
 *
 * Output: false
 * Explanation: There are two 1's in the top-left 3x3 sub-box.
 *
 * Constraints:
 *
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit 1-9 or '.'.
 *
 */
private object ValidSudoku {
    /**
     * Validates if a given 9x9 Sudoku board is valid according to Sudoku rules:
     * - Each row must contain digits 1-9 without repetition
     * - Each column must contain digits 1-9 without repetition
     * - Each 3x3 sub-box must contain digits 1-9 without repetition
     *
     * @param board 9x9 array where each cell contains either a digit ('1'-'9') or empty cell ('.')
     * @return true if the board is valid, false otherwise
     */
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        // Arrays to track used numbers in each row, column, and 3x3 square
        // Each integer acts as a bit mask where each bit represents a digit (1-9)
        val rows = IntArray(9)    // Track numbers in each row
        val cols = IntArray(9)    // Track numbers in each column
        val squares = IntArray(9)  // Track numbers in each 3x3 square

        // Iterate through each cell in the 9x9 board
        for (r in 0 until 9) {
            for (c in 0 until 9) {
                // Skip empty cells (marked as '.')
                if (board[r][c] == '.') continue

                // Convert character digit to 0-based index (e.g., '1' -> 0, '9' -> 8)
                val value = board[r][c] - '1'

                // Create a bit mask for the current number
                // e.g., for 3 ('4' - '1' = 3): 1 << 3 = 1000 in binary
                val bit = 1 shl value

                // Calculate which 3x3 square we're in
                // (r/3)*3 gives the row group (0,3,6), (c/3) gives the column group (0,1,2)
                val squareIdx = (r / 3) * 3 + (c / 3)

                // Check if number already exists in current row, column, or square
                // using bitwise AND (&) operation
                if ((rows[r] and bit) != 0 || // Check row
                    (cols[c] and bit) != 0 || // Check column
                    (squares[squareIdx] and bit) != 0) { // Check 3x3 square
                    return false // Number already exists, invalid board
                }

                // Update the bit masks using bitwise OR (|) operation
                rows[r] = rows[r] or bit           // Mark number as used in row
                cols[c] = cols[c] or bit           // Mark number as used in column
                squares[squareIdx] = squares[squareIdx] or bit  // Mark number as used in square
            }
        }
        return true // No conflicts found, valid board
    }
}

fun main() {
    val board = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )

    println(ValidSudoku.isValidSudoku(board)) // true

    val board2 = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '3', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '1', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '5', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('2', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )

    println(ValidSudoku.isValidSudoku(board2)) // false
}