package org.big.service;

import java.util.ArrayList;

import org.big.dao.DeptDAO;
import org.big.dto.DeptDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeptSelectServiceImpl implements TableService {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		DeptDAO dao = new DeptDAO();
		ArrayList<DeptDTO> select = dao.select();
		req.setAttribute("select", select);
	}
}
