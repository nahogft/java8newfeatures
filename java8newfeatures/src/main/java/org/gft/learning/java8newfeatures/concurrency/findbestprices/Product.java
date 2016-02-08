package org.gft.learning.java8newfeatures.concurrency.findbestprices;

import java.util.Random;

public class Product {
	private String description;
	private String currency = "€";
	private String shopName = "myshop";
	
	public Product(String title) {
		this.setDescription(title);
	}
	
	public int findBestPrice(){
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Random().nextInt(100);
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return String.format("[%s price is %3d%s] ", getDescription(), findBestPrice(), getCurrency());
	}


}
