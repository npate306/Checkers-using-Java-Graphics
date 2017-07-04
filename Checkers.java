import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Checkers extends JPanel implements MouseListener {
	/**
	 * Main method sets title for JFrame being used for display, as wells as the size, content, close operation and whether or not it is
	 * resizeable by the user as well as visible to the user
	 * @param args
	 */

	public static void main(String[] args) {
		JFrame window = new JFrame("Checkers");
		Checkers content = new Checkers();
		window.setContentPane(content);
		window.setSize(661, 695);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);
	}
	/**
	 * Constructor, just adds mouse listener to screen
	 */

	public Checkers() {
		addMouseListener(this);
	}
	/**
	 * PaintComponent first paints the checkers board, then the blue pieces and then the green pieces using two for loops in order to get the 
	 * position of the pieces right, 75 for the height and width is good enough for this version varies depending on the screen size!
	 */

	public void paintComponent(Graphics g) {

		int row;
		int col;
		int x, y;

		for (row = 0; row < 8; row++) {

			for (col = 0; col < 8; col++) {
				x = col * 80;
				y = row * 80;
				if ((row % 2) == (col % 2))
					g.setColor(Color.black);
				else
					g.setColor(Color.red);
				g.fillRect(x, y, 80, 80);
			}

		}
		for (row = 0; row < 3; row++) {
			for (col = 0; col < 8; col++) {
				x = col * 80;
				y = row * 80;
				if ((row % 2) != (col % 2)) {
					g.setColor(Color.BLUE);
					g.fillOval(x, y, 75, 75);
				}
			}
		}
		for (row = 8; row > 4; row--) {
			for (col = 0; col < 8; col++) {
				x = col * 80;
				y = row * 80;
				if ((row % 2) != (col % 2)) {
					g.setColor(Color.GREEN);
					g.fillOval(x, y, 75, 75);
				}
			}
		}
	}
	
	/**
	 *	Mousepressed checks if the mouse and shift,control, and alt keys are being pressed at the same time if shift is, then the spot on the
	 *  board that is clicked is replaced with red space. If control is, then a blue piece is painted, if alt is then a green piece 
	 *  location depends on where the user clicks on the board. 
	 */
	public void mousePressed(MouseEvent evt) {
		Graphics g = getGraphics();
		if (evt.isShiftDown()) {
			g.setColor(Color.RED);
			g.fillRect(evt.getX(), evt.getY(), 80, 80);
			return;
		}
		if (evt.isControlDown()) {
			g.setColor(Color.BLUE);
			g.fillOval(evt.getX(), evt.getY(), 75, 75);
		}
		if (evt.isAltDown()) {
			g.setColor(Color.GREEN);
			g.fillOval(evt.getX(), evt.getY(), 75, 75);
		}
	}

	public void mouseReleased(MouseEvent evt) {
	}

	public void mouseClicked(MouseEvent evt) {
	}

	public void mouseEntered(MouseEvent evt) {
	}

	public void mouseExited(MouseEvent evt) {
	}

}