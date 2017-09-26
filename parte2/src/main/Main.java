package main;

import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.Logger;

import cart.Cart;
import commands.Command;
//import database.DatabaseMethods;
import store.Store;
import main.MainMethods;
import maps.MenuButtons;
import maps.MenuButtonsMap;

public class Main {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/ecommercestore";

	static final String USER = "user";
	static final String PASS = "root";
	static final Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		
		boolean backToMenu = true;
		MenuButtonsMap menuButtonsMap = new MenuButtonsMap();
		Map<MenuButtons, Command> commandMap = menuButtonsMap.getCommandMap();
		MenuButtons[] menuButtons = MenuButtons.values();
		MainMethods mainMethods = new MainMethods();
		Scanner scan = new Scanner(System.in);
		Cart cart = new Cart();
		Store store = new Store();
//		DatabaseMethods db = new DatabaseMethods();
		
//		db.dbConnection();
//		db.dbPopulateStore(store);
//		db.dbCartPriceInitialization();
		do {
			mainMethods.showMenu();
			try {
				String chooseMenu = scan.next();
				mainMethods.setMenuButtons(menuButtons[Integer.valueOf(chooseMenu) - 1]);
				commandMap.get(mainMethods.getMenuButtons()).action(cart, store);
				if (mainMethods.getMenuButtons().equals(MenuButtons.nove))
					backToMenu = false;
			} catch (Exception e) {
			}
		} while (backToMenu == true);
		scan.close();
	}
}
