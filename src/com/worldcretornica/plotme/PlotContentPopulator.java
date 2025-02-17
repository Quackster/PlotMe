package com.worldcretornica.plotme;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.data.BlockData;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

public class PlotContentPopulator extends BlockPopulator {
    private double plotsize;
    private double pathsize;

    private Material plotfloor;
    private Material filling;

    private int roadheight;

    public PlotContentPopulator() {
        plotsize = 32;
        pathsize = 7;
        roadheight = 64;
        plotfloor = Material.GRASS_BLOCK;
        filling = Material.STONE;
    }

    public PlotContentPopulator(PlotMapInfo pmi) {
        plotsize = pmi.PlotSize;
        pathsize = pmi.PathWidth;
        roadheight = pmi.RoadHeight;
        plotfloor = pmi.PlotFloorBlockValue;
        filling = pmi.PlotFillingBlockValue;
    }

    @Override
	public void populate(World w, Random rand, Chunk chunk) {
        double size = plotsize + pathsize;

        int cx = chunk.getX();
        int cz = chunk.getZ();

        int xx = cx << 4;
		int zz = cz << 4;

        for (int x = 0; x < 16; x++) {
            int valx = x + xx;

            valx -= Math.ceil(pathsize / 2);
            valx = (valx % (int) size);
            if (valx < 0) valx += size;

            boolean modX = valx < plotsize;

            for (int z = 0; z < 16; z++) {
                int valz = z + zz;

                valz -= Math.ceil(pathsize / 2);
                valz = (valz % (int) size);
                if (valz < 0) valz += size;

                boolean modZ = valz < plotsize;

                for (int y = 0; y <= roadheight; y++) {
                    if (y < roadheight) {
                        setData(w, x + xx, y, z + zz, filling);
                    } else {
                        if (modX && modZ) {
                            setData(w, x + xx, y, z + zz, plotfloor);
                        }
                    }
                }
            }
        }
	}

    private void setData(World w, int x, int y, int z, Material material) {
        w.getBlockAt(x, y, z).setType(material, false);
    }
}
