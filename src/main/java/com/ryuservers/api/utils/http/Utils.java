/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryuservers.api.utils.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author adamr
 */
public class Utils {
    public static Gson getStandardGsonInstance() {
        
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.registerTypeAdapter(RyuAPICallback.class, new InterfaceAdapter());
        return builder.create();
    }
}
