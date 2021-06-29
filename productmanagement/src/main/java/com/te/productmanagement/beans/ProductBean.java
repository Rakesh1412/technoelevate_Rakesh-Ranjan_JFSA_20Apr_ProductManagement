package com.te.productmanagement.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
public class ProductBean implements Serializable {
	@Id
	private int pid;
	private String pname;
	private Date mfg;
	private Date exp;
	private int price;
	private int qnty;
	
}
