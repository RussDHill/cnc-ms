package edu.ait.testservice.entities;

public class TestParams {

    private String dummyProperty1;
    private String dummyProperty2;

    public TestParams(String dummyProperty1, String dummyProperty2) {
        this.dummyProperty1 = dummyProperty1;
        this.dummyProperty2 = dummyProperty2;
    }

    public String getDummyProperty1() {
        return dummyProperty1;
    }

    public void setDummyProperty1(String dummyProperty1) {
        this.dummyProperty1 = dummyProperty1;
    }

    public String getDummyProperty2() {
        return dummyProperty2;
    }

    public void setDummyProperty2(String dummyProperty2) {
        this.dummyProperty2 = dummyProperty2;
    }
}
