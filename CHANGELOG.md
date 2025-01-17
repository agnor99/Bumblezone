### **(V.6.7.20 Changes) (1.19.4 Minecraft)**

##### Loot:
(Forge): Made the Bee Stinger loot table not run other mod's GLM to help prevent duplicate drops when killing bee mobs.

##### Misc:
(Forge): Fixed crash at startup due to wrong event used.


### **(V.6.7.19 Changes) (1.19.4 Minecraft)**

##### Blocks:
Redid backend code for doing Crystalline Flower drops to help prevent possibly more Crystalline Flower duplicating bugs when interacting with other mod's behaviors.

##### Entities:
Added raw meat as a possible reward for trading Rotten Flesh with Bee Queen.

##### Mod Compat:
Fixed another chance calculation issue for left-clicked JEI Bee Queen trades.


### **(V.6.7.18 Changes) (1.19.4 Minecraft)**

##### Entities:
Sorry, fixed the packet size issue for real this time.
 Made absolutely sure list of items is not included in trade entry in the packet if I have the tag already for the items.


### **(V.6.7.17 Changes) (1.19.4 Minecraft)**

##### Entities:
Removed Extended Mushroom's honey mushroom cap/carpet from the main Bee Queen trades to stop it from blowing up my packet size
 and polluting the main trades with all wool/carpet trades. This is because they tag ALL mushroom cap blocks and mushroom carpets
 under the minecraft:wool and Minecraft:wool_carpet tag causing weird behaviors and issues. Like blowing up my recipe viewer packets.
 Issue report I made to them about this that they closed as won't fix: https://github.com/cech12/ExtendedMushrooms/issues/66

Fixed issue where Queen trade packet could become massive in certain situations. Now the tag size should be much smaller than before.

##### Fluids:
Fixed Bumblezone Honey Fluid turning other mod's tagged honey fluids into Glistering Honey Crystal block.

##### Mod Compat:
Fixed chances not showing correctly for left-clicked JEI Bee Queen trades.

(Forge): Fixed JEED compat

(Fabric/Quilt): Added compat with JEED mod to show what gives the effects.


### **(V.6.7.16 Changes) (1.19.4 Minecraft)**

##### Blocks:
Fixed super duper rare crash that magically happened for one person trying to open the Crystalline Flower UI while connected to a server.

Trying to open Crystalline Flower UI while it is currently opened for another player will now tell you the flower is occupied so you know why it can't be opened.

##### Client:
(Forge): Fixed random crash that occurs due to forgetting to enqueueWork some client stuff to not be multi-threaded.
  Thanks Forge for multithreading mod loading and causing us concurrency issues when we forget to enqueueWork.


### **(V.6.7.15 Changes) (1.19.4 Minecraft)**

##### Items:
Cleaned up some recipes and tags to use Bumblezone's the_bumblezone:buckets/honey tag for better compatibility.

##### Networking:
Reduced amount of data being synced to clients connecting to server due to Bee Queen trade syncing.


### **(V.6.7.14 Changes) (1.19.4 Minecraft)**

##### Dimension:
Fix rare crash when mob spawns at edge of chunk creation.

##### Blocks:
Adjusted Honeycomb Brood Block's randomTick mob spawning to hopefully reduce issue of spawning too many mobs.

##### Configs:
(Forge): Fixed musicDiscTimeLengthFlightOfTheBumblebee not showing up properly

broodBlocksBeeSpawnCapacity config option default value is now lowered to 40


### **(V.6.7.13 Changes) (1.19.4 Minecraft)**

##### Blocks:
Fixed issue where Crystalline Flower enchantment list gets confused if player upgrades the flower while still in the UI and had selected an enchantment already.

Glistering Honey Crystal now only drops a max of 4 Honey Crystal Shards when mined with Fortune 3 instead of 12 Honey Crystal Shards.

4 Honey Crystal Shards in a square will now allow crafting Glistering Honey Crystal.

##### Advancements:
Removed Beenergized requirement from the Max Flight advancement to match the advancement description properly.

##### Effects:
Slightly adjusted Wrath and Protection effect icons.

##### Mod Compat:
Added Carry On tag to disable Carry On from being able to pick up Crystalline Flower due to that action duplicating the flower.

Fixed crash with Rubidium because they ported a Sodium feature that breaks several mod's custom vertex consumers. Rip people's modpacks due to that porting.


### **(V.6.7.12 Changes) (1.19.4 Minecraft)**

##### Advancements:
(Fabric/Quilt): Fixed Bee breeding and Honey Slime breeding advancements not getting progress when breeding the mobs.


### **(V.6.7.11 Changes) (1.19.4 Minecraft)**

##### Fluids:
Fixed Sugar Water turning vanilla Water non-sources fluid blocks above into source blocks


### **(V.6.7.10 Changes) (1.19.4 Minecraft)**

##### Fluids:
(Forge): Fixed Sugar Water not turning Lava into Obsidian. Forgot to do specific thingy with Forge's Fluid API system since they removed Lava's check for Water Tagged fluids.

##### Items:
Buffed Crystal Cannon to deal damage between 8 and 13 for each projectile and consumes 1 extra durability now.

##### Mod Compat:
Added compatibility with Projectile Damage Attribute mod with my Crystal Cannon. Should allow changing the weapon's damage and projectile speed through Projectile Damage Attribute mod.
If you already have Projectile Damage Attribute mod on, update it to v3.1.0 or else it will be incompatible with v6.7.10+ Bumblezone.


### **(V.6.7.9 Changes) (1.19.4 Minecraft)**

##### Biomes:
Added mitigation efforts to stop out-of-control vanilla Slime spawns in Bumblezone if another mod removes the y < 40 check that vanilla Slime has.

##### Structures:
Honitel now spawns red flowers mostly along with several other modded red flowers. Controlled by these two block tags:
 `the_bumblezone:honitel/allowed_flowers`
 `the_bumblezone:honitel/forced_disallowed_flowers`

Added a hidden Crystalline Flower to Honey Fountain structure.

##### Fluids:
Fixed Sugar Water not properly aging up neighboring Sugar Cane blocks and nerfed its speed at growing Sugar Cane a bit.

##### Teleportation:
Fixed original dimension/position data for exiting Bumblezone being lost upon dying.

##### Lang:
Added `dimension.the_bumblezone.the_bumblezone` translation key for other mods to get the correct name of my dimension easier.


### **(V.6.7.8 Changes) (1.19.4 Minecraft)**

##### Fluids:
Added Sugar Water Bubble Columns! These Bubble Columns are triggered with Soul Sand and Magma Block like vanilla.
 Also, you can intermix vanilla Bubble Column and Sugar Water Bubble Column and the push/pull effect will propagate through the columns properly!
 The Sugar Water Bubble Column uses two block tags to determine if it is created and whether it is a push or pull column:
 `the_bumblezone:sugar_water/downward_bubble_column_causing`
 `the_bumblezone:sugar_water/upward_bubble_column_causing`

##### Items:
Fixed Sugar Water Bottle gathering by Glass Bottle in Creative mode leading to strange desync issues with inventory.

Properly record to vanilla's statistics screen more of Bumblezone's item use actions.

(Forge): Fixed food items not giving effects after drinking it more than once. (Example: Sugar Water Bottle or Royal Jelly Bottle)

##### Blocks:
Fixed Stage 4 Honeycomb Brood Block not turning into Empty Honeycomb Brood Block if player right clicks with a Glass Bottle.

##### Entities:
Fixed Beehemoth flying too fast when tamed and rode without a Saddle on

##### Structures:
Fixed Hanging Gardens not spawning flowers that are using the MultifaceBlock class.
 (Example: Wilder Wilds's Glory of the Snow flowers)

Added 2 Crystalline Flowers to Honitel structure.

##### Mod Compat:
Made Empty Honeycomb Brood Block reviving go to stage 3 brood Block instead of stage 4 if given a baby bee from 
 Productive Bees's Bee Cage, Resourceful Bees's Bee Jar, Goodall Bottled Bee, or Buzzier Bees's Bottle O' Bee.

(Forge): Fixed potential deadlock with Productive Bees comb spawning in Bumblezone dimension.

(Forge): Allow Productive Bees's and Resourceful Bees's bees to spawn from Honeycomb Brood Blocks fed by a Dispenser instead of by hand.
 Config options are added to turn this off if it breaks balance in your modpack due to automation of Brood blocks.


### **(V.6.7.7 Changes) (1.19.4 Minecraft)**

##### Teleportation:
Replaced "Loading Terrain..." screen with my own when teleporting or loading into the Bumblezone dimension.

Fixed Player teleporting out of dimension going to wrong coordinates.

Fixed Players entering Bumblezone sometimes being 1 block into ground.

##### Items:
Carpenter Bee Boots mining speed buffed a bit when boosted by presence of other bee gear on.

##### Mod Compat:
Goodall's Bottled Bee item now can be used to revive Empty Honeycomb Brood Blocks by hand or Dispenser. 

Goodall's Ant can now sometimes spawn in Hanging Gardens structure.

Disable REI overlay when in Crystalline Flower screen due to GUI not meshing well on full screen.

Backpacked's Honey Jar themed Backpack in a Curios slot will enhance Bumblezone's bee armor abilities!

(Forge): Resourceful Bees's Bee Jar now can be used to revive Empty Honeycomb Brood Blocks by hand or Dispenser.

(Forge): Productive Bees's filled Bee Cage now can be used to revive Empty Honeycomb Brood Blocks by hand or Dispenser.

(Forge): Fixed several mod compat configs not working.

(Fabric/Quilt): Fixed beeLootInjection and moddedBeeLootInjection not actually applying.


### **(V.6.7.6 Changes) (1.19.4 Minecraft)**

##### Blocks:
Fixed String Curtains able to be extended by non-op players in protected server spawn chunks. Should not happen now.

##### Items:
(Fabric/Quilt): Fixed crash with Pollen Puff flower spawning. Had to update Fake Player API.

Fixed Carpenter Bee Boots able to mine in protected server spawn chunks by non-op players. Should not happen now.

Fixed Pollen Puff thrown by non-op players able to place Pile of Pollen blocks in protected server spawn chunks. Should not happen now.

##### Fluids:
Fixed Honey Fluid and Royal Jelly Fluid able to turn all waterlogged blocks into Glistering Honey Crystal.
 Instead, the fluid should turn into the crystal instead of the waterlogged block (unless said block is marked as replaceable in their material like Seagrass)

##### Mod Compat:
Adjusted certain mod's flowers from spawning or not in the Bumblezone's Hanging Gardens structure.

Adjusted some Bee Queen trades to add some more trades using some mod's items.

Fixed Carpenter Bee Boots able to mine in claimed chunks by non-claim owners players. Only works for some claim mods.

Fixed Pollen Puff thrown by non-claim owner players able to place Pile of Pollen blocks in claimed chunks. Only works for some claim mods.

Fixed String Curtains able to be extended by non-claim owner players in claimed chunks. Only works for some claim mods.


### **(V.6.7.5 Changes) (1.19.4 Minecraft)**

##### Items:
Bee Stinger will now drop from adult Bees that still have their stinger! (Also works on modded bees that extended the Bee class)
 The drop is handled by this loot table: `the_bumblezone:entities/bee_stinger_drops`
 Also added two config options to make disabling this feature easier: beeLootInjection and moddedBeeLootInjection in configs.

Bee Stinger now can be brewed with Awkward Potion in Brewing Stand to make a Long Poison Potion!

##### Blocks:
Adjusted lighting of two blocks when in item form (Honeycomb Brood Block and Empty Honey Brood Block)

##### Fluids:
Sugar Water Bucket evaporating the fluid when placed in Nether and the likes now uses this loot table for the Sugar item drop.
 `the_bumblezone:fluids/sugar_water_evaporates`
 Allows you to customize the spawned item, how many, disable it, etc by datapacks.

##### Advancements:
Changed advancement icon to match creative menu icon

Added advancement for brewing Long Poison potion. Easiest done by using Bee Stinger as ingredient.

Added advancement to show URL to Bumblezone Wiki for those who rather look up the mod online instead.

##### Mod Compat:
(Forge): Having Queen Bee mod's Bee Antenna Helmet on will now count towards improving Bumblezone's bee armor abilities.

(Forge): Fixed Neurotoxins enchantment not being craftable with Token Enchanter mod. (Changed the 4 Suspicious Stew requirement to 1)


#### **(V.6.7.4 Changes) (1.19.4 Minecraft)**

##### Structures:
Changed how Dance Floor structure spawns Music Discs. Now it will pick a random disc to spawn from this item tag:
 `the_bumblezone:structures/dance_floor_music_discs`
 This will allow me and modpack makers to add other mod's Music Discs that feel fits to spawn in this structure.
 Windswept's Bumblebee and Biome Makeover's Red Rose Music Disc may appear in this structure if those mods are on!

##### Teleportation:
Send some packets now when teleporting to and from Bumblezone. Might help against some issues or oddities with teleporting.
 Will fix Modern Industrialization's Quantum Armor not having flight after going to/from Bumblezone. Now it will keep the ability.

##### Fluids:
Got Sugar Water Fluid to now spread to neighboring waterloggable blocks if they have 2 source blocks next to them. They will get waterlogged by vanilla Water.

##### Mod Compat:
Shows short description of Bumblezone's enchantments for Enchantment Lore mod.


### **(V.6.7.3 Changes) (1.19.4 Minecraft)**

##### Structures:
Added back Mystical Botania flowers to Honey Cocoon loot in structures. Forgot they were the "normal" flowers.
 The "special" Botania flowers still will not be permitted in structure loot for balance reasons.

##### Entities:
Adjusted Bee Queen trading so it logs error instead of crashing due to empty/broken item tags used for trading.

##### Fluids:
Added `the_bumblezone:sugar_water/forced_disallow_waterlogging_blocks_when_placed_in_fluid` block tag to allow fine tuning
 what blocks can be waterlogged when placed into Sugar Water Fluid to go along with other item tag 
 `the_bumblezone:sugar_water/waterloggable_blocks_when_placed_in_fluid`

##### Forge:
Forge Bumblezone requires v45.0.29 or newer Forge now due to needing some new Forge changes.
 As a result, Sugar Water Bucket now can waterlog more blocks so they become filled with vanilla Water.


### **(V.6.7.1 Changes) (1.19.4 Minecraft)**

##### Structures:
Fixed Honey Cave Room's Honey Cocoons still able to spawn Botania's Special/Mythical flowers.
 Was not properly reading from the `the_bumblezone:structures/disallowed_flowers_in_cocoon_loot` item tag.

##### Items:
(Fabric/Quilt): Spectrum's Bee Head item when worn will count towards boosting the abilities of Bumblezone's bee armors.


### **(V.6.7.0 Changes) (1.19.4 Minecraft)**

##### Misc:
(Forge): Fixed crash with v45.0.23 Forge due to Forge breaking change.

Renamed Bee Queen's Super Trades to Bonus Trades everywhere. This includes code, configs, and even tags such as the now-named:
 `the_bumblezone:bee_queen/disallowed_random_bonus_trade_items`
 `the_bumblezone:bee_queen/forced_allow_random_bonus_trade_items`

##### Items:
Fixed possible crash with Bee Helmet's Bee Highlighting.

Fixed Stingless Bee Helmet attempting to pick up bees while shift right-clicking bees.
 Only normal right click should pick up bees because crouching is what removes the bee from your head.
 As a result, this fixes the incompat with Carry On mod as well when wearing the helmet and shift right-clicking bees.

Decreased number of Bees that needs highlighting by Stingless Bee Helmet to complete its achievement from 100 to 60.

Buffed Honeybee Leggings to become pollinated much more often when running through flowers.

(Fabric/Quilt): Sugar Water Bucket will now be able to do regular vanilla Water waterlogging for more waterloggable blocks by faking to be vanilla water to those blocks.

Sugar Water Bucket spawns Sugar item when attempted to be placed in nether or other dimension that extinguishes water.

Bumblezone's Bee Armor abilities now scales with how many bee-themed armor/curios/trinkets you have equipped on. (Including a few other mod's bee armor/curios/trinkets)
 The armors/curios/trinkets that counts towards improving abilities such as flight time are controlled by this item tag:

  `the_bumblezone:bee_armors/bz_armor_ability_enhancing_gear`

  Compat with modded items includes these mods once they update to 1.19.4 MC:

- Traveler's Backpack's Bee Backpack (Requires backpack to be in Curios/Trinkets slot. Enable Curios/Trinkets compat in Traveler's Backpack's config)

- Dungeon Gear's Bee Nest and Beehive armor set along with their Buzzy Nest artifact.

- MC Dungeons Armors's Bee Nest and Beehive armor set.

- Dungeons Content's Bee Nest and Beehive armor set.

- Productive Bees's Bee Nest Diamond Helmet.

- Simple Hats's Bee Hat.

##### Blocks:
Fixed Crystalline Flower getting wrong enchantments if you are in flower's UI connected to server and someone else opens a flower as well.

Fixed Crystalline Flower xp requirements getting messed up on servers if use sets config to use more than 32,767 xp for a tier.

Fixed Crystalline Flower selecting wrong enchantment on servers if there is more than 127 enchantments in the UI.

Nerfed Crystalline flower so it takes 1634xp to reach max tier instead of 1451xp.

Fixed mobs trying to pathfind through Honey Cocoon instead of around or on top.

##### Fluids:
Sugar Water fluid now can allow Lilypads to be placed on it. Vanilla had a hardcoded check for vanilla water in the Lilypad code originally.

Many more waterloggable blocks can be placed into Sugar Water and be waterlogged with vanilla Water.
 If a modded block doesn't get waterlogged, try adding it to this new blockstate to see if it'll waterlog when placed into Sugar Water fluid:
 `the_bumblezone:sugar_water/waterloggable_blocks_when_placed_in_fluid`

##### Entities:
If using another mod to put passengers on the Bee Queen, now those passengers are positioned properly on the queen's back.

Royal Jelly Block/Bucket trades now have 0.11% of Dragon Egg chance down from previously 0.43%.
 Already incredibly difficult to get. Now even more of a once-in-a-lifetime chance of getting. Are you a lottery winner???

Fixed Bee Queen trades not being synced from server to client. Now clients with recipe viewers can see trades when connected to server.

##### Structures:
Slightly buffed the loot in Honitel and Pirate Ship structures. Pirate Ship loot can have Spyglass now.

Fixed one of Cell Maze's piece not having properly randomize loot in its Honey Cocoon.

Throne Pillar's queen room should not be crowded with Glistering Honey Crystals anymore.
 Also prevent the giant crystal features in a few other structures as well.

Increased chances of Pollinated Streams of having a spider spawner piece.

Added new item tag called `the_bumblezone:structures/disallowed_flowers_in_cocoon_loot` that can disallow flowers from showing
 up in Honey Cocoons in Bumblezone's structures. This is mainly used to prevent Botania's "special" flowers from
 spawning as loot for better balancing. Regular Botania flowers can still spawn. Just not overpowered flowers now.

Added new Entity Type tags that will be used for mod compat where a few of Bumblezone's Spider Spawners will be 
 converted into spawners for certain other mod's mobs. You can use these tags to quickly add rare chances of new 
 mob spawners in Bumblezone! The tags are:

- `the_bumblezone:structure_spawner_mobs/battle_cubes_rare_spawner_type`

- `the_bumblezone:structure_spawner_mobs/cell_maze_rare_spawner_type`

- `the_bumblezone:structure_spawner_mobs/pollinated_stream_rare_spawner_type`

- `the_bumblezone:structure_spawner_mobs/spider_infested_bee_dungeon_rare_spawner_type`

##### Mod Compat:
Improved and condensed the Bee Queen trades in JEI, REI, and EMI. Much less page spam when viewing all recipes on the Bee Queen Spawn Egg item.

(Forge): Chance of spawning Enemy Expansion's Ladybug mob in Hanging Gardens structure.

(Forge): Enemy Expansion's Wasp mob spawners may rarely spawn in Cell Maze, Battle Cubes, and Pollinated Streams structures.

(Forge/Fabric/Quilt): Better Animal Plus's Tarantula mob spawners may rarely spawn in Spider Infested Bee Dungeons and Pollinated Streams structures.

(Forge): Blue Skies's Nested Spider mob spawners may rarely spawn in Spider Infested Bee Dungeons.

(Forge): Blue Skies's Venom Spider mob spawners may rarely spawn in Cell Maze and Battle Cubes structures.

(Forge/Fabric/Quilt): Twilight Forest's Hedge Spider mob spawners may rarely spawn in Spider Infested Bee Dungeons, Cell Maze, and Pollinated Streams structures.

(Forge/Fabric/Quilt): Twilight Forest's Swarm Spider mob spawners may rarely spawn in Spider Infested Bee Dungeons and Cell Maze structures.

(Forge): Alchemists Garden's Spiderling mob spawners may rarely spawn in Spider Infested Bee Dungeons, Cell Maze, and Pollinated Streams structures.

(Forge): Tofucraft's Tofu Spider mob spawners may rarely spawn in Cell Maze and Pollinated Streams structures.

(Forge): Born In Chaos's Wither Spider mob spawners may rarely spawn in Battle Cubes structures.

(Forge): Earth Mobs Mod's Bone Spider mob spawners may rarely spawn in Battle Cubes structures.

(Forge): Earth Mobs Mod's Stray Bone Spider mob spawners may rarely spawn in Battle Cubes structures.

(Forge/Fabric/Quilt): Earth To Java Mobs's Bone Spider mob spawners may rarely spawn in Battle Cubes structures.

(Forge): Minecraft Earth Mod's Bone Spider mob spawners may rarely spawn in Battle Cubes structures.

(Forge): Canes Wonderful Spiders's Jumping, Wolf, and Hard Shell Spider mob spawners may rarely spawn in Spider Infested Bee Dungeons structures.

(Forge): Canes Wonderful Spiders's Black Widow and Orb Weaver mob spawners may rarely spawn in Battle Cubes structures.
