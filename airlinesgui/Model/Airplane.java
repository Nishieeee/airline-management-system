package com.mycompany.airlinesgui.Model;

public class Airplane {
	
	private int id;
	private int EconomyCapacity;
	private int BusinessCapacity;
	private String model;
	
	public Airplane() {}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setEconomyCapacity(int EconomyCapacity) {
		this.EconomyCapacity = EconomyCapacity;
	}
	
	public int getEconomyCapacity() {
		return EconomyCapacity;
	}
	
	public void setBusinessCapacity(int BusinessCapacity) {
		this.BusinessCapacity = BusinessCapacity;
	}
	
	public int getBusinessCapacity() {
		return BusinessCapacity;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getModel() {
		return model;
	}
	
	public String[] getData() {
		return new String[] {
			String.valueOf(id),
			String.valueOf(EconomyCapacity),
			String.valueOf(BusinessCapacity),
			model
		};
	}

}
