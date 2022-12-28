package com.telepathicgrunt.the_bumblezone.blocks;

import com.telepathicgrunt.the_bumblezone.Bumblezone;
import com.telepathicgrunt.the_bumblezone.modinit.BzTags;
import it.unimi.dsi.fastutil.Pair;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;


public class StringCurtain extends Block {

    public static final BooleanProperty ATTACHED = BooleanProperty.create("attached");
    public static final BooleanProperty MIDDLE = BooleanProperty.create("middle");
    public static final DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
    protected final Map<Pair<Direction, Boolean>, VoxelShape> collisionShapeByMap;

    public StringCurtain() {
        this(Properties.of(Material.CLOTH_DECORATION, MaterialColor.WOOL)
                .noOcclusion()
                .noCollission()
                .lightLevel((blockState) -> 1)
                .sound(SoundType.WOOL)
                .strength(0.3F));
    }

    public static void setupStringCurtainbehaviors() {
        FlammableBlockRegistry.getDefaultInstance().add(BzTags.STRING_CURTAINS, 60, 20);

        UseBlockCallback.EVENT.register(new ResourceLocation(Bumblezone.MODID, "string_below_string_curtain"),
            (player, level, interactionHand, hitResult) -> {
                if (player != null && player.getItemInHand(interactionHand).is(BzTags.STRING_CURTAINS_CURTAIN_EXTENDING_ITEMS)) {
                    BlockPos pos = hitResult.getBlockPos().relative(hitResult.getDirection()).above();
                    BlockState aboveState = level.getBlockState(pos);
                    if (aboveState.is(BzTags.STRING_CURTAINS)) {
                        return aboveState.use(level, player, interactionHand, new BlockHitResult(
                                hitResult.getLocation().add(0, 1, 0),
                                hitResult.getDirection(),
                                pos,
                                hitResult.isInside()
                        ));
                    }
                }

                return InteractionResult.PASS;
            });
    }

    public StringCurtain(Properties properties) {
        super(properties);
        this.collisionShapeByMap = this.makeShapes();
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(ATTACHED, true)
                .setValue(MIDDLE, true)
                .setValue(HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockStateBuilder) {
        blockStateBuilder.add(ATTACHED, MIDDLE, HORIZONTAL_FACING);
    }

    protected Map<Pair<Direction, Boolean>, VoxelShape> makeShapes() {
        Map<Pair<Direction, Boolean>, VoxelShape> shapeMap = new Object2ObjectArrayMap<>();

        shapeMap.put(Pair.of(Direction.NORTH, false), Block.box(0, 0, 15, 16, 16, 16));
        shapeMap.put(Pair.of(Direction.SOUTH, false), Block.box(0, 0, 0, 16, 16, 1));
        shapeMap.put(Pair.of(Direction.WEST, false), Block.box(15, 0, 0, 16, 16, 16));
        shapeMap.put(Pair.of(Direction.EAST, false), Block.box(0, 0, 0, 1, 16, 16));

        VoxelShape temp = Block.box(0, 0, 7.5, 16, 16, 8.5);
        shapeMap.put(Pair.of(Direction.NORTH, true), temp);
        shapeMap.put(Pair.of(Direction.SOUTH, true), temp);

        temp = Block.box(7.5, 0, 0, 8.5, 16, 16);
        shapeMap.put(Pair.of(Direction.WEST, true), temp);
        shapeMap.put(Pair.of(Direction.EAST, true), temp);

        return shapeMap;
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return collisionShapeByMap.get(Pair.of(blockState.getValue(HORIZONTAL_FACING), blockState.getValue(MIDDLE)));
    }

    @Override
    public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
        if ((entity instanceof Bee || entity.getType().is(BzTags.STRING_CURTAIN_BLOCKS_PATHFINDING_FOR_NON_BEE_MOB)) &&
            !entity.getType().is(BzTags.STRING_CURTAIN_FORCE_ALLOW_PATHFINDING))
        {
            if (!entity.hasControllingPassenger() &&
                !entity.isPassenger() &&
                entity.isPushable() &&
                blockState.is(BzTags.STRING_CURTAINS))
            {
                Vec3 centerPos = blockState.getShape(level, blockPos).bounds().getCenter().add(blockPos.getX(), blockPos.getY(), blockPos.getZ());
                Vec3 beeCenter = entity.position();
                double speedSlowdown = 1.4f;
                double forcePushSpeed = 0.03f;
                if (blockState.getValue(HORIZONTAL_FACING).getAxis() == Direction.Axis.X) {
                    if (centerPos.x() > beeCenter.x()) {
                        if (entity.getDeltaMovement().x() > 0) {
                            entity.setDeltaMovement(
                                    entity.getDeltaMovement().x() / speedSlowdown,
                                    entity.getDeltaMovement().y(),
                                    entity.getDeltaMovement().z()
                            );
                        }
                        entity.push(-forcePushSpeed, 0, 0);
                    }
                    else {
                        if (entity.getDeltaMovement().x() < 0) {
                            entity.setDeltaMovement(
                                    entity.getDeltaMovement().x() / speedSlowdown,
                                    entity.getDeltaMovement().y(),
                                    entity.getDeltaMovement().z()
                            );
                        }
                        entity.push(forcePushSpeed, 0, 0);
                    }
                }
                else if (blockState.getValue(HORIZONTAL_FACING).getAxis() == Direction.Axis.Z) {
                    if (centerPos.z() > beeCenter.z()) {
                        if (entity.getDeltaMovement().z() > 0) {
                            entity.setDeltaMovement(
                                    entity.getDeltaMovement().x(),
                                    entity.getDeltaMovement().y(),
                                    entity.getDeltaMovement().z() / speedSlowdown
                            );
                        }
                        entity.push(0, 0, -forcePushSpeed);
                    }
                    else {
                        if (entity.getDeltaMovement().z() < 0) {
                            entity.setDeltaMovement(
                                    entity.getDeltaMovement().x(),
                                    entity.getDeltaMovement().y(),
                                    entity.getDeltaMovement().z() / speedSlowdown
                            );
                        }
                        entity.push(0, 0, forcePushSpeed);
                    }
                }
            }
        }

        super.entityInside(blockState, level, blockPos, entity);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        Level level = placeContext.getLevel();
        BlockPos blockpos = placeContext.getClickedPos().relative(placeContext.getClickedFace().getOpposite());
        BlockState clickedBlock = level.getBlockState(blockpos);
        if (!clickedBlock.isFaceSturdy(level, blockpos, placeContext.getClickedFace())) {
            return null;
        }

        if(placeContext.getClickedFace().getAxis() != Direction.Axis.Y) {
            return defaultBlockState()
                    .setValue(ATTACHED, true)
                    .setValue(MIDDLE, false)
                    .setValue(HORIZONTAL_FACING, placeContext.getClickedFace());
        }
        if(placeContext.getClickedFace() == Direction.DOWN) {
            return defaultBlockState()
                    .setValue(ATTACHED, true)
                    .setValue(MIDDLE, true)
                    .setValue(HORIZONTAL_FACING, placeContext.getHorizontalDirection());
        }

        return null;
    }

    @Override
    public boolean canSurvive(BlockState blockstate, LevelReader world, BlockPos pos) {
        if (!blockstate.is(BzTags.STRING_CURTAINS)) {
            return false;
        }

        if (blockstate.getValue(MIDDLE) || !blockstate.getValue(ATTACHED)) {
            BlockState aboveState = world.getBlockState(pos.above());
            return aboveState.is(BzTags.STRING_CURTAINS) || aboveState.isFaceSturdy(world, pos.above(), Direction.DOWN);
        }
        else {
            Direction facing = blockstate.getValue(HORIZONTAL_FACING);
            BlockState sideState = world.getBlockState(pos.relative(facing.getOpposite()));
            return sideState.isFaceSturdy(world, pos.relative(facing.getOpposite()), facing);
        }
    }

    @Override
    public void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, BlockPos blockPos2, boolean bl) {
        if (!level.isClientSide) {
            if (!blockState.canSurvive(level, blockPos)) {
                level.destroyBlock(blockPos, true);
            }
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public InteractionResult use(BlockState blockstate, Level world, BlockPos position, Player playerEntity, InteractionHand playerHand, BlockHitResult raytraceResult) {
        ItemStack itemstack = playerEntity.getItemInHand(playerHand);
        if (itemstack.is(BzTags.STRING_CURTAINS_CURTAIN_EXTENDING_ITEMS) && blockstate.is(BzTags.STRING_CURTAINS)) {
            BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos().set(position);
            BlockState belowState = world.getBlockState(mutableBlockPos.move(Direction.DOWN));
            while (belowState.is(BzTags.STRING_CURTAINS) && world.isInWorldBounds(mutableBlockPos)) {
                belowState = world.getBlockState(mutableBlockPos.move(Direction.DOWN));
            }

            if (world.isInWorldBounds(mutableBlockPos) && belowState.isAir()) {
                world.setBlock(
                        mutableBlockPos,
                        defaultBlockState()
                            .setValue(ATTACHED, false)
                            .setValue(MIDDLE, blockstate.getValue(MIDDLE))
                            .setValue(HORIZONTAL_FACING, blockstate.getValue(HORIZONTAL_FACING)),
                        3);

                if (!playerEntity.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
            }
            return InteractionResult.SUCCESS;
        }

        return super.use(blockstate, world, position, playerEntity, playerHand, raytraceResult);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(HORIZONTAL_FACING, rot.rotate(state.getValue(HORIZONTAL_FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(HORIZONTAL_FACING)));
    }
}