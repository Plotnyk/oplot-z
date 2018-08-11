package app.service.transform.impl;

import java.util.List;

import app.infra.util.ReflectionUtil;

/**
 * Base functionality of the field preparation
 * @author Plotnyk
 *
 */
public class FieldProvider {
    public List<String> getFieldNames(Class<?> source, Class<?> dest) {
        return ReflectionUtil.findSimilarFields(source, dest);
    }
}
