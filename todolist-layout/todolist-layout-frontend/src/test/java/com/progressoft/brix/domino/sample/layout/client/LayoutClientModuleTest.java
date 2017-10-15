package com.progressoft.brix.domino.sample.layout.client;

import com.google.gwtmockito.GwtMockitoTestRunner;
import com.progressoft.brix.domino.api.client.annotations.ClientModule;
import com.progressoft.brix.domino.sample.layout.client.presenters.LayoutPresenter;
import com.progressoft.brix.domino.sample.layout.client.presenters.LayoutPresenterSpy;
import com.progressoft.brix.domino.sample.layout.client.views.FakeLayoutView;
import com.progressoft.brix.domino.sample.layout.shared.extension.LayoutContext;
import com.progressoft.brix.domino.test.api.client.ClientContext;
import com.progressoft.brix.domino.test.api.client.DominoTestClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.progressoft.brix.domino.sample.layout.shared.extension.LayoutContext.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

@ClientModule(name = "TestLayout")
@RunWith(GwtMockitoTestRunner.class)
public class LayoutClientModuleTest {

    private LayoutPresenterSpy presenterSpy;
    private FakeLayoutView fakeView;
    private ClientContext clientContext;
    private FakeLayoutContribution fakeLayoutContribution;

    @Before
    public void setUp() {
        presenterSpy = new LayoutPresenterSpy();
        DominoTestClient.useModules(new LayoutModuleConfiguration(), new TestLayoutModuleConfiguration())
                .replacePresenter(LayoutPresenter.class, presenterSpy)
                .viewOf(LayoutPresenter.class, view -> fakeView = (FakeLayoutView) view)
                .contributionOf(FakeLayoutContribution.class, contribution -> fakeLayoutContribution = contribution)
                .onStartCompleted(clientContext -> this.clientContext = clientContext)
                .start();
    }

    @Test
    public void givenLayoutModule_whenContributingToMainExtensionPoint_thenShouldReceiveMainContextAndShowLayout() {
        assertNotNull(presenterSpy.getMainContext());
        assertThat(fakeView.isVisible()).isTrue();
    }

    @Test
    public void givenLayoutIsVisible_whenContributingToLayout_thenShouldReceiveLayoutContext() throws Exception {
        assertThat(fakeLayoutContribution.context).isNotNull();
    }

    @Test(expected = MenuItemConnotBeNullException.class)
    public void givenLayoutContext_whenAddMenuItem_thenShouldThrowException() throws Exception {
        fakeLayoutContribution.context.addMenuItem(null);
    }

    @Test
    public void givenLayoutContext_whenAddNullMenuItem_thenMenuItemShouldBeAddedToLayoutView() throws Exception {
        final LayoutMenuItem layoutMenuItem = new LayoutMenuItem() {
            @Override
            public String icon() {
                return null;
            }

            @Override
            public String text() {
                return null;
            }

            @Override
            public SelectHandler selectHandler() {
                return null;
            }
        };
        fakeLayoutContribution.context.addMenuItem(layoutMenuItem);
        assertThat(fakeView.layoutMenuItems).contains(layoutMenuItem);
    }

    @Test
    public void givenLayoutContext_whenSetContent_thenContentShouldSetInLayoutView() throws Exception {
        final LayoutContent<Object> content= () -> null;
        fakeLayoutContribution.context.setContent(content);
        assertThat(fakeView.content).isEqualTo(content);
    }

    @Test(expected = ContentConnotBeNullException.class)
    public void givenLayoutContext_whenSetNullContent_thenThrowException() throws Exception {
        fakeLayoutContribution.context.setContent(null);
    }

    @Test
    public void givenLayoutContext_whenSetAddHandler_thenShouldSetAddHandlerInLayoutView() throws Exception {
        CreateItemHandler createItemHandler= () -> {};
        fakeLayoutContribution.context.setAddHandler(createItemHandler);
        assertThat(fakeView.createHandler).isEqualTo(createItemHandler);
    }

    @Test(expected = HandlerConnotBeNullException.class)
    public void givenLayoutContext_whenSetNullCreateHandler_thenShouldThrowException() throws Exception {
        fakeLayoutContribution.context.setAddHandler(null);
    }


}
