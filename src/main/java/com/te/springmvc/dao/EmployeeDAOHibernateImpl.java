package com.te.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.springmvc.beans.EmployeeBean;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	@Override
	public EmployeeBean authenticate(int id, String pwd) {

		EntityManagerFactory factory = null;
		EntityManager manager = null;

		try {
			factory = Persistence.createEntityManagerFactory("empData");
			manager = factory.createEntityManager();

			EmployeeBean bean = manager.find(EmployeeBean.class, id);

			if (bean != null) {
				if (bean.getPassword().equals(pwd)) {
					System.out.println("Login Sucess");
					return bean;
				} else {
					System.out.println("Invalid Credentails");
					return null;
				}
			} else {
				System.out.println("User Not Found");
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (factory != null) {
				factory.close();
			}
			if (manager != null) {
				manager.close();
			}
		}

	}// end of authenticate

	@Override
	public EmployeeBean getEmployee(int id) {

		EntityManagerFactory factory = null;
		EntityManager manager = null;

		try {
			factory = Persistence.createEntityManagerFactory("empData");
			manager = factory.createEntityManager();

			EmployeeBean bean = manager.find(EmployeeBean.class, id);

			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (factory != null) {
				factory.close();
			}
			if (manager != null) {
				manager.close();
			}
		}

	}// end of getEmployee

	@Override
	public boolean delEmpData(int id) {

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {
			factory = Persistence.createEntityManagerFactory("empData");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();

			transaction.begin();

			EmployeeBean bean = manager.find(EmployeeBean.class, id);
			if (bean != null) {
				manager.remove(bean);
				transaction.commit();
				return true;
			} else {

				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (factory != null) {
				factory.close();
			}
			if (manager != null) {
				manager.close();
			}
		}

	}// end of delEmpData

	@Override
	public List<EmployeeBean> getAllEmp() {

		EntityManagerFactory factory = null;
		EntityManager manager = null;

		try {
			factory = Persistence.createEntityManagerFactory("empData");
			manager = factory.createEntityManager();

			String data = "from EmployeeBean";

			Query query = manager.createQuery(data);

			List<EmployeeBean> empBeans = query.getResultList();

			if (empBeans != null) {
				return empBeans;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (factory != null) {
				factory.close();
			}
			if (manager != null) {
				manager.close();
			}
		}

	}// end of getAllEmp

}
// end of class
