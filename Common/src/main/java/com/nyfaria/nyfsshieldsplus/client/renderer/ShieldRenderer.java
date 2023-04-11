package com.nyfaria.nyfsshieldsplus.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.model.ShieldModel;
import net.minecraft.client.model.TridentModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BannerRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.core.Holder;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.entity.BannerPattern;

import java.util.List;

public class ShieldRenderer extends BlockEntityWithoutLevelRenderer {
    private ShieldModel shieldModel;
    private final EntityModelSet entityModelSet;
    public ShieldRenderer(BlockEntityRenderDispatcher $$0, EntityModelSet $$1) {
        super($$0, $$1);
        this.entityModelSet = $$1;
    }
    public void onResourceManagerReload(ResourceManager $$0) {
        this.shieldModel = new ShieldModel(this.entityModelSet.bakeLayer(ModelLayers.SHIELD));
    }
    @Override
    public void renderByItem(ItemStack $$0, ItemTransforms.TransformType $$1, PoseStack $$2, MultiBufferSource $$3, int $$4, int $$5) {
        boolean $$24 = BlockItem.getBlockEntityData($$0) != null;
        $$2.pushPose();
        $$2.scale(1.0F, -1.0F, -1.0F);
        Material $$25 = $$24 ? ModelBakery.SHIELD_BASE : ModelBakery.NO_PATTERN_SHIELD;
        VertexConsumer $$26 = $$25.sprite().wrap(ItemRenderer.getFoilBufferDirect($$3, this.shieldModel.renderType($$25.atlasLocation()), true, $$0.hasFoil()));
        this.shieldModel.handle().render($$2, $$26, $$4, $$5, 1.0F, 1.0F, 1.0F, 1.0F);
        if ($$24) {
            List<Pair<Holder<BannerPattern>, DyeColor>> $$27 = BannerBlockEntity.createPatterns(ShieldItem.getColor($$0), BannerBlockEntity.getItemPatterns($$0));
            BannerRenderer.renderPatterns($$2, $$3, $$4, $$5, this.shieldModel.plate(), $$25, false, $$27, $$0.hasFoil());
        } else {
            this.shieldModel.plate().render($$2, $$26, $$4, $$5, 1.0F, 1.0F, 1.0F, 1.0F);
        }

        $$2.popPose();
    }
}
