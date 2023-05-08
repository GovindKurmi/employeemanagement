package com.gk.restaurants.service;

import com.gk.restaurants.model.Menu;

public interface HotelKeeperService {

	public Menu getVegMenu();

	public Menu getNonVegMenu();

	public Menu getVegNonMenu();
}
