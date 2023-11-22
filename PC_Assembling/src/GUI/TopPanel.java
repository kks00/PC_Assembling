package GUI;

import java.io.*;
import java.util.*;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class TopPanel extends JPanel {
	public TopPanel() {
		setLayout(new FlowLayout());
		
		JLabel title_lbl = new JLabel("PC Assembling");
		title_lbl.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		title_lbl.setVerticalAlignment(JLabel.CENTER);
		title_lbl.setHorizontalAlignment(JLabel.CENTER);
		add(title_lbl);
	}
}
