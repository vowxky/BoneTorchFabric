package vowxky.bonetorchfabric.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import vowxky.bonetorchfabric.Bonetorchfabric;

import java.util.concurrent.CompletableFuture;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class BonetorchLootTableProvider extends FabricBlockLootTableProvider {
    protected BonetorchLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(Bonetorchfabric.BONE_TORCH, Bonetorchfabric.BONE_TORCH_ITEM);
        addDrop(Bonetorchfabric.BONE_SOUL_TORCH, Bonetorchfabric.BONE_SOUL_TORCH_ITEM);
    }

}
