package org.big.controller;

import java.io.IOException;

import org.big.service.DeptInsertServiceImpl;
import org.big.service.DeptSelectServiceImpl;
import org.big.service.DeptUpdateServiceImpl;
import org.big.service.EmpInsertServiceImpl;
import org.big.service.EmpSelectServiceImpl;
import org.big.service.TableService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class FrontController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reqURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String serv = reqURI.substring(contextPath.length());
		System.out.println("serv = " + serv);
		
		TableService service = null;
		String nextPage = null;
		
		if (serv.equals("/select.do")) {
			service = new DeptSelectServiceImpl();
			service.execute(req, resp);
			nextPage = "select.jsp";
		}
		if (serv.equals("/empSelect.do")) {
			service = new EmpSelectServiceImpl();
			service.execute(req, resp);
			nextPage = "empSelect.jsp";
		}
		if (serv.equals("/insertData.do")) {
			nextPage = "insert.jsp";
		}
		if (serv.equals("/insert.do")) {
			service = new DeptInsertServiceImpl();
			service.execute(req, resp);
			nextPage = "select.do";
		}
		if (serv.equals("/empInsertData.do")) {
			nextPage = "empInsert.jsp";
		}
		if (serv.equals("/empInsert.do")) {
			service = new EmpInsertServiceImpl();
			service.execute(req, resp);
			nextPage = "empSelect.do";
		}
		if (serv.equals("/updateData.do")) {
			nextPage = "update.jsp";
		}
		if (serv.equals("/update.do")) {
			service = new DeptUpdateServiceImpl();
			service.execute(req, resp);
			nextPage = "select.do";
		}
		
		
		RequestDispatcher dis = req.getRequestDispatcher(nextPage);
		dis.forward(req, resp);
	}
}






