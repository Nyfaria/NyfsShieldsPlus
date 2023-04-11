package com.nyfaria.nyfsshieldsplus.client;

import com.nyfaria.nyfsshieldsplus.client.renderer.ShieldRenderer;
import net.minecraft.client.Minecraft;

public class CommonClientCode {

    public static final ShieldRenderer SHIELD_RENDERER = new ShieldRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
}
