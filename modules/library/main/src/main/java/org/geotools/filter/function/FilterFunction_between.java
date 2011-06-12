package org.geotools.filter.function;

/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 * 
 *    (C) 2005-2008, Open Source Geospatial Foundation (OSGeo)
 *    
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */

//this code is autogenerated - you shouldnt be modifying it!
import static org.geotools.filter.capability.FunctionNameImpl.parameter;

import org.geotools.filter.FunctionExpressionImpl;
import org.geotools.filter.capability.FunctionNameImpl;
import org.opengis.filter.capability.FunctionName;

public class FilterFunction_between extends FunctionExpressionImpl {
    
    public static FunctionName NAME = new FunctionNameImpl("between",
            parameter("between", Boolean.class),
            parameter("value", Object.class), // they can be numbers or strings...
            parameter("low", Object.class),
            parameter("high", Object.class));
    
    public FilterFunction_between() {
        super(NAME);
    }

    public Object evaluate(Object feature) {
        Object value;
        Object low;
        Object high;

        try { // attempt to get value and perform conversion
            value = (Object) getExpression(0).evaluate(feature);
        } catch (Exception e) // probably a type error
        {
            throw new IllegalArgumentException(
                    "Filter Function problem for function between argument #0 - expected type Object");
        }

        try { // attempt to get value and perform conversion
            low = (Object) getExpression(1).evaluate(feature);
        } catch (Exception e) // probably a type error
        {
            throw new IllegalArgumentException(
                    "Filter Function problem for function between argument #1 - expected type Object");
        }

        try { // attempt to get value and perform conversion
            high = (Object) getExpression(2).evaluate(feature);
        } catch (Exception e) // probably a type error
        {
            throw new IllegalArgumentException(
                    "Filter Function problem for function between argument #2 - expected type Object");
        }

        return new Boolean(StaticGeometry.between(value, low, high));
    }
}
