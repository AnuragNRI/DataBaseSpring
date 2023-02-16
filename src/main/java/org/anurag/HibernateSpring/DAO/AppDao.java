package org.anurag.HibernateSpring.DAO;

import java.util.List;

import org.anurag.HibernateSpring.model.User;

public interface AppDao {
	public List<User> listUsers();
}
