//package com.progressoft.brix.domino.sample.items.server.handlers;
//
//import com.progressoft.brix.domino.api.server.handler.Handler;
//import com.progressoft.brix.domino.api.server.handler.RequestHandler;
//import com.progressoft.brix.domino.sample.items.shared.response.ItemsResponse;
//import com.progressoft.brix.domino.sample.items.shared.request.ItemsRequest;
//
//import java.util.logging.Logger;
//
///**
// * Sample request class
// */
//@Handler("ItemsRequest")
//public class ItemsHandler implements RequestHandler<ItemsRequest, ItemsResponse> {
//    private static final Logger LOGGER= Logger.getLogger(ItemsHandler.class.getName());
//    @Override
//    public ItemsResponse handleRequest(ItemsRequest request) {
//        LOGGER.info("message recieved from client : "+request.getMessage());
//        return new ItemsResponse("Server message");
//    }
//}
