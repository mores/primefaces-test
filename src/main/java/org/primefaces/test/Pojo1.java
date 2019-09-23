package org.primefaces.test;

public class Pojo1 {

	private Pojo2 defaultPojo2;
	private java.util.List<Pojo2> pojos;

	public Pojo2 getDefaultPojo2() {
		return defaultPojo2;
	}

	public void setDefaultPojo2(Pojo2 defaultPojo2) {
		this.defaultPojo2 = defaultPojo2;
	}

	public java.util.List<Pojo2> getPojo2s() {
		return pojos;
	}

	public void setPojo2s(java.util.List<Pojo2> pojos) {
		this.pojos = pojos;
	}
}
