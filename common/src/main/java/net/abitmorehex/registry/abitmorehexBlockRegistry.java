package net.abitmorehex.registry;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.abitmorehex.abitmorehex;
import net.abitmorehex.blocks.EdifiedSignBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

import static net.abitmorehex.abitmorehex.id;
import static net.abitmorehex.registry.abitmorehexItemRegistry.ABITMOREHEX_GROUP;

public class abitmorehexBlockRegistry {
    // Register blocks and items through this
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(abitmorehex.MOD_ID, Registry.BLOCK_KEY);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(abitmorehex.MOD_ID, Registry.ITEM_KEY);

    public static void init() {
        BLOCKS.register();
        ITEMS.register();
    }

    // During the loading phase, refrain from accessing suppliers' items (e.g. EXAMPLE_ITEM.get()), they will not be available
    public static final RegistrySupplier<Block> EDIFIED_SIGNBLOCK = BLOCKS.register("edified_sign", () -> new EdifiedSignBlock(EdifiedSignBlock.Settings.copy(Blocks.OAK_SIGN).nonOpaque().noCollision()));
    public static final RegistrySupplier<Item> EDIFIED_SIGN = ITEMS.register("edified_sign", () -> new BlockItem(EDIFIED_SIGNBLOCK.get(), new Item.Settings().group(ABITMOREHEX_GROUP)));
}
