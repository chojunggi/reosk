package com.kiosk.reosk.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Menu {

	@Id
	private	String	mcode;
	
	private	String	mname;
	private	String	mimgurl;
	
}
