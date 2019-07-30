package com.tc.empspring2.dao;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.tc.empspring2.beans.EmployeeInfoBean;
import com.tc.empspring2.util.HibernateUtil;

import lombok.extern.java.Log;

@Log
public final class EmployeeDAOHibernateImpl implements EmployeeDao {

	public List<EmployeeInfoBean> getAllEmployeeInfo() {
		List<EmployeeInfoBean> beans = null;
		try (Session session = HibernateUtil.openSession();) {
			String hql = "from EmployeeInfoBean";
			Query query = session.createQuery(hql);
			beans = query.list();
		}
		return beans;

	}
	
	public List<EmployeeInfoBean> getAllEmployeeInfoWithRestrictions(String condition){
		try (Session session = HibernateUtil.openSession();) {
		String hql = "from EmployeeInfoBean where str(id) like :id";
		Query query = session.createQuery(hql);
//		query.setParameter("name", condition+"%");
		query.setParameter("id", condition+"%");
//		Criteria criteria = session.createCriteria(EmployeeInfoBean.class).add(Restrictions.like("id", Integer.parseInt(condition)));
		List<EmployeeInfoBean> beans = query.list();
		return beans;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public EmployeeInfoBean getEmployeeInfo(String id) {
		try {
			return getEmployeeInfo(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		}

	}

	public EmployeeInfoBean getEmployeeInfo(int id) {
		try (Session session = HibernateUtil.openSession();) {

			// 3. Open Session

			// 4. Interact with the DB via Session
			EmployeeInfoBean bean = session.get(EmployeeInfoBean.class, id);

			// 5. Close Session
			session.close();

			return bean;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private boolean saveOrUpdate(EmployeeInfoBean bean) {
		Transaction txn = null;
		try (Session session = HibernateUtil.openSession();) {
			txn = session.beginTransaction();
			session.saveOrUpdate(bean);
			txn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if (txn != null) {
				txn.rollback();
			}
			return false;
		}
	}

	@Override
	public boolean createEmployeeInfo(EmployeeInfoBean bean) {
		// TODO Auto-generated method stub
		return saveOrUpdate(bean);

	}

	@Override
	public boolean updateEmployeeInfo(EmployeeInfoBean bean) {
		// TODO Auto-generated method stub
		return saveOrUpdate(bean);
	}

	@Override
	public boolean deleteEmployeeInfo(int id) {
		Transaction txn = null;
		EmployeeInfoBean bean = new EmployeeInfoBean();
		bean.setId(id);
		try (Session session = HibernateUtil.openSession();) {

			txn = session.beginTransaction();
			session.delete(bean);
			txn.commit();
			return true;
		} catch (Exception e) {
			log.severe(Arrays.toString(e.getStackTrace()));
			if (txn != null) {
				txn.rollback();
			}
			return false;
		}
	}

	@Override
	public boolean deleteEmployeeInfo(String id) {
		// TODO Auto-generated method stub
		return deleteEmployeeInfo(Integer.parseInt(id));
	}

//END of getEmployeeInfo(int) method

}
