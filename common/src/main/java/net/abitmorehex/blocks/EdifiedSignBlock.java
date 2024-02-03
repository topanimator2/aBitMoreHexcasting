package net.abitmorehex.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SignBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.property.Properties;
import net.minecraft.util.SignType;

public class EdifiedSignBlock extends SignBlock {
    public EdifiedSignBlock(AbstractBlock.Settings settings) {
        super(settings, SignType.CRIMSON);
    }

    @Override
    public net.minecraft.block.BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(Properties.ROTATION, ctx.getPlayerFacing().getOpposite().getHorizontal());
    }
}
