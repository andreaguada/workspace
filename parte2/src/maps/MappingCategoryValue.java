package maps;

import java.util.HashMap;
import java.util.Map;

public class MappingCategoryValue {

	private Map<Category, Value> map = new HashMap<Category, Value>();

	public Map<Category, Value> getMap() {

		map.put(Category.Pantaloni, new Value(10, 120));
		map.put(Category.Portafoglio, new Value(5, 200));
		map.put(Category.Braccialetti, new Value(1, 2000));
		map.put(Category.Orecchini, new Value(8, 180));
		map.put(Category.Orologio, new Value(40, 20000));
		map.put(Category.Armadio, new Value(120, 700));
		map.put(Category.Ombrello, new Value(5, 60));
		map.put(Category.Lenzuola, new Value(15, 30));
		map.put(Category.Giaccone, new Value(40, 560));
		map.put(Category.Giacca, new Value(30, 320));
		map.put(Category.Cappellino, new Value(7, 45));
		map.put(Category.Sedia, new Value(5, 35));
		map.put(Category.Tappeti, new Value(40, 190));
		map.put(Category.Scarpe, new Value(70, 300));
		map.put(Category.Maglietta, new Value(10, 30));
		map.put(Category.Calze, new Value(10, 30));
		map.put(Category.Elettronica, new Value(10, 5000));

		return map;
	}

	public void setMap(Map<Category, Value> map) {
		this.map = map;
	}
}
