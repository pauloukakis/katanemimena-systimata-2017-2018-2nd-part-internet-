package gr.hua.dit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;



public class Car implements Serializable {

	

	/**
	 * 
	 */
	
	/**
	 * 
	 */

	
	private int id;

	
	private String ownerName;

	
	private String lastDate;

	
	private String carModel;
	
	
	private String carType;
	
	
	private int kteoPrice;
	
	

	public Car() {
		
	}

	public Car(int id,  String ownerName, String lastDate,String carModel, String carType,int kteoPrice) {
		super();
		this.id = id;
		this.ownerName = ownerName;
		this.lastDate = lastDate;
		this.carModel = carModel;
		this.carType = carType;
		this.kteoPrice = kteoPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getLastDate() {
		return lastDate;
	}

	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}
	
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public int getKteoPrice() {
		return kteoPrice;
	}

	public void setKteoPrice(int kteoPrice) {
		this.kteoPrice = kteoPrice;
	}
	
	@Override
	public String toString() {
		return "Car [id=" + id + ", ownerName=" + ownerName + ", lastDate=" + lastDate + ", carModel=" + carModel + ", carType=" + carType + ", kteoPrice=" + kteoPrice +"]";
	}
	
	

}
