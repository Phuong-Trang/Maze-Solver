package hw4_20001983_NgoPhuongTrang.bai6_maze;

import hw4_20001983_NgoPhuongTrang.bai3.LinkedListQueue;

public class MazeSolver {
    final int[][] maze;
    final Position start;
    final Position end;
    boolean[][] visited;
    Position[][] parent;
    final int[] DIRECTION = {1, 0, -1, 0, 0, 1, 0, -1}; // {Down, Up, Right, Left}

    public MazeSolver(int[][] maze, Position start, Position end) {
        this.maze = maze;
        this.start = start;
        this.end = end;

        visited = new boolean[maze.length][maze[0].length];
        parent = new Position[maze.length][maze[0].length];
    }

    public boolean canMove(int row, int col) {
        if (row >= 0 && row < maze.length && col >= 0 && col < maze[0].length)
            return maze[row][col] == 0 && !visited[row][col];
        return false;
    }

    public void bfs() {
        boolean done = false;
        LinkedListQueue<Position> queue = new LinkedListQueue<>();
        queue.enqueue(start);
        parent[start.row][start.col] = new Position(-1, -1);
        visited[start.row][start.col] = true;

        while (!queue.isEmpty()) {
            Position current = queue.first();
            if (current.equal(end)) {
                done = true;
                printPath();
                break;
            }
            for (int i = 0; i < DIRECTION.length; i += 2) {
                int newRow = current.row + DIRECTION[i];
                int newCol = current.col + DIRECTION[i + 1];
                if (canMove(newRow, newCol)) {
                    Position newPos = new Position(newRow, newCol);
                    queue.enqueue(newPos);
                    visited[newRow][newCol] = true;
                    parent[newRow][newCol] = current;
                }
            }
            queue.dequeue();
        }

        if (!done)
            System.out.println("Can't find a path for this maze");
    }

    public void printPath() {
        Position current = end;
        while (!current.equal(new Position(-1, -1))) {
            maze[current.row][current.col] = 2;
            current = parent[current.row][current.col];
        }
    }
}
