package region.pr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Server;
import org.bukkit.entity.Player;

public class LChunk implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 31023712341092678L;

	public String owner;
	public List<String> friends = new ArrayList<String>();
	private Byte type = 1;
	public int x;
	public int y;
	private int TypeCh = 1;
	

	public LChunk (Player p, int x, int y, byte type, int TypeChunk) {
		if (p!=null){
        owner = p.getName();}else{ owner = null;}
		this.x = x;
		this.y = y;
		this.type = type;
		this.TypeCh = TypeChunk;
		}
	
	public Player getOwner() {
		return regionListener.getServer().getPlayer(owner);
	}
	public String getStOwner(){
		return owner;
	}
	public byte getType() {
		return type;
	}
	public int getTypeCh(){
	
		return TypeCh;
	}
	public boolean addFriend(String friend) {
		if(!friends.contains(friend)) {
			friends.add(friend);
			return true;
		} 
		return false;
	}
	public boolean removeFriend(String friend) {
		if(friends.contains(friend)){
			friends.remove(friend);
			return true;
		}
		return false;
	}
	public String getFriendss() {
		String sus = "";
		if (friends!=null){
		for(int i=0; i<friends.size(); i++) {
			if (i+1==friends.size()){
				sus = sus + friends.get(i);
			}else{
				sus = sus + friends.get(i)+ ", ";
			}
		}
		}else{
			sus = "Нет друзей";
		}
		return sus;
	}
	public Player[] getFriends() {
		Player su[] = new Player[friends.size()];
		Server server = regionListener.getServer();
		for(int i=0; i<friends.size(); i++) {
			su[i]=server.getPlayer(friends.get(i));
		}
		return su;
	}
	public void setType(int type) {
		TypeCh = type;
	}
	
	public boolean isFriend(String arg){
		for(int i=0; i<friends.size();i++){
			if(friends.get(i)==arg){
				return true;
			}
		}
		return false;
	}
	public int maxFriend(){
		return friends.size();
	}
	
	
		
}
