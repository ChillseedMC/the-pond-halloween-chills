/*License
Part of the code is based on the "Villager Hats Mod" source code by PinkGoosik
https://github.com/PinkGoosik/villager-hats
 */

package net.chillseed.thepondhalloweenchills.client.render;

import net.chillseed.thepondhalloweenchills.ThePondHalloweenChills;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;
import net.chillseed.thepondhalloweenchills.item.hats.Hat;

public class HatRenderer<T extends PlayerEntity, M extends PlayerEntityModel<T>> extends FeatureRenderer<T, M> {

    public HatRenderer(FeatureRendererContext<T, M> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, PlayerEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        ItemStack stack = entity.getEquippedStack(EquipmentSlot.HEAD);
        var biped = this.getContextModel();

        if(stack.getItem() instanceof Hat hat) {
            ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
            double height = hat.getHeight();
            float size = hat.getSize();

            matrices.push();
            biped.head.rotate(matrices);
            matrices.translate(0D, -1D, 0D);
            matrices.translate(0D, -(height), 0D);
            matrices.scale(size, size, size);
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180.0F));
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F));

            var model = new ModelIdentifier(ThePondHalloweenChills.MOD_ID, hat.getHatName(), "inventory");
            itemRenderer.renderItem(stack, ModelTransformationMode.NONE, false, matrices, vertexConsumers, light, OverlayTexture.DEFAULT_UV, itemRenderer.getModels().getModelManager().getModel(model));
            matrices.pop();
        }
    }

}
