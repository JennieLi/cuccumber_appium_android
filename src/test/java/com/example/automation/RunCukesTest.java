/**
 * Copyright (C) 2013 Myriad Group AG. All Rights Reserved.
 */

package com.example.automation;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(format = {
        "html:target/cucumber-html-report", "json-pretty:target/cucumber-json-report.json"
})
public class RunCukesTest {
}
