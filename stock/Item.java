package org.grocery.stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM_TBL")
public class Item {
	@GeneratedValue
	@Id
	@Column(name = "ITEM_ID")
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "QTY")
	private int quantity;
	@Column(name = "PRICE")
	private double price;
	static{
		totalNumberOfItems=0;
	}
	private static int totalNumberOfItems;
	
	public Item() {
		super();
		
	}

	public Item( String name, int quantity, double price) {
		super();
		Item.totalNumberOfItems++;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public static int getTotalNumberOfItems() {
		return totalNumberOfItems;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
