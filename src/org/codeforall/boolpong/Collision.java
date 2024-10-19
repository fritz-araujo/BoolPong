package org.codeforall.boolpong;


public class Collision {

    private int[][] rectangles;

    public Collision() {

        rectangles = new int[][]{
                {200, 300, 260, 320}, // Target copo 0
                {160, 260, 220, 280}, // Target copo 1
                {240, 260, 300, 280}, // Target copo 2
                {120, 220, 180, 240}, // Target copo 3
                {200, 220, 260, 240}, // Target copo 4
                {280, 220, 340, 240}  // Target copo 5
        };
    }
    // check collision and it suppose to say what cup was hit
    public int checkCollision(int ballX, int ballY) {
        for (int i = 0; i < rectangles.length; i++) {
            int[] rect = rectangles[i];

            // Check if ball's position falls within the rectangle
            if (ballX >= rect[0] && ballX <= rect[2] && ballY >= rect[1] && ballY <= rect[3]) {
                return i;  // Return the index of the cup that was hit
            }
        }
        return -1; // No collision detected
    }
}