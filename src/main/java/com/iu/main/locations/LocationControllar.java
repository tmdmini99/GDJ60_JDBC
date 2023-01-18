package com.iu.main.locations;

import java.util.ArrayList;
import java.util.Scanner;

public class LocationControllar {
	private Scanner sc;
	private LocationDAO locationDAO;
	private LocationView lv;
	private ArrayList<LocationDTO> ar;
	
	
	public LocationControllar() {
		this.sc=new Scanner(System.in);
		this.locationDAO=new LocationDAO();
		this.lv= new LocationView();
		this.ar=new ArrayList<LocationDTO>();
		
		
	}
	
	public void start() throws Exception{
		boolean check = true;
		
		while(check) {
			System.out.println("1. 지역리스트");
			System.out.println("2. 지역상세정보");
			System.out.println("3. 주소 검색");
			System.out.println("4. 종료");
			
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				ar =locationDAO.getList();
				lv.view(ar);
				break;
				
			case 2:
				System.out.println("부서 위치 번호 입력");
				select = sc.nextInt();
				LocationDTO dto=locationDAO.getDetail(select);
				if(dto !=null) {
					lv.view(dto);	
				}else {
					lv.view("Data가 없다");
				}
				break;
			case 3:
				System.out.println("검색할 주소");
				String add=sc.next();
				ar=locationDAO.getFind(add);
				
			default:
				check = false;
				break;
			}
			
			
			
		}
		
	}
}