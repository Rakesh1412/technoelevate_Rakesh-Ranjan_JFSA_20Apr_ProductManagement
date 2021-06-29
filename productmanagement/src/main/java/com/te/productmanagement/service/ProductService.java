package com.te.productmanagement.service;

import java.util.List;

import com.te.productmanagement.beans.ManagerBean;
import com.te.productmanagement.beans.ProductBean;

public interface ProductService {

	public ManagerBean authenticate(int id, String password);

//	public ProductBean getProductData(int id);

	public boolean deleteProductData(int id);

	public boolean addProduct(ProductBean productBean);

	public boolean updateRecord(ProductBean productBean);

	public List<ProductBean> getAllProducts();

}
