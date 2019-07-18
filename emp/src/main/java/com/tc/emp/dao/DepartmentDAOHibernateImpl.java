package com.tc.emp.dao;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tc.emp.bean.DepartmentInfoBean;
import com.tc.emp.util.HibernateUtil;

import lombok.extern.java.Log;

@Log
public final class DepartmentDAOHibernateImpl implements DepartmentDao {

	@Override
	public boolean createDepartmentInfo(DepartmentInfoBean bean) {
		Transaction txn = null;
		try (Session session = HibernateUtil.openSession();) {

			txn = session.beginTransaction();
			session.save(bean);
			txn.commit();
			return true;
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			log.severe(Arrays.toString(e.getStackTrace()));
			
			return false;
		}
	}

//END of getEmployeeInfo(int) method

}
