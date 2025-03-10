public class 이지현_Maze {
    public static void main(String[] args) {
        int[][] maze = {
            {0, 0, 1, 0, 0, 1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 1, 0, 0},
            {0, 1, 1, 0, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 1, 0, 1, 0, 1, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 1, 1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 1, 0, 0},
            {0, 1, 1, 0, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
        };

        boolean[][] visited = new boolean[10][10];
        int[][] stack = new int[100][2];
        int stackSize = -1;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        stack[++stackSize] = new int[] {0, 0};
        visited[0][0] = true;

        int moveCount = 0;
        boolean isEscape = false;

        while (stackSize >= 0) {
            int[] current = stack[stackSize];
            int x = current[0];
            int y = current[1];
            boolean moved = false;

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX >= 0 && nextX < 10 && nextY >= 0 && nextY < 10 
                        && maze[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                    stack[++stackSize] = new int[] {nextX, nextY};
                    visited[nextX][nextY] = true;
                    moveCount++;
                    moved = true;

                    if (nextX == 9 && nextY == 9) {
                        isEscape = true;
                        break;
                    }
                    break;
                }
            }

            if (!moved) {
                stackSize--;
            }

            if (isEscape) {
                break;
            }
        }

        if (isEscape) {
            System.out.printf("Pass, %d\n", moveCount);
        } else {
            System.out.printf("Fail, %d\n", moveCount);
        }
    }
}
