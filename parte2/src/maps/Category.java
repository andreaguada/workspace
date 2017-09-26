package maps;

import java.util.Arrays;
import java.util.Comparator;

public enum Category {

	Calze, Maglietta, Pantaloni, Cappellino, Elettronica, Ombrello, Lenzuola, Tappeti, Armadio, 
	Sedia, Giacca, Giaccone, Portafoglio, Orologio, Orecchini, Braccialetti, Scarpe, Pannolini;

	public static Category[] alphabeticalOrder() {
		Category[] orderedCategories = Category.values();
		Arrays.sort(orderedCategories, new Comparator<Category>() {
			@Override
			public int compare(Category item1, Category item2) {
				return item1.toString().compareTo(item2.toString());
			}
		});
		return orderedCategories;
	}

	public static Category getRandomCategory() {
		return values()[(int) (Math.random() * values().length)];
	}

}
