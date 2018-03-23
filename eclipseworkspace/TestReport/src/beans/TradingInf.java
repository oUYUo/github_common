package beans;

public class TradingInf {
	public TradingInf(){};
	
	private int TradingId;
	private int goodsId;
	private int UserId;
	private int tradingNum;
	public int getTradingId() {
		return TradingId;
	}
	public void setTradingId(int tradingId) {
		TradingId = tradingId;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public int getTradingNum() {
		return tradingNum;
	}
	public void setTradingNum(int tradingNum) {
		this.tradingNum = tradingNum;
	}

}
