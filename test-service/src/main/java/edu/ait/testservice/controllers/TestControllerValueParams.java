package edu.ait.testservice.controllers;

import edu.ait.testservice.entities.TestParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControllerValueParams {
    //get the parameters locally using @Value
    @Value("${test-service.dummyProperty1}")
    private String param1;
    @Value("${test-service.dummyProperty2}")
    private String param2;

    @GetMapping("testparams")
    public TestParams getTestParamsFromConfigServer() {
        return new TestParams(param1, param2);
    }

}
