package kisokManager; 
 
public class Inventory { 
/* 제품 
 * 제품등록날짜 
 * 제품 수량 
 * */ 
	 
	int goodsCode; 
	String date; 
	int goodsCount;
	boolean buyingSelling;

	
	@Override
	public String toString() {
		return "날짜 : " + date +" "+ buyingOrSelling(this.buyingSelling)+ " 개수 : " + goodsCount;
	}

	public String buyingOrSelling(boolean a) {
		if(this.buyingSelling)
			return "입고";
		else {
			return "출고";
		}
	}

	public Inventory(int goodsCode, String date, int goodsCount, boolean a) {
		this.goodsCode=goodsCode;
		this.date = date;
		this.goodsCount = goodsCount;
		this.buyingSelling=a;
		
	}

	

	public boolean isBuyingSelling() {
		return buyingSelling;
	}


	public void setBuyingSelling(boolean buyingSelling) {
		this.buyingSelling = buyingSelling;
	}


	public int getGoodsCode() {
		return goodsCode;
	}


	public void setGoodsCode(int goodsCode) {
		this.goodsCode = goodsCode;
	}


	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}
	
} 
