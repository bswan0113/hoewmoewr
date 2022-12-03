package kisokManager; 
 
import java.util.ArrayList; 
import java.util.Scanner; 
 
public class InventorySystem { 
	/*필드 
	 * 인벤토리리스트 
	 * 스캐너 
	 * 자산(정수형 변수로 설정)xx -> 클래스로 변경  * */
	
	
	static ArrayList<Inventory> allList = new ArrayList<Inventory>(); 
	//판매하고 구매한 모든 내역을 등록	 
	static ArrayList<Inventory> inven = new ArrayList<Inventory>(); 
	//동일 품목을 합침
	static Scanner scan = new Scanner(System.in); 
	static Asset asset= new Asset();
	//자산
	static ArrayList<Asset> assetList = new ArrayList<Asset>();
	//자산내역
	static ArrayList<Goods> goodsList = new ArrayList<Goods>(); 
	 
	{System.out.println("인벤토리관리 시스템을 실행합니다.\n");} 
	 
	//시스템기동 
	public void run() { 
		int menu=1213; 
		do { 
			printMenu(); 
			menu=scan.nextInt(); 
			scan.nextLine(); 
			runMenu(menu); 
			 
		}while(menu!=8); 
		System.out.println("시스템을 종료합니다."); 
		 
	} 
 
//메인메뉴 실행 
	private void runMenu(int menu) { 
		switch(menu) { 
		case 1: addItem(); 
			break; 
		case 2:reviseItem(); 
			break; 
		case 3:deleteItem(); 
			break; 
		case 4:buyItem(); 
			break; 
		case 5:sellItem(); 
			break; 
		case 6:  salesConfirmation();
			break; 
		case 7: printItem();//제품 확인 
			break; 
		case 8: 
			break; 
		 
		default: System.out.println("잘못 입력하셨습니다."); 
		} 
		 
	} 
	 
	 
	 
 
 
private void salesConfirmation() {
	printConfirmationMenu();
	int select =scan.nextInt();
	scan.nextLine();
	runConfirmaionMenu(select);

	
}

private void runConfirmaionMenu(int select) {
	switch(select) {
	case 1: totalCheck();
		break;
	case 2: totalOperatingProfitCheck();
		break;
	case 3:	annalAsset();
		break;
	case 4: System.out.println("미구현");
		break;
	case 5: System.out.println("미구현");
		break;
	case 6: return;
	default: System.out.println("잘못된 접근입니다.");
	}
	
}

private void annalAsset() {
	System.out.println("조회 방식을 선택해주세요.");
	System.out.println("1.연전체매출확인");
	System.out.println("2.제품별 연매출 확인");
	System.out.println("3.이전으로");
	int select=scan.nextInt();
	scan.nextLine();
	switch(select) {
	case 1: System.out.println("미구현");
		break;
	case 2: System.out.println("미구현");
		break;
	case 3:
		return;
		default: System.out.println("잘못된 선택입니다.");
	}
	
}

private void totalOperatingProfitCheck() {
	int sum=0;
	for(int i=0; i<assetList.size();i++) {
		sum+=assetList.get(i).getIncome();
		sum-=assetList.get(i).getOutcome();
	}
	System.out.println("전체 영업이익은 "+ sum + "원 입니다.");
	
}

private void totalCheck() {
	int sum=0;
	for(int i=0; i<assetList.size();i++) {
		sum+=assetList.get(i).getIncome();
	}
	System.out.println("전체 매출액은 "+ sum + "원 입니다.");
	
	
	
}

private void printConfirmationMenu() {
	System.out.println("1.전체 매출액 확인");
	System.out.println("2.전체 영업이익 확인");
	System.out.println("3.연별 매출액 확인 / 미구현");
	System.out.println("4.월별 매출액 확인 / 미구현");
	System.out.println("5.일별 매출액 확인 / 미구현");	
	System.out.println("6. 이전메뉴");
}

//제품판매메소드 
private void sellItem() { 
	System.out.println("구매 날짜를 입력해주세요.");
	String date = scan.nextLine();
	System.out.println("판매한 제품의 코드를 입력해주세요."); 
	int goodsCode=scan.nextInt(); 
	scan.nextLine(); 
	if(goodsCode>goodsList.size()) { 
		System.out.println("존재하지 않는 제품코드입니다."); 
		return; 
	} 
	System.out.println("판매한 수량을 입력해주세요."); 
	int quantity=scan.nextInt(); 
	scan.nextLine(); 
	int totalPrice = (quantity*(goodsList.get(goodsCode).getPrice())); 
	asset.income(totalPrice); 
	boolean a = false;
	Asset tmp = new Asset(totalPrice, a);
	assetList.add(tmp);
	Inventory newTmp = new Inventory(goodsCode, date, quantity, a);
	allList.add(newTmp);
	for(int i=0; i<inven.size(); i++) {
		if(goodsCode==inven.get(i).goodsCode) {
			quantity-=inven.get(i).getGoodsCount();
			inven.get(i).setGoodsCount(quantity);
		}
		else {
			inven.add(newTmp);
		}
	}
	System.out.println("자산 잔고 금액 : " + asset.totalAsset); 
	System.out.println("품목 잔고 : " + quantity);
} 
//제품 출력메소드 
private void printItem() { 
	System.out.println("1.제품 코드 확인"); 
	System.out.println("2.제품재고확인"); 
	int select=scan.nextInt(); 
	scan.nextLine(); 
	switch(select) { 
	case 1: printList(); 
		break; 
	case 2: printGoodstoDetail();
		break; 
	default: System.out.println("비정상적인 접근입니다."); 
	} 
	 
} 
 //제품의 코드가 입력되면 제품의 날짜별 입출고 내역과 총 수량을 출력
private void printGoodstoDetail() {
	System.out.println("조회할 제품의 코드를 입력해주세요.");
	int code = scan.nextInt();
	scan.nextLine();
		for(int i=0; i<inven.size();i++) {
			if(!(inven.get(i).goodsCode==code)) {
				System.out.println("존재하지 않는 제품 코드입니다.");
				return;
			}
	}
	for(int i=0; i<allList.size();i++) {
		if(allList.get(i).goodsCode==code) {
			System.out.println(getNametoGoodsCode(code));
			break;
		}
	}
	for(int i=0; i<allList.size();i++) {
		if(allList.get(i).goodsCode==code) {
			System.out.println(allList.get(i));
		}
	}
	for(int i=0; i<inven.size();i++) {
		if(inven.get(i).getGoodsCode()==code) {
			System.out.println(inven.get(i).getGoodsCount());
			break;
		}
	}
}

//전제품 코드확인 

//제품구매메소드 
private void buyItem() { 
	System.out.println("구매 날짜를 입력해주세요.");
	String date = scan.nextLine();
	System.out.println("구매한 제품의 코드를 입력해주세요."); 
	int goodsCode=scan.nextInt(); 
	scan.nextLine(); 
	if(goodsCode>goodsList.size()) { 
		System.out.println("존재하지 않는 제품코드입니다."); 
		return; 
	} 
	System.out.println("구매한 수량을 입력해주세요."); 
	int quantity=scan.nextInt(); 
	scan.nextLine(); 
	int totalPrice = (quantity*goodsList.get(goodsCode).getPurchase()); 
	asset.outcome(totalPrice); 
	boolean a= true;
	Asset tmp = new Asset(totalPrice, a);
	assetList.add(tmp);
	Inventory newTmp = new Inventory(goodsCode, date, quantity, a);
	allList.add(newTmp);
	for(int i=0; i<inven.size(); i++) {
		if(goodsCode==inven.get(i).goodsCode) {
			quantity+=inven.get(i).getGoodsCount();
			inven.get(i).setGoodsCount(quantity);
		}
		else {
			inven.add(newTmp);
		}
	}
	System.out.println("자산 잔고 금액 : " + asset.totalAsset); 
	System.out.println("품목 잔고 : " + quantity);
	 
} 
//제품정보삭제 
private void deleteItem() { 
	try { 
	System.out.println("삭제할 제품의 코드를 입력해주세요."); 
	int goodsCode=scan.nextInt(); 
	scan.nextLine();	 
	 
	if(finalConfirm(goodsCode)) { 
		goodsList.remove(goodsCode); 
		System.out.println("삭제가 완료되었습니다."); 
	} 
	else { 
		System.out.println("삭제를 취소합니다."); 
	}}catch(Exception e) { 
		System.out.println("존재하지 않는 제품코드입니다."); 
		return; 
	} 
	 
 
	 
} 
//최종확인 메소드
private boolean finalConfirm(int goodsCode) { 
	System.out.println("정말 아래의 상품을 삭제하시겠습니까?"); 
	System.out.println(goodsList.get(goodsCode)); 
	char yOrN= scan.next().charAt(0); 
	if(yOrN=='Y') return true; 
	else { 
		return false; 
	} 
} 
 
//아이템 수정 
private void reviseItem() { 
	 
	try{System.out.println("수정할 제품의 코드를 입력해주세요."); 
	int goodsCode=scan.nextInt(); 
	scan.nextLine();	 
	System.out.println("수정할 항목을 입력해주세요."); 
	System.out.println("1.분류"); 
	System.out.println("2.제품명"); 
	int select=scan.nextInt(); 
	scan.nextLine(); 
	switch(select) { 
	case 1:  reviseCategory(goodsCode); 
		break; 
	case 2: reviseName(goodsCode); 
		break; 
		default: System.out.println("정확한 항목을 입력해주세요."); 
	} 
	}catch(Exception E) { 
		System.out.println("비정상적인 접근입니다."); 
	} 
	 
} 
 
 
private void reviseName(int goodsCode) { 
	System.out.println("이름을 어떻게 변경하시겠습니까?"); 
	String name = scan.nextLine(); 
	goodsList.get(goodsCode).setName(name); 
} 
 
private void reviseCategory(int goodsCode) { 
	System.out.println("분류를 어떻게 변경하시겠습니까?"); 
	String revise= scan.nextLine(); 
	goodsList.get(goodsCode).setCategory(revise); 
	 
} 
//아이템 등록 
private void addItem() { 
	System.out.println("등록할 제품의 분류를 입력해주세요."); 
	String category=scan.nextLine(); 
	System.out.println("등록할 제품의 이름을 입력해주세요."); 
	String name = scan.nextLine(); 
	System.out.println("등록할 제품의 구매가를 입력해주세요."); 
	final int purchase = scan.nextInt(); 
	System.out.println("등록할 제품의 판매가를 입력해주세요."); 
	final int price = scan.nextInt(); 
	scan.nextLine(); 
	Goods newGoods = new Goods(category, name, purchase, price); 
	System.out.println("등록이 완료 되었습니다."); 
	goodsList.add(newGoods.goodsCode, newGoods); 
} 
 
//메인메뉴출력 
	private void printMenu() { 
		System.out.println("1.제품 등록"); 
		System.out.println("2.제품 수정"); 
		System.out.println("3.제품 삭제"); 
		System.out.println("4.제품 구매"); 
		System.out.println("5.제품 판매"); 
		System.out.println("6.자산 관리"); 
		System.out.println("7.재고 확인"); 
		System.out.println("8.시스템 종료"); 
 
	}
//아이템 코드가 입력되면 제품명을 가져오는 메소드
	public String getNametoGoodsCode(int goodsCode) {
		for(int i=0; i<goodsList.size();i++) {
			if(goodsList.get(i).goodsCode==goodsCode) {
				return goodsList.get(i).getName();
			}
		}
		return null;
	}
	//아이템 코드가 입력되면 카테고리를 가져오는 메소드
	public String getCategorytoGoodsCode(int goodsCode) {
		for(int i=0; i<goodsList.size();i++) {
			if(goodsList.get(i).goodsCode==goodsCode) {
				return goodsList.get(i).getCategory();
			}
		}
		return null;
	}
	
	//등록된 제품의 모든 리스트를 출력
	// 등록날짜 / 분류 / 코드 / 이름 /입출고여부/ 갯수
	public void printList() {
		String print="";
		int code=-11;
		
		for(int i=0; i<allList.size();i++) {
			print=allList.get(i).getDate()+" / ";
			code =allList.get(i).goodsCode;
			print+=getCategorytoGoodsCode(code)+" / ";
			print+=getNametoGoodsCode(code)+" / ";
			print+= allList.get(i).buyingOrSelling(allList.get(i).isBuyingSelling())+" / ";		
			print+=allList.get(i).getGoodsCount();
			System.out.println(print);
			print="";
		}
		
	}
	 
} 
