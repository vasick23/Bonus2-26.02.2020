import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AppMain {
	public static void main(String[] args) {
		JFrame windowFrame = new JFrame();
		JLabel statusbar = new JLabel("Problem and game info will be displayed here.");
		windowFrame.add(statusbar, BorderLayout.SOUTH);
		windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowFrame.setSize(1000, 1100);
		windowFrame.setResizable(false);
		windowFrame.add(new Board());	
		windowFrame.setVisible(true);
	}
}