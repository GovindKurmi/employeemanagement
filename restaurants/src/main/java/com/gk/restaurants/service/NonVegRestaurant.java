package com.gk.restaurants.service;

import com.gk.restaurants.Hotel;
import com.gk.restaurants.model.Menu;
import com.gk.restaurants.model.NonVegMenu;

public class NonVegRestaurant implements Hotel {

	@Override
	public Menu getMenus() {
		Menu menu = new NonVegMenu();
		menu.setId(1);
		menu.setItem("vegNonResurent");

		return menu;
	}

}
