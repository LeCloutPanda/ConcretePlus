package dev.concreteplus.panda.custom;

import net.minecraft.block.FenceGateBlock;
import net.minecraft.sound.SoundEvent;

public class CustomFenceGate extends FenceGateBlock{

    public CustomFenceGate(Settings settings, SoundEvent closeSound, SoundEvent openSound) {
        super(settings, closeSound, openSound);
    }
}
