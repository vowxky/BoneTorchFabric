package vowxky.bonetorchfabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.Item;
import net.minecraft.item.VerticallyAttachableBlockItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class Bonetorchfabric implements ModInitializer {
    public static final String MOD_ID = "bonetorchfabric";

    public static Block BONE_TORCH;
    public static Block WALL_BONE_TORCH;
    public static Item BONE_TORN_ITEM;

    @Override
    public void onInitialize() {
        registerBlocks();
        registerItems();
    }

    private void registerBlocks() {
        BONE_TORCH = registerOnlyBlock("bone_torch",
                new TorchBlock(ParticleTypes.FLAME, AbstractBlock.Settings.copy(Blocks.TORCH).sounds(BlockSoundGroup.BONE)));
        WALL_BONE_TORCH = registerOnlyBlock("bone_wall_torch",
                new WallTorchBlock(ParticleTypes.FLAME, AbstractBlock.Settings.copy(Blocks.WALL_TORCH).dropsLike(BONE_TORCH).sounds(BlockSoundGroup.BONE)));
    }

    private void registerItems() {
        BONE_TORN_ITEM = registerBlockItem("bone_torch",
                new VerticallyAttachableBlockItem(BONE_TORCH, WALL_BONE_TORCH, new Item.Settings(), Direction.DOWN));
    }

    private static Block registerOnlyBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name), item);
    }
}