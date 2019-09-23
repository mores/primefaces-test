package org.primefaces.test;

public class Pojo2 {

	private String description;
	private String id;

	public Pojo2(String id, String description) {
		this.id = id;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return (getId() != null)
				? (getClass().hashCode() + getId().hashCode())
				: super.hashCode();
	}

	@Override
	public boolean equals(Object other) {
		return (other != null && getClass() == other.getClass() && getId() != null)
				? getId().equals(((Pojo2) other).getId())
				: (other == this);
	}
}
