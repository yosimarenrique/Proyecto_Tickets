package org.tickets.modelo;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.tickets.bean.Empleado;
import org.tickets.utils.HibernateUtil;

@Stateless
public class EmpleadoDao {

	//@PersistenceContext
	private EntityManager entityManager;
	
	private Session session;

	public Empleado verificarDatos(Empleado empleado) throws Exception {
		Empleado emp = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM empleado WHERE email = '" + empleado.getEmail()
					+ "' and clave = '" + empleado.getClave() + "'";
			Query query = session.createQuery(hql);

			List<Empleado> empleados = entityManager.createNamedQuery("sds", Empleado.class)
				.setParameter("nombre", "va.lor")
				.getResultList();
			
			if (!query.list().isEmpty()) {
				emp = (Empleado) query.list().get(0);
			}

		} catch (Exception e) {
			throw e;
		}

		return emp;
		
	}

}
