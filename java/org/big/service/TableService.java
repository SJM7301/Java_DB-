package org.big.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface TableService {
	public void execute(HttpServletRequest req, HttpServletResponse resp);
}
