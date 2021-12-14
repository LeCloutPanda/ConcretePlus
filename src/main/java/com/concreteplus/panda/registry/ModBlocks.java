package com.concreteplus.panda.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.PressurePlateBlock.ActivationRule;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import com.concreteplus.panda.ConcretePlus;
import com.concreteplus.panda.custom.CustomButton;
import com.concreteplus.panda.custom.CustomCarpet;
import com.concreteplus.panda.custom.CustomDoor;
import com.concreteplus.panda.custom.CustomFence;
import com.concreteplus.panda.custom.CustomFenceGate;
import com.concreteplus.panda.custom.CustomPane;
import com.concreteplus.panda.custom.CustomPressurePlate;
import com.concreteplus.panda.custom.CustomSlab;
import com.concreteplus.panda.custom.CustomStairs;
import com.concreteplus.panda.custom.CustomTrapDoor;
import com.concreteplus.panda.custom.CustomVerticalSlab;
import com.concreteplus.panda.custom.CustomWall;

public class ModBlocks {
    public String modId = "pandamc_concreteplus";

    public static final FabricBlockSettings concrete = FabricBlockSettings.of(Material.STONE, DyeColor.WHITE).requiresTool().strength(1.8F);
    public static final Settings concrete_metal = FabricBlockSettings.of(Material.METAL, DyeColor.WHITE).requiresTool().strength(1.8F);
    
    public static final ItemGroup building = ConcretePlus.concrete_plus_building_group;
    public static final ItemGroup redstone = ConcretePlus.concrete_plus_redstone_group;

    public static String[] colors = { "white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black" };
    
    private static Item registerNewElement(String path, Block entry, int index, ItemGroup group) {
        Block current = Registry.register(Registry.BLOCK, new Identifier("pandamc_concreteplus", colors[index] + path), entry);
        return Registry.register(Registry.ITEM, new Identifier("pandamc_concreteplus",  colors[index] + path), new BlockItem(current, new Item.Settings().group(group)));
    }

	public void init() {
        for (int i = 0; i < colors.length; i++) {
            registerNewElement("_concrete_slab", new CustomSlab(concrete), i, building); // Done
            registerNewElement("_concrete_vertical_slab", new CustomVerticalSlab(concrete), i, building); // Done
            registerNewElement("_concrete_stairs", new CustomStairs(Blocks.WHITE_CONCRETE.getDefaultState(), concrete), i, building); // Done
            registerNewElement("_concrete_fence", new CustomFence(concrete), i, building); // Done
            registerNewElement("_concrete_fence_gate", new CustomFenceGate(concrete), i, building); // Done
            registerNewElement("_concrete_wall", new CustomWall(concrete), i, building); // Done
            registerNewElement("_concrete_carpet", new CustomCarpet(concrete), i, building); // Done
            registerNewElement("_concrete_pane", new CustomPane(concrete), i, building); // Done
            registerNewElement("_concrete_door", new CustomDoor(concrete), i, redstone); // Done
            registerNewElement("_concrete_trapdoor", new CustomTrapDoor(concrete), i, redstone); // Done
            registerNewElement("_concrete_door_powered", new CustomDoor(concrete_metal), i, redstone); // Done
            registerNewElement("_concrete_trapdoor_powered", new CustomTrapDoor(concrete_metal), i, redstone); // Done
            registerNewElement("_concrete_pressure_plate", new CustomPressurePlate(ActivationRule.EVERYTHING, concrete), i, redstone);
            registerNewElement("_concrete_weighted_pressure_plate", new CustomPressurePlate(ActivationRule.MOBS, concrete), i, redstone);
            registerNewElement("_concrete_button", new CustomButton(concrete), i, redstone);
        }
    }
}