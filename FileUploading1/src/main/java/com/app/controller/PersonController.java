package com.app.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Person;
import com.app.util.HibernateUtil;

@WebServlet("/upload")
@MultipartConfig(maxFileSize = 16234234)
public class PersonController extends HttpServlet {
	private static final long serialVersionUID=1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Person person=new Person();
		person.setName(req.getParameter("name"));
		Part part=req.getPart("image");
		InputStream is=null;
		if(part!=null) 
			is=part.getInputStream();
		byte[] data=new byte[is.available()];
		is.read(data);
		person.setImage(data);
		Transaction tx=null;
		
		try(Session session=HibernateUtil.getSessionFactory().openSession()) {
			tx=session.beginTransaction();
			session.persist(person);
			tx.commit();
			req.setAttribute("message","File Uploaded");
		} catch (Exception e) {
			req.setAttribute("message","problem");
		}
		req.getRequestDispatcher("upload.jsp").forward(req, resp);;
	}
}
