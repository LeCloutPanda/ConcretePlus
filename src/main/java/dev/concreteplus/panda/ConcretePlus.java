package dev.concreteplus.panda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.concreteplus.panda.ConcretePlus;
import dev.concreteplus.panda.custom.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.PressurePlateBlock.ActivationRule;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ConcretePlus implements ModInitializer {

    static String modId = "pandamc_concreteplus";

    public static final Logger LOGGER = LoggerFactory.getLogger("pandamc_conreteplus");


    public static final ItemGroup concrete_plus_building_group = FabricItemGroupBuilder.build(
	    new Identifier("pandamc_concreteplus", "concrete_plus_building_group"), 
	    () -> new ItemStack(Blocks.WHITE_CONCRETE)
	);	

	public static final Settings concrete = Settings.of(Material.STONE).strength(Blocks.WHITE_CONCRETE.getBlastResistance()).hardness(Blocks.WHITE_CONCRETE.getHardness());
    public static final Settings concrete_metal = Settings.of(Material.METAL).strength(Blocks.WHITE_CONCRETE.getBlastResistance()).hardness(Blocks.WHITE_CONCRETE.getHardness());
    static String[] colors = { "white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black" };

    private static Item registerNewElement(String path, Block entry, int index, ItemGroup group) {
        Block current = Registry.register(Registry.BLOCK, new Identifier("pandamc_concreteplus", colors[index] + path), entry);
        return Registry.register(Registry.ITEM, new Identifier("pandamc_concreteplus",  colors[index] + path), new BlockItem(current, new Item.Settings().group(group)));
    }

	public void init() {
        for (int i = 0; i < colors.length; i++) {
            registerNewElement("_concrete_slab", new CustomSlab(concrete), i, concrete_plus_building_group);
            registerNewElement("_concrete_vertical_slab", new CustomVerticalSlab(concrete), i, concrete_plus_building_group);
            registerNewElement("_concrete_stairs", new CustomStairs(Blocks.WHITE_CONCRETE.getDefaultState(), concrete), i, concrete_plus_building_group); 
            registerNewElement("_concrete_fence", new CustomFence(concrete), i, concrete_plus_building_group);
            registerNewElement("_concrete_fence_gate", new CustomFenceGate(concrete), i, concrete_plus_building_group);
            registerNewElement("_concrete_wall", new CustomWall(concrete), i, concrete_plus_building_group);
            registerNewElement("_concrete_carpet", new CustomCarpet(concrete), i, concrete_plus_building_group); 
            registerNewElement("_concrete_pane", new CustomPane(concrete), i, concrete_plus_building_group); 
            registerNewElement("_concrete_door", new CustomDoor(concrete), i, concrete_plus_building_group); 
            registerNewElement("_concrete_trapdoor", new CustomTrapDoor(concrete), i, concrete_plus_building_group); 
            registerNewElement("_concrete_door_powered", new CustomDoor(concrete_metal), i, concrete_plus_building_group);
            registerNewElement("_concrete_trapdoor_powered", new CustomTrapDoor(concrete_metal), i, concrete_plus_building_group); 
            registerNewElement("_concrete_pressure_plate", new CustomPressurePlate(ActivationRule.EVERYTHING, concrete), i, concrete_plus_building_group);
            registerNewElement("_concrete_weighted_pressure_plate", new CustomPressurePlate(ActivationRule.MOBS, concrete), i, concrete_plus_building_group);
            registerNewElement("_concrete_button", new CustomButton(concrete, false), i, concrete_plus_building_group);
        }
    }

    @Override
    public void onInitialize() {
        init();   
    }
}
