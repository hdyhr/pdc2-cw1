package com.sddevops.coursework1;


public class Items {
	protected int id;
	protected String itemName;
	protected int quantity;
	protected double price;
	
	
	public Items() {}
	
	public Items(String itemName, int quantity, double price) {
		super();
		this.itemName =itemName;
		this.quantity = quantity;
        this.price = price;
	}
	
	public Items(int id, String itemName, int quantity, double price) {
        super();
        this.id = id;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getitemName() {
        return itemName;
    }
    public void setitemName(String itemName) {
        this.itemName = itemName;
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

