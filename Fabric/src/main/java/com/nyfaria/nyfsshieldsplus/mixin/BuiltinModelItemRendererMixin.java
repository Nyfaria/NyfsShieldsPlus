/*
 * Copyright (c) 2016, 2017, 2018, 2019 FabricMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nyfaria.nyfsshieldsplus.mixin;

import com.nyfaria.nyfsshieldsplus.client.CommonClientCode;
import com.nyfaria.nyfsshieldsplus.init.ItemInit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.impl.client.rendering.BuiltinItemRendererRegistryImpl;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.item.ItemStack;

@Mixin(BlockEntityWithoutLevelRenderer.class)
abstract class BuiltinModelItemRendererMixin {
	@Inject(method = "renderByItem", at = @At("HEAD"), cancellable = true)
	private void fabric_onRender(ItemStack stack, ItemTransforms.TransformType mode, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay, CallbackInfo info) {
		if(stack.is(ItemInit.ADVANCED_SHIELD.get())){
			CommonClientCode.SHIELD_RENDERER.renderByItem(stack, mode, matrices, vertexConsumers, light, overlay);
			info.cancel();
		}
	}
}
