package com.myco.div.unit.microservices.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversionBean {
	private Long id;
	private BigDecimal conversionMultiple;
	private BigDecimal totalCalculatedAmount;
	
	private int port;
	private String from;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	private String to;
	private BigDecimal quantity;
	
	public CurrencyConversionBean(Long id, BigDecimal conversionMultiple, BigDecimal totalCalculatedAmount, int port,
			String from, String to, BigDecimal quantity) {
		super();
		this.id = id;
		this.conversionMultiple = conversionMultiple;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.port = port;
		this.from = from;
		this.to = to;
		this.quantity = quantity;
	}
	
	public CurrencyConversionBean() {
		super();
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	

}
