import java.awt.*;

public class CafeWall{
	public static final int Mortar = 2;
	public static void main(String[] args){
		DrawingPanel panel = new DrawingPanel(650, 400);
		panel.setBackground(Color.gray);
		Graphics g = panel.getGraphics();
		drawingRow(g, 0, 0, 4, 20);//upper-left
		drawingRow(g, 50, 70, 5, 30); //mid-left
		drawingGrid(g, 10, 150, 4, 25, 0);
		drawingGrid(g, 250, 200, 3, 25, 10);
		drawingGrid(g, 425, 180, 5, 20, 10);
		drawingGrid(g, 400, 20, 2, 35, 35);
	}
	
	public static void drawingRow(Graphics g, int x, int y, int pair, int size){
		/* 4 pairs of 1 black and 1 white square box
		i = total num of boxes */
		for (int i = 1; i <= pair; i ++){
			g.setColor(Color.black);
			g.fillRect(x + size * (i - 1) * 2, y, size, size);
			g.setColor(Color.white);
			g.fillRect(x + size * (i - 1) * 2 + size, y, size, size);
			g.setColor(Color.blue);//X in the balck box
			g.drawLine(x + 2 * size * (i - 1), y, x + 2 * size * (i - 1) + size, y + size);
			g.drawLine(x + 2 * size * (i - 1), y + size, x + 2 * size * (i - 1) + size, y);
		}
	}
	
	public static void drawingGrid(Graphics g, int x, int y, int pair, int size, int offset){
		/* j = varible numbers of row.
		Then write a for loop using drawingRow to let row become drawingGrid
		with multiple lines repeated */
		for(int j = 1; j <= 2 * pair; j ++){
			drawingRow(g, x + (offset + ((int)Math.pow(-1, j) * offset))/ 2, y + (Mortar + size) * (j - 1), pair, size);
		}
	}
}