package GUI;

import java.io.*;
import java.util.*;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import Item.GetItem;
import GUI.ItemList;

public class MainForm extends JFrame {
	static public ItemList item_list;
	static public ShoppingCart shopping_cart;
	static public TopPanel top_panel;
	
	public MainForm() {
		super("PC Assembling");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		new GetItem();
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		item_list = new ItemList();
		c.add(new JScrollPane(item_list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);

		c.add(new MenuList(), BorderLayout.WEST);
		
		shopping_cart = new ShoppingCart();
		c.add(shopping_cart, BorderLayout.SOUTH);
		shopping_cart.setPreferredSize(new Dimension(1152, 200));
		
		top_panel = new TopPanel(); 
		c.add(top_panel, BorderLayout.NORTH);
		top_panel.setPreferredSize(new Dimension(1152, 50));
		
		setSize(1152, 1000);
		setLocation(100, 100);
		setVisible(true);
			
	}

	public static void main(String[] args) {
		new MainForm();

	}

}
