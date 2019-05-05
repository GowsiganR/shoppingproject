package com.niit.DAO;

import java.util.List;

import com.niit.Sections.Supplier;

public interface SupplierDAO {
	public boolean addSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public boolean deleteSupplier(Supplier supplier);
	public List<Supplier> getSuppliersList();
    public Supplier getSupplier(int supplierId);
}
