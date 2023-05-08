package com.gk.restaurants.service;

import com.gk.restaurants.Hotel;
import com.gk.restaurants.model.Both;
import com.gk.restaurants.model.Menu;

public class VegNonBothRestaurant implements Hotel {

	public Menu getMenus() {
		Menu b = new Both();
		b.setId(0);
		b.setItem("vegNonBoth");
		return b;
	}
}
