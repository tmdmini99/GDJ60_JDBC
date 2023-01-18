package com.iu.main.employees;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeControllar {
	private ArrayList<EmployeeDTO> ar;
	private Scanner sc;
	private EmployeeDAO employeeDAO;
	private EmployeeView ev;
	
	public EmployeeControllar() {
		this.ar = new ArrayList<EmployeeDTO>();
		this.sc = new Scanner(System.in);
		this.employeeDAO= new EmployeeDAO();
		this.ev = new EmployeeView();
		
		
		
	}
	
	
	public void start() throws Exception{
		boolean check = true;
		
		while(check) {
			
			EmployeeDTO dto = null;
			System.out.println("1. 사원정보 리스트");
			System.out.println("2. 개별 사원 정보");
			System.out.println("3. 사원 검색");
			System.out.println("4. 종료");
			int select = sc.nextInt();
			
			switch (select) {
			case 1:
				ar = employeeDAO.getList();
				ev.view(ar);
				break;
			case 2:
				System.out.println("사원 번호를 입력하세요");
				select = sc.nextInt();
				dto = employeeDAO.getDetail(select);
				if(dto !=null) {
					ev.view(dto);
				}else {
					System.out.println("찾는 사람이 없습니다");
				}
				break;
			case 3:
				System.out.println("사원 이름 입력");
				String name = sc.next();
				ar=employeeDAO.search(name);
				if(ar != null) {
					ev.view(ar);
				}else {
					System.out.println("해당 성을 가진 사람이 없습니다");
				}
				break;

			default:
				check = false;
				break;
			}
		}
		
	}
}