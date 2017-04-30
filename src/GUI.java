package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI extends JFrame {
	final Dimension FRAME_SIZE = new Dimension(1200, 800);
	final Dimension CONTROL_BUTTON_SIZE = new Dimension(200, 100);
	ArrayList<String> hexColors = new ArrayList<String>();
	int colorPointer = 0;

	JPanel graphicsWrapper = new JPanel();

	public GUI() {
		addDefaultColors();

		graphicsWrapper.setSize(FRAME_SIZE.width, FRAME_SIZE.height);
		graphicsWrapper.setBackground(hex2Rgb(hexColors.get(0)));
		add(graphicsWrapper, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(FRAME_SIZE.width, 2*FRAME_SIZE.height);
		setVisible(true);
		makeControlPanel();
	}

	private void makeControlPanel() {
		JFrame controlFrame = new JFrame();
		controlFrame.setLayout(new FlowLayout());
		controlFrame.setSize(CONTROL_BUTTON_SIZE.width, CONTROL_BUTTON_SIZE.height);

		JButton changeBGButton = new JButton();
		changeBGButton.setText("Change Background Color");
		changeBGButton.setPreferredSize(CONTROL_BUTTON_SIZE);

		changeBGButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (colorPointer == hexColors.size() - 1) colorPointer = 0;
				else colorPointer++;
				graphicsWrapper.setBackground(hex2Rgb(hexColors.get(colorPointer)));
				graphicsWrapper.repaint();
			}
		});

		controlFrame.add(changeBGButton);

		JButton constelationButton = new JButton();
		constelationButton.setText("Constelation");
		constelationButton.setPreferredSize(CONTROL_BUTTON_SIZE);

		constelationButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println(e.getClickCount());
				if (e.getClickCount() % 2 == 1) {
					graphicsWrapper.add(new Constelations(FRAME_SIZE));
					graphicsWrapper.repaint();
				} else {
					graphicsWrapper.remove(graphicsWrapper.getComponent(0));
					repaint();
				}
			}
		});

		controlFrame.add(constelationButton);

		controlFrame.setLocation(new Point(FRAME_SIZE.width + 10, 0));
		controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		controlFrame.setVisible(true);
	}

	public static Color hex2Rgb(String colorStr) {
		return new Color(
			Integer.valueOf(colorStr.substring(1,3), 16),
			Integer.valueOf(colorStr.substring(3,5), 16),
			Integer.valueOf(colorStr.substring(5,7), 16));
	}

	public void addDefaultColors() {
		hexColors.add("#768ca0");
		hexColors.add("#accbe7");
		hexColors.add("#38689a");
	}
}