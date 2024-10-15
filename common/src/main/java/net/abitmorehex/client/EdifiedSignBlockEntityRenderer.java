package net.abitmorehex.client;

import net.abitmorehex.blocks.tileentities.EdifiedSignBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;

public class EdifiedSignBlockEntityRenderer implements BlockEntityRenderer<EdifiedSignBlockEntity> {

    private final SignBlockEntityRenderer delegate;

    public EdifiedSignBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        this.delegate = new SignBlockEntityRenderer(context);
    }

    @Override
    public void render(EdifiedSignBlockEntity blockEntity, float tickDelta, net.minecraft.client.util.math.MatrixStack matrices, net.minecraft.client.render.VertexConsumerProvider vertexConsumers, int light, int overlay) {
        delegate.render(blockEntity, tickDelta, matrices, vertexConsumers, light, overlay);
    }

    @Override
    public boolean rendersOutsideBoundingBox(EdifiedSignBlockEntity blockEntity) {
        return true;
    }
}
