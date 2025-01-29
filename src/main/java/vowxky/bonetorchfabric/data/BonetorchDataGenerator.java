package vowxky.bonetorchfabric.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class BonetorchDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(BonetorchLootTableProvider::new);
        pack.addProvider(BonetorchRecipeProvider::new);
    }
}
