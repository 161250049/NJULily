package businesslogic.promotionbl.info;

import dataenum.ClientLevel;

public interface ClientInfo_Promotion {

	/**
	 * 根据客户ID返回等级
	 * @param clientID
	 * @return
	 * @author Zing
	 * @version Dec 10, 2014 8:50:12 AM
	 */
	public ClientLevel getLevel(String clientID);
}
