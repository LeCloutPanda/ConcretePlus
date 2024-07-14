package dev.concreteplus.panda;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.concreteplus.panda.ConcretePlus;
import dev.concreteplus.panda.custom.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.block.WoodType;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;

public class ConcretePlus implements ModInitializer {

    private static final String modId = "pandamc_concreteplus";
    public static final Logger LOGGER = LoggerFactory.getLogger("pandamc_conreteplus");

    private static final String[] colors = { "white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black" };
    private static final Settings settings = Settings.copy(Blocks.WHITE_CONCRETE).requiresTool().strength(Blocks.WHITE_CONCRETE.getBlastResistance()).hardness(Blocks.WHITE_CONCRETE.getHardness()).sounds(BlockSoundGroup.STONE);

    private static List<Item> customItems = new LinkedList<Item>();  
	private static ItemGroup concrete_plus_group;
    
    private static Item registerNewElement(String path, Block entry, int index) {
        Block current = Registry.register(Registries.BLOCK, Identifier.of(modId, colors[index] + path), entry);
        Item item = Registry.register(Registries.ITEM, Identifier.of(modId, colors[index] + path), new BlockItem(current, new Item.Settings()));
        customItems.add(item);
        return item;
    }

    private static void RegisterBlocksAndItems() {
        for (int i = 0; i < colors.length; i++) {
            registerNewElement("_concrete_slab",                    new CustomSlab(settings), i);
            registerNewElement("_concrete_vertical_slab",           new CustomVerticalSlab(settings), i);
            registerNewElement("_concrete_stairs",                  new CustomStairs(Blocks.WHITE_CONCRETE.getDefaultState(), settings), i);
            registerNewElement("_concrete_fence",                   new CustomFence(settings), i);
            registerNewElement("_concrete_fence_gate",              new CustomFenceGate(settings, WoodType.SPRUCE), i);
            registerNewElement("_concrete_wall",                    new CustomWall(settings), i);
            registerNewElement("_concrete_carpet",                  new CustomCarpet(settings), i);
            registerNewElement("_concrete_pane",                    new CustomPane(settings), i);
            registerNewElement("_concrete_door",                    new CustomDoor(settings, BlockSetType.STONE), i);
            registerNewElement("_concrete_trapdoor",                new CustomTrapDoor(settings, BlockSetType.STONE), i);
            registerNewElement("_concrete_door_powered",            new CustomDoor(settings, BlockSetType.IRON), i);
            registerNewElement("_concrete_trapdoor_powered",        new CustomTrapDoor(settings, BlockSetType.IRON), i);
            registerNewElement("_concrete_pressure_plate",          new CustomPressurePlate(settings, BlockSetType.STONE), i);
            registerNewElement("_concrete_weighted_pressure_plate", new CustomPressurePlate(settings, BlockSetType.STONE), i);
            registerNewElement("_concrete_button",                  new CustomButton(settings, BlockSetType.STONE, 10), i);
        }

        concrete_plus_group = FabricItemGroup.builder()
        .icon(() -> new ItemStack(customItems.get(0)))
        .displayName(Text.translatable("itemGroup.pandamc_concreteplus.concrete_plus_group"))
        .entries((context, entries) -> {
            for (int i = 0; i < customItems.size(); i++) {
                entries.add(customItems.get(i));
            }
        })
        .build();

        Registry.register(Registries.ITEM_GROUP, Identifier.of(modId, "concrete_plus_group"), concrete_plus_group);
    }

    @Override
    public void onInitialize() {
        RegisterBlocksAndItems();
    }
}
