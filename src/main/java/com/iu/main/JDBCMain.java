package com.iu.main;

import com.iu.main.departments.DepartmentControllar;
import com.iu.main.departments.DepartmentDAO;
import com.iu.main.employees.EmployeeControllar;
import com.iu.main.locations.LocationControllar;
import com.iu.main.locations.LocationDAO;
import com.iu.main.util.DBConnection;

public class JDBCMain {

	public static void main(String[] args) {
		System.out.println("start");
		
		DepartmentControllar dc = new DepartmentControllar();
		LocationControllar lc = new LocationControllar();
		EmployeeControllar ec = new EmployeeControllar();
		try {
			//dao.getDetail(20000);
			//dao.getList();
			//dao1.getList();
			//dao1.getDetail(2100);
			dc.start();
			//lc.start();
			//ec.start();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("finish");

	}

}