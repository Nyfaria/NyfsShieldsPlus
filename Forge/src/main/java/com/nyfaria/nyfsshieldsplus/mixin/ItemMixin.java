package com.nyfaria.nyfsshieldsplus.mixin;

import com.nyfaria.nyfsshieldsplus.client.CommonClientCode;
import com.nyfaria.nyfsshieldsplus.client.renderer.ShieldRenderer;
import com.nyfaria.nyfsshieldsplus.item.AdvancedShieldItem;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(Item.class)
public class ItemMixin {

    @Inject(method = "initializeClient", at=@At("HEAD"))
    public void initClient(Consumer<IClientItemExtensions> consumer, CallbackInfo ci){
        if((Item)(Object)this instanceof AdvancedShieldItem){
            consumer.accept(new IClientItemExtensions() {
                                @Override
                                public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                                    return CommonClientCode.SHIELD_RENDERER;
                                }
                            }

            );
        }
    }
}
