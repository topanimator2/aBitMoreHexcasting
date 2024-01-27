package net.abitmorehex.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.abitmorehex.abitmorehexClient;

/**
 * Fabric client loading entrypoint.
 */
public class abitmorehexClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        abitmorehexClient.init();
    }
}
