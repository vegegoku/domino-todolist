package com.progressoft.brix.domino.sample.items.client;

import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwtmockito.GwtMockitoTestRunner;
import com.google.gwtmockito.WithClassesToStub;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;

import static org.junit.Assert.*;

import com.progressoft.brix.domino.sample.items.client.presenters.ItemsPresenter;
import com.progressoft.brix.domino.sample.items.client.presenters.ItemsPresenterSpy;
import com.progressoft.brix.domino.sample.items.client.views.ItemsViewSpy;

import com.progressoft.brix.domino.test.api.client.DominoTestClient;

@RunWith(GwtMockitoTestRunner.class)
@WithClassesToStub(RootPanel.class)
public class ItemsClientModuleTest{

    private ItemsPresenterSpy presenterSpy;
    private ItemsViewSpy viewSpy;

    @Before
    public void setUp() {
        presenterSpy = new ItemsPresenterSpy();
        viewSpy = new ItemsViewSpy();
        DominoTestClient.useModules(new ItemsModuleConfiguration(), new ItemsUIModuleConfiguration())
                .replacePresenter(ItemsPresenter.class, presenterSpy)
                .replaceView(ItemsPresenter.class, viewSpy)
                .start();
    }

    @Test
    public void nothing() throws Exception {

    }
}
