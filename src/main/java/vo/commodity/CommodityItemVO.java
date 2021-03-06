package vo.commodity;

import vo.ValueObject;

/**
 * 商品条目值对象
 * @author cylong
 * @version Oct 31, 2014 3:41:16 PM
 */
public class CommodityItemVO extends ValueObject {

	/** 商品名称 */
	public String name;
	/** 商品型号 */
	public String type;
	/** 商品数量 */
	public int number;
	/** 商品 单价 */
	public double price;
	/** 总价 */
	public double total;
	/** 商品备注 */
	public String remark;

	public CommodityItemVO(String ID, int number, double price, String remark, String name, String type) {
		this.ID = ID;
		this.name = name;
		this.type = type;
		this.number = number;
		this.price = price;
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "\r\n\t[商品ID=" + ID + ", 商品名称=" + name + ", 商品类型=" + type + ", 商品数量=" + number + ", 商品单价=" + price
				+ ", 商品总价=" + total + ", 备注=" + remark + "]";
	}

}
