package net.abitmorehex.blocks;

import net.abitmorehex.blocks.tileentities.EdifiedSignBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.SignBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.SignType;
import net.minecraft.util.math.BlockPos;

public class EdifiedSignBlock extends SignBlock {
    public EdifiedSignBlock(AbstractBlock.Settings settings) {
        super(settings, SignType.OAK); // Use your custom SignType if applicable
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new EdifiedSignBlockEntity(pos, state);
    }
}
