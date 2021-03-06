package businesslogic.accountinitbl.info;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ClientPO;
import vo.client.ClientVO;

public interface ClientInfo_Init {
	
	public ArrayList<ClientVO> getClientVOs(ArrayList<ClientPO> POs);
	
	public ArrayList<ClientPO> getClientPOs() throws RemoteException;
}
