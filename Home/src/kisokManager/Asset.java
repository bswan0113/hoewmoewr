package kisokManager; 
 
 
public class Asset { 
 
	int income=0, outcome=0, totalAsset=0; 
	 
	Asset(){
		
	}
	Asset(int b, boolean a){
		if(a) {
			income=0;
			outcome=b;
		}
		else if(!a) {
			income=b;
			outcome=0;
		}
		
	}
	void income(int money) { 
		this.income+=money; 
		totalAsset(); 
	} 
	void outcome(int money) { 
		this.outcome-=money; 
		totalAsset(); 
	} 
	void totalAsset() { 
		totalAsset=income+outcome; 
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public int getOutcome() {
		return outcome;
	}
	public void setOutcome(int outcome) {
		this.outcome = outcome;
	}
	public int getTotalAsset() {
		return totalAsset;
	}
	public void setTotalAsset(int totalAsset) {
		this.totalAsset = totalAsset;
	} 
	
	
	
} 




