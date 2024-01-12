package dev.concreteplus.panda.custom;

import net.minecraft.block.BlockSetType;
import net.minecraft.block.PressurePlateBlock;

public class CustomPressurePlate extends PressurePlateBlock{
    public CustomPressurePlate(ActivationRule type, Settings settings, BlockSetType blockSetType) {
        super(type, settings, blockSetType);
    }
}
