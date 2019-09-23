package org.primefaces.test;

import javax.faces.bean.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.annotation.PostConstruct;

@ManagedBean(name = "systemBean", eager = true)
@ApplicationScoped
public class SystemBean implements java.io.Serializable {
	private java.util.List<Pojo2> pojos;
	private java.util.Map<String, Pojo2> lookup;

	public SystemBean() {
	}

	@PostConstruct
	public void init() {

		pojos = new java.util.ArrayList<>();
		lookup = new java.util.HashMap<>();

		Pojo2 one = new Pojo2( "1", "AAA" );
		lookup.put( one.getId(), one );
		pojos.add( one );

		one = new Pojo2( "2", "BBBB" );
		lookup.put( one.getId(), one );
                pojos.add( one );

		one = new Pojo2( "3", "CCC" );
		lookup.put( one.getId(), one );
                pojos.add( one );

		one = new Pojo2( "4", "DDD" );
		lookup.put( one.getId(), one );
                pojos.add( one );

		one = new Pojo2( "5", "EEE" );
		lookup.put( one.getId(), one );
                pojos.add( one );

		one = new Pojo2( "6", "FFF" );
		lookup.put( one.getId(), one );
                pojos.add( one );
	}
	public java.util.List<Pojo2> getPojo2s() {
		return pojos;
	}

	public Pojo2 getPojo2(String id) {
		if (id != null) {
			return lookup.get(id);
		}

		return null;
	}
}
