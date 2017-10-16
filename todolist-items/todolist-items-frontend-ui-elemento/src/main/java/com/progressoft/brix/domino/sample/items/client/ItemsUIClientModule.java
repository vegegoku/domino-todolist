package com.progressoft.brix.domino.sample.items.client;

import com.google.gwt.core.client.EntryPoint;
import com.progressoft.brix.domino.api.client.ModuleConfigurator;
import com.progressoft.brix.domino.api.client.annotations.ClientModule;
import com.vaadin.polymer.Polymer;
import com.vaadin.polymer.paper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@ClientModule(name="ItemsUI")
public class ItemsUIClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(ItemsUIClientModule.class);

	public void onModuleLoad() {

		Polymer.importHref(Arrays.asList(
				PaperDialogElement.SRC,
				PaperInputElement.SRC,
				PaperTextareaElement.SRC,
				PaperButtonElement.SRC,
				PaperCheckboxElement.SRC));

		LOGGER.info("Initializing Items client UI module ...");
		new ModuleConfigurator().configureModule(new ItemsUIModuleConfiguration());
	}
}
