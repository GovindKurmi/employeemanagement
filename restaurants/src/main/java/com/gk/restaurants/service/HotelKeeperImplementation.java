package com.gk.restaurants.service;

import com.gk.restaurants.Hotel;
import com.gk.restaurants.model.Menu;

public class HotelKeeperImplementation implements HotelKeeperService {

	public Menu getVegMenu() {
		Hotel v = new VegRestaurant();
		return v.getMenus();
	}

	public Menu getNonVegMenu() {
		Hotel v = new NonVegRestaurant();
		return v.getMenus();
	}

	public Menu getVegNonMenu() {
		Hotel v = new VegNonBothRestaurant();
		return v.getMenus();
	}
}
