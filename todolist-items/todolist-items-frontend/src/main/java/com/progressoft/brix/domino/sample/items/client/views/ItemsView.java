package com.progressoft.brix.domino.sample.items.client.views;

import com.progressoft.brix.domino.api.client.mvp.view.View;

import java.util.List;

import static com.progressoft.brix.domino.sample.layout.shared.extension.LayoutContext.LayoutContent;


public interface ItemsView extends View{
    void showAdd();

    LayoutContent getContent();

    void addNewItemHandler(NewItemHandler newItemHandler);

    void addItem(String title, String description, SuccessAddHandler successAddHandler);

    void clearAll();

    void remove(List<TodoItem> doneItems);

    @FunctionalInterface
    interface NewItemHandler {
        void onNewItem(String title, String description);
    }

    interface SuccessAddHandler {
        void onSuccess(TodoItem item);
    }

    interface TodoItem{
        boolean isDone();
    }
}