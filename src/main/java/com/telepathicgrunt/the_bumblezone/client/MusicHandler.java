package com.telepathicgrunt.the_bumblezone.client;

import com.telepathicgrunt.the_bumblezone.Bumblezone;
import com.telepathicgrunt.the_bumblezone.modinit.BzSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;

public class MusicHandler {

    private static ISound ANGRY_BEE_MUSIC = null;
    private static final ResourceLocation BIOME_MUSIC = new ResourceLocation(Bumblezone.MODID, "biome_music");

    // CLIENT-SIDED
    public static void playAngryBeeMusic(PlayerEntity entity){
        Minecraft minecraftClient = Minecraft.getInstance();
        if(!entity.isCreative() && entity == minecraftClient.player && !minecraftClient.getSoundHandler().isPlaying(ANGRY_BEE_MUSIC)){
            ANGRY_BEE_MUSIC = SimpleSound.music(BzSounds.ANGERED_BEES.get());
            minecraftClient.getSoundHandler().play(ANGRY_BEE_MUSIC);
        }
        minecraftClient.getSoundHandler().stop(BIOME_MUSIC, SoundCategory.MUSIC);
    }

    // CLIENT-SIDED
    public static void stopAngryBeeMusic(PlayerEntity entity){
        Minecraft minecraftClient = Minecraft.getInstance();
        if(entity == minecraftClient.player && ANGRY_BEE_MUSIC != null){
            minecraftClient.getSoundHandler().stop(ANGRY_BEE_MUSIC);
        }
    }
}
