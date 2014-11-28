package vo;

import java.util.ArrayList;

import dataenum.BillState;
import dataenum.BillType;
import dataenum.Storage;

/**
 * 销售和销售退货单值对象
 * @author cylong
 * @version Oct 26, 2014 2:28:02 PM
 */
/**
 * @author Zing
 * @version 2014年10月29日上午9:03:59
 */
public class SalesVO {

	/** 单据编号 */
	public String ID;
	/** 客户 */
	public String client;
	/** 仓库 */
	public Storage storage;
	/** 业务员 */
	public String salesman;
	/** 操作员 */
	public String user;
	/** 商品列表清单 */
	public ArrayList<CommodityItemVO> commodities;
	/** 折让前总额 */
	public double beforePrice;
	/** 折让金额 */
	public double allowance;
	/** 代金券总额 */
	public double voucher;
	/** 折让后总额 */
	public double afterPrice;
	/** 备注 */
	public String remark;
	/** 单据类型 */
	public BillType type;
	/** 单据状态 */
	public BillState state;

	/**
	 * @param client
	 * @param storage
	 * @param user
	 * @param commodities
	 * @param remark
	 * @param beforePrice
	 * @param allowance
	 * @param voucher
	 * @param afterPrice
	 */
	public SalesVO(String ID, String client, Storage storage, String user, String salesman, ArrayList<CommodityItemVO> commodities, String remark, double beforePrice, double allowance, double voucher, double afterPrice, BillType type, BillState state) {
		this.ID = ID;
		this.salesman = salesman;
		this.client = client;
		this.storage = storage;
		this.user = user;
		this.commodities = commodities;
		this.remark = remark;
		this.beforePrice = beforePrice;
		this.allowance = allowance;
		this.voucher = voucher;
		this.afterPrice = afterPrice;
		this.type = type;
		this.state = state;
	}
}
