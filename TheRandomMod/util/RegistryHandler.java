package com.IslamicReligion.TheRandomMod.util;

import com.IslamicReligion.TheRandomMod.TheRandomMod;
import com.IslamicReligion.TheRandomMod.blocks.*;
import com.IslamicReligion.TheRandomMod.blocks.tileentity.ChestPlusTileEntity;
import com.IslamicReligion.TheRandomMod.inventories.ChestBlockContainer;
import com.IslamicReligion.TheRandomMod.inventories.ChestBlockContainerTypes;
import com.IslamicReligion.TheRandomMod.items.ItemBase;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TheRandomMod.MOD_ID);
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TheRandomMod.MOD_ID);
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, TheRandomMod.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
//        ChestBlockContainerTypes.CONTAINERS.register((FMLJavaModLoadingContext.get().getModEventBus()));
    }

    //Items
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", ItemBase::new);

    //Blocks
    public static final RegistryObject<Block> SILVER_ORE = BLOCKS.register("silver_ore", SilverOre::new);
    public static final RegistryObject<Block> SILVER_BLOCK = BLOCKS.register("silver_block", SilverBlock::new);
    public static final RegistryObject<Block> CRAFTING_TABLE_PLUSPLUS = BLOCKS.register("crafting_table_plusplus", CraftingTablePlusPlus::new);
    public static final RegistryObject<Block> CHEST_PLUS = BLOCKS.register("chest_plus", ChestPlus::new);

    public static final RegistryObject<Block> TEST_CHEST = BLOCKS.register("test_chest", TestChest::new);

    //Block Items
    public static final RegistryObject<Item> SILVER_ORE_ITEM = ITEMS.register("silver_ore", () -> new BlockItemBase(SILVER_ORE.get()));
    public static final RegistryObject<Item> SILVER_BLOCK_ITEM = ITEMS.register("silver_block", () -> new BlockItemBase(SILVER_BLOCK.get()));
    public static final RegistryObject<Item> CRAFTING_TABLE_PLUSPLUS_ITEM = ITEMS.register("crafting_table_plusplus", () -> new BlockItemBase(CRAFTING_TABLE_PLUSPLUS.get()));
    public static final RegistryObject<Item> CHEST_PLUS_ITEM = ITEMS.register("chest_plus", () -> new BlockItemBase(CHEST_PLUS.get()));

    public static final RegistryObject<Item> TEST_CHEST_ITEM = ITEMS.register("test_chest", () -> new BlockItemBase(TEST_CHEST.get()));

    // Tile Entities
    public static final RegistryObject<TileEntityType<ChestPlusTileEntity>> CHEST_PLUS_TILE_ENTITY = TILE_ENTITIES.register("chest_plus", () -> new TileEntityType<>(ChestPlusTileEntity::new, Sets.newHashSet(CHEST_PLUS.get()), null));
}
