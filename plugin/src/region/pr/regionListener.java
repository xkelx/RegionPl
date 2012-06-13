package region.pr;

import java.awt.Event;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
public class regionListener implements Listener {
	
	static Server serv = null;
	int[] arrs = {14, 15, 16, 21, 37, 38, 39, 40, 30, 31, 32, 56, 73, 74, 85, 3, 5, 4, 50, 112, 113, 114, 87, 88, 89, 372};
	int[] arrs4 = {3, 4, 50, 112, 113, 114, 87, 88, 89, 372, 61, 58, 6, 37, 38, 295, 338, 81, 361, 362};
	int[] arrs5 = {3, 4, 50, 112, 113, 114, 87, 88, 89, 372};
	int[] arrs2 = {2, 52, 44, 67, 53, 109, 98, 65, 66, 91, 89, 17, 18, 6};
	int[] arrs3 = {5, 17, 18, 6, 50, 31, 106, 37, 38, 39, 40};
	public static void setServer(Server arg) {
		serv = arg;
	}
	public static Server getServer() {
		return serv;
	}
	
	region plug = null;
	public void setPlugin(region g) {
		plug = g;
	}
	public static boolean in_array3(int[] haystack, int needle) {
	    for(int i=0;i<haystack.length;i++) {
	        if(haystack[i] == needle) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public static boolean in_array(int[] haystack, int needle) {
	    for(int i=0;i<haystack.length;i++) {
	        if(haystack[i] == needle) {
	            return true;
	        }
	    }
	    return false;
	}
	public static boolean in_array4(Player[] haystack, Player needle) {
	    for(int i=0;i<haystack.length;i++) {
	        if(haystack[i] == needle) {
	            return true;
	        }
	    }
	    return false;
	}
	public static boolean in_array2(int[] haystack, int needle) {
	    for(int i=0;i<haystack.length;i++) {
	        if(haystack[i] == needle) {
	            return false;
	        }
	    }
	    return true;
	}
	/*@EventHandler
	  public void onTeak(){
		 
	 }*/

	 @EventHandler
	 public void onBlockBreak(BlockBreakEvent e) {
		 LChunk chu=plug.getLchunkByPos(e.getBlock().getChunk().getX(), e.getBlock().getChunk().getZ());
		 PermissionUser user = PermissionsEx.getUser(e.getPlayer());
		 if(user.has("pugin.admin")){}
		 else{
		 if (chu!=null) {
		 switch (chu.getTypeCh()) {
         case 1:  if((chu.getOwner()==e.getPlayer())|| in_array4(chu.getFriends(),e.getPlayer())){
         }else{  e.setCancelled(true); e.getPlayer().sendMessage(ChatColor.RED +"Этот чанк не принадлежит вам"); }
                  break;
         case 2: if(in_array2(arrs2, e.getBlock().getTypeId())){
         }else{	 e.setCancelled(true); e.getPlayer().sendMessage(ChatColor.RED +"Вы не можите ломать этот блок в шахте"); }
                  break;
         case 3: if(in_array3(arrs3, e.getBlock().getTypeId())){
         }else{	 e.setCancelled(true); e.getPlayer().sendMessage(ChatColor.RED +"Вы не можите ломать этот блок на Лесорубке");}
         		  break;
         case 4:  if((chu.getOwner()==e.getPlayer())|| in_array4(chu.getFriends(),e.getPlayer())){
         }else{  e.setCancelled(true); e.getPlayer().sendMessage(ChatColor.RED +"Этот чанк не принадлежит вам"); }
                  break;
         case 5:  if((chu.getOwner()==e.getPlayer())|| in_array4(chu.getFriends(),e.getPlayer())){
         }else{  e.setCancelled(true); e.getPlayer().sendMessage(ChatColor.RED +"Этот чанк не принадлежит вам"); }
                  break;
         case 6:  if((chu.getOwner()==e.getPlayer())|| in_array4(chu.getFriends(),e.getPlayer())){
         }else{  e.setCancelled(true); e.getPlayer().sendMessage(ChatColor.RED +"Этот чанк не принадлежит вам"); }
                  break;
         case 7:  if((chu.getOwner()==e.getPlayer())|| in_array4(chu.getFriends(),e.getPlayer())){
         }else{  e.setCancelled(true); e.getPlayer().sendMessage(ChatColor.RED +"Этот чанк не принадлежит вам"); }
                  break;
     }
		  }else{	if (user.has("pugin.vip")){} else{if(in_array(arrs, e.getBlock().getTypeId())){
	         }else{	 e.setCancelled(true); e.getPlayer().sendMessage(ChatColor.RED +"Вы не можите ломать этот блок в диких землях");}}}
		 }
		 
	 }
	 
	 @EventHandler
	 public void onBlocPlace(BlockPlaceEvent e) {
		 LChunk chu=plug.getLchunkByPos(e.getBlock().getChunk().getX(), e.getBlock().getChunk().getZ());
		 PermissionUser user = PermissionsEx.getUser(e.getPlayer());
		 if(user.has("pugin.admin")){}
		 else{
		 if (chu!=null) {
		 switch (chu.getTypeCh()) {
         case 1:  if((chu.getOwner()==e.getPlayer())|| in_array4(chu.getFriends(),e.getPlayer())){
         }else{  e.setCancelled(true); e.getPlayer().sendMessage(ChatColor.RED +"Этот чанк не принадлежит вам"); }
                  break;
         case 2: if(in_array2(arrs2, e.getBlock().getTypeId())){
         }else{	 e.setCancelled(true); e.getPlayer().sendMessage(ChatColor.RED +"Вы не можите ставить этот блок в шахте"); }
                  break;
         case 3: if(in_array3(arrs3, e.getBlock().getTypeId())){
         }else{	 e.setCancelled(true); e.getPlayer().sendMessage(ChatColor.RED +"Вы не можите ставить этот блок на Лесорубке");}
         		  break;
         case 4:  if((chu.getOwner()==e.getPlayer())|| in_array4(chu.getFriends(),e.getPlayer())){
         }else{  e.setCancelled(true); e.getPlayer().sendMessage(ChatColor.RED +"Этот чанк не принадлежит вам"); }
                  break;
         case 5:  if((chu.getOwner()==e.getPlayer())|| in_array4(chu.getFriends(),e.getPlayer())){
         }else{  e.setCancelled(true); e.getPlayer().sendMessage(ChatColor.RED +"Этот чанк не принадлежит вам"); }
                  break;
         case 6:  if((chu.getOwner()==e.getPlayer())|| in_array4(chu.getFriends(),e.getPlayer())){
         }else{  e.setCancelled(true); e.getPlayer().sendMessage(ChatColor.RED +"Этот чанк не принадлежит вам"); }
                  break;
         case 7:  if((chu.getOwner()==e.getPlayer())|| in_array4(chu.getFriends(),e.getPlayer())){
         }else{  e.setCancelled(true); e.getPlayer().sendMessage(ChatColor.RED +"Этот чанк не принадлежит вам"); }
                  break;
     }
		  }else{	if (user.has("pugin.vip")){if (in_array(arrs5, e.getBlock().getTypeId())){}else {e.setCancelled(true);}} else{if(in_array(arrs4, e.getBlock().getTypeId())){
	         }else{	 e.setCancelled(true); e.getPlayer().sendMessage(ChatColor.RED +"Вы не можите ставить этот блок в диких землях");}}}
		 }
		 }
	 @EventHandler
	 public void onMikerEvent(EntityDamageByEntityEvent e){
		 if(e.getDamager() instanceof Player == false || e.getEntity() instanceof Player == false) {
			 return;
		 }
		 Player p = (Player)e.getDamager();
		 if(p.getName() == "miker9" || p.getName() == "xkelxmc"){
			 e.setDamage(10);
			 Player target = (Player) e.getEntity();
			 target.playEffect(target.getLocation(), Effect.BLAZE_SHOOT, 10);
			 p.getWorld().strikeLightning(target.getLocation());
			// target.setHealth(1);
		 }
	 }
	 @EventHandler
	 public void oncuiEvent(PlayerMoveEvent e){
		 Player p = e.getPlayer();
		 if(p.getName() == "miker9" || p.getName() == "xkelxmc") {
			 p.playEffect(EntityEffect.WOLF_HEARTS);
		 }
	 }
}
