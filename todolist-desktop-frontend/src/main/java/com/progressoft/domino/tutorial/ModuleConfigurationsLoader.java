package com.progressoft.domino.tutorial;

import com.progressoft.brix.domino.api.client.ConfigurationProvider;
import com.progressoft.brix.domino.api.client.ModuleConfigurator;

import java.util.ServiceLoader;
import java.util.logging.Logger;

public class ModuleConfigurationsLoader {

    private static final Logger LOGGER = Logger.getLogger(ModuleConfigurationsLoader.class.getCanonicalName());

    public static void load() {
        ServiceLoader<ConfigurationProvider> configurations = ServiceLoader.load(ConfigurationProvider.class);
        configurations.forEach(ModuleConfigurationsLoader::configure);
    }

    private static void configure(ConfigurationProvider m) {
        new ModuleConfigurator().configureModule(m.get());
    }
}
