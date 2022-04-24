package hw4_20001983_NgoPhuongTrang.bai6_maze;

import javax.swing.*;

public class Play {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MazeView mazeView = new MazeView();
            mazeView.setVisible(true);
        });
    }
}
