package net.abitmorehex.forge;

import net.abitmorehex.abitmorehexClient;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * Forge client loading entrypoint.
 */
public class abitmorehexClientForge {
    public static void init(FMLClientSetupEvent event) {
        abitmorehexClient.init();
    }
}
