package Item;

import java.io.*;
import java.util.*;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class GetItem {
	public static HashMap<String, Vector<Item>> Items = new HashMap<String, Vector<Item>>();
	
	public static boolean GetCategoryData(String category_name, Vector<Item> item_list) {
		try {
			String file_name = "Datas/".concat(category_name).concat(".txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file_name), "MS949"));
			
			while (true) {
				String line_data = br.readLine();
				if (line_data == null)
					break;
				
				Item new_item = new Item(category_name, line_data);
				item_list.add(new_item);
			}
			
			br.close();
			return true;
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
	}

	public GetItem() {				
		for (int i = 0; i < Item.categories.length; i++) {
			String curr_category = Item.categories[i];
			Vector<Item> curr_items = new Vector<Item>();
			if (GetCategoryData(curr_category, curr_items)) {
				Items.put(curr_category, curr_items);
			} else {
				System.out.println(curr_category + " 아이템 정보 가져오기 실패");
			}
		}
	}

}
