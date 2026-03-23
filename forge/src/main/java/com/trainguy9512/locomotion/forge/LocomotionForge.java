package com.trainguy9512.locomotion.forge;

import com.trainguy9512.locomotion.LocomotionMain;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(LocomotionMain.MOD_ID)
public class LocomotionForge {
    public LocomotionForge() {
        LocomotionMain.initialize();

        if (FMLEnvironment.dist.isClient()) {
            ModLoadingContext.get().registerExtensionPoint(
                    ConfigScreenHandler.ConfigScreenFactory.class,
                    () -> new ConfigScreenHandler.ConfigScreenFactory(
                            (minecraft, parent) -> LocomotionMain.CONFIG.getConfigScreen(
                                    modId -> net.minecraftforge.fml.ModList.get().isLoaded(modId)
                            ).apply(parent)
                    )
            );
        }
    }
}
