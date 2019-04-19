package com.serverless;

import com.serverless.handlers.RequestStreamHandler;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class InvokeBridgeWithStreamTest {
  @Before
  public void before() {
    System.setProperty("artifactPath", "target/test-classes/com/serverless/handlers/RequestStreamHandler.class");
    System.setProperty("className", "com.serverless.handlers.RequestStreamHandler");
    System.setProperty("handlerName", "handleRequest");
  }

  @Test
  public void verifyInvoke() {
    System.setIn(getClass().getResourceAsStream("/test.json"));
    InvokeBridge.main(new String[]{});
    assertNotNull(RequestStreamHandler.input);
  }
}
