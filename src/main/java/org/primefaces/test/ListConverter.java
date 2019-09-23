package org.primefaces.test;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.primefaces.model.DualListModel;
import org.primefaces.component.picklist.PickList;

@FacesConverter(value = "ListConverter")
public class ListConverter implements javax.faces.convert.Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Object ret = null;
		if (component instanceof PickList) {
			Object dualList = ((PickList) component).getValue();
			DualListModel dl = (DualListModel) dualList;
			for (Object o : dl.getSource()) {
				String id = "" + ((Pojo2) o).getId();
				if (value.equals(id)) {
					ret = o;
					break;
				}
			}
			if (ret == null)
				for (Object o : dl.getTarget()) {
					String id = "" + ((Pojo2) o).getId();
					if (value.equals(id)) {
						ret = o;
						break;
					}
				}
		}
		return ret;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		String str = "";
		if (value instanceof Pojo2) {
			str = "" + ((Pojo2) value).getId();
		}
		return str;
	}
}
