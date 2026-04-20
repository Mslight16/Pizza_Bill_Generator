package com.billGenerator;

public class Main {
	public static void main(String[] args) {
	Pizza basePizza = new Pizza(true);
	basePizza.addExtraCheese();
	basePizza.addExtraToppings();
	basePizza.takeAway();
	basePizza.getBill();
	
	DeluxPizza dp = new DeluxPizza(true);
		dp.takeAway();
		dp.getBill();
		
	}
}
