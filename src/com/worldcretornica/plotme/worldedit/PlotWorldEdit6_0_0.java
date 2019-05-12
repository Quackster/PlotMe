package com.worldcretornica.plotme.worldedit;

import com.sk89q.worldedit.math.BlockVector3;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.function.mask.Mask;
import com.sk89q.worldedit.function.mask.RegionMask;
import com.sk89q.worldedit.regions.CuboidRegion;
import com.worldcretornica.plotme.Plot;
import com.worldcretornica.plotme.PlotManager;
import com.worldcretornica.plotme.PlotMe;
import org.bukkit.util.Vector;

public class PlotWorldEdit6_0_0 implements PlotWorldEdit {
	
	public void setMask(Player p)
	{
		setMask(p, p.getLocation());
	}
	
	public void setMask(Player p, Location l)
	{
		World w = p.getWorld();
		
		String id = PlotManager.getPlotId(l);
				
		Location bottom = null;
		Location top = null;
		
		LocalSession session = PlotMe.worldeditplugin.getSession(p);
				
		if(!id.equalsIgnoreCase(""))
		{		
			Plot plot = PlotManager.getPlotById(p, id);
			
			if(plot != null && plot.isAllowed(p.getUniqueId()))
			{			
				bottom = PlotManager.getPlotBottomLoc(w, id);
				top = PlotManager.getPlotTopLoc(w, id);
				
				LocalSession localsession = PlotMe.worldeditplugin.getSession(p);
				com.sk89q.worldedit.world.World world = localsession.getSelectionWorld();
						
				BlockVector3 pos1 = BlockVector3.at(bottom.getBlockX(), bottom.getBlockY(), bottom.getBlockZ());
				BlockVector3 pos2 = BlockVector3.at(top.getBlockX(), top.getBlockY(), top.getBlockZ());
						
				CuboidRegion cr = new CuboidRegion(world, pos1, pos2);
				
				RegionMask rm = new RegionMask(cr);
				
				session.setMask(rm);
				return;
			}
		}
		
		if(bottom == null || top == null){
			bottom = new Location(w, 0, 0, 0);
			top = new Location(w, 0, 0, 0);
		}
		
		if(session.getMask() == null)
		{
			LocalSession localsession = PlotMe.worldeditplugin.getSession(p);
			com.sk89q.worldedit.world.World world = localsession.getSelectionWorld();

			BlockVector3 pos1 = BlockVector3.at(bottom.getBlockX(), bottom.getBlockY(), bottom.getBlockZ());
			BlockVector3 pos2 = BlockVector3.at(top.getBlockX(), top.getBlockY(), top.getBlockZ());
					
			CuboidRegion cr = new CuboidRegion(world, pos1, pos2);
			
			RegionMask rm = new RegionMask(cr);
			
			session.setMask(rm);
		}
	}

	public void removeMask(Player p)
	{
		LocalSession session = PlotMe.worldeditplugin.getSession(p);
		Mask mask = null;
		session.setMask(mask);
	}	
}
