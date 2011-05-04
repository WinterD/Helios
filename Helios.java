package com.bukkit.winterdeath.Helios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
/*import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.SimplePluginManager;*/
import org.bukkit.World;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.Location;
import java.util.logging.Logger;

public class Helios extends JavaPlugin{
	
	public Server serverH;
	public World worldH;
	public Location locationH;
	public Player player;
	
	@Override
	public void onDisable(){
		System.out.println("Helios H.S.!");
	}
	@Override
	public void onEnable(){
		System.out.println("Helios actif!");
		getCommand("jour").setExecutor(new CommandExecutor(){
			@Override
			public boolean onCommand(CommandSender sender, Command command,
					String label, String[] args) {
				if(sender instanceof Player && args.length==0)
				{
					player = (Player) sender;
					if(player.isOp())
					{
						locationH = player.getLocation();
						worldH = locationH.getWorld();
						
						worldH.setTime(6*1000);
						player.sendMessage("Helios|: Il fait maintenant jour.");
						return true;
					}
					else{	
						player.sendMessage("Vous devez être opérateur pour utilser Helios.");
						return false;
					}
				}
				else
					return false;
			}
		});
		getCommand("nuit").setExecutor(new CommandExecutor(){
			@Override
			public boolean onCommand(CommandSender sender, Command command,
					String label, String[] args) {
				if(sender instanceof Player && args.length==0)
				{	
					player = (Player) sender;
					if(player.isOp()){
						locationH = player.getLocation();
						worldH = locationH.getWorld();;
					
						worldH.setTime(18*1000);
						player.sendMessage("Helios|: Il fait maintenant nuit.");
						return true;
					
					}
					else{
						player.sendMessage("Vous devez être opérateur pour utilser Helios.");
						return false;
					}
					
				}
				else
					return false;
			}
		});
		getCommand("changeTemps").setExecutor(new CommandExecutor(){
			@Override
			public boolean onCommand(CommandSender sender, Command command,
					String label, String[] args) {
				if(sender instanceof Player){
					player = (Player) sender;
					
					if(player.isOp()){
						
						if(args.length==1){
							long time = Long.valueOf(args[0]); ///!\
							locationH = player.getLocation();
							worldH = locationH.getWorld();
							worldH.setTime(time);
							player.sendMessage("Helios : Reussis - L'heure du serveur a été modifiée.");
							return true;
						}
						else{
							return false;
						}
					}
					else{
						player.sendMessage("Helios : Erreur - Recquiert statut OP.");
						return false;
					}
						
				}
				else{
					return false;
				}
			}
		});
		getCommand("addTemps").setExecutor(new CommandExecutor(){
			@Override
			public boolean onCommand(CommandSender sender, Command command,
					String label, String[] args) {
				if(sender instanceof Player){
					player = (Player) sender;
					
					if(player.isOp()){
						
						if(args.length==1){
							long time = Long.valueOf(args[0]); ///!\
							locationH = player.getLocation();
							worldH = locationH.getWorld();
							addTime(time);
							player.sendMessage("Helios : Reussis - L'heure du serveur a été modifiée.");
							return true;
						}
						else{
							return false;
						}
					}
					else{
						player.sendMessage("Helios : Erreur - Recquiert statut OP.");
						return false;
					}
						
				}
				else{
					return false;
				}
			}
		});
		getCommand("supTemps").setExecutor(new CommandExecutor(){
			@Override
			public boolean onCommand(CommandSender sender, Command command,
					String label, String[] args) {
				if(sender instanceof Player){
					player = (Player) sender;
					
					if(player.isOp()){
						
						if(args.length==1){
							long time = Long.valueOf(args[0]); ///!\
							locationH = player.getLocation();
							worldH = locationH.getWorld();
							supTime(time);
							player.sendMessage("Helios : Reussis - L'heure du serveur a été modifiée.");
							return true;
						}
						else{
							return false;
						}
					}
					else{
						player.sendMessage("Helios : Erreur - Recquiert statut OP.");
						return false;
					}
						
				}
				else{
					return false;
				}
			}
		});
		getCommand("getTemps").setExecutor(new CommandExecutor(){
			@Override
			public boolean onCommand(CommandSender sender, Command command,
					String label, String[] args) {
				if(sender instanceof Player && args.length==0)
				{
					player = (Player) sender;
					if(player.isOp())
					{
						locationH = player.getLocation();
						worldH = locationH.getWorld();
						player.sendMessage("Helios - Heure du serveur :" + worldH.getFullTime());
						return true;
					}
					else{	
						player.sendMessage("Vous devez être opérateur pour utilser Helios.");
						return false;
					}
				}
				else
					return false;
			}
		});
	}
	public void addTime(long time){
		long timeB = worldH.getTime();
		worldH.setTime(timeB + time);
	}
	public void supTime(long time){
		long timeB = worldH.getTime();
		worldH.setTime(timeB - time);