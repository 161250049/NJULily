package businesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CommodityItemPO;
import po.PromotionPO;
import vo.commodity.CommodityItemVO;
import vo.promotion.PromotionBargainVO;
import vo.promotion.PromotionClientVO;
import vo.promotion.PromotionCommodityVO;
import vo.promotion.PromotionGoodsVO;
import vo.promotion.PromotionTotalVO;
import businesslogic.common.ChangeCommodityItems;
import dataenum.ClientLevel;

public class PromotionTrans {

	/**
	 * 特价包PO到VO的转换
	 * @param POs
	 * @return
	 * @author Zing
	 * @version Dec 9, 2014 4:43:31 PM
	 * @throws RemoteException
	 */
	static public ArrayList<PromotionBargainVO> bargainsPOtoVO(ArrayList<PromotionPO> POs) throws RemoteException {
		ArrayList<PromotionBargainVO> VOs = new ArrayList<PromotionBargainVO>();
		for(PromotionPO po : POs) {
			VOs.add(bargainPOvoVO(po));
		}
		return VOs;
	}
	
	static public PromotionBargainVO bargainPOvoVO(PromotionPO po) throws RemoteException {
		String ID = po.getID();
		String beginDate = po.getBeginDate();
		String endDate = po.getEndDate();
		ArrayList<CommodityItemVO> bargains = ChangeCommodityItems.itemPOToVO(po.getBargains());
		double beforeTotal = po.getBeforeTotal();
		double bargainTotal = po.getBargainTotal();
		PromotionBargainVO vo = new PromotionBargainVO(ID, beginDate, endDate, bargains, beforeTotal, bargainTotal);
		return vo;
	}

	/**
	 * 客户等级促销包的
	 * @param POs
	 * @return
	 * @author Zing
	 * @version Dec 9, 2014 4:58:14 PM
	 * @throws RemoteException
	 */
	static public ArrayList<PromotionClientVO> clientPOtoVO(ArrayList<PromotionPO> POs) throws RemoteException {
		ArrayList<PromotionClientVO> VOs = new ArrayList<PromotionClientVO>();
		for(PromotionPO po : POs) {
			VOs.add(clientPOtoVO(po));
		}
		return VOs;
	}
	
	static public PromotionClientVO clientPOtoVO(PromotionPO po) throws RemoteException {
		String ID = po.getID();
		String beginDate = po.getBeginDate();
		String endDate = po.getEndDate();
		ClientLevel level = po.getLevel();
		ArrayList<CommodityItemVO> gifts = ChangeCommodityItems.itemPOToVO(po.getGifts());
		double allowance = po.getAllowance();
		int voucher = po.getVoucher();
		PromotionClientVO vo = new PromotionClientVO(ID, beginDate, endDate, level, gifts, allowance, voucher);
		return vo;
	}

	/**
	 * 商品促销的PO转VO
	 * @param POs
	 * @return
	 * @author Zing
	 * @version Dec 9, 2014 5:20:57 PM
	 * @throws RemoteException
	 */
	static public ArrayList<PromotionCommodityVO> commodityPOtoVO(ArrayList<PromotionPO> POs) throws RemoteException {
		ArrayList<PromotionCommodityVO> VOs = new ArrayList<PromotionCommodityVO>();
		for(PromotionPO po : POs) {
			String ID = po.getID();
			String beginDate = po.getBeginDate();
			String endDate = po.getEndDate();
			ArrayList<PromotionGoodsVO> goods = getGoods(po.getCommodities());
			ArrayList<CommodityItemVO> gifts = ChangeCommodityItems.itemPOToVO(po.getGifts());
			double allowance = po.getAllowance();
			int voucher = po.getVoucher();
			PromotionCommodityVO vo = new PromotionCommodityVO(ID, beginDate, endDate, goods, gifts, allowance, voucher);
			VOs.add(vo);
		}
		return VOs;
	}

	/**
	 * 根据总价的促销的PO到VO
	 * @param POs
	 * @return
	 * @author Zing
	 * @version Dec 9, 2014 5:23:46 PM
	 * @throws RemoteException
	 */
	static public ArrayList<PromotionTotalVO> totalPOtoVO(ArrayList<PromotionPO> POs) throws RemoteException {
		ArrayList<PromotionTotalVO> VOs = new ArrayList<PromotionTotalVO>();
		for(PromotionPO po : POs) {
			VOs.add(totalPOtoVO(po));
		}
		return VOs;
	}
	
	static public PromotionTotalVO totalPOtoVO(PromotionPO po) throws RemoteException {
		String ID = po.getID();
		String beginDate = po.getBeginDate();
		String endDate = po.getEndDate();
		double total = po.getTotal();
		ArrayList<CommodityItemVO> gifts = ChangeCommodityItems.itemPOToVO(po.getGifts());
		double allowance = po.getAllowance();
		int voucher = po.getVoucher();
		PromotionTotalVO vo = new PromotionTotalVO(ID, beginDate, endDate, total, gifts, allowance, voucher);
		return vo;
	}
	
	static private ArrayList<PromotionGoodsVO> getGoods(ArrayList<CommodityItemPO> commodityItems) {
		ArrayList<PromotionGoodsVO> VOs = new ArrayList<PromotionGoodsVO>();
		for (CommodityItemPO item : commodityItems) {
			PromotionGoodsVO vo = new PromotionGoodsVO(item.getID(), item.getName(), item.getNumber());
			VOs.add(vo);
		}
		return VOs;
	}
}
