package businesslogic.accountbillbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;

import vo.AccountBillItemVO;
import vo.AccountBillVO;
import dataenum.BillType;
import blservice.accountbillblservice.AccountBillBLService;

/**
 * @see blservice.accountbillblservice.AccountBillBLService
 * @author cylong
 * @version 2014年12月14日 上午8:51:44
 */
public class AccountBillController implements AccountBillBLService {

	private AccountBill accountBill;

	public AccountBillController() {
		try {
			accountBill = new AccountBill();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#getID(dataenum.BillType)
	 */
	@Override
	public String getID(BillType type) {
		try {
			return accountBill.getID(type);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#find(java.lang.String)
	 */
	@Override
	public AccountBillVO find(String ID) {
		try {
			return accountBill.find(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#getAllClients()
	 */
	@Override
	public HashMap<String, String> getAllClients() {
		try {
			return accountBill.getAllClients();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#getAllAccounts()
	 */
	@Override
	public HashMap<String, String> getAllAccounts() {
		return accountBill.getAllAccounts();
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#addBillItem(vo.AccountBillItemVO)
	 */
	@Override
	public void addBillItem(AccountBillItemVO vo) {
		accountBill.addBillItem(vo);
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#getSumMoney()
	 */
	@Override
	public double getSumMoney() {
		return accountBill.getSumMoney();
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#addAccountBill(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public void addAccountBill(String clientID, String clientName) {
		accountBill.addAccountBill(clientID, clientName);
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#submit()
	 */
	@Override
	public AccountBillVO submit() {
		try {
			return accountBill.submit();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#save()
	 */
	@Override
	public AccountBillVO save() {
		return accountBill.save();
	}

}
