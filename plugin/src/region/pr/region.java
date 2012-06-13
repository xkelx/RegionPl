package region.pr;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import net.minecraft.server.mod_decor;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class region extends JavaPlugin {
	private String pluginPrefix;
	private String pluginName;
	public final static Logger log = Logger.getLogger("Minecraft");
	private final static String pluginFolder = "plugins/timework/";
	public int mon;
	public List<LChunk> regions = new ArrayList<LChunk>();
	public int cost;

	@Override
	public void onDisable() {
		try {
			slapi.save(regions, pluginFolder + "regions.mrf");
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info(pluginPrefix + " is disabled!");
	}

	@SuppressWarnings("unchecked")
	public void onEnable() {
		regionListener.setServer(this.getServer());
		pluginName = this.getDescription().getName();
		pluginPrefix = "[" + pluginName + "] ";
		log.info(pluginPrefix + "version " + this.getDescription().getVersion()
				+ " by " + "timework" + " is enabled!");

		try {
			if (slapi.load(pluginFolder + "regions.mrf") != null) {
				regions = (List<LChunk>) slapi.load(pluginFolder
						+ "regions.mrf");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		PluginManager PM = this.getServer().getPluginManager();
		regionListener lis = new regionListener();
		PM.registerEvents(lis, this);
		lis.setPlugin(this);
	}
	public void regen(int c, LChunk chur) {
		

	}
	
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
		if((commandLabel+args[0]).equalsIgnoreCase("teraddmine")) {
			if(! (sender instanceof Player)) {
				log.warning("It can't be executed by console");
				return true;
			}
			Player p = (Player) sender;
			int Chunk_x=p.getLocation().getChunk().getX(), Chunk_y=p.getLocation().getChunk().getZ();
			LChunk chu = getLchunkByPos(Chunk_x, Chunk_y);
			if(getMap(p)==0){cost=20;
			}else{
			mon=getMap(p);
			cost=20;
			for(int i = 1; i<mon; i++){cost=cost+4;}
			}
			int cost2=0;
			if (cost>64){
				if (32*(int)(cost/32)<cost){cost2=(int)(cost/32); cost=cost - 32*(int)(cost/32);}
				else{
				cost2=(int)(cost/32)-1; cost=cost-(32*(int)(cost/32)-1);	
				}
			}else{cost2=0;}
			cost=cost*2;
			cost2=cost2*2;
			ItemStack diamondstack = new ItemStack(mod_decor.monetas.id, cost);
			ItemStack diamondstack2 = new ItemStack(mod_decor.monetag.id, cost2);
			PermissionUser user = PermissionsEx.getUser(p);
			PlayerInventory inventory = p.getPlayer().getInventory();
			if(chu.getStOwner()==p.getName()) {
				if(chu.getTypeCh()==1){
					switch(Integer.parseInt(args[1])){
					case 1: 
						if(user.has("pugin.admin"))
						 {chu.setType(4);}else{
						if(inventory.contains(mod_decor.monetas.id, cost)&&(inventory.contains(mod_decor.monetag.id, cost2))) {
							inventory.removeItem(diamondstack);
							inventory.removeItem(diamondstack2);
							chu.setType(4);
						}else{ if (cost2==0){p.sendMessage(ChatColor.RED +"Нехватает денег, нужно" + cost+ "A silver");}
						else{
							p.sendMessage(ChatColor.RED +"Нехватает денег, нужно"+ cost2 +"A Gold" + cost+ "A Silver");
						}}}
						break;
					case 2: 
						if(user.has("pugin.admin"))
					 {chu.setType(5);}else{
					if(inventory.contains(mod_decor.monetas.id, cost)&&(inventory.contains(mod_decor.monetag.id, cost2))) {
						inventory.removeItem(diamondstack);
						inventory.removeItem(diamondstack2);
						chu.setType(5);
					}else{ if (cost2==0){p.sendMessage(ChatColor.RED +"Нехватает денег, нужно" + cost+ "A silver");}
					else{
						p.sendMessage(ChatColor.RED +"Нехватает денег, нужно"+ cost2 +"A Gold" + cost+ "A Silver");
					}}} 
						break;
					case 3: 
						if(user.has("pugin.admin"))
						 {chu.setType(6);}else{
						if(inventory.contains(mod_decor.monetas.id, cost)&&(inventory.contains(mod_decor.monetag.id, cost2))) {
							inventory.removeItem(diamondstack);
							inventory.removeItem(diamondstack2);
							chu.setType(6);
						}else{ if (cost2==0){p.sendMessage(ChatColor.RED +"Нехватает денег, нужно" + cost+ "A silver");}
						else{
							p.sendMessage(ChatColor.RED +"Нехватает денег, нужно"+ cost2 +"A Gold" + cost+ "A Silver");
						}}}
						break;
					case 4: 
						if(user.has("pugin.admin"))
						 {chu.setType(7);}else{
						if(inventory.contains(mod_decor.monetas.id, cost)&&(inventory.contains(mod_decor.monetag.id, cost2))) {
							inventory.removeItem(diamondstack);
							inventory.removeItem(diamondstack2);
							chu.setType(7);
						}else{ if (cost2==0){p.sendMessage(ChatColor.RED +"Нехватает денег, нужно" + cost+ "A silver");}
						else{
							p.sendMessage(ChatColor.RED +"Нехватает денег, нужно"+ cost2 +"A Gold" + cost+ "A Silver");
						}}}
						break;
					}
					
				} else {
					p.sendMessage("Вы можете поставить шахту только на обычный чанк");
				}
			} else {
				p.sendMessage(ChatColor.RED + "Этот чанк не принадлежит вам!");
			}
			
		}

		if((commandLabel+args[0]).equalsIgnoreCase("terregenmine")) {
			if(! (sender instanceof Player)) {
				log.warning("It can't be executed by console");
				return true;
			}
			Player p = (Player) sender;
			int Chunk_x=p.getLocation().getChunk().getX(), Chunk_y=p.getLocation().getChunk().getZ();
			LChunk chu = getLchunkByPos(Chunk_x, Chunk_y);
			if(getMap(p)==0){cost=20;
			}else{
			mon=getMap(p);
			cost=20;
			for(int i = 1; i<mon; i++){cost=cost+4;}
			}
			int cost2=0;
			if (cost>64){
				if (32*(int)(cost/32)<cost){cost2=(int)(cost/32); cost=cost - 32*(int)(cost/32);}
				else{
				cost2=(int)(cost/32)-1; cost=cost-(32*(int)(cost/32)-1);	
				}
			}else{cost2=0;}
			cost=cost*2;
			cost2=cost2*2;
			ItemStack diamondstack = new ItemStack(mod_decor.monetas.id, cost);
			ItemStack diamondstack2 = new ItemStack(mod_decor.monetag.id, cost2);
			PermissionUser user = PermissionsEx.getUser(p);
			PlayerInventory inventory = p.getPlayer().getInventory();
			if(chu.getStOwner()==p.getName()) {
					switch(chu.getTypeCh()-3){
					case 1: 
						if(user.has("pugin.admin"))
						 {
							regen(1,chu);
						 }else{
						if(inventory.contains(mod_decor.monetas.id, cost)&&(inventory.contains(mod_decor.monetag.id, cost2))) {
							inventory.removeItem(diamondstack);
							inventory.removeItem(diamondstack2);
							regen(1,chu);
						}else{ if (cost2==0){p.sendMessage(ChatColor.RED +"Нехватает денег, нужно" + cost+ "A silver");}
						else{
							p.sendMessage(ChatColor.RED +"Нехватает денег, нужно"+ cost2 +"A Gold" + cost+ "A Silver");
						}}}
						break;
					case 2: 
						if(user.has("pugin.admin"))
					 {
							regen(2,chu);
					 }else{
					if(inventory.contains(mod_decor.monetas.id, cost)&&(inventory.contains(mod_decor.monetag.id, cost2))) {
						inventory.removeItem(diamondstack);
						inventory.removeItem(diamondstack2);
						regen(2,chu);
					}else{ if (cost2==0){p.sendMessage(ChatColor.RED +"Нехватает денег, нужно" + cost+ "A silver");}
					else{
						p.sendMessage(ChatColor.RED +"Нехватает денег, нужно"+ cost2 +"A Gold" + cost+ "A Silver");
					}}} 
						break;
					case 3: 
						if(user.has("pugin.admin"))
						 {
							regen(3,chu);
						 }else{
						if(inventory.contains(mod_decor.monetas.id, cost)&&(inventory.contains(mod_decor.monetag.id, cost2))) {
							inventory.removeItem(diamondstack);
							inventory.removeItem(diamondstack2);
							regen(3,chu);
						}else{ if (cost2==0){p.sendMessage(ChatColor.RED +"Нехватает денег, нужно" + cost+ "A silver");}
						else{
							p.sendMessage(ChatColor.RED +"Нехватает денег, нужно"+ cost2 +"A Gold" + cost+ "A Silver");
						}}}
						break;
					case 4: 
						if(user.has("pugin.admin"))
						 {
							regen(4,chu);
						 }else{
						if(inventory.contains(mod_decor.monetas.id, cost)&&(inventory.contains(mod_decor.monetag.id, cost2))) {
							inventory.removeItem(diamondstack);
							inventory.removeItem(diamondstack2);
							regen(4,chu);
						}else{ if (cost2==0){p.sendMessage(ChatColor.RED +"Нехватает денег, нужно" + cost+ "A silver");}
						else{
							p.sendMessage(ChatColor.RED +"Нехватает денег, нужно"+ cost2 +"A Gold" + cost+ "A Silver");
						}}}
						break;
					}
					
				
			} else {
				p.sendMessage(ChatColor.RED + "Этот чанк не принадлежит вам!");
			}
		}
		
		
			if((commandLabel+args[0]).equalsIgnoreCase("tershow")) {
				if(! (sender instanceof Player)) {
					log.warning("It can't be executed by console");
					return true;
				}
				//Player p = (Player) sender;
				//int Chunk_x=p.getLocation().getChunk().getX(), Chunk_y=p.getLocation().getChunk().getZ();
				//LChunk chu = getLchunkByPos(Chunk_x, Chunk_y);
				
			}
			if((commandLabel+args[0]).equalsIgnoreCase("teraddfr")) {
				if(! (sender instanceof Player)) {
					log.warning("It can't be executed by console");
					return true;
				}
				Player p = (Player) sender;
				int Chunk_x=p.getLocation().getChunk().getX(), Chunk_y=p.getLocation().getChunk().getZ();
				LChunk chu = getLchunkByPos(Chunk_x, Chunk_y);
				
				if(args.length<2) {
					p.sendMessage(ChatColor.RED +"Вы неправильно ввели параметры!");
					p.sendMessage(ChatColor.RED +"/ter addfr ник");
					return true;
				} 
				if(args[1] == p.getName()) {
					p.sendMessage(ChatColor.RED +"Вы не можете добавить в друзья самого себя");
					return true;
				}
				if (chu!=null){
					if ((chu.getTypeCh()==1)&&(chu.getOwner()==p)&& chu.maxFriend()<9){
						
						if(chu.addFriend(args[1])){
							p.sendMessage(ChatColor.AQUA +"Вы успешно добавили друга");
							return true;
						} else {
							p.sendMessage(ChatColor.RED +"Друг уже добавлен");
							return true;
						}
						
				}}
				
			}
			if((commandLabel+args[0]).equalsIgnoreCase("terremovefr")) {
				if(! (sender instanceof Player)) {
					log.warning("It can't be executed by console");
					return true;
				}
				Player p = (Player) sender;
				int Chunk_x=p.getLocation().getChunk().getX(), Chunk_y=p.getLocation().getChunk().getZ();
				LChunk chu = getLchunkByPos(Chunk_x, Chunk_y);
				if(args.length<2) {
					p.sendMessage(ChatColor.RED +"Вы неправильно ввели параметры!");
					p.sendMessage(ChatColor.RED +"/ter removefr ник");
					return true;
				} 
				if(args[1] == p.getName()) {
					p.sendMessage(ChatColor.RED +"Вы не можете удалить из друзей самого себя");
					return true;
				}
				if (chu!=null){
					if ((chu.getTypeCh()==1)&&(chu.getOwner()==p)){
						
						if(chu.removeFriend(args[1])){
							p.sendMessage(ChatColor.AQUA +"Вы успешно удалили друга");
							return true;
						} else {
							p.sendMessage(ChatColor.RED +"forever alone");
							return true;
						}
						
				}}
			}
		
			if((commandLabel+args[0]).equalsIgnoreCase("tersave")){
			try {
				slapi.save(regions, pluginFolder+"regions.mrf");
			} catch (Exception e) {
				e.printStackTrace();
			}}
			if((commandLabel+args[0]).equalsIgnoreCase("terinfo")) {
				if(! (sender instanceof Player)) {
					log.warning("It can't be executed by console");
					return true;
				}
				Player p = (Player) sender;
				int Chunk_x=p.getLocation().getChunk().getX(), Chunk_y=p.getLocation().getChunk().getZ();
				LChunk chu = getLchunkByPos(Chunk_x, Chunk_y);
				PermissionUser user = PermissionsEx.getUser(p);

				if(getMap(p)==0){cost=20;
				}else{
				mon=getMap(p);
				cost=20;
				for(int i = 1; i<mon; i++){cost=cost+4;}
				}
				 if (user.has("pugin.vip")){
					cost=(int)(cost/4);	
				 }
				int cost2=0;
				if (cost>64){
					if (32*(int)(cost/32)<cost){cost2=(int)(cost/32); cost=cost - 32*(int)(cost/32);}
					else{
					cost2=(int)(cost/32)-1; cost=cost-(32*(int)(cost/32)-1);	
					}
				}else{cost2=0;}
				if (chu==null){
					if (cost2==0){
				p.sendMessage(ChatColor.GREEN +"Info: Дикие земли ["+Chunk_x+","+ Chunk_y+"] " + ChatColor.WHITE + " Територия стоит: " + cost + "A Silver.");
					}else{
				p.sendMessage(ChatColor.GREEN +"Info: Дикие земли ["+Chunk_x+","+ Chunk_y+"] " + ChatColor.WHITE + " Територия стоит: " + cost2 + "A Gold" + cost + "A Silver.");		
					}
					}else{
					switch (chu.getTypeCh()){	
					case 1: p.sendMessage(ChatColor.GREEN + "Info: ["+Chunk_x+","+Chunk_y+"] Територия игрока - " + chu.getStOwner());
							p.sendMessage(ChatColor.GREEN + "Друзья: "+ChatColor.WHITE + chu.getFriendss());
					break;
					case 2: p.sendMessage(ChatColor.GREEN + "Info: ["+Chunk_x+","+Chunk_y+"] Территория шахты");
					break;
					case 3:	p.sendMessage(ChatColor.GREEN + "Info: ["+Chunk_x+","+Chunk_y+"] Территория Лесорубки");
					break;
					default: p.sendMessage(ChatColor.RED +"ERROR");
						}
					}
				
			}
			if((commandLabel+args[0]).equalsIgnoreCase("terbuy")){
				if(! (sender instanceof Player)) {
					log.warning("It can't be executed by console");
					return true;
				}
				
				Player p =  (Player) sender;
				
				int Chunk_x=p.getLocation().getChunk().getX(), Chunk_y=p.getLocation().getChunk().getZ();
				
				
				Object[] l = regions.toArray();
				for(int i = 0; i<l.length; i++) {
					LChunk chu = (LChunk) l[i];
					if(chu.x == Chunk_x & chu.y == Chunk_y) {
						sender.sendMessage(ChatColor.RED +"Этот чанк уже куплен");
						break;
					}
				}
				LChunk chu = getLchunkByPos(Chunk_x, Chunk_y);
				if (chu== null){
				PlayerInventory inventory = p.getPlayer().getInventory();
				if(getMap(p)==0){cost=20;
				}else{
				mon=getMap(p);
				cost=20;
				for(int i = 1; i<mon; i++){cost=cost+4;}
				}
				PermissionUser user = PermissionsEx.getUser(p);
				 if (user.has("pugin.vip")){
					cost=(int)(cost/4);	
				 }
				 
				int cost2=0;
				if (cost>64){
					if (32*(int)(cost/32)<cost){cost2=(int)(cost/32); cost=cost - 32*(int)(cost/32);}
					else{
					cost2=(int)(cost/32)-1; cost=cost-(32*(int)(cost/32)-1);	
					}
				}else{cost2=0;}
				
				
				ItemStack diamondstack = new ItemStack(mod_decor.monetas.id, cost);
				ItemStack diamondstack2 = new ItemStack(mod_decor.monetag.id, cost2);

				
				 if(user.has("pugin.admin"))
				 {
					 regions.add(new LChunk(p, Chunk_x, Chunk_y, (byte)0, 1));
						log.info("["+Chunk_x+","+ Chunk_y+"] buyed buy "+p.getName());

						p.sendMessage(ChatColor.AQUA +"Вы успешно купили чанк");
				 }else{
				if(inventory.contains(mod_decor.monetas.id, cost)&&(inventory.contains(mod_decor.monetag.id, cost2))) {
						inventory.removeItem(diamondstack);
						inventory.removeItem(diamondstack2);
				regions.add(new LChunk(p, Chunk_x, Chunk_y, (byte)0, 1));
				log.info("["+Chunk_x+","+ Chunk_y+"] buyed buy "+p.getName());

				p.sendMessage(ChatColor.AQUA +"Вы успешно купили чанк");
				}else{ if (cost2==0){p.sendMessage(ChatColor.RED +"Нехватает денег, нужно" + cost+ "A silver");}
				else{
					p.sendMessage(ChatColor.RED +"Нехватает денег, нужно"+ cost2 +"A Gold" + cost+ "A Silver");
				}
				}}
			   }else{
				   if (chu.getTypeCh()==2){
				   p.sendMessage(ChatColor.RED +"Вы не можите купить шахту");}
				   else{ 
					   if (chu.getTypeCh()==3){
						   p.sendMessage(ChatColor.RED +"Вы не можите купить Лесорубку");
					   }else{
					   p.sendMessage(ChatColor.RED +"Вы уже купили этот чанк");
					   }
				   }
				   
			   }
	
			}
			
			
			if((commandLabel+args[0]).equalsIgnoreCase("tersell")) {
				if(! (sender instanceof Player)) {
					log.warning("It can't be executed by console");
					return true;
				}
				
				Player p = (Player) sender;
				
				int Chunk_x=p.getLocation().getChunk().getX(), Chunk_y=p.getLocation().getChunk().getZ();
				
				LChunk chu = getLchunkByPos(Chunk_x, Chunk_y);
				
				if(chu!=null && chu.getOwner() == p) {
					PlayerInventory inventory = p.getPlayer().getInventory();
				    PermissionUser user = PermissionsEx.getUser(p);
					if(getMap(p)==0){cost=20;
					}else{
					mon=getMap(p);
					cost=20;
					for(int i = 1; i<mon; i++){cost=cost+4;}
					}
					 if (user.has("pugin.vip")){
							cost=(int)(cost/4);	
						 }
					cost = (int)(cost-cost*0.36);
					
					int cost2=0;
					if (cost>64){
						if (32*(int)(cost/32)<cost){cost2=(int)(cost/32); cost=cost - 32*(int)(cost/32);}
						else{
						cost2=(int)(cost/32)-1; cost=cost-(32*(int)(cost/32)-1);	
						}
					}else{cost2=0;}				
			    ItemStack diamondstack2 = new ItemStack(mod_decor.monetag.id, cost2);
			    ItemStack diamondstack = new ItemStack(mod_decor.monetas.id, cost);

				 if(user.has("pugin.admin"))
				 {}else{	inventory.addItem(diamondstack); inventory.addItem(diamondstack2);}
					regions.remove(chu);
					p.sendMessage(ChatColor.AQUA +"Чанк продан");
				} else {
					p.sendMessage(ChatColor.RED +"Этот чанк не принадлежит вам");
				}
			}
				if((commandLabel+args[0]).equalsIgnoreCase("tersetmine")) {
					if(! (sender instanceof Player)) {
						log.warning("It can't be executed by console");
						return true;
					}
					Player p = (Player) sender;
					int Chunk_x=p.getLocation().getChunk().getX(), Chunk_y=p.getLocation().getChunk().getZ();
					
					LChunk chu = getLchunkByPos(Chunk_x, Chunk_y);
					PermissionUser user = PermissionsEx.getUser(p);
					 if(user.has("pugin.admin"))
					 {					
					if(chu==null) {
						
						regions.add(new LChunk(p, Chunk_x, Chunk_y, (byte)0, 2));
						p.sendMessage(ChatColor.AQUA +"Вы успешно создали шахту");
						
					} else {
						p.sendMessage(ChatColor.RED +"Вы не можите создать шахту на этой земле");
					}
					 
					 }else{p.sendMessage(ChatColor.RED +"Недостаточно прав");}
					
				}
				if((commandLabel+args[0]).equalsIgnoreCase("terremovemine")) {
					if(! (sender instanceof Player)) {
						log.warning("It can't be executed by console");
						return true;
					}
					Player p = (Player) sender;
					int Chunk_x=p.getLocation().getChunk().getX(), Chunk_y=p.getLocation().getChunk().getZ();
					
					LChunk chu = getLchunkByPos(Chunk_x, Chunk_y);
					PermissionUser user = PermissionsEx.getUser(p);
					 if(user.has("pugin.admin"))
					 {
					if (chu!= null && chu.getTypeCh()==2){

						regions.remove(chu);
						p.sendMessage(ChatColor.AQUA +"Вы успешно уничтожили шахту");
					}else{p.sendMessage(ChatColor.RED +"Этот чанк не являеться шахтой");}
					 }else{p.sendMessage(ChatColor.RED +"Недостаточно прав");}
					}
				if((commandLabel+args[0]).equalsIgnoreCase("tersetles")) {
					if(! (sender instanceof Player)) {
						log.warning("It can't be executed by console");
						return true;
					}
					Player p = (Player) sender;
					int Chunk_x=p.getLocation().getChunk().getX(), Chunk_y=p.getLocation().getChunk().getZ();
					
					LChunk chu = getLchunkByPos(Chunk_x, Chunk_y);
					PermissionUser user = PermissionsEx.getUser(p);
					 if(user.has("pugin.admin"))
					 {
					if(chu==null) {

						regions.add(new LChunk(p, Chunk_x, Chunk_y, (byte)0, 3));
						p.sendMessage(ChatColor.AQUA +"Вы успешно создали Лесорубку");}

					 else {
								p.sendMessage(ChatColor.RED +"Вы не можите создать Лесорубку на этой земле");
					}
					 }else{p.sendMessage(ChatColor.RED +"Недостаточно прав");}
				}
				if((commandLabel+args[0]).equalsIgnoreCase("terremoveles")) {
					if(! (sender instanceof Player)) {
						log.warning("It can't be executed by console");
						return true;
					}
					Player p = (Player) sender;
					int Chunk_x=p.getLocation().getChunk().getX(), Chunk_y=p.getLocation().getChunk().getZ();
					
					LChunk chu = getLchunkByPos(Chunk_x, Chunk_y);
					PermissionUser user = PermissionsEx.getUser(p);
					 if(user.has("pugin.admin"))
					 {
					if (chu!= null && chu.getTypeCh()==3){
						regions.remove(chu);
						p.sendMessage(ChatColor.AQUA +"Вы успешно уничтожили Лесорубку");
					}else{p.sendMessage(ChatColor.RED +"Этот чанк не являеться Лесорубкой");}
					 }else{p.sendMessage(ChatColor.RED +"Недостаточно прав");}
					}
			return true;
	    }

	public static String getPluginfolder() {
		return pluginFolder;
	}

	public LChunk getLchunkByPos(int x, int y) {
		Object[] l = regions.toArray();
		for (int i = 0; i < l.length; i++) {
			LChunk chu = (LChunk) l[i];

			if (chu.x == x & chu.y == y) {
				return chu;
			}
		}
		return null;
	}

	public int getMap(Player pl) {
		int xxx = 0;
		Object[] l = regions.toArray();
		for (int i = 0; i < l.length; i++) {
			LChunk chu = (LChunk) l[i];

			if (chu.getOwner() == pl) {
				xxx++;
			}
		}
		return xxx;

	}
	
	public String getSysTime() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		return (dateFormat.format(date));
	}

}
