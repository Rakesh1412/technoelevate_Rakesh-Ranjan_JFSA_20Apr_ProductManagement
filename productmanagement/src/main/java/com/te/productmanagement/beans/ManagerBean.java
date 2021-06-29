package com.te.productmanagement.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@Entity
public class ManagerBean implements Serializable {
	
	@Id
	private int id;
	private String name;
	private String password;
}
