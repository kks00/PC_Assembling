package GUI;

import java.io.*;
import java.util.*;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import Item.Item;

public class ShoppingCart extends JPanel {
	HashMap<JLabel, Item> item_map;
	CartItemList cart_item_list;
	JLabel price_lbl;
	int curr_sum = 0;
	
	class CartItemList extends JPanel {
		public void add_item(Item curr_item) {
			JLabel curr_label = new JLabel(curr_item.name) {
				@Override
				protected void paintComponent(Graphics g) {
					// super.paintComponent(g);
					
					Image img = curr_item.image.getImage();
					g.drawImage(img, 0, 0, 100, 100, this);
					g.setFont(new Font("맑은 고딕", Font.BOLD, 12));
					g.drawString(curr_item.Category + ": " + curr_item.price, 0, 110);
				}
			};
			
			curr_label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					if (e.getClickCount() == 2) {
						JLabel selected_lbl = (JLabel)e.getSource();
						remove(selected_lbl);
						
						Item curr_item = item_map.get(selected_lbl);
						decrease_sum(curr_item.price);
						
						revalidate();
						repaint();
					}
				}
			});
			curr_label.setPreferredSize(new Dimension(120, 120));
			add(curr_label);
			increase_sum(curr_item.price);
			item_map.put(curr_label, curr_item);
			
			revalidate();
			repaint();
		}
		
		public CartItemList() {
			setLayout(new FlowLayout());
		}
	}
	
	public void increase_sum(String value) {
		int val = Integer.parseInt(value.replace(",", ""));
		curr_sum += val;
		price_lbl.setText("현재 합계: " + Integer.toString(curr_sum) + "원");
	}
	
	public void decrease_sum(String value) {
		int val = Integer.parseInt(value.replace(",", ""));
		curr_sum -= val;
		price_lbl.setText("현재 합계: " + Integer.toString(curr_sum) + "원");
	}
	
	class PriceInfo extends JPanel {
		public PriceInfo() {
			price_lbl = new JLabel("현재 합계: 0원"); 
			price_lbl.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			add(price_lbl);
		}
	}
	
	
	public void add_item(Item curr_item) {	
		cart_item_list.add_item(curr_item);
	}
	
	public ShoppingCart() {
		item_map = new HashMap<JLabel, Item>();
		setLayout(new BorderLayout());
		
		JLabel text_lbl = new JLabel("장바구니 (아이템을 더블클릭하면 삭제합니다)"); 
		text_lbl.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		text_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		add(text_lbl, BorderLayout.NORTH);
		
		cart_item_list = new CartItemList();
		add(new JScrollPane(cart_item_list), BorderLayout.CENTER);
		
		add(new PriceInfo(), BorderLayout.SOUTH);
		
		JButton btn_receipt = new JButton("견적서 보기");
		btn_receipt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ReceiptForm(item_map, curr_sum);
			}
		});
		add(btn_receipt, BorderLayout.EAST);
	}
}
