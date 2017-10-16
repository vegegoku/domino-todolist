package com.progressoft.brix.domino.sample.items.client.presenters;

import com.progressoft.brix.domino.sample.items.client.presenters.DefaultItemsPresenter;
import com.progressoft.brix.domino.api.shared.extension.MainContext;

public class ItemsPresenterSpy extends DefaultItemsPresenter{

    private MainContext mainContext;

//    @Override
//    public void contributeToMainModule(MainContext context) {
//        super.contributeToMainModule(context);
//        this.mainContext=context;
//    }

    public MainContext getMainContext() {
        return mainContext;
    }

    @Override
    protected String getConcrete() {
        return DefaultItemsPresenter.class.getCanonicalName();
    }
}
