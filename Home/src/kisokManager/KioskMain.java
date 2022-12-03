package kisokManager; 
 
public class KioskMain { 
	/*제품을 관리하는 프로그램을 작성하시오 
	 * -구매가격, 판매가격은 변동이 없음 
	 * -제품 등록(분류, 제품명, 수량, 구매가격, 판매가격, 등록날짜) 
	 * -제품 수정 
	 * -제품 삭제 
	 * -제품 구매 
	 * -제품 판매 
	 * -매출액 확인 
	 * 		-매출액은 년별, 일별, 월별 각각 제품별, 전체매출확인 
	 *  
	 * */ 
 
	public static void main(String[] args) { 
		/*inventorySystem 객체 생성 
		 * inventorySystem 실행 
		 * */ 
 
		InventorySystem system = new InventorySystem(); 
		system.run(); 
	} 
 
} 
