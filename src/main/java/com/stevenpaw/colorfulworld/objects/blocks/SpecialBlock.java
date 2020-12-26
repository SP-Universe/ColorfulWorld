package com.stevenpaw.colorfulworld.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class SpecialBlock extends Block {

    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    public static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(1, 0, 15, 15, 1, 16), Block.makeCuboidShape(0, 0, 0, 1, 1, 16), Block.makeCuboidShape(15, 0, 0, 16, 1, 16), Block.makeCuboidShape(15, 15, 0, 16, 16, 16), Block.makeCuboidShape(0, 15, 0, 1, 16, 16), Block.makeCuboidShape(0, 1, 0, 1, 15, 1), Block.makeCuboidShape(15, 1, 0, 16, 15, 1), Block.makeCuboidShape(15, 1, 15, 16, 15, 16), Block.makeCuboidShape(0, 1, 15, 1, 15, 16), Block.makeCuboidShape(1, 0, 0, 15, 1, 1), Block.makeCuboidShape(1, 15, 15, 15, 16, 16), Block.makeCuboidShape(1, 15, 0, 15, 16, 1), Block.makeCuboidShape(5, 5, 5, 11, 11, 11), Block.makeCuboidShape(11, 7, 7, 13, 9, 9), Block.makeCuboidShape(3, 7, 7, 5, 9, 9), Block.makeCuboidShape(7, 11, 7, 9, 13, 9), Block.makeCuboidShape(7, 3, 7, 9, 5, 9), Block.makeCuboidShape(7, 7, 3, 9, 9, 5), Block.makeCuboidShape(7, 7, 11, 9, 9, 13)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    public static final VoxelShape SHAPE_E = Stream.of(Block.makeCuboidShape(1, 0, 15, 15, 1, 16), Block.makeCuboidShape(0, 0, 0, 1, 1, 16), Block.makeCuboidShape(15, 0, 0, 16, 1, 16), Block.makeCuboidShape(15, 15, 0, 16, 16, 16), Block.makeCuboidShape(0, 15, 0, 1, 16, 16), Block.makeCuboidShape(0, 1, 0, 1, 15, 1), Block.makeCuboidShape(15, 1, 0, 16, 15, 1), Block.makeCuboidShape(15, 1, 15, 16, 15, 16), Block.makeCuboidShape(0, 1, 15, 1, 15, 16), Block.makeCuboidShape(1, 0, 0, 15, 1, 1), Block.makeCuboidShape(1, 15, 15, 15, 16, 16), Block.makeCuboidShape(1, 15, 0, 15, 16, 1), Block.makeCuboidShape(5, 5, 5, 11, 11, 11), Block.makeCuboidShape(11, 7, 7, 13, 9, 9), Block.makeCuboidShape(3, 7, 7, 5, 9, 9), Block.makeCuboidShape(7, 11, 7, 9, 13, 9), Block.makeCuboidShape(7, 3, 7, 9, 5, 9), Block.makeCuboidShape(7, 7, 3, 9, 9, 5), Block.makeCuboidShape(7, 7, 11, 9, 9, 13)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    public static final VoxelShape SHAPE_S = Stream.of(Block.makeCuboidShape(1, 0, 15, 15, 1, 16), Block.makeCuboidShape(0, 0, 0, 1, 1, 16), Block.makeCuboidShape(15, 0, 0, 16, 1, 16), Block.makeCuboidShape(15, 15, 0, 16, 16, 16), Block.makeCuboidShape(0, 15, 0, 1, 16, 16), Block.makeCuboidShape(0, 1, 0, 1, 15, 1), Block.makeCuboidShape(15, 1, 0, 16, 15, 1), Block.makeCuboidShape(15, 1, 15, 16, 15, 16), Block.makeCuboidShape(0, 1, 15, 1, 15, 16), Block.makeCuboidShape(1, 0, 0, 15, 1, 1), Block.makeCuboidShape(1, 15, 15, 15, 16, 16), Block.makeCuboidShape(1, 15, 0, 15, 16, 1), Block.makeCuboidShape(5, 5, 5, 11, 11, 11), Block.makeCuboidShape(11, 7, 7, 13, 9, 9), Block.makeCuboidShape(3, 7, 7, 5, 9, 9), Block.makeCuboidShape(7, 11, 7, 9, 13, 9), Block.makeCuboidShape(7, 3, 7, 9, 5, 9), Block.makeCuboidShape(7, 7, 3, 9, 9, 5), Block.makeCuboidShape(7, 7, 11, 9, 9, 13)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    public static final VoxelShape SHAPE_W = Stream.of(Block.makeCuboidShape(1, 0, 15, 15, 1, 16), Block.makeCuboidShape(0, 0, 0, 1, 1, 16), Block.makeCuboidShape(15, 0, 0, 16, 1, 16), Block.makeCuboidShape(15, 15, 0, 16, 16, 16), Block.makeCuboidShape(0, 15, 0, 1, 16, 16), Block.makeCuboidShape(0, 1, 0, 1, 15, 1), Block.makeCuboidShape(15, 1, 0, 16, 15, 1), Block.makeCuboidShape(15, 1, 15, 16, 15, 16), Block.makeCuboidShape(0, 1, 15, 1, 15, 16), Block.makeCuboidShape(1, 0, 0, 15, 1, 1), Block.makeCuboidShape(1, 15, 15, 15, 16, 16), Block.makeCuboidShape(1, 15, 0, 15, 16, 1), Block.makeCuboidShape(5, 5, 5, 11, 11, 11), Block.makeCuboidShape(11, 7, 7, 13, 9, 9), Block.makeCuboidShape(3, 7, 7, 5, 9, 9), Block.makeCuboidShape(7, 11, 7, 9, 13, 9), Block.makeCuboidShape(7, 3, 7, 9, 5, 9), Block.makeCuboidShape(7, 7, 3, 9, 9, 5), Block.makeCuboidShape(7, 7, 11, 9, 9, 13)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public SpecialBlock(Properties properties) {
        super(properties);

        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)){
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote){
            ServerWorld serverWorld = (ServerWorld)worldIn;
            LightningBoltEntity entity = new LightningBoltEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), false);
            serverWorld.addLightningBolt(entity);

            serverWorld.spawnParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, pos.getX(), pos.getY(), pos.getZ(), 25, 0,0,0,1.0f);
        }

        return  ActionResultType.SUCCESS;
    }
}
