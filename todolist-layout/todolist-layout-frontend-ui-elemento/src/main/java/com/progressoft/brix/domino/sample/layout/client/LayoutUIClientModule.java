package com.progressoft.brix.domino.sample.layout.client;

import com.google.gwt.core.client.EntryPoint;
import com.progressoft.brix.domino.api.client.ModuleConfigurator;
import com.progressoft.brix.domino.api.client.annotations.ClientModule;

import com.vaadin.polymer.Polymer;
import com.vaadin.polymer.app.AppDrawerElement;
import com.vaadin.polymer.app.AppHeaderElement;
import com.vaadin.polymer.iron.IronIconElement;
import com.vaadin.polymer.iron.IronIconsElement;
import com.vaadin.polymer.paper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;


@ClientModule(name="LayoutUI")
public class LayoutUIClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(LayoutUIClientModule.class);

	public void onModuleLoad() {


		LOGGER.info("Initializing Layout client UI module ...");
		new ModuleConfigurator().configureModule(new LayoutUIModuleConfiguration());
	}
}
