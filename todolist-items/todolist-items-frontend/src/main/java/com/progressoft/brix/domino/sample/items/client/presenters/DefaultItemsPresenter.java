package com.progressoft.brix.domino.sample.items.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.sample.items.client.views.ItemsView;
import com.progressoft.brix.domino.sample.layout.shared.extension.LayoutContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.progressoft.brix.domino.sample.layout.shared.extension.LayoutContext.*;


@Presenter
public class DefaultItemsPresenter extends BaseClientPresenter<ItemsView> implements ItemsPresenter {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultItemsPresenter.class);

    private List<ItemsView.TodoItem> addedItems = new ArrayList<>();

    @Override
    public void initView(ItemsView view) {
        view.addNewItemHandler((title, description) -> view.addItem(title, description, item -> addedItems.add(item)));
    }

    @Override
    public void contributeToLayoutModule(LayoutContext context) {

        context.setContent(view.getContent());

        context.addMenuItem(new MenuItem("delete", "Clear All", () -> {
            context.closeMenu();
            clearAll();
        }));
        context.addMenuItem(new MenuItem("clear", "Clear Done", () -> {
            context.closeMenu();
            removeDoneItems();
        }));

        context.addMenuItem(new MenuItem("settings", "Settings", () -> LOGGER.info("Settings")));
        context.addMenuItem(new MenuItem("help", "Help", () -> LOGGER.info("help")));

        context.setAddHandler(() -> view.showAdd());

    }

    private void clearAll() {
        view.clearAll();
        addedItems.clear();
    }

    private void removeDoneItems() {
        List<ItemsView.TodoItem> doneItems = addedItems.stream().filter(ItemsView.TodoItem::isDone).collect(Collectors.toList());
        view.remove(doneItems);
        addedItems.removeAll(doneItems);
    }

    class MenuItem implements LayoutMenuItem {

        private final String icon;
        private final String text;
        private final SelectHandler selectHandler;

        MenuItem(String icon, String text, SelectHandler selectHandler) {
            this.icon = icon;
            this.text = text;
            this.selectHandler = selectHandler;
        }

        @Override
        public String icon() {
            return icon;
        }

        @Override
        public String text() {
            return text;
        }

        @Override
        public SelectHandler selectHandler() {
            return selectHandler;
        }
    }
}