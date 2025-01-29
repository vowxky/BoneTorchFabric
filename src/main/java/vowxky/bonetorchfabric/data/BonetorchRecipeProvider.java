package vowxky.bonetorchfabric.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import vowxky.bonetorchfabric.Bonetorchfabric;

import java.util.concurrent.CompletableFuture;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class BonetorchRecipeProvider extends FabricRecipeProvider {
    public BonetorchRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Bonetorchfabric.BONE_TORCH_ITEM, 4)
                .pattern("C")
                .pattern("B")
                .input('C', ItemTags.COALS)
                .input('B', Items.BONE)
                .criterion("has_bone", conditionsFromItem(Items.BONE))
                .offerTo(exporter, Bonetorchfabric.id("bone_torch"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Bonetorchfabric.BONE_SOUL_TORCH_ITEM, 4)
                .pattern("C")
                .pattern("B")
                .pattern("S")
                .input('C', ItemTags.COALS)
                .input('B', Items.BONE)
                .input('S', Items.SOUL_SAND)
                .criterion("has_soul_sand", conditionsFromItem(Items.SOUL_SAND))
                .offerTo(exporter, Bonetorchfabric.id("bone_soul_torch"));
    }
}
