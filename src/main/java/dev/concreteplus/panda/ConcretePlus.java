package dev.concreteplus.panda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.concreteplus.panda.ConcretePlus;
import dev.concreteplus.panda.custom.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.PressurePlateBlock.ActivationRule;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ConcretePlus implements ModInitializer {

    static String modId = "pandamc_concreteplus";

	public static final ItemGroup concrete_plus_building_group = FabricItemGroupBuilder.build(
		new Identifier("pandamc_concreteplus", "concrete_plus_building_group"), 
		() -> new ItemStack(Blocks.WHITE_CONCRETE)
	);	

    public static final Logger LOGGER = LoggerFactory.getLogger("pandamc_conreteplus");

    public static final FabricBlockSettings concrete = FabricBlockSettings.of(Material.STONE, DyeColor.WHITE).strength(1.8F);
    public static final FabricBlockSettings concrete_metal = FabricBlockSettings.of(Material.METAL, DyeColor.WHITE).strength(1.8F);

    public static final ItemGroup building = ConcretePlus.concrete_plus_building_group;

    static String[] colors = { "white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black" };
    
    private static Item registerNewElement(String path, Block entry, int index, ItemGroup group) {
        Block current = Registry.register(Registry.BLOCK, new Identifier("pandamc_concreteplus", colors[index] + path), entry);
        return Registry.register(Registry.ITEM, new Identifier("pandamc_concreteplus",  colors[index] + path), new BlockItem(current, new Item.Settings().group(group)));
    }

	public void init() {
        for (int i = 0; i < colors.length; i++) {
            registerNewElement("_concrete_slab", new CustomSlab(concrete), i, building);
            registerNewElement("_concrete_vertical_slab", new CustomVerticalSlab(concrete), i, building); 
            registerNewElement("_concrete_stairs", new CustomStairs(Blocks.WHITE_CONCRETE.getDefaultState(), concrete), i, building);
            registerNewElement("_concrete_fence", new CustomFence(concrete), i, building); 
            registerNewElement("_concrete_fence_gate", new CustomFenceGate(concrete), i, building); 
            registerNewElement("_concrete_wall", new CustomWall(concrete), i, building);
            registerNewElement("_concrete_carpet", new CustomCarpet(concrete), i, building);
            registerNewElement("_concrete_pane", new CustomPane(concrete), i, building); 
            registerNewElement("_concrete_door", new CustomDoor(concrete), i, building); 
            registerNewElement("_concrete_trapdoor", new CustomTrapDoor(concrete), i, building);
            registerNewElement("_concrete_door_powered", new CustomDoor(concrete_metal), i, building);
            registerNewElement("_concrete_trapdoor_powered", new CustomTrapDoor(concrete_metal), i, building);
            registerNewElement("_concrete_pressure_plate", new CustomPressurePlate(ActivationRule.EVERYTHING, concrete), i, building);
            registerNewElement("_concrete_weighted_pressure_plate", new CustomPressurePlate(ActivationRule.MOBS, concrete), i, building);
            registerNewElement("_concrete_button", new CustomButton(concrete), i, building);
        }
    }

    @Override
    public void onInitialize() {
        init();        
    }
}
