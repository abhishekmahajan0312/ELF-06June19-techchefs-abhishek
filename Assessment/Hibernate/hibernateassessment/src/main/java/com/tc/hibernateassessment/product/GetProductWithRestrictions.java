package com.tc.hibernateassessment.product;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.tc.hibernateassessment.dto.CustomerBean;
import com.tc.hibernateassessment.dto.ProductsBean;
import com.tc.hibernateassessment.util.HibernateUtil;

import lombok.extern.java.Log;

@Log
public class GetProductWithRestrictions {

	public static void main(String[] args) {

		Session session = HibernateUtil.openSession();
		Criteria criteria = session.createCriteria(ProductsBean.class).add(Restrictions.lt("price", 100.0));
		List<ProductsBean> productList = criteria.list();
		for (ProductsBean productsBean : productList) {
			log.info("Product Id: " + productsBean.getId());
			log.info("Product Name: " + productsBean.getProductName());
			log.info("Price: " + productsBean.getPrice());
			log.info("Color: " + productsBean.getColour());
			log.info("Weight: " + productsBean.getWeight());
		}
		
		productList.clear();
		criteria = session.createCriteria(ProductsBean.class).add(Restrictions.ilike("productName", "A%"));
		productList = criteria.list();
		for (ProductsBean productsBean : productList) {
			log.info("Product Id: " + productsBean.getId());
			log.info("Product Name: " + productsBean.getProductName());
			log.info("Price: " + productsBean.getPrice());
			log.info("Color: " + productsBean.getColour());
			log.info("Weight: " + productsBean.getWeight());
		}
		session.close();
	}

}
