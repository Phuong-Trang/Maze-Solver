package hw4_20001983_NgoPhuongTrang.bai6_maze;

import javax.swing.*;
import java.awt.*;

public class MazeView extends JFrame {
    final int[][] maze =
            {
                    {1, 1, 0, 1, 0, 0, 1, 1},
                    {1, 1, 0, 0, 0, 1, 0, 0},
                    {0, 0, 1, 0, 1, 1, 0, 1},
                    {1, 0, 0, 0, 0, 1, 0, 1},
                    {1, 1, 1, 1, 0, 0, 0, 1},
                    {0, 0, 0, 0, 0, 1, 0, 0},
                    {1, 1, 0, 1, 0, 1, 1, 1},
                    {1, 0, 0, 1, 0, 1, 1, 1},
            };
//            {
//                {0, 0, 0, 0},
//                {0, 0, 0, 0},
//                {0, 0, 0, 0},
//                {0, 0, 0, 0},
//                {0, 0, 0, 0}
//            };
    final Position start = new Position(2, 0);
    final Position end = new Position(5, 7);

    public MazeView() {
        setTitle("Maze Solver");
        setSize(500, 500); // set Frame view size to 500 * 500
        setLocationRelativeTo(null);   // set Frame view position to the center of your computer screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MazeSolver ms = new MazeSolver(maze, start, end);
        ms.bfs();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // create graphic for the game
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                Color color;
                // base on the position's value to choose its color
                if (maze[row][col] == 1)
                    color = Color.BLACK;
                else if (maze[row][col] == 2)
                    color = Color.ORANGE;
                else
                    color = Color.WHITE;
                g.setColor(color);

                /*  fill the position with chosen color
                    each position has a size of 50 x 50
                    and starting coordinate at (x,y) = (50 * (col + 1), 50 * (row + 1))
                 */
                g.fillRect(50 * (col + 1), 50 * (row + 1), 50, 50);
            }
        }
    }
}
