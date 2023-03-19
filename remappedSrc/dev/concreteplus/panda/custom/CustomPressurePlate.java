package dev.concreteplus.panda.custom;

import net.minecraft.block.PressurePlateBlock;
import net.minecraft.sound.SoundEvent;

public class CustomPressurePlate extends PressurePlateBlock{

    public CustomPressurePlate(ActivationRule type, Settings settings, SoundEvent depressSound, SoundEvent pressSound) {
        super(type, settings, depressSound, pressSound);
    }
}
