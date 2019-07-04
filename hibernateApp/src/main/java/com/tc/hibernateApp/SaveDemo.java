package com.tc.hibernateApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tc.hibernate.util.HibernateUtil;
import com.tc.hibernateApp.dto.EmployeeOtherInfoBean;

public class SaveDemo {
	public static void main(String[] args) {

//		Configuration cfg = new Configuration();
//		cfg.configure("hibernate.cfg.xml");
////			cfg.addAnnotatedClass(EmployeeInfoBean.class);
//
//		SessionFactory factory = cfg.buildSessionFactory();
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

//			EmployeeInfoBean empInf = new EmployeeInfoBean();
//			empInf.setId(103);
//			empInf.setName("Akshay");
//			empInf.setAge(25);
//			empInf.setGender("male");
//			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//			Date date = format.parse("2012-12-13");
//
//			empInf.setSalary(20000);
//			empInf.setPhone(9876543210l);
//			empInf.setJoiningDate(date);
//			empInf.setAccountNumber(506520102044558l);
//			empInf.setEmail("akshay@gmail.com");
//			empInf.setDesignation("Software Engineer");
//
//			empInf.setDob(format.parse("1995-02-12"));
//			empInf.setDeptId(1);
//			empInf.setMngrId(5);

		Transaction transaction = session.beginTransaction();

		EmployeeOtherInfoBean empOthInfo = new EmployeeOtherInfoBean();
		empOthInfo.setId(6);
		empOthInfo.setPan("DPDJF9988L");
		empOthInfo.setMarried(true);
		empOthInfo.setBloodGroup("B+");
		empOthInfo.setChallenged(false);
		empOthInfo.setEmergencyCNM(7894561230l);
		empOthInfo.setEmergencyCP("Paul");
		empOthInfo.setNationality("Indian");
		empOthInfo.setReligion("Sikh");
		empOthInfo.setFatherNM("Harsh");
		empOthInfo.setMotherNM("Madhu");
		empOthInfo.setSpouseNM("Diksha");
		empOthInfo.setPassport("M12388923");
		empOthInfo.setAdhar(778845515223l);
		session.saveOrUpdate(empOthInfo);
//			session.save(empInf);
//			session.save(empOthInfo);
		transaction.commit();

	}
}
