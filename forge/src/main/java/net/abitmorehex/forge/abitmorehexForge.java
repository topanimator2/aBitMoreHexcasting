package net.abitmorehex.forge;

import dev.architectury.platform.forge.EventBuses;
import net.abitmorehex.abitmorehex;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * This is your loading entrypoint on forge, in case you need to initialize
 * something platform-specific.
 */
@Mod(abitmorehex.MOD_ID)
public class abitmorehexForge {
    public abitmorehexForge() {
        // Submit our event bus to let architectury register our content on the right time
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(abitmorehex.MOD_ID, bus);
        bus.addListener(abitmorehexClientForge::init);
        abitmorehex.init();
    }
}
