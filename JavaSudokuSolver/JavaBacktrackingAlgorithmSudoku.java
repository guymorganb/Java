public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };

        if (solveSudoku(board)) {
            System.out.println("Solution:");
            printBoard(board);
        } else {
            System.out.println("No solution found.");
        }
    }

    private static boolean solveSudoku(int[][] board) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        
        // find the next empty cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }
        
        // if there are no more empty cells, the puzzle is solved
        if (isEmpty) {
            return true;
        }
        
        // try each number from 1 to 9 in the empty cell
        for (int num = 1; num <= 9; num++) {
            if (isValid(board, row, col, num)) {
                board[row][col] = num;
                
                // recursively try to solve the puzzle
                if (solveSudoku(board)) {
                    return true;
                } else {
                    // backtrack and try the next number
                    board[row][col] = 0;
                }
            }
        }
        
        // no number worked in this cell, so backtrack
        return false;
    }

    private static boolean isValid(int[][] board, int row, int col, int num) {
        // check the row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        
        // check the column
        for (int i = 0; i < board[0].length; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        
        // check the 3x3 box
        int boxRow = row - row % 3;


        //Explination
        /*
    function solveSudoku(grid) {
  // get the next empty cell
  const [row, col] = getNextEmptyCell(grid);
  
  // if there are no empty cells, then we're done
  if (row === -1) {
    return true;
  }

  // try each possible value in the empty cell
  for (let num = 1; num <= 9; num++) {
    // check if the value is valid
    if (isValid(grid, row, col, num)) {
      // if the value is valid, place it in the cell
      grid[row][col] = num;

      // recursively try to solve the rest of the puzzle
      if (solveSudoku(grid)) {
        return true;
      }

      // if we couldn't solve the puzzle with this value, backtrack and try another value
      grid[row][col] = 0;
    }
  }

  // if none of the values worked, the puzzle is unsolvable
  return false;
}

__________________________________________________________________________________________
The function solveSudoku takes in a 9x9 array grid that represents the Sudoku puzzle, and returns a boolean indicating whether the puzzle was solvable or not.
The first thing the function does is call the helper function getNextEmptyCell to get the next empty cell in the grid. The function returns an array [row, col] that contains the coordinates of the next empty cell. If there are no empty cells, then the function immediately returns true, because the puzzle is already solved.
Next, the function tries each possible value (1-9) in the empty cell, one at a time, and checks if the value is valid using the helper function isValid. If the value is valid, it is placed in the cell and the function recursively calls itself to try to solve the rest of the puzzle. If the function returns true, that means the puzzle was solved and the function returns true. If the function returns false, that means the value we tried didn't work, so we need to backtrack by resetting the cell to 0 and trying another value.
If none of the values work, the puzzle is unsolvable and the function returns false.
Here are the helper functions used in the code:

function getNextEmptyCell(grid) {
  for (let row = 0; row < 9; row++) {
    for (let col = 0; col < 9; col++) {
      if (grid[row][col] === 0) {
        return [row, col];
      }
    }
  }
  return [-1, -1];
}

function isValid(grid, row, col, num) {
  // check row
  for (let i = 0; i < 9; i++) {
    if (grid[row][i] === num) {
      return false;
    }
  }

  // check column
  for (let i = 0; i < 9; i++) {
    if (grid[i][col] === num) {
      return false;
    }
  }

  // check subgrid
  const subgridRow = Math.floor(row / 3) * 3;
  const subgridCol = Math.floor(col / 3) * 3;
  for (let i = 0; i < 3; i++) {
    for (let j = 0; j < 3; j++) {
      if (grid[subgridRow + i][subgridCol + j] === num) {
        return false;
      }
   


         * 
         */