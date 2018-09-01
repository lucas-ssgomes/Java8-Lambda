package Estudo;

import java.util.Arrays;
import java.util.List;

public class Notes2 {
	
	public static void main(String[] args) {
		List<String> itens = 
				Arrays.asList("item1", "item2", "item3", "item4");
	
		for(String str : itens) {
			System.out.println(str);
		}
		
		System.out.println("");
		itens.forEach((str) -> System.out.println(str));
	
	}

}
