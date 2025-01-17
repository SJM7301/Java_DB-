package org.big.service;

import org.big.dao.DeptDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeptUpdateServiceImpl implements TableService {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String deptno = req.getParameter("deptno");
		String dname = req.getParameter("dname");
		String loc = req.getParameter("loc");
		
		DeptDAO dao = new DeptDAO();
		dao.deptUpdate(deptno, dname, loc);
	}
}
