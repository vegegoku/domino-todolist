package com.progressoft.brix.domino.sample.items.client.ui.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.sample.items.client.presenters.ItemsPresenter;
import com.progressoft.brix.domino.sample.items.client.views.ItemsView;
import gwt.material.design.client.ui.MaterialCollection;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialPanel;
import jsinterop.base.Js;

import java.util.List;

import static com.progressoft.brix.domino.sample.layout.shared.extension.LayoutContext.LayoutContent;


@UiView(presentable = ItemsPresenter.class)
public class DefaultItemsView extends Composite implements ItemsView, LayoutContent<MaterialContainer> {

    private final MaterialPanel root;

    @UiField
    MaterialContainer listContainer;

    @UiField
    MaterialCollection itemsCollection;

    @Override
    public MaterialContainer get() {
        return listContainer;
    }

    interface DefaultItemsViewUiBinder extends UiBinder<MaterialPanel, DefaultItemsView> {
    }

    private static DefaultItemsViewUiBinder uiBinder = GWT.create(DefaultItemsViewUiBinder.class);


    NewItemDialog newItemDialog;


    public DefaultItemsView() {
        root = uiBinder.createAndBindUi(this);
        initWidget(root);
        newItemDialog = new NewItemDialog();
        RootPanel.get().add(newItemDialog);
    }

    @Override
    public void showAdd() {
        newItemDialog.modal.open();
    }

    @Override
    public LayoutContent getContent() {
        return this;
    }

    @Override
    public void addNewItemHandler(NewItemHandler newItemHandler) {
        newItemDialog.addButton.addClickHandler(
                evt -> {
                    if(newItemDialog.titleField.getValue().isEmpty())
                        newItemDialog.titleField.setError("Title is required");
                    else {
                        newItemHandler
                                .onNewItem(newItemDialog.titleField.getValue(),
                                        newItemDialog.descriptionField.getValue());
                        newItemDialog.titleField.setValue("");
                        newItemDialog.descriptionField.setValue("");
                        newItemDialog.modal.close();
                    }
                });
    }

    @Override
    public void addItem(String title, String description, SuccessAddHandler successAddHandler) {
        Item item = Item.create().init(title, description);
        itemsCollection.add(item);
        successAddHandler.onSuccess(item);
    }

    @Override
    public void clearAll() {
        itemsCollection.clear();
    }

    @Override
    public void remove(List<TodoItem> doneItems) {
        doneItems.stream().map(todoItem -> ((Item) Js.cast(todoItem)))
                .forEach(w -> itemsCollection.remove(w));
    }
}