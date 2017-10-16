package com.progressoft.brix.domino.sample.items.client;

import com.google.gwtmockito.GwtMockitoTestRunner;
import com.progressoft.brix.domino.api.client.annotations.ClientModule;
import com.progressoft.brix.domino.sample.items.client.presenters.ItemsPresenterSpy;
import com.progressoft.brix.domino.sample.items.client.views.FakeItemsView;
import com.progressoft.brix.domino.test.api.client.ClientContext;
import org.junit.Test;
import org.junit.runner.RunWith;


@ClientModule(name="TestItems")
@RunWith(GwtMockitoTestRunner.class)
public class ItemsClientModuleTest{

    private ItemsPresenterSpy presenterSpy;
    private FakeItemsView fakeView;
    private ClientContext clientContext;

    @Test
    public void nothing() throws Exception {

    }

    //    @Before
//    public void setUp() {
//        presenterSpy = new ItemsPresenterSpy();
//        DominoTestClient.useModules(new ItemsModuleConfiguration(), new TestItemsModuleConfiguration())
//                .replacePresenter(ItemsPresenter.class, presenterSpy)
//                .viewOf(ItemsPresenter.class, view -> fakeView= (FakeItemsView) view)
//                .onStartCompleted(clientContext -> this.clientContext = clientContext)
//                .start();
//    }
//
//    @Test
//    public void givenItemsModule_whenContributingToMainExtensionPoint_thenShouldReceiveMainContext() throws Exception {
//        assertNotNull(presenterSpy.getMainContext());
//    }
//
//    @Test
//    public void givenItemsClientModule_whenItemsServerRequestIsSent_thenServerMessageShouldBeRecieved() {
//        clientContext.forRequest(new ItemsServerRequest().getKey()).returnResponse(new ItemsResponse("Server message"));
//        new ItemsServerRequest(){
//            @Override
//            protected void process(ItemsPresenter presenter, ItemsRequest serverArgs, ItemsResponse response) {
//                super.process(presenter, serverArgs, response);
//                assertEquals("Server message",response.getServerMessage());
//            }
//
//            @Override
//            public void processFailed(ItemsPresenter presenter, ItemsRequest serverArgs,
//                FailedServerResponse failedResponse) {
//                fail(failedResponse.getError().getMessage());
//            }
//
//            @Override
//            public String getKey() {
//                return ItemsServerRequest.class.getCanonicalName();
//            }
//        }.send();
//    }
}
