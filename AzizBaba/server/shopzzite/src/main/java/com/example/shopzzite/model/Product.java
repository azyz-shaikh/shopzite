package com.example.shopzzite.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@SQLDelete(sql="UPDATE product SET is_deleted= true WHERE p_id=?")
@Where(clause =" is_deleted=false")
@Entity
public class Product {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pId;
	
	private String pName;
	@Column(length = 3000)
	private String pDesc;
	private int pPrice;
	private String pPhoto;
	private Boolean is_deleted=false;
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	@ManyToOne()
	private Category category;
	
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpDesc() {
		return pDesc;
	}
	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	public String getpPhoto() {
		return pPhoto;
	}
	public void setpPhoto(String pPhoto) {
		this.pPhoto = pPhoto;
	}
	public Product(String pName, String pDesc, int pPrice, String pPhoto ,Category category) {
		super();
		this.pName = pName;
		this.pDesc = pDesc;
		this.pPrice = pPrice;
		this.pPhoto = pPhoto;
		this.category=category;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
