package com.progressoft.brix.domino.sample.items.client.ui.views;

import com.progressoft.brix.domino.sample.layout.shared.extension.LayoutContext;
import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.Templated;


@Templated
public abstract class ItemsList implements IsElement<HTMLElement>, LayoutContext.LayoutContent<HTMLElement> {


    public static ItemsList create(){
        return new Templated_ItemsList();
    }

    @Override
    public HTMLElement get() {
        return this.asElement();
    }
}
