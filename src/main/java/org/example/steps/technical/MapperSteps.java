package org.example.steps.technical;

import io.cucumber.java.*;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Type;

/**
 * TECHNICAL: Steps for handling data transformations for Cucumber in TAF.
 */
public class MapperSteps extends CucumberSteps {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @DefaultParameterTransformer
    @DefaultDataTableEntryTransformer
    @DefaultDataTableCellTransformer
    public Object transformer(Object fromValue, Type toValueType) {
        return objectMapper.convertValue(fromValue, objectMapper.constructType(toValueType));
    }

}
