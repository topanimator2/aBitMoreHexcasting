package net.abitmorehex;

import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import net.abitmorehex.client.EdifiedSignBlockEntityRenderer;
import net.abitmorehex.registry.abitmorehexBlockRegistry;

public class abitmorehexClient {
    public static void init() {
        BlockEntityRendererRegistry.register(abitmorehexBlockRegistry.EDIFIED_SIGN_BLOCK_ENTITY.get(), EdifiedSignBlockEntityRenderer::new);
    }
}
