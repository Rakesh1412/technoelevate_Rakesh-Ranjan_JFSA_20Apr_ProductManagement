package com.te.productmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.productmanagement.beans.ManagerBean;
import com.te.productmanagement.beans.ProductBean;
import com.te.productmanagement.custexception.LoginException;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Override
	public ManagerBean authenticate(int id, String password) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager manager = factory.createEntityManager();
		ManagerBean infoBean = manager.find(ManagerBean.class, id);

		if (infoBean != null) {
			System.out.println("authenti");
			if (infoBean.getPassword().equals(password)) {
				return infoBean;
			} else {
				throw new LoginException("wrong password");
			}
		} else {
			throw new LoginException("Invalid ID");
		}
	}

	@Override
	public boolean deleteProductData(int id) {
		boolean isDeleted = false;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			ProductBean infoBean = manager.find(ProductBean.class, id);
			manager.remove(infoBean);
			transaction.commit();
			isDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}

		return isDeleted;
	}

	@Override
	public boolean addProduct(ProductBean productBean) {
		boolean isInserted = false;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			manager.persist(productBean);
			transaction.commit();
			isInserted = true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

		return isInserted;
	}

	@Override
	public boolean updateRecord(ProductBean productBean) {
		boolean isUpdated = false;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			ProductBean actualInfo = manager.find(ProductBean.class, productBean.getPid());

			if (productBean.getPname() != null && productBean.getPname() != "") {
				actualInfo.setPname(productBean.getPname());
			}

			if (productBean.getMfg() != null) {
				actualInfo.setMfg(productBean.getMfg());
			}
			if (productBean.getExp() != null) {
				actualInfo.setExp(productBean.getExp());
			}

			if (productBean.getPrice() > 0 ) {
				actualInfo.setPrice(productBean.getPrice());
			}
			if (productBean.getQnty() > 0 ) {
				actualInfo.setQnty(productBean.getQnty());
			}

			transaction.commit();
			isUpdated = true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

		return isUpdated;
	}

	@Override
	public List<ProductBean> getAllProducts() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("from EmployeeInfoBean");
		ArrayList<ProductBean> productBean = new ArrayList<ProductBean>();
		try {
			productBean = (ArrayList<ProductBean>) query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			productBean = null;
		}

		return productBean;
	}

}
