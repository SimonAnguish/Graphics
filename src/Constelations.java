package src;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Constelations extends JComponent {
	final int COUNT_OF_POINTS = 10;
	Point[] points;

	public Constelations(Dimension d) {
		points = new Point[COUNT_OF_POINTS];

		setSize(d.width, d.height);

		Random rand = new Random();

		for (int i=0;i<points.length;i++) {
			points[i] = new Point(rand.nextInt(d.width), rand.nextInt(d.height));
		}


		repaint();
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.WHITE);
		try {
			for (Point p : points) {
				g2.fillOval(p.x, p.y, 10, 10);
			}
		} catch (NullPointerException e) {
			System.out.println("Skipping painting until NullPointerException is resolved");
		}
	}
}