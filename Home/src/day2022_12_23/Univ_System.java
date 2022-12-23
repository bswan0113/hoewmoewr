package day2022_12_23;

import java.sql.*;
import java.util.Scanner;

public class Univ_System {
	Connection con;

	Scanner scan = new Scanner(System.in);
	{System.out.println("서버 연결중입니다. 잠시만 기다려주세요.");}

	public void run() throws Exception {
		connect();
		int menu=111;
		do {
			printMainMenu();
			menu=scan.nextInt();scan.nextLine();
			switchMainMenu(menu);
			
		}while(menu!=4);
	}

	private void switchMainMenu(int menu) {
		switch(menu) {

		case 1: intoStdMenu();
			break;
			
		case 2: intoPrfMenu();
			break;
			
		case 3: intoAdminMenu();
			break;
			
		case 4: System.out.println("시스템을 종료합니다.");
			break;
		default: System.out.println("잘못된 입력입니다.");
		}
		
	}

	private void intoAdminMenu() {
		System.out.println("당신의 용무는 무엇인가요?");
		System.out.println("1.학생관리");
		System.out.println("2.교직원관리");
		System.out.println("3.개설강좌관리");
		System.out.println("4.학부관리");
		System.out.println("5. 이전메뉴로 돌아가길 원합니다.");
	}

	private void intoPrfMenu() {
		System.out.println("당신의 용무는 무엇인가요?");
		System.out.println("1. 성적등록");
		System.out.println("2. 성적정정");
		System.out.println("3. 성적정보삭제");
		System.out.println("4. 성적조회");
		System.out.println("5. 이전메뉴로 돌아가길 원합니다.");

	}

	private void intoStdMenu() {
		System.out.println("당신의 용무는 무엇인가요?");
		System.out.println("1. 수강신청");
		System.out.println("2. 수강정정");
		System.out.println("3. 수강취소");
		System.out.println("4. 성적조회");
		System.out.println("5. 이전 메뉴로 돌아가길 원합니다.");

	}

	private void printMainMenu() {
		System.out.println("초기화면 입니다.");
		System.out.println("당신은 누구신가요?");
		System.out.println("1. 학생");
		System.out.println("2. 교수");
		System.out.println("3. 서버관리자");
		System.out.println("4. 시스템종료");
	}

	private void connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
	     	String url = "jdbc:mysql://localhost/university"; 
	        String id = "root";
	        String pw = "root";
        con = DriverManager.getConnection(url, id, pw);		
        System.out.println("서버 접속이 완료되었습니다.");
	}
}
