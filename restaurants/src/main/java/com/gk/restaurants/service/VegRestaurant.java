package com.gk.restaurants.service;

import com.gk.restaurants.Hotel;
import com.gk.restaurants.model.Menu;
import com.gk.restaurants.model.VegMenu;

public class VegRestaurant implements Hotel {

	@Override
	public Menu getMenus() {
		Menu menu = new VegMenu();
		menu.setId(1);
		menu.setItem("vegResurent");

		return menu;
	}

}
