package net.abitmorehex;

import net.abitmorehex.registry.abitmorehexBlockRegistry;
import net.abitmorehex.registry.abitmorehexIotaTypeRegistry;
import net.abitmorehex.registry.abitmorehexItemRegistry;
import net.abitmorehex.registry.abitmorehexPatternRegistry;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This is effectively the loading entrypoint for most of your code, at least
 * if you are using Architectury as intended.
 */
public class abitmorehex {
    public static final String MOD_ID = "abitmorehex";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);


    public static void init() {
        LOGGER.info("aBitMore hexes is aBit and Loaded!");

        abitmorehexItemRegistry.init();
        abitmorehexBlockRegistry.init();
        abitmorehexIotaTypeRegistry.init();
        abitmorehexPatternRegistry.init();

        LOGGER.info(DummyAbstractions.getConfigDirectory().toAbsolutePath().normalize().toString());
    }

    /**
     * Shortcut for identifiers specific to this mod.
     */
    public static Identifier id(String string) {
        return new Identifier(MOD_ID, string);
    }
}
