package GUI;

import java.io.*;
import java.util.*;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import Item.Item;
import Item.GetItem;

public class ItemList extends JPanel {
	String curr_category;
	HashMap<JLabel, Item> labels;
	
	public void reload_items(String Category, Vector<Item> item_list) {
		curr_category = Category;
		
		Iterator<JLabel> label_iter = labels.keySet().iterator();
		while (label_iter.hasNext()) {
			JLabel curr_label = label_iter.next();
			remove(curr_label);
		}
		labels.clear();
		
		Iterator<Item> item_iter = item_list.iterator();
		while (item_iter.hasNext()) {
			Item curr_item = item_iter.next();
			JLabel curr_label = new JLabel(curr_item.name) {
				@Override
				public void paintComponent(Graphics g) {
					// super.paintComponent(g);
					Image img = curr_item.image.getImage();
					g.drawImage(img, 0, 0, 100, 100, this);
					g.setFont(new Font("맑은 고딕", Font.BOLD, 13));
					g.drawString(curr_item.price, 0, 110);
				}
			};
			
			curr_label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					if (e.getClickCount() == 2) {
						JLabel selected_lbl = (JLabel)e.getSource();
						new DetailForm(labels.get(selected_lbl));
					}
				}
			});
			
			curr_label.setVerticalAlignment(SwingConstants.CENTER);
	
			labels.put(curr_label, curr_item);
			add(curr_label);
		}
		
		revalidate();
		repaint();
	}

	public ItemList() {
		labels = new HashMap<JLabel, Item>();
		setLayout(new GridLayout(5, 3, 20, 20));
		
	}

}
