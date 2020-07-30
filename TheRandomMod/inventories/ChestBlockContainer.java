package com.IslamicReligion.TheRandomMod.inventories;

import com.IslamicReligion.TheRandomMod.blocks.ChestTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChestBlockContainer extends Container {

    private final IInventory inventory;

    private final ChestTypes chestType;

    public static ChestBlockContainer createChestPlusContainer(int windowId, PlayerInventory playerInventory) {
        return new ChestBlockContainer(ChestBlockContainerTypes.CHEST_PLUS.get(), windowId, playerInventory, new Inventory(ChestTypes.CHEST_PLUS.size), ChestTypes.CHEST_PLUS);
    }

    public static ChestBlockContainer createChestPlusContainer(int windowId, PlayerInventory playerInventory, IInventory inventory) {
        return new ChestBlockContainer(ChestBlockContainerTypes.CHEST_PLUS.get(), windowId, playerInventory, inventory, ChestTypes.CHEST_PLUS);
    }

    public ChestBlockContainer(ContainerType<?> containerType, int windowId, PlayerInventory playerInventory, IInventory inventory, ChestTypes chestType) {
        super(containerType, windowId);
//        assertInventorySize(inventory, 0);

        this.inventory = inventory;
        this.chestType = chestType;

        inventory.openInventory(playerInventory.player);

//        if (chestType == ChestTypes.CHEST_PLUS) {
//            this.addSlot(new DirtChestSlot(inventory, 0, 12 + 4 * 18, 8 + 2 * 18));
//        }
            for (int chestRow = 0; chestRow < chestType.getRowCount(); chestRow++) {
                for (int chestCol = 0; chestCol < chestType.rowLength; chestCol++) {
                    this.addSlot(new Slot(inventory, chestCol + chestRow * chestType.rowLength, 12 + chestCol * 18, 18 + chestRow * 18));
                }
        }

        int leftCol = (chestType.xSize - 162) / 2 + 1;

        for (int playerInvRow = 0; playerInvRow < 3; playerInvRow++) {
            for (int playerInvCol = 0; playerInvCol < 9; playerInvCol++) {
                this.addSlot(new Slot(playerInventory, playerInvCol + playerInvRow * 9 + 9, leftCol + playerInvCol * 18, chestType.ySize - (4 - playerInvRow) * 18 - 10));
            }

        }

        for (int hotbarSlot = 0; hotbarSlot < 9; hotbarSlot++) {
            this.addSlot(new Slot(playerInventory, hotbarSlot, leftCol + hotbarSlot * 18, chestType.ySize - 24));
        }
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return this.inventory.isUsableByPlayer(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < this.chestType.size) {
                if (!this.mergeItemStack(itemstack1, this.chestType.size, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, this.chestType.size, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            }
            else {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }

    @Override
    public void onContainerClosed(PlayerEntity playerIn) {
        super.onContainerClosed(playerIn);
        this.inventory.closeInventory(playerIn);
    }

    @OnlyIn(Dist.CLIENT)
    public ChestTypes getChestType() {
        return this.chestType;
    }
}
