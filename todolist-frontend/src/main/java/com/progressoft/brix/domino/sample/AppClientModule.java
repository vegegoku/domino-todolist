package com.progressoft.brix.domino.sample;

import com.google.gwt.core.client.EntryPoint;
import com.progressoft.brix.domino.api.client.ClientApp;
import com.google.gwt.user.client.History;
import com.vaadin.polymer.Polymer;
import com.vaadin.polymer.PolymerFunction;
import com.vaadin.polymer.app.*;
import com.vaadin.polymer.iron.IronIconElement;
import com.vaadin.polymer.iron.IronIconsElement;
import com.vaadin.polymer.paper.*;

import java.util.Arrays;
import java.util.logging.Logger;

public class AppClientModule implements EntryPoint {

    private static final Logger LOGGER = Logger.getLogger(AppClientModule.class.getName());

    public void onModuleLoad() {
        Polymer.whenReady(o -> {
            Polymer.importHref(Arrays.asList("paper-styles", "iron-icons"), o1 -> {
                Polymer.importHref(Arrays.asList(
                        AppDrawerElement.SRC,
                        AppDrawerLayoutElement.SRC,
                        AppHeaderLayoutElement.SRC,
                        AppHeaderElement.SRC,
                        AppToolbarElement.SRC,
                        AppHeaderElement.SRC,
                        PaperItemElement.SRC,
                        PaperFabElement.SRC,
                        IronIconsElement.SRC,
                        PaperIconButtonElement.SRC,
                        PaperBadgeElement.SRC
                ));
                ClientApp.make().run();
                return 0;
            });

            return 0;
        });


        LOGGER.info("todolist Application frontend have been initialized.");
    }
}
