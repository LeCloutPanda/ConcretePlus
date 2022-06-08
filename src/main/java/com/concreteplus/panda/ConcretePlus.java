package com.concreteplus.panda;

import com.concreteplus.panda.registry.ModBlocks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ConcretePlus implements ModInitializer {
	
	ModBlocks blocks = new ModBlocks();

	public static final ItemGroup concrete_plus_building_group = FabricItemGroupBuilder.build(
		new Identifier("pandamc_concreteplus", "concrete_plus_building_group"), 
		() -> new ItemStack(Blocks.WHITE_CONCRETE)
	);	
	public static final ItemGroup concrete_plus_redstone_group = FabricItemGroupBuilder.build(
		new Identifier("pandamc_concreteplus", "concrete_plus_redstone_group"), 
		() -> new ItemStack(Blocks.WHITE_CONCRETE)
	);

	@Override
	public void onInitialize() {
		blocks.init();
	}
}
