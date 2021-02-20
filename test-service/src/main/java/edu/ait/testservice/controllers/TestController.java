package edu.ait.testservice.controllers;

import edu.ait.testservice.Configuration;
import edu.ait.testservice.entities.TestParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    Configuration config;

    @GetMapping("testconfig")
    public TestParams getTestParamsFromConfigServer() {
        return new TestParams(config.getDummyProperty1(), config.getDummyProperty2());
    }
}
