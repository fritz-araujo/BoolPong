package org.codeforall.boolpong.gfx.simplegfx;

import org.codeforall.boolpong.grid.GridColor;
import org.codeforall.boolpong.grid.GridDirection;
import org.codeforall.boolpong.grid.position.AbstractGridPosition;
import org.codeforall.boolpong.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Simple graphics position
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;
    private GridDirection direction;

    /**
     * Simple graphics position constructor
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(SimpleGfxGrid grid){
        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);

    }

    /**
     * Simple graphics position constructor
     * @param col position column
     * @param row position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid){
        super(col, row, grid);
        simpleGfxGrid = grid;
        rectangle = new Rectangle(simpleGfxGrid.columnToX(col), simpleGfxGrid.rowToY(row) , simpleGfxGrid.getX(), simpleGfxGrid.getY());
        show();

    }

    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {
        rectangle.draw();
        rectangle.fill();
    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {
        rectangle.delete();
    }


    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    /*
    //@Override
    public void moveInDirection(GridDirection direction, int distance) {
        switch(direction){
            case UP -> rectangle.translate(0, distance * simpleGfxGrid.getCellSize());
            case DOWN -> rectangle.translate(0, -distance * simpleGfxGrid.getCellSize());
            case LEFT -> rectangle.translate(-distance * simpleGfxGrid.getCellSize(), 0);
            case RIGHT -> rectangle.translate(distance * simpleGfxGrid.getCellSize(), 0);
        }
    }*/

    /**
     * @see AbstractGridPosition#setColor(GridColor)
     */
    @Override
    public void setColor(GridColor color) {
    }
}
