package com.concreteplus.panda;

import java.util.LinkedList;
import java.util.List;

import com.concreteplus.panda.ConcretePlus;
import com.concreteplus.panda.custom.*;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup.Builder;
import net.minecraft.util.Identifier;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.PressurePlateBlock.ActivationRule;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ConcretePlus implements ModInitializer {
    static List<Item> customItems = new LinkedList<Item>();  
	public static ItemGroup concrete_plus_building_group;

	public static final Settings concrete = Settings.of(Material.STONE).strength(Blocks.WHITE_CONCRETE.getBlastResistance()).hardness(Blocks.WHITE_CONCRETE.getHardness());
    public static final Settings concrete_metal = Settings.of(Material.METAL).strength(Blocks.WHITE_CONCRETE.getBlastResistance()).hardness(Blocks.WHITE_CONCRETE.getHardness());
    static String[] colors = { "white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black" };


    private static Item registerNewElement(String path, Block entry, int index) {
        Block current = Registry.register(Registries.BLOCK, new Identifier("pandamc_concreteplus", colors[index] + path), entry);
        Item item = Registry.register(Registries.ITEM, new Identifier("pandamc_concreteplus",  colors[index] + path), new BlockItem(current, new Item.Settings()));
        customItems.add(item);
        return item;
    }

    private static void RegisterBlocksAndItems() {
        for (int i = 0; i < colors.length; i++) {
            registerNewElement("_concrete_slab", new CustomSlab(concrete), i); // Done
            registerNewElement("_concrete_vertical_slab", new CustomVerticalSlab(concrete), i); // Done
            registerNewElement("_concrete_stairs", new CustomStairs(Blocks.WHITE_CONCRETE.getDefaultState(), concrete), i); // Done
            registerNewElement("_concrete_fence", new CustomFence(concrete), i); // Done
            registerNewElement("_concrete_fence_gate", new CustomFenceGate(concrete, null, null), i); // Done
            registerNewElement("_concrete_wall", new CustomWall(concrete), i); // Done
            registerNewElement("_concrete_carpet", new CustomCarpet(concrete), i); // Done
            registerNewElement("_concrete_pane", new CustomPane(concrete), i); // Done
            registerNewElement("_concrete_door", new CustomDoor(concrete, null, null), i); // Done
            registerNewElement("_concrete_trapdoor", new CustomTrapDoor(concrete, null, null), i); // Done
            registerNewElement("_concrete_door_powered", new CustomDoor(concrete_metal, null, null), i); // Done
            registerNewElement("_concrete_trapdoor_powered", new CustomTrapDoor(concrete_metal, null, null), i); // Done
            registerNewElement("_concrete_pressure_plate", new CustomPressurePlate(ActivationRule.EVERYTHING, concrete, null, null), i); // Done
            registerNewElement("_concrete_weighted_pressure_plate", new CustomPressurePlate(ActivationRule.MOBS, concrete, null, null), i); // Done
            registerNewElement("_concrete_button", new CustomButton(concrete, i, false, null, null), i); // Done
        }

        concrete_plus_building_group = FabricItemGroup.builder(new Identifier("pandamc_concreteplus", "concrete_plus_group"))
        .icon(() -> new ItemStack(customItems.get(0)))
        .entries((enabledFeatures, entries, operatorEnabled) -> {
            for (Item item : customItems) {
                entries.add(item);
            }
        }).build();
    }

    @Override
    public void onInitialize() {
        RegisterBlocksAndItems();
        
    }
}
