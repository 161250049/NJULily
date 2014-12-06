package vo.client;

import vo.ValueObject;
import dataenum.ClientCategory;
import dataenum.ClientLevel;

public class ClientAddVO extends ValueObject{
	/** 客户类别：进货商、销售商 */
	public ClientCategory category;
	/** 客户级别：1-5（vip） */
	public ClientLevel level;
	/** 客户姓名 */
	public String name;
	/** 客户电话 */
	public String phone;
	/** 客户地址 */
	public String address;
	/** 客户邮编 */
	public String post;
	/** 客户电子邮箱 */
	public String email;
	/** 客户应收额度 */
	public double receivableLimit;
	/** 默认业务员 */
	public String salesman;
	
	/**
	 * 添加一个客户的时候，只要填写这些信息就可以了
	 */
	public ClientAddVO(String ID, ClientCategory category, ClientLevel level, String name, String phone, String address, 
			String post, String email, double receivableLimit, String salesman) {
		this.ID = ID;
		this.category = category;
		this.level = level;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.post = post;
		this.email = email;
		this.receivableLimit = receivableLimit;
		this.salesman = salesman;
	}
}
