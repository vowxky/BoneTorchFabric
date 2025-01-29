package vowxky.bonetorchfabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import vowxky.bonetorchfabric.Bonetorchfabric;

public class BonetorchfabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        setupRenderLayers();
    }

    public void setupRenderLayers() {
        BlockRenderLayerMap.INSTANCE.putBlock(Bonetorchfabric.BONE_TORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Bonetorchfabric.WALL_BONE_TORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Bonetorchfabric.BONE_SOUL_TORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Bonetorchfabric.WALL_BONE_SOUL_TORCH, RenderLayer.getCutout());
    }
}
