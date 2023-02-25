package dev.concreteplus.panda;

import java.util.LinkedList;
import java.util.List;

import dev.concreteplus.panda.ConcretePlus;
import dev.concreteplus.panda.custom.*;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
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
import net.minecraft.sound.SoundEvents;

public class ConcretePlus implements ModInitializer {

    static String modId = "pandamc_concreteplus";

    static List<Item> customItems = new LinkedList<Item>();  
	public static ItemGroup concrete_plus_building_group;

	public static final Settings concrete = Settings.of(Material.STONE).strength(Blocks.WHITE_CONCRETE.getBlastResistance()).hardness(Blocks.WHITE_CONCRETE.getHardness());
    public static final Settings concrete_metal = Settings.of(Material.METAL).strength(Blocks.WHITE_CONCRETE.getBlastResistance()).hardness(Blocks.WHITE_CONCRETE.getHardness());
    static String[] colors = { "white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black" };


    private static Item registerNewElement(String path, Block entry, int index) {
        Block current = Registry.register(Registries.BLOCK, new Identifier(modId, colors[index] + path), entry);
        Item item = Registry.register(Registries.ITEM, new Identifier(modId,  colors[index] + path), new BlockItem(current, new Item.Settings()));
        customItems.add(item);
        return item;
    }

    private static void RegisterBlocksAndItems() {
        for (int i = 0; i < colors.length; i++) {
            registerNewElement("_concrete_slab", new CustomSlab(concrete), i);
            registerNewElement("_concrete_vertical_slab", new CustomVerticalSlab(concrete), i);
            registerNewElement("_concrete_stairs", new CustomStairs(Blocks.WHITE_CONCRETE.getDefaultState(), concrete), i);
            registerNewElement("_concrete_fence", new CustomFence(concrete), i);
            registerNewElement("_concrete_fence_gate", new CustomFenceGate(concrete, SoundEvents.BLOCK_FENCE_GATE_CLOSE, SoundEvents.BLOCK_FENCE_GATE_OPEN), i);
            registerNewElement("_concrete_wall", new CustomWall(concrete), i);
            registerNewElement("_concrete_carpet", new CustomCarpet(concrete), i);
            registerNewElement("_concrete_pane", new CustomPane(concrete), i);
            registerNewElement("_concrete_door", new CustomDoor(concrete, SoundEvents.BLOCK_WOODEN_DOOR_CLOSE, SoundEvents.BLOCK_WOODEN_DOOR_OPEN), i);
            registerNewElement("_concrete_trapdoor", new CustomTrapDoor(concrete, SoundEvents.BLOCK_WOODEN_TRAPDOOR_CLOSE, SoundEvents.BLOCK_WOODEN_TRAPDOOR_OPEN), i);
            registerNewElement("_concrete_door_powered", new CustomDoor(concrete_metal,  SoundEvents.BLOCK_IRON_DOOR_CLOSE, SoundEvents.BLOCK_IRON_DOOR_OPEN), i);
            registerNewElement("_concrete_trapdoor_powered", new CustomTrapDoor(concrete_metal, SoundEvents.BLOCK_IRON_TRAPDOOR_CLOSE, SoundEvents.BLOCK_IRON_TRAPDOOR_OPEN), i);
            registerNewElement("_concrete_pressure_plate", new CustomPressurePlate(ActivationRule.EVERYTHING, concrete, SoundEvents.BLOCK_STONE_PRESSURE_PLATE_CLICK_OFF, SoundEvents.BLOCK_STONE_PRESSURE_PLATE_CLICK_ON), i);
            registerNewElement("_concrete_weighted_pressure_plate", new CustomPressurePlate(ActivationRule.MOBS, concrete, SoundEvents.BLOCK_STONE_PRESSURE_PLATE_CLICK_OFF, SoundEvents.BLOCK_STONE_PRESSURE_PLATE_CLICK_ON), i);
            registerNewElement("_concrete_button", new CustomButton(concrete, 10, false, SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF, SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON), i);
        }

        concrete_plus_building_group = FabricItemGroup.builder(new Identifier(modId, "concrete_plus_group"))
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
