/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryuservers.api.utils.http;

import com.ryuservers.api.methods.ListOnlinePlayers;

import java.io.Serializable;
import java.util.ArrayList;

public enum DefaultConfigurationEntry {
    PORT("port", 25618),
    CALLS("calls.json");

    public static ArrayList<Entrypoint> getDefaultCallbacks() {
        ArrayList<String> tokens = new ArrayList<>();
        tokens.add("testToken");
        
        ArrayList<Entrypoint> entries = new ArrayList<>();
        Entrypoint playersOnlineCallback = new Entrypoint(new ListOnlinePlayers(), "/onlinePlayers", RequestType.GET, true, tokens);

        entries.add(playersOnlineCallback);

        return entries;
    }
    
    private String name;
    private Serializable object;

    private DefaultConfigurationEntry(String name, Serializable obj) {
        this.name = name.toLowerCase();
        this.object = obj;
    }
    
    private DefaultConfigurationEntry(Serializable obj) {
        this.name = name().toLowerCase();
        this.object = obj;
    }

    public String getName() {
        return name;
    }

    public Serializable getObject() {
        return object;
    }

    @Override
    public String toString() {
        return name;
    }
    
    

    
    
}
