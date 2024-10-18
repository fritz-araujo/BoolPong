package org.codeforall.boolpong;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Field {

    private int MaxX;
    private int MaxY;
    public final int CELLSIZE = 20;

    private Rectangle [] grid;

    public Field(int cols, int rows) {

        MaxX = CELLSIZE * cols;
        MaxY = CELLSIZE * rows;

        int counterX = 0;
        int counterY = 0;
        grid = new Rectangle[cols*rows];

        int i = 0;

        while (counterX < cols && counterY < rows) {

            Rectangle r1 = new Rectangle(CELLSIZE * counterX, CELLSIZE * counterY, CELLSIZE, CELLSIZE);
            r1.draw();
            counterX++;

            if (counterX == cols){
                counterY++;
                counterX = 0;
            }

            grid[i] = r1;
            i++;

        }

    }

    public Rectangle[] getGrid() {
        return grid;
    }
}
