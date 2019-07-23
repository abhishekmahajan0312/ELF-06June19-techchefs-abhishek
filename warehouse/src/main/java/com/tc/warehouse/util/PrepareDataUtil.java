package com.tc.warehouse.util;

import com.tc.warehouse.beans.ItemBean;

public class PrepareDataUtil {

	private PrepareDataUtil() {
	}

	public static ItemBean prepareData(int id) {

		ItemBean itemBean = new ItemBean();
		itemBean.setItemID(id);
		itemBean.setName("XBox");
		itemBean.setQuantity(500);
		itemBean.setDescription("Microsoft");
		itemBean.setCost(50000);
		return itemBean;

	}
}// End of Class
