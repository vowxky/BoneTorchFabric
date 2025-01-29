package vowxky.bonetorchfabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
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
    public static Item BONE_TORCH_ITEM;

    public static Block BONE_SOUL_TORCH;
    public static Block WALL_BONE_SOUL_TORCH;
    public static Item BONE_SOUL_TORCH_ITEM;

    @Override
    public void onInitialize() {
        registerBlocks();
        registerItems();
        addItemsCreativetab();
    }

    private void registerBlocks() {
        BONE_TORCH = registerOnlyBlock("bone_torch",
                new TorchBlock(ParticleTypes.FLAME, AbstractBlock.Settings.copy(Blocks.TORCH).sounds(BlockSoundGroup.BONE)));
        WALL_BONE_TORCH = registerOnlyBlock("bone_wall_torch",
                new WallTorchBlock(ParticleTypes.FLAME, AbstractBlock.Settings.copy(Blocks.TORCH).dropsLike(BONE_TORCH)));

        BONE_SOUL_TORCH = registerOnlyBlock("bone_soul_torch",
                new TorchBlock(ParticleTypes.SOUL_FIRE_FLAME, AbstractBlock.Settings.copy(Blocks.SOUL_TORCH).sounds(BlockSoundGroup.BONE)));
        WALL_BONE_SOUL_TORCH = registerOnlyBlock("bone_soul_wall_torch",
                new WallTorchBlock(ParticleTypes.SOUL_FIRE_FLAME, AbstractBlock.Settings.copy(Blocks.SOUL_TORCH).dropsLike(BONE_SOUL_TORCH).sounds(BlockSoundGroup.BONE)));
    }

    private void registerItems() {
        BONE_TORCH_ITEM = registerBlockItem("bone_torch",
                new VerticallyAttachableBlockItem(BONE_TORCH, WALL_BONE_TORCH, new Item.Settings(), Direction.DOWN));
        BONE_SOUL_TORCH_ITEM = registerBlockItem("bone_soul_torch",
                new VerticallyAttachableBlockItem(BONE_SOUL_TORCH, WALL_BONE_SOUL_TORCH, new Item.Settings(), Direction.DOWN));
    }

    private void addItemsCreativetab(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(new ItemStack(Bonetorchfabric.BONE_TORCH_ITEM));
            entries.add(new ItemStack(Bonetorchfabric.BONE_SOUL_TORCH_ITEM));
        });
    }

    private static Block registerOnlyBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, id(name), block);
    }

    private static Item registerBlockItem(String name, Item item) {
        return Registry.register(Registries.ITEM, id(name), item);
    }

    public static Identifier id(String path){
        return Identifier.of(MOD_ID, path);
    }
}