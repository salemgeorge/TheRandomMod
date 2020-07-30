package com.IslamicReligion.TheRandomMod.inventories;

import com.IslamicReligion.TheRandomMod.TheRandomMod;
import com.IslamicReligion.TheRandomMod.blocks.ChestTypes;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ChestBlockContainerTypes {

    public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, TheRandomMod.MOD_ID);

    public static void init() {
        CONTAINERS.register((FMLJavaModLoadingContext.get().getModEventBus()));
    }

    public static final RegistryObject<ContainerType<ChestBlockContainer>> CHEST_PLUS = CONTAINERS.register("chest_plus", () -> new ContainerType<>(ChestBlockContainer::createChestPlusContainer));
}
