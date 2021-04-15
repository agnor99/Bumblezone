package net.telepathicgrunt.bumblezone;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import nerdhub.cardinal.components.api.util.RespawnCopyStrategy;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.DefaultBiomeCreator;
import net.telepathicgrunt.bumblezone.modinit.BzBlocks;
import net.telepathicgrunt.bumblezone.configs.BzConfig;
import net.telepathicgrunt.bumblezone.world.dimension.BzDimension;
import net.telepathicgrunt.bumblezone.modinit.BzEffects;
import net.telepathicgrunt.bumblezone.entities.BeeAggression;
import net.telepathicgrunt.bumblezone.modinit.BzEntities;
import net.telepathicgrunt.bumblezone.entities.IPlayerComponent;
import net.telepathicgrunt.bumblezone.entities.PlayerComponent;
import net.telepathicgrunt.bumblezone.world.features.BzConfiguredFeatures;
import net.telepathicgrunt.bumblezone.modinit.BzFeatures;
import net.telepathicgrunt.bumblezone.modinit.BzPlacements;
import net.telepathicgrunt.bumblezone.modinit.BzItems;
import net.telepathicgrunt.bumblezone.items.DispenserItemSetup;
import net.telepathicgrunt.bumblezone.modcompat.ModChecker;
import net.telepathicgrunt.bumblezone.tags.BZBlockTags;
import net.telepathicgrunt.bumblezone.tags.BZItemTags;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Bumblezone implements ModInitializer, EntityComponentInitializer {

    public static final String MODID = "the_bumblezone";
    public static final Identifier MOD_DIMENSION_ID = new Identifier(Bumblezone.MODID, Bumblezone.MODID);

    public static BzConfig BZ_CONFIG;
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static final ComponentKey<IPlayerComponent> PLAYER_COMPONENT =
            ComponentRegistry.getOrCreate(new Identifier(MODID, "player_component"), IPlayerComponent.class);

    @Override
    public void onInitialize() {
        //Set up config
        AutoConfig.register(BzConfig.class, JanksonConfigSerializer::new);
        BZ_CONFIG = AutoConfig.getConfigHolder(BzConfig.class).getConfig();

        BZBlockTags.initTags();
        BZItemTags.initTags();

        BzBlocks.registerBlocks();
        BzEntities.registerEntities();
        BzItems.registerItems();
        BzEffects.registerEffects();

        BzPlacements.registerPlacements();
        BzFeatures.registerFeatures();
        BzConfiguredFeatures.registerConfiguredFeatures();
        BzDimension.setupDimension();

        ServerWorldEvents.LOAD.register((MinecraftServer minecraftServer, ServerWorld serverWorld)-> BeeAggression.setupBeeHatingList(serverWorld));
        DispenserItemSetup.setupDispenserBehaviors();

        ModChecker.setupModCompat();
    }

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        //attach component to player
        registry.registerForPlayers(PLAYER_COMPONENT, p -> new PlayerComponent(), RespawnCopyStrategy.INVENTORY);
    }

    public static void reserveBiomeIDs() {
        //Reserve Bumblezone biome IDs for the json version to replace
        Registry.register(BuiltinRegistries.BIOME, new Identifier(Bumblezone.MODID, "hive_wall"), DefaultBiomeCreator.createTheVoid());
        Registry.register(BuiltinRegistries.BIOME, new Identifier(Bumblezone.MODID, "hive_pillar"), DefaultBiomeCreator.createTheVoid());
        Registry.register(BuiltinRegistries.BIOME, new Identifier(Bumblezone.MODID, "sugar_water_floor"), DefaultBiomeCreator.createTheVoid());
    }
}
