/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryuservers.api.utils.http;

import com.google.gson.*;

import java.lang.reflect.Type;

public class InterfaceAdapter implements JsonSerializer, JsonDeserializer {
    private static final String CLASSNAME = "CLASSNAME";
    private static final String DATA = "DATA";

        public Class getObjectClass(String className) {
            try {
                return Class.forName(className);
                } catch (ClassNotFoundException e) {
                    throw new JsonParseException(e.getMessage());
                }
        }

    @Override
    public JsonElement serialize(Object t, Type type, JsonSerializationContext jsc) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(CLASSNAME, t.getClass().getName());
        jsonObject.add(DATA, jsc.serialize(t));
        return jsonObject;
    }

    @Override
    public Object deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        JsonObject jsonObject = je.getAsJsonObject();
            JsonPrimitive prim = (JsonPrimitive) jsonObject.get(CLASSNAME);
            String className = prim.getAsString();
            Class klass = getObjectClass(className);
                return jdc.deserialize(jsonObject.get(DATA), klass);
    }
    
}
