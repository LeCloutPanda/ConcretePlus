package com.concreteplus.panda.registry;

import com.concreteplus.panda.ConcretePlus;
import com.concreteplus.panda.custom.*;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.PressurePlateBlock.ActivationRule;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup.Builder;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    //public static Block wc = Blocks.WHITE_CONCRETE;
//
    //public static final Settings concrete = Settings.of(Material.STONE).strength(wc.getBlastResistance()).hardness(wc.getHardness());
    //public static final Settings concrete_metal = Settings.of(Material.METAL).strength(wc.getBlastResistance()).hardness(wc.getHardness());
//
    //public static final Builder building = ConcretePlus.concrete_plus_building_group;
    //public static final Builder redstone = ConcretePlus.concrete_plus_redstone_group;
//
    //public static final ItemConvertible WHITE_CONCRETE = null;
//
    //static String[] colors = { "white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black" };
    //
    //private static Item registerNewElement(String path, Block entry, int index) {
    //    Block current = Registry.register(Registries.BLOCK, new Identifier("pandamc_concreteplus", colors[index] + path), entry);
    //    return Registry.register(Registries.ITEM, new Identifier("pandamc_concreteplus",  colors[index] + path), new BlockItem(current, new Item.Settings()));
    //}
//
	//public static void init() {
    //    for (int i = 0; i < colors.length; i++) {
    //        registerNewElement("_concrete_slab", new CustomSlab(concrete), i); // Done
    //        registerNewElement("_concrete_vertical_slab", new CustomVerticalSlab(concrete), i, building); // Done
    //        registerNewElement("_concrete_stairs", new CustomStairs(Blocks.WHITE_CONCRETE.getDefaultState(), concrete), i); // Done
    //        registerNewElement("_concrete_fence", new CustomFence(concrete), i, building); // Done
    //        registerNewElement("_concrete_fence_gate", new CustomFenceGate(concrete, null, null), i); // Done
    //        registerNewElement("_concrete_wall", new CustomWall(concrete), i); // Done
    //        registerNewElement("_concrete_carpet", new CustomCarpet(concrete), i); // Done
    //        registerNewElement("_concrete_pane", new CustomPane(concrete), i); // Done
    //        registerNewElement("_concrete_door", new CustomDoor(concrete, null, null), i); // Done
    //        registerNewElement("_concrete_trapdoor", new CustomTrapDoor(concrete, null, null), i); // Done
    //        registerNewElement("_concrete_door_powered", new CustomDoor(concrete_metal, null, null), i); // Done
    //        registerNewElement("_concrete_trapdoor_powered", new CustomTrapDoor(concrete_metal, null, null), i); // Done
    //        registerNewElement("_concrete_pressure_plate", new CustomPressurePlate(ActivationRule.EVERYTHING, concrete, null, null), i); // Done
    //        registerNewElement("_concrete_weighted_pressure_plate", new CustomPressurePlate(ActivationRule.MOBS, concrete, null, null), i); // Done
    //        registerNewElement("_concrete_button", new CustomButton(concrete, i, false, null, null), i); // Done
    //    }
    //}
}