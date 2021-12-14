package com.concreteplus.panda.custom;

import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;


public class CustomVerticalSlab extends HorizontalFacingBlock {

    private static final VoxelShape NORTH_SHAPE;
    private static final VoxelShape EAST_SHAPE;
    private static final VoxelShape SOUTH_SHAPE;
    private static final VoxelShape WEST_SHAPE;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public CustomVerticalSlab(Settings settings){
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false).with(FACING, Direction.NORTH));
    }

    @Override
    public FluidState getFluidState(BlockState blockState_1) {
        return (Boolean)blockState_1.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(blockState_1);
    }

    @Override
    public BlockRenderType getRenderType(BlockState blockState_1) {
        return BlockRenderType.MODEL;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext) {
        FluidState fluidState = itemPlacementContext.getWorld().getFluidState(itemPlacementContext.getBlockPos());
        boolean waterLog = fluidState.isIn(FluidTags.WATER) && fluidState.getLevel() == 8;
        return super.getPlacementState(itemPlacementContext).with(WATERLOGGED, waterLog)
                .with(FACING, itemPlacementContext.getPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING);
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH: return NORTH_SHAPE;
            case EAST: return EAST_SHAPE;
            case SOUTH: return SOUTH_SHAPE;
            case WEST: return WEST_SHAPE;
            default: return super.getOutlineShape(state, view, pos, context);
        }
    }
    static {
        VoxelShape shape = createCuboidShape(0, 0, 0, 8, 16, 16);

        EAST_SHAPE = shape;
        NORTH_SHAPE = rotate(Direction.EAST, Direction.NORTH, shape);
        SOUTH_SHAPE = rotate(Direction.EAST, Direction.SOUTH, shape);
        WEST_SHAPE = rotate(Direction.EAST, Direction.WEST, shape);
    }
    private static VoxelShape rotate(Direction from, Direction to, VoxelShape shape) {
        VoxelShape[] buffer = new VoxelShape[]{ shape, VoxelShapes.empty() };

        int times = (to.getHorizontal() - from.getHorizontal() + 4) % 4;
        for (int i = 0; i < times; i++) {
            buffer[0].forEachBox((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = VoxelShapes.union(buffer[1], VoxelShapes.cuboid(1-maxZ, minY, minX, 1-minZ, maxY, maxX)));
            buffer[0] = buffer[1];
            buffer[1] = VoxelShapes.empty();
        }

        return buffer[0];
    }
}