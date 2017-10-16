package com.progressoft.brix.domino.sample.items.client.ui.views;

import com.vaadin.polymer.paper.PaperButtonElement;
import com.vaadin.polymer.paper.PaperDialogElement;
import com.vaadin.polymer.paper.PaperInputElement;
import com.vaadin.polymer.paper.PaperTextareaElement;
import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

@Templated
public abstract class NewItem implements IsElement<HTMLElement> {

    @DataElement
    PaperDialogElement addItemDialog;

    @DataElement
    PaperButtonElement confirmAddButton;

    @DataElement
    PaperInputElement titleInput;

    @DataElement
    PaperTextareaElement descriptionInput;

    public static NewItem create(){
        return new Templated_NewItem();
    }
}
