package org.anurag.HibernateSpring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.anurag.HibernateSpring.DAO.AppDaoImp;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.anurag.HibernateSpring.model.User;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		ModelAndView model = new ModelAndView("home");
		List<User> users = new ArrayList<User>();
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/org/anurag/HibernateSpring/DAO/Spring-AppDaoConfig.xml");
		AppDaoImp DAO = context.getBean("daoBean" , AppDaoImp.class);
		
		users = DAO.listUsers();
		System.out.println(users);
		model.addObject("users" , users);
		return model;
	}
}
