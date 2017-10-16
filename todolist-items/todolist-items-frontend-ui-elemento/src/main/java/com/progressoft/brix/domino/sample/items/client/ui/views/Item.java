package com.progressoft.brix.domino.sample.items.client.ui.views;

import com.progressoft.brix.domino.sample.items.client.views.ItemsView;
import com.vaadin.polymer.paper.PaperCheckboxElement;
import elemental2.dom.Element;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import static com.progressoft.brix.domino.sample.items.client.views.ItemsView.*;


@Templated
public abstract class Item implements IsElement<HTMLElement>, TodoItem {

    @DataElement
    HTMLElement title;

    @DataElement
    HTMLDivElement description;

    @DataElement
    PaperCheckboxElement done;

    public static Item create(){
        return new Templated_Item();
    }

    public Item init(String title, String description) {
        this.title.textContent=title;
        this.description.textContent=description;

        done.addEventListener("tap", evt -> {
            if(done.getChecked()){
                this.title.classList.add("done");
                this.description.classList.add("done");
            }else{
                this.title.classList.remove("done");
                this.description.classList.remove("done");
            }
        });
        return this;
    }

    @Override
    public boolean isDone() {
        return done.getActive();
    }
}
