package kisokManager; 
 
 
public class Goods { 
/*필드 
 * 제품명, 제품분류 
 * 구매가, 판매가 
 * */ 
	 
	String name, category; 
	int purchase, price; 
	int goodsCode; 
	static int count=0; 
	 
	public Goods(String category,String name,  int purchase, int price) { 
		this.name = name; 
		this.category = category; 
		this.purchase = purchase; 
		this.price = price; 
		goodsCode=count; 
		count++; 
	} 
 
	@Override 
	public String toString() { 
		return "제품코드 : "+ goodsCode + " / 분류 : " + category +" / 제품명 : "+ name +"\n구매가/판매가 : " +purchase+"/"+price+"\n"; 
	} 

	@Override 
	public int hashCode() { 
		final int prime = 31; 
		int result = 1; 
		result = prime * result + goodsCode; 
		return result; 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPurchase() {
		return purchase;
	}

	public void setPurchase(int purchase) {
		this.purchase = purchase;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(int goodsCode) {
		this.goodsCode = goodsCode;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Goods.count = count;
	} 
 
 
	 
} 
