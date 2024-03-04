class  Account
{
	String ban="신한은행";
	private int balance = 50000000;
	pivate String account_num="123456789"'
	String master="홍길동";

	public String getAccount_num(){
	return account_num;
	}

	public void setAccount_num(String getaccount_num){
	this.account_num=account_num
	}
}

//해결책) 메서드를 통해 간접적으로 접근 할 수 있게 해주자
//pirvate 묶여진 변수를 읽게 할 수 있도록 제공되는 메서드 정의 패턴을 가르켜 getter라 하며
//변수를 변경할 수 있도록 제공되는 메서드 정의 패턴 setter라 한다
//메서드는 외부에서 접근을 할 수 잇어야 하므로, public으로 풀어주자


