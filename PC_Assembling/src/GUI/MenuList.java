package GUI;

import java.io.*;
import java.util.*;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import Item.GetItem;
import Item.Item;

public class MenuList extends JPanel {
	public MenuList() {
		setLayout(new GridLayout(Item.categories.length, 1));
		for (int i = 0; i < Item.categories.length; i++) {
			String curr_category = Item.categories[i];
			JButton curr_btn = new JButton(curr_category);
			
			curr_btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String btn_caption = ((JButton)e.getSource()).getText();
					MainForm.item_list.reload_items(btn_caption, GetItem.Items.get(btn_caption));
				}
			});
			
			add(curr_btn);
		}
	}
}
