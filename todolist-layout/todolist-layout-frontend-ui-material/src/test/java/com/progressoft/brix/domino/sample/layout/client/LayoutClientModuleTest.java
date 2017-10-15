package com.progressoft.brix.domino.sample.layout.client;

import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwtmockito.GwtMockitoTestRunner;
import com.google.gwtmockito.WithClassesToStub;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;

import static org.junit.Assert.*;

import com.progressoft.brix.domino.sample.layout.client.presenters.LayoutPresenter;
import com.progressoft.brix.domino.sample.layout.client.presenters.LayoutPresenterSpy;
import com.progressoft.brix.domino.sample.layout.client.views.LayoutViewSpy;

import com.progressoft.brix.domino.test.api.client.DominoTestClient;

@RunWith(GwtMockitoTestRunner.class)
@WithClassesToStub(RootPanel.class)
public class LayoutClientModuleTest{

    private LayoutPresenterSpy presenterSpy;
    private LayoutViewSpy viewSpy;

    @Before
    public void setUp() {
        presenterSpy = new LayoutPresenterSpy();
        viewSpy = new LayoutViewSpy();
        DominoTestClient.useModules(new LayoutModuleConfiguration(), new LayoutUIModuleConfiguration())
                .replacePresenter(LayoutPresenter.class, presenterSpy)
                .replaceView(LayoutPresenter.class, viewSpy)
                .start();
    }

    @Test
    public void nothing() throws Exception {

    }
}
