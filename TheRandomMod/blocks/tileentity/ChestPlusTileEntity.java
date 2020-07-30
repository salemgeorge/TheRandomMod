package com.IslamicReligion.TheRandomMod.blocks.tileentity;

import com.IslamicReligion.TheRandomMod.blocks.ChestTypes;
import com.IslamicReligion.TheRandomMod.inventories.ChestBlockContainer;
import com.IslamicReligion.TheRandomMod.util.RegistryHandler;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.tileentity.TileEntityType;

public class ChestPlusTileEntity extends GenericChestTileEntity {
    public ChestPlusTileEntity() {
        super(RegistryHandler.CHEST_PLUS_TILE_ENTITY.get(), ChestTypes.CHEST_PLUS);
    }

    @Override
    protected Container createMenu(int id, PlayerInventory playerInventory) {
        return ChestBlockContainer.createChestPlusContainer(id, playerInventory, this);
    }
}
