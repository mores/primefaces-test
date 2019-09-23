package org.primefaces.test;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.enterprise.context.ApplicationScoped;

@ManagedBean(name = "testView")
@ApplicationScoped
public class TestView implements Serializable {

	private String testString;

	private java.util.List<Pojo2> allPojo2s;
	private org.primefaces.model.DualListModel<Pojo2> pojos;
	private Pojo1 pojo1;

	@ManagedProperty("#{systemBean}")
	private SystemBean systemBean;

	@PostConstruct
	public void init() {
		testString = "Welcome to PrimeFaces!!!";

		allPojo2s = systemBean.getPojo2s();

		java.util.List<Pojo2> source = new java.util.ArrayList<Pojo2>();
		java.util.List<Pojo2> target = new java.util.ArrayList<Pojo2>();

		pojo1 = new Pojo1();
		java.util.List<Pojo2> pojo1Pojo2s = new java.util.ArrayList<Pojo2>();
		pojo1Pojo2s.add(allPojo2s.get(0));
		pojo1Pojo2s.add(allPojo2s.get(1));
		pojo1Pojo2s.add(allPojo2s.get(2));
		pojo1.setPojo2s(pojo1Pojo2s);

		source = org.apache.commons.collections.ListUtils.subtract(allPojo2s,
				pojo1.getPojo2s());
		target = pojo1.getPojo2s();

		pojos = new org.primefaces.model.DualListModel<Pojo2>(source, target);
	}
	public org.primefaces.model.DualListModel<Pojo2> getPojo2s() {
		return pojos;
	}

	public void setPojo2s(org.primefaces.model.DualListModel<Pojo2> pojos) {
		this.pojos = pojos;
	}

	public Pojo1 getPojo1() {
		return pojo1;
	}

	public void setPojo1(Pojo1 pojo1) {
		this.pojo1 = pojo1;
	}

	public SystemBean getSystemBean() {
		return systemBean;
	}

	public void setSystemBean(SystemBean systemBean) {
		this.systemBean = systemBean;
	}

	public String getTestString() {
		return testString;
	}

	public void setTestString(String testString) {
		this.testString = testString;
	}

	public String editSave() {
		return null;
	}
}
