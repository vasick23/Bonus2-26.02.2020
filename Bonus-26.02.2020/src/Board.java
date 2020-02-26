import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class Board extends JPanel {
	private static final long serialVersionUID = 4;
	private final int TILE_SIDE = 15;
	private int selectedRow = -1;
	private int selectedCol = -1;
	private int clicks = 0;
	String Player;
	final String player1 = "Player1";
	final String player2 = "Player2";
	public Board() {
		addMouseListener(new EventProxy() {	
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				selectedRow = y / TILE_SIDE; 
				selectedCol = x / TILE_SIDE;
				System.out.println(selectedRow + ";" + selectedCol);
				updateUI();
				clicks = e.getClickCount();
				if(e.getClickCount()>2) {
					
				}
			}
		});
	}

	public void paint(Graphics g) {
		for(int row = 0; row < 64; row++) {
			for(int col = 0; col < 64; col++) {
				render(g, row, col);
					if((row% 4 == 0)||(col % 9 == 0))  {
					BlueRect(g, row, col);
				    }
			}
		}
	}
	
	private void render(Graphics g, int row, int col) {
		boolean isRowEven 	= (row % 2 == 0);
		boolean isColEvent 	= (col % 2 == 0);
		boolean isWhite 	= (isRowEven && isColEvent) || (!isRowEven && !isColEvent);
		Color tileColor = isWhite ? Color.RED 
								  : Color.GREEN;
		boolean isSelected = (row == selectedRow) && 
							 (col == selectedCol);
		int tileX = col * TILE_SIDE;
		int tileY = row * TILE_SIDE;
		if(isSelected && clicks == 3) {
			tileColor = Color.BLACK;
			g.setColor(tileColor);
			g.fillRect(tileX, tileY, TILE_SIDE, TILE_SIDE);
			return;
		} 
		g.setColor(tileColor);
		g.fillRect(tileX, tileY, TILE_SIDE, TILE_SIDE);
	}
	public void BlueRect(Graphics g, int row, int col){
		int tileX = col * TILE_SIDE;
		int tileY = row * TILE_SIDE;
	    g.setColor(Color.BLUE);
	    g.fillRect(tileX, tileY, TILE_SIDE, TILE_SIDE);
	}
}