package com.kiosk.reosk.entity;

import java.io.Serializable;
import java.util.Objects;

public class ProdId implements Serializable{

	private	String	mcode;
	private	String	pcode;
	
	
	public	ProdId() {};
	public	ProdId(String mcode, String pcode) {
		this.mcode	=	mcode;
		this.pcode	=	pcode;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdId prodId = (ProdId) o;
        return 	Objects.equals(mcode, prodId.mcode) &&
                Objects.equals(pcode, prodId.pcode);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(mcode, pcode);
	}
	
	
}
