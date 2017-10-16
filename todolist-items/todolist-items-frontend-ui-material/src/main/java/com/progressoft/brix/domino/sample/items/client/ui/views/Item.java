package com.progressoft.brix.domino.sample.items.client.ui.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.progressoft.brix.domino.sample.items.client.views.ItemsView;
import gwt.material.design.client.ui.*;

import static com.progressoft.brix.domino.sample.items.client.ui.views.Bundle.INSTANCE;


public class Item extends Composite implements ItemsView.TodoItem {

    @UiField
    MaterialLabel titleField;

    @UiField
    MaterialLabel descriptionField;

    @UiField
    MaterialCheckBox selector;

    MaterialCollectionItem root;

    @Override
    public boolean isDone() {
        return selector.getValue();
    }


    interface ItemUiBinder extends UiBinder<MaterialCollectionItem, Item> {}

    private static ItemUiBinder uiBinder = GWT.create(ItemUiBinder.class);

    public Item() {
        root = uiBinder.createAndBindUi(this);
        initWidget(root);

    }
    public static Item create(){
        return new Item();
    }

    public Item init(String title, String description){
        titleField.setText(title);
        descriptionField.setText(description);
        return this;
    }

    @UiHandler("selector")
    void onClick(ClickEvent event){
        if(selector.getValue()){
            root.addStyleName(style().done());
        }else{
            root.removeStyleName(style().done());
        }
    }

    private ItemsBundle.Style style() {
        return INSTANCE.style();
    }
}
