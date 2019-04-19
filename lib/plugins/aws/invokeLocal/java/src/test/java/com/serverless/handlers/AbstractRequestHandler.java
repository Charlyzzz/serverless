package com.serverless.handlers;

import java.util.Map;

public abstract class AbstractRequestHandler implements com.amazonaws.services.lambda.runtime.RequestHandler<Map, Map> {

  abstract Map doHandle(Map event);

  @Override
  public Map handleRequest(Map event, com.amazonaws.services.lambda.runtime.Context context) {
    event.put("extra", "data");
    return doHandle(event);
  }

  public static class InheritedTestHandler extends AbstractRequestHandler {

    public static String result;

    @Override
    Map doHandle(Map event) {
      result = (String) event.get("extra");
      return event;
    }
  }
}
