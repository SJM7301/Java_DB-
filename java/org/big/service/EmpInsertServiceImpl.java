package org.big.service;

import org.big.dao.DeptDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmpInsertServiceImpl implements TableService {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String empno = req.getParameter("empno");
		String ename = req.getParameter("ename");
		String job = req.getParameter("job");
		String mgr = req.getParameter("mgr");
		String hiredate = req.getParameter("hiredate");
		String sal = req.getParameter("sal");
		String comm = req.getParameter("comm");
		String deptno = req.getParameter("deptno");
		
		DeptDAO dao = new DeptDAO();
		dao.empInput(empno, ename, job, mgr, hiredate, sal, comm, deptno);
		
	}
}
