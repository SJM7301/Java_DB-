package org.big.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.big.dto.DeptDTO;
import org.big.dto.EmpDTO;

public class DeptDAO {
	
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String userid = "scott";
	String passwd = "1111";
	
	public DeptDAO() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(driver);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void deptUpdate(String _deptno, String _dname, String _loc) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(url, userid, passwd);
			String query = "UPDATE dept SET deptno = ?, dname = ?, loc = ? WHERE deptno = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(_deptno));
			pstmt.setString(2, _dname);
			pstmt.setString(3, _loc);
			pstmt.setInt(4, Integer.parseInt(_deptno));
			
			int n = pstmt.executeUpdate();
			if (n == 1) {
				System.out.println("데이터 수정 성공!!");
			} else {
				System.out.println("데이터 수정 실패!!");	
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	public void empInput(String _empno, String _ename, String _job, String _mgr, String _hiredate, String _sal, String _comm, String _deptno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(url, userid, passwd);
			String query = "INSERT INTO emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(_empno));
			pstmt.setString(2, _ename);
			pstmt.setString(3, _job);
			pstmt.setInt(4, Integer.parseInt(_mgr));
			pstmt.setString(5, _hiredate);
			pstmt.setInt(6, Integer.parseInt(_sal));
			pstmt.setInt(7, Integer.parseInt(_comm));
			pstmt.setInt(8, Integer.parseInt(_deptno));
			
			int n = pstmt.executeUpdate();
			if (n == 1) {
				System.out.println("데이터 입력 성공!!");
			} else {
				System.out.println("데이터 입력 실패!!");	
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	public void input(String _deptno, String _dname, String _loc) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(url, userid, passwd);
			String query = "INSERT INTO dept(deptno, dname, loc) VALUES(?, ?, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(_deptno));
			pstmt.setString(2, _dname);
			pstmt.setString(3, _loc);
			
			int n = pstmt.executeUpdate();
			if (n == 1) {
				System.out.println("데이터 입력 성공!!");
			} else {
				System.out.println("데이터 입력 실패!!");	
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	public ArrayList<EmpDTO> empSelect(){
		ArrayList<EmpDTO> list = new ArrayList<EmpDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, passwd);
			String query = "SELECT * FROM emp";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int empno = rs.getInt("empno");                
				String ename = rs.getString("ename");              
				String job = rs.getString("job");                
				int mgr = rs.getInt("mgr");                 
				String hiredate = rs.getString("hiredate");          
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");              
				int deptno = rs.getInt("deptno");
				
				EmpDTO data = new EmpDTO();
				data.setEmpno(empno);
				data.setEname(ename);
				data.setJob(job);
				data.setMgr(mgr);
				data.setHiredate(hiredate);
				data.setSal(sal);
				data.setComm(comm);
				data.setDeptno(deptno);
				
				list.add(data);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return list;
	}
	
	public ArrayList<DeptDTO> select(){
		ArrayList<DeptDTO> list = new ArrayList<DeptDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, passwd);
			String query = "SELECT * FROM dept";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				
				DeptDTO data = new DeptDTO(deptno, dname, loc);
				list.add(data);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return list;
	}
	
}
