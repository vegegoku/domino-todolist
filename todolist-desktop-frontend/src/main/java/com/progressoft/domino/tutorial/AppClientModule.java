package com.progressoft.domino.tutorial;

import com.progressoft.brix.domino.api.client.ClientApp;
import com.progressoft.brix.domino.desktop.client.CoreModule;

import java.util.logging.Logger;

public class AppClientModule {

    private static final Logger LOGGER = Logger.getLogger(AppClientModule.class.getName());

    public static void main(String[] args) {
        CoreModule.init();
        ModuleConfigurationsLoader.load();
        ClientApp.make().run();
    }
}
