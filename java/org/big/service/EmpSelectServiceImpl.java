package org.big.service;

import java.util.ArrayList;

import org.big.dao.DeptDAO;
import org.big.dto.EmpDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmpSelectServiceImpl implements TableService {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		DeptDAO dao = new DeptDAO();
		ArrayList<EmpDTO> empSelect = dao.empSelect();
		req.setAttribute("empSelect", empSelect);
	}
}
