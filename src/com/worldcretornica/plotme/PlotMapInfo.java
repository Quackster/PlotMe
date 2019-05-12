package com.worldcretornica.plotme;

import org.bukkit.Material;

import java.util.HashMap;
import java.util.List;

public class PlotMapInfo {

	public int PlotSize;
	public int PlotAutoLimit;
	public int PathWidth;
	
	public Material BottomBlockId;
	public Material BottomBlockValue;
	public Material WallBlockId;
	public Material WallBlockValue;
	public Material PlotFloorBlockId;
	public Material PlotFloorBlockValue;
	public Material PlotFillingBlockId;
	public Material PlotFillingBlockValue;
	
	public Material RoadMainBlockId;
	public Material RoadMainBlockValue;
	public Material RoadStripeBlockId;
	public Material RoadStripeBlockValue;
	
	public HashMap<String, Plot> plots;
	public int RoadHeight;
	public int DaysToExpiration;
	
	public String ProtectedWallBlockId;
	public String ForSaleWallBlockId;
	public String AuctionWallBlockId;
	
	public List<String> ProtectedBlocks;
	public List<String> PreventedItems;

	public boolean UseEconomy;
	public boolean CanPutOnSale;
	public boolean CanSellToBank;
	public boolean RefundClaimPriceOnReset;
	public boolean RefundClaimPriceOnSetOwner;
	public double ClaimPrice;
	public double ClearPrice;
	public double AddPlayerPrice;
	public double DenyPlayerPrice;
	public double RemovePlayerPrice;
	public double UndenyPlayerPrice;
	public double PlotHomePrice;
	public boolean CanCustomizeSellPrice;
	public double SellToPlayerPrice;
	public double SellToBankPrice;
	public double BuyFromBankPrice;
	public double AddCommentPrice;
	public double BiomeChangePrice;
	public double ProtectPrice;
	public double DisposePrice;
	
	public boolean AutoLinkPlots;
	public boolean DisableExplosion;
	public boolean DisableIgnition;
	
	
}
