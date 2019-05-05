package com.niit.Sections;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Supplier {
	@Id
	@GeneratedValue
	
	private int supplierId;
	private String supplierName;
	private String supplierLocation;
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierLocation() {
		return supplierLocation;
	}
	public void setSupplierLocation(String supplierLocation) {
		this.supplierLocation = supplierLocation;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public int getSupplierId() {
		return supplierId;
}
}
