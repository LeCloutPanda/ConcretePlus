package com.concreteplus.panda.custom;

import net.minecraft.block.DoorBlock;
import net.minecraft.sound.SoundEvent;

public class CustomDoor extends DoorBlock {
    public CustomDoor(Settings settings, SoundEvent closeSound, SoundEvent openSound) {
        super(settings, closeSound, openSound);
    }
}
