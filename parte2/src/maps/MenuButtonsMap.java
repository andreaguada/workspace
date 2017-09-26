package maps;

import java.util.HashMap;
import java.util.Map;
import commands.Command;
import commands.Command1;
import commands.Command2;
import commands.Command3;
import commands.Command4;
import commands.Command5;
import commands.Command6;
import commands.Command7;
import commands.Command8;
import commands.Command9;

public class MenuButtonsMap {

	private Map<MenuButtons, Command> commandMap = new HashMap<MenuButtons, Command>();

	public Map<MenuButtons, Command> getCommandMap() {

		commandMap.put(MenuButtons.uno, new Command1());
		commandMap.put(MenuButtons.due, new Command2());
		commandMap.put(MenuButtons.tre, new Command3());
		commandMap.put(MenuButtons.quattro, new Command4());
		commandMap.put(MenuButtons.cinque, new Command5());
		commandMap.put(MenuButtons.sei, new Command6());
		commandMap.put(MenuButtons.sette, new Command7());
		commandMap.put(MenuButtons.otto, new Command8());
		commandMap.put(MenuButtons.nove, new Command9());
		
		return commandMap;
	}

	public void setCommandMap(Map<MenuButtons, Command> commandMap) {
		this.commandMap = commandMap;
	}
}
