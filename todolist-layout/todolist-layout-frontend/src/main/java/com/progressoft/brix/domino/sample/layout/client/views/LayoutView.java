package com.progressoft.brix.domino.sample.layout.client.views;

import com.progressoft.brix.domino.api.client.mvp.view.View;
import com.progressoft.brix.domino.sample.layout.shared.extension.LayoutContext;

public interface LayoutView extends View {
    void show(ShowingHandler showingHandler);

    void addMenuItem(LayoutContext.LayoutMenuItem layoutMenuItem);

    void setContent(LayoutContext.LayoutContent content);

    void setCreateHandler(LayoutContext.CreateItemHandler createItemHandler);

    void closeMenu();

    void addClickHandler(ClickHandler handler);

    void showAlert();

    interface ShowingHandler {
        void onShow();
    }

    interface ClickHandler {
        void handle();
    }
}