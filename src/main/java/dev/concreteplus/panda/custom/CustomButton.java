package dev.concreteplus.panda.custom;

import net.minecraft.block.BlockSetType;
import net.minecraft.block.ButtonBlock;

public class CustomButton extends ButtonBlock {

    public CustomButton(Settings settings, BlockSetType blockSetType, int pressTicks) {
        super(blockSetType, pressTicks, settings);
    }
}