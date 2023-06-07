package com.kiosk.reosk.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "prod")
@IdClass(ProdId.class)
public class Prod {
	@Id
	private String mcode;
	
	@Id   
	private	String	pcode;
	
	
	private	String	pname;
	private	String	pimgurl;
	private Integer price;
	
	@ManyToOne
    @JoinColumn(name = "mcode", insertable = false, updatable = false)
    private Menu menu;
	
}
