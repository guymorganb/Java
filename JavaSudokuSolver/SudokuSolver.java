public class SudokuSolver {
    private int[][] grid;
    private static final int EMPTY = 0;
    private static final int SIZE = 9;

    public SudokuSolver(int[][] grid) {
        this.grid = grid;
    }

    public void solve() {
        if (solve(0, 0)) {
            printGrid();
        } else {
            System.out.println("No solution found");
        }
    }

    private boolean solve(int row, int col) {
        if (row == SIZE) {
            row = 0;
            if (++col == SIZE) {
                return true;
            }
        }

        if (grid[row][col] != EMPTY) {
            return solve(row + 1, col);
        }

        for (int val = 1; val <= SIZE; ++val) {
            if (isValid(row, col, val)) {
                grid[row][col] = val;
                if (solve(row + 1, col)) {
                    return true;
                }
            }
        }

        grid[row][col] = EMPTY;
        return false;
    }

    private boolean isValid(int row, int col, int val) {
        for (int i = 0; i < SIZE; ++i) {
            if (val == grid[i][col]) {
                return false;
            }
        }

        for (int j = 0; j < SIZE; ++j) {
            if (val == grid[row][j]) {
                return false;
            }
        }

        int boxRow = row - row % 3;
        int boxCol = col - col % 3;

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (val == grid[boxRow + i][boxCol + j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private void printGrid() {
        for (int row = 0; row < SIZE; ++row) {
            for (int col = 0; col < SIZE; ++col) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        Sudoku
