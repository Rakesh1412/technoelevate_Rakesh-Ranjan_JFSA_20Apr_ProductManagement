package com.te.productmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.productmanagement.beans.ManagerBean;
import com.te.productmanagement.beans.ProductBean;
import com.te.productmanagement.dao.ProductDaoImpl;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDaoImpl dao;

	@Override
	public ManagerBean authenticate(int id, String password) {
		if (id <= 0) {
			return null;
		} else {

			return dao.authenticate(id, password);
		}
	}

	@Override
	public boolean deleteProductData(int id) {
		return dao.deleteProductData(id);
	}

	@Override
	public boolean updateRecord(ProductBean productBean) {
		// TODO Auto-generated method stub
		return dao.updateRecord(productBean);
	}

	@Override
	public List<ProductBean> getAllProducts() {
		// TODO Auto-generated method stub
		return dao.getAllProducts();
	}

	@Override
	public boolean addProduct(ProductBean productBean) {

		return dao.addProduct(productBean);

	}

}
