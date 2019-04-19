package com.serverless;

import com.serverless.handlers.AbstractRequestHandler;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InvokeBridgeWithAbstractHandlerTest {

  @Before
  public void before() {
    System.setProperty("artifactPath", "target/test-classes/com/serverless/handlers/AbstractRequestHandler.class");
    System.setProperty("className", "com.serverless.handlers.AbstractRequestHandler$InheritedTestHandler");
    System.setProperty("handlerName", "handleRequest");
  }

  @Test
  public void verifyInvoke() {
    System.setIn(getClass().getResourceAsStream("/test.json"));
    InvokeBridge.main(new String[]{});
    assertEquals("data", AbstractRequestHandler.InheritedTestHandler.result);
  }
}
