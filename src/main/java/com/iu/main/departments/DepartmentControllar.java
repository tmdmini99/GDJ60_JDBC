package com.iu.main.departments;

import java.util.ArrayList;
import java.util.Scanner;

public class DepartmentControllar{
	private Scanner sc;
	private DepartmentDAO departmentDAO;
	private DepartmentView dv;
	//의존성이 필요하다
	
	public DepartmentControllar() {
		this.sc=new Scanner(System.in);
		this.departmentDAO=new DepartmentDAO();
		this.dv = new DepartmentView();
		//의존선 주입
		
	}
	
	
	
	public void start() throws Exception{
		boolean check = true;
		
		while(check) {
			System.out.println("1. 부서 리스트");
			System.out.println("2. 부서상세정보");
			System.out.println("3. 종    료");
			int select=sc.nextInt();
			switch(select) {
				case 1:
					ArrayList<DepartmentDTO>ar=departmentDAO.getList();
					dv.view(ar);
					break;
				case 2:
					System.out.println("부서번호를 입력하세요");
					select = sc.nextInt();
					DepartmentDTO departmentDTO=departmentDAO.getDetail(select);
					if(departmentDTO != null) {
					dv.view(departmentDTO);
					}else
						dv.view("Data가 없다");
					break;
				default:
					check=false;
					break;
			}
			
		}
		
	}
}