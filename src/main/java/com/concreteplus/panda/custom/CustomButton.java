package com.concreteplus.panda.custom;

import net.minecraft.block.ButtonBlock;
import net.minecraft.sound.SoundEvent;

public class CustomButton extends ButtonBlock {

    public CustomButton(Settings settings, int pressTicks, boolean wooden, SoundEvent clickOffSound,
            SoundEvent clickOnSound) {
        super(settings, pressTicks, wooden, clickOffSound, clickOnSound);
    }       
}
