package GUI;

import java.io.*;
import java.util.*;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import Item.Item;

class BtnPanel extends JPanel {
	public BtnPanel() {
		setLayout(new FlowLayout());
		
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

public class ReceiptForm extends JFrame {
	JTable main_table;
	
	public ReceiptForm(HashMap<JLabel, Item> loaded_items, int sum) {
		super("견적서");
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JLabel title_lbl = new JLabel("견적서 (합계: " + sum + "원)");
		title_lbl.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		title_lbl.setVerticalAlignment(JLabel.CENTER);
		title_lbl.setHorizontalAlignment(JLabel.CENTER);
		c.add(title_lbl, BorderLayout.NORTH);
		
		String[] headers = {"카테고리", "제품명", "가격"};
		
		int item_count = loaded_items.values().size();
		Iterator<Item> iter = loaded_items.values().iterator();
		String[][] data = new String[item_count][];
		for (int i = 0; i < item_count; i++) {
			data[i] = new String[3];
			
			Item curr_item = iter.next();
			data[i][0] = curr_item.Category;
			data[i][1] = curr_item.name;
			data[i][2] = curr_item.price;
		}
		main_table = new JTable(data, headers);
		
		main_table.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		main_table.getColumnModel().getColumn(0).setPreferredWidth(100);
		main_table.getColumnModel().getColumn(1).setPreferredWidth(600);
		main_table.getColumnModel().getColumn(2).setPreferredWidth(100);
		main_table.setRowHeight(50);
		
		main_table.setEnabled(false);
		
		c.add(new BtnPanel(), BorderLayout.SOUTH);
		
		c.add(new JScrollPane(main_table), BorderLayout.CENTER);
		
		setSize(800, 800);
		setLocation(200, 200);
		setVisible(true);
	}
}
