package com.tc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mrg_mst_tbl")
public class MrgModel {

	private Long id;
	private String name;
	private String village;
	private int amount;
	private string gift;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="GIFT")
	public String getGift() {
		return gift;
	}
	public void setGift(String gift) {
		this.gift = gift;
	}
	@Column(name="VILLAGE")
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	@Column(name="AMOUNT")
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "MrgModel [id=" + id + ", name=" + name + ", village=" + village + ", amount=" + amount + ",gift=" + gift + "]";
	}
	
}
