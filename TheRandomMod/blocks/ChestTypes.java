package com.IslamicReligion.TheRandomMod.blocks;

import com.IslamicReligion.TheRandomMod.blocks.tileentity.ChestPlusTileEntity;
import com.IslamicReligion.TheRandomMod.blocks.tileentity.GenericChestTileEntity;
import com.IslamicReligion.TheRandomMod.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import com.IslamicReligion.TheRandomMod.util.Util;

import javax.annotation.Nullable;
import java.util.Locale;

public enum ChestTypes {

    CHEST_PLUS(45, 9, 184, 204, new ResourceLocation("therandommod", "textures/gui/chest_plus_container.png"), 256, 256);

    private final String name;
    public final int size;
    public final int rowLength;
    public final int xSize;
    public final int ySize;
    public final ResourceLocation guiTexture;
    public final int textureXSize;
    public final int textureYSize;

    ChestTypes(int size, int rowLength, int xSize, int ySize, ResourceLocation guiTexture, int textureXSize, int textureYSize) {
        this(null, size, rowLength, xSize, ySize, guiTexture, textureXSize, textureYSize);
    }

    ChestTypes(@Nullable String name, int size, int rowLength, int xSize, int ySize, ResourceLocation guiTexture, int textureXSize, int textureYSize) {
        this.name = name == null ? Util.toEnglishName(this.name()) : name;
        this.size = size;
        this.rowLength = rowLength;
        this.xSize = xSize;
        this.ySize = ySize;
        this.guiTexture = guiTexture;
        this.textureXSize = textureXSize;
        this.textureYSize = textureYSize;
    }

    public String getId() {
        return this.name().toLowerCase(Locale.ROOT);
    }

    public String getEnglishName() {
        return this.name;
    }

//    public String func_176610_l() {
//        return this.getEnglishName();
//    }

    public int getRowCount() {
        return this.size / this.rowLength;
    }

    public static Block get(ChestTypes type) {
        switch (type) {
            case CHEST_PLUS:
                return RegistryHandler.CHEST_PLUS.get();
            default:
                return Blocks.CHEST;
        }
    }

    public GenericChestTileEntity makeEntity() {
        switch (this) {
            case CHEST_PLUS:
                return new ChestPlusTileEntity();
            default:
                return null;
        }
    }
}
