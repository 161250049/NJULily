package businesslogic.userbl;

import io.DefineList;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import config.RMIConfig;
import message.ResultMessage;
import po.UserPO;
import vo.UserVO;
import blservice.userblservice.LoginInfo;
import dataenum.UserIdentity;
import dataservice.userdataservice.AdminInfo;
import dataservice.userdataservice.UserDataService;

public class User {

	private UserDataService userData;
	private DefineList<UserPO> currentUser;	// 保存用户名
	private DefineList<UserPO> currentUserTemp;	// 用户的登录信息
	private UserPO current;	// 当前登录的用户

	/**
	 * @throws MalformedURLException
	 * @throws RemoteException
	 * @throws NotBoundException
	 * @author cylong
	 * @version 2014年12月14日 上午5:18:22
	 */
	public User() throws MalformedURLException, RemoteException, NotBoundException {
		currentUser = new DefineList<UserPO>("data/loginInfo.ser");
		currentUserTemp = new DefineList<UserPO>("data/loginInfoTemp.ser");
		userData = (UserDataService)Naming.lookup(RMIConfig.PREFIX + UserDataService.NAME);
	}

	/**
	 * 供界面层显示
	 * @return 新的ID
	 * @author cylong
	 * @version 2014年11月29日 下午6:54:10
	 * @throws RemoteException
	 */
	public String getID() throws RemoteException {
		return userData.getID();
	}

	/**
	 * 验证用户登录
	 * @param loginInfo
	 * @return 登录结果
	 * @author cylong
	 * @version 2014年11月29日 下午9:24:17
	 * @throws RemoteException
	 */
	public UserIdentity login(LoginInfo loginInfo) throws RemoteException {
		// 验证管理员登录
		AdminInfo admin = new AdminInfo(loginInfo.username, loginInfo.password);
		if (userData.checkAdmin(admin)) {
			return admin.iden;
		}

		// 验证普通用户登录
		ArrayList<UserPO> pos = userData.show();
		for(UserPO po : pos) {
			if (po.getUsername().equals(loginInfo.username)) {
				current = po;
				break;
			}
		}
		if (current == null) {
			return null;
		} else if (!loginInfo.password.equals(current.getPassword())) {
			return null;
		}
		if (loginInfo.isRemembered) {	// 保存当前登录的用户的帐户名
			currentUser.set(0, current);
			currentUserTemp.set(0, current);	// 记录当前登录的用户的信息
		} else {	// 删除记住的账号
			currentUser.clear();
		}
		return current.getIden();
	}

	/**
	 * 返回用户保存的用户名
	 * @return 用户保存的用户名，不存在就返回null
	 * @author cylong
	 * @version 2014年11月29日 下午9:25:38
	 */
	public String returnUsername() {
		if (currentUser.isEmpty()) {
			return null;
		}
		return currentUser.get(0).getUsername();
	}

	/**
	 * 添加用户
	 * @param vo UserVO
	 * @return 添加结果
	 * @author cylong
	 * @version 2014年11月29日 下午9:29:55
	 * @throws RemoteException
	 */
	public ResultMessage add(UserVO vo) throws RemoteException {
		UserPO po = voToPO(vo);
		return userData.insert(po);
	}

	/**
	 * 以ID删除用户
	 * @param ID
	 * @return 删除结果
	 * @author cylong
	 * @version 2014年11月29日 下午9:30:23
	 * @throws RemoteException
	 */
	public ResultMessage delete(String ID) throws RemoteException {
		return userData.delete(ID);
	}

	/**
	 * 更新用户信息
	 * 如果该用户没有权限更改的，ui上禁止更改
	 * @throws RemoteException
	 */
	public ResultMessage update(UserVO vo) throws RemoteException {
		UserPO po = voToPO(vo);
		return userData.update(po);
	}

	/**
	 * 返回全部的用户
	 * @return 全部的用户的ArrayList
	 * @author cylong
	 * @version 2014年11月29日 下午9:42:27
	 * @throws RemoteException
	 */
	public ArrayList<UserVO> show() throws RemoteException {
		ArrayList<UserVO> usersVO = new ArrayList<UserVO>();
		ArrayList<UserPO> usersPO = userData.show();
		for(UserPO po : usersPO) {
			UserVO vo = poToVO(po);
			usersVO.add(vo);
		}
		return usersVO;
	}

	/**
	 * UserVO转化成UserPO
	 * @param vo UserVO
	 * @return UserPO
	 * @author cylong
	 * @version 2014年11月29日 下午9:37:24
	 */
	private UserPO voToPO(UserVO vo) {
		String ID = vo.ID;
		String username = vo.username;
		String name = vo.name;
		String password = vo.password;
		String phone = vo.phone;
		UserIdentity iden = vo.iden;
		UserPO po = new UserPO(ID, username, name, password, phone, iden);
		return po;
	}

	/**
	 * UserPO转化成UserVO
	 * @param po UserPO
	 * @return UserVO
	 * @author cylong
	 * @version 2014年11月29日 下午9:41:20
	 */
	private UserVO poToVO(UserPO po) {
		String ID = po.getID();
		String username = po.getUsername();
		String name = po.getName();
		String password = po.getPassword();
		String phone = po.getPhone();
		UserIdentity iden = po.getIden();
		UserVO vo = new UserVO(ID, username, name, password, phone, iden);
		return vo;
	}

	/**
	 * 更新管理员密码
	 * @param oldPass 旧密码
	 * @param newPass 新密码
	 * @return 成功、失败
	 * @author cylong
	 * @version 2014年12月3日 上午10:43:22
	 * @throws RemoteException
	 */
	public ResultMessage updateAdmin(String oldPass, String newPass) throws RemoteException {
		return userData.updateAdmin(oldPass, newPass);
	}

}
