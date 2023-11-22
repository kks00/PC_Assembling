package Item;

import java.util.*;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Item {
	public static String[] categories = {"CPU", "HDD", "SSD", "그래픽카드", "메모리", "메인보드", "케이스", "쿨러", "파워"};
	
	public String Category;
	public int index;
	public String name;
	public String price;
	public String spec;
	public ImageIcon image;
	
	public static ImageIcon getImageIcon(String category_name, int index) {
		String file_name = "Datas/".concat(category_name).concat("/").concat(Integer.toString(index)).concat(".jpg");
		return new ImageIcon(file_name);
	}

	public Item(String Category, String data_line) {
		this.Category = Category;
		
		String[] splited_data = data_line.split("\\|");
		
		index = Integer.parseInt(splited_data[0]);
		name = splited_data[1];
		price = splited_data[2];
		spec = splited_data[3];
		
		image = getImageIcon(Category, index);
	}
}
