package com.te.productmanagement.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.productmanagement.beans.ManagerBean;
import com.te.productmanagement.beans.ProductBean;
import com.te.productmanagement.dao.ProductDaoImpl;
import com.te.productmanagement.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String authenticate(int id, String password, HttpServletRequest request, ModelMap map) {
		ManagerBean infoBean = service.authenticate(id, password);
		System.out.println(infoBean);
		if (infoBean != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loggedIn", infoBean);
//			session.setMaxInactiveInterval(3600);
			map.addAttribute("name", infoBean.getName());
			return "home";
		} else {
			map.addAttribute("errMsg", "Invalid Credentials");
			return "login";
		}
	}

	@GetMapping("/addForm")
	public String getAddFrom(@SessionAttribute(name = "loggedIn", required = false) ManagerBean infoBean,
			ModelMap map) {
		if (infoBean != null) {
			return "add";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "login";
		}

	}

	@GetMapping("/add")
	public String addProduct(ProductBean productBean,
			@SessionAttribute(name = "loggedIn", required = false) ManagerBean infoBean, ModelMap map) {
		System.out.println("in method");
		if (infoBean != null) {
			System.out.println("in if");
			if (service.addProduct(productBean)) {
				map.addAttribute("msg", "Successfully Inserted");
			} else {
				map.addAttribute("msg", "Failed to Insert");
			}
			return "home";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "login";
		}

	}

	@GetMapping("/deleteForm")
	public String getDeleteForm(@SessionAttribute(name = "loggedIn", required = false) ManagerBean infoBean,
			ModelMap map) {
		if (infoBean != null) {
			return "delete";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "login";
		}
	}

	@GetMapping("/delete")
	public String deleteData(int id, @SessionAttribute(name = "loggedIn", required = false) ManagerBean infoBean,
			ModelMap map) {
		if (infoBean != null) {
			if (service.deleteProductData(id)) {
				map.addAttribute("msg", "Data Deleted successfully for id : " + id);
			} else {
				map.addAttribute("msg", "Could not find Record for id : " + id);
			}
			return "delete";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "login";
		}

	}

	@GetMapping("/updateForm")
	public String getUpadatePage(@SessionAttribute(name = "loggedIn", required = false) ManagerBean infoBean,
			ModelMap map) {
		if (infoBean != null) {
			map.addAttribute("id", infoBean);
			return "updateEmployee";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "login";

		}
	}

	@PostMapping("/update")
	public String updateProductData(@SessionAttribute(name = "loggedIn", required = false) ManagerBean infoBean,
			ModelMap map, ProductBean productBean) {
		if (infoBean != null) {
			if (service.updateRecord(productBean)) {
				map.addAttribute("msg", "Updated Successfully");
				map.addAttribute("id", productBean);
			} else {
				map.addAttribute("msg", "Updation Failed");
				map.addAttribute("id", infoBean);
			}
			return "updateEmployee";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "login";
		}
	}

	@GetMapping("/getData")
	public String getAllRecords(@SessionAttribute(name = "loggedIn", required = false) ProductBean infoBean,
			ModelMap map) {
		if (infoBean != null) {
			List<ProductBean> productBeans = service.getAllProducts();
			if (productBeans != null) {

				map.addAttribute("list", productBeans);
			} else {
				map.addAttribute("errMsg", "No Records Found");
			}
			map.addAttribute("name", infoBean.getPname());
			return "home";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "login";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap map) {
		session.invalidate();
		map.addAttribute("msg", "logout successfull");
		return "empLogin";
	}// logout

}
