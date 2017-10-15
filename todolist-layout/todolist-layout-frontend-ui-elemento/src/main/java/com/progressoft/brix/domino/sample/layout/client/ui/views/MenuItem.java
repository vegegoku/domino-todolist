package com.progressoft.brix.domino.sample.layout.client.ui.views;

import com.vaadin.polymer.iron.IronIconElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

@Templated
public abstract class MenuItem implements IsElement<HTMLElement>{

    @DataElement
    IronIconElement itemIcon;

    @DataElement
    HTMLDivElement itemText;

    public static MenuItem create(){
        return new Templated_MenuItem();
    }

    public MenuItem init(String icon, String text){
        itemIcon.setIcon(icon);
        itemText.innerHTML=text;
        return this;
    }



}
