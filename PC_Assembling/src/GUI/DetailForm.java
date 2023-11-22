package GUI;

import java.io.*;
import java.util.*;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import Item.Item;

public class DetailForm extends JFrame {
	Item selected_item;
	
	class SubPanel extends JPanel {
		public SubPanel(Item selected_item) {
			//setLayout(new GridLayout(4, 1));
			setLayout(new FlowLayout());
			
			JLabel name_lbl = new JLabel(selected_item.name);
			name_lbl.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			name_lbl.setHorizontalAlignment(JLabel.CENTER);
			name_lbl.setVerticalAlignment(JLabel.CENTER);
			name_lbl.setPreferredSize(new Dimension(600, 50));
			add(name_lbl);
			
			JLabel price_lbl = new JLabel(selected_item.price);
			price_lbl.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			price_lbl.setHorizontalAlignment(JLabel.CENTER);
			price_lbl.setVerticalAlignment(JLabel.CENTER);
			price_lbl.setPreferredSize(new Dimension(600, 50));
			add(price_lbl);
			
			JTextArea spec_area = new JTextArea(selected_item.spec, 7, 40);
			spec_area.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
			spec_area.setLineWrap(true);
			spec_area.setPreferredSize(new Dimension(600, 100));
			add(new JScrollPane(spec_area), BorderLayout.SOUTH);
		}
	}
	
	class BtnPanel extends JPanel {
		public BtnPanel() {
			setLayout(new FlowLayout());
			
			JButton add_btn = new JButton("담기");
			add_btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					MainForm.shopping_cart.add_item(selected_item);
					
					JFrame parent_frm = (JFrame)SwingUtilities.getWindowAncestor((JButton)e.getSource());
					parent_frm.setVisible(false);
					parent_frm.dispose();
				}
			});
			add_btn.setPreferredSize(new Dimension(250, 40));
			add_btn.setFont(new Font("맑은 고딕", Font.BOLD, 17));
			add(add_btn);
			
			JButton close_btn = new JButton("닫기");
			close_btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame parent_frm = (JFrame)SwingUtilities.getWindowAncestor((JButton)e.getSource());
					parent_frm.setVisible(false);
					parent_frm.dispose();
				}
				
			});
			close_btn.setPreferredSize(new Dimension(250, 40));
			close_btn.setFont(new Font("맑은 고딕", Font.BOLD, 17));
			add(close_btn);
		}
	}
	
	public DetailForm(Item selected_item) {
		super(selected_item.name);
		this.selected_item = selected_item;
		setLayout(new BorderLayout());
		
		JLabel img_lbl = new JLabel(selected_item.image);
		add(img_lbl, BorderLayout.NORTH);
		JPanel sub = new SubPanel(selected_item); 
		add(sub, BorderLayout.CENTER);
		add(new BtnPanel(), BorderLayout.SOUTH);
		
		setSize(600, 850);
		setLocation(200, 200);
		setVisible(true);
	}
}
