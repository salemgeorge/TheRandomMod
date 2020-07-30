package com.IslamicReligion.TheRandomMod.blocks;

import com.IslamicReligion.TheRandomMod.blocks.tileentity.ChestPlusTileEntity;
import com.IslamicReligion.TheRandomMod.blocks.tileentity.GenericChestTileEntity;
import com.IslamicReligion.TheRandomMod.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class ChestPlus extends GenericChestBlock {
    public ChestPlus() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(5.0f, 6.0f)
                .sound(SoundType.METAL)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(2),
                ChestTypes.CHEST_PLUS,
                RegistryHandler.CHEST_PLUS_TILE_ENTITY::get
        );
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new ChestPlusTileEntity();
    }
}
