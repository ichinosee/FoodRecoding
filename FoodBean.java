package la.bean;

import java.io.Serializable;

public class FoodBean implements Serializable{
	private int code;
	private String name;
	private int calorie;
	private int quantity;



	public FoodBean(int code, String name, int calorie) {
		this.code = code;
		this.name = name;
		this.calorie = calorie;
	}



	public FoodBean(int code, String name, int calorie, int quantity) {
		this.code = code;
		this.name = name;
		this.calorie = calorie;
		this.quantity = quantity;
	}



	public FoodBean() {

	}



	public int getCode() {
		return code;
	}



	public void setCode(int code) {
		this.code = code;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getCalorie() {
		return calorie;
	}



	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}





}
