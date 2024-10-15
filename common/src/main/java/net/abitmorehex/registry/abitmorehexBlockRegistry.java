package net.abitmorehex.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.abitmorehex.abitmorehex;
import net.abitmorehex.blocks.EdifiedSignBlock;
import net.abitmorehex.blocks.tileentities.EdifiedSignBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

import static net.abitmorehex.registry.abitmorehexItemRegistry.ABITMOREHEX_GROUP;

public class abitmorehexBlockRegistry {
    // Register blocks, items, and block entities through this
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(abitmorehex.MOD_ID, Registry.BLOCK_KEY);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(abitmorehex.MOD_ID, Registry.ITEM_KEY);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(abitmorehex.MOD_ID, Registry.BLOCK_ENTITY_TYPE_KEY);

    public static void init() {
        BLOCKS.register();
        ITEMS.register();
        BLOCK_ENTITIES.register();
    }

    // Registering the EdifiedSignBlock and its BlockItem
    public static final RegistrySupplier<Block> EDIFIED_SIGNBLOCK = BLOCKS.register("edified_sign", () -> new EdifiedSignBlock(Block.Settings.copy(Blocks.OAK_SIGN).nonOpaque().noCollision()));
    public static final RegistrySupplier<Item> EDIFIED_SIGN_ITEM = ITEMS.register("edified_sign", () -> new BlockItem(EDIFIED_SIGNBLOCK.get(), new Item.Settings().group(ABITMOREHEX_GROUP)));

    // Registering the Tile Entity for the EdifiedSignBlock
    public static final RegistrySupplier<BlockEntityType<EdifiedSignBlockEntity>> EDIFIED_SIGN_BLOCK_ENTITY = BLOCK_ENTITIES.register("edified_sign",
            () -> BlockEntityType.Builder.create(EdifiedSignBlockEntity::new, EDIFIED_SIGNBLOCK.get()).build(null)
    );


}
