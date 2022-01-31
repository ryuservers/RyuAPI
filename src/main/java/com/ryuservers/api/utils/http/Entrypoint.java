/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryuservers.api.utils.http;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author adamr
 */
public class Entrypoint implements Serializable {

    private RyuAPICallback callback;
    private String route;
    private RequestType requestType;
    private boolean tokenEnabled;
    private ArrayList<String> tokens;

    public Entrypoint(RyuAPICallback callback, String route, RequestType requestType) {
        this.callback = callback;
        this.route = route;
        this.requestType = requestType;
        this.tokenEnabled = false;
        this.tokens = new ArrayList<>();
    }

    public Entrypoint(RyuAPICallback callback, String route, RequestType requestType, boolean tokenEnabled, ArrayList<String> token) {
        this.callback = callback;
        this.route = route;
        this.requestType = requestType;
        this.tokenEnabled = tokenEnabled;
        this.tokens = token;
    }

    public RyuAPICallback getCallback() {
        return callback;
    }

    public String getRoute() {
        return route;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public boolean isTokenEnabled() {
        return tokenEnabled;
    }

    public ArrayList<String> getTokens() {
        return tokens;
    }
    
    public boolean isTokenOnList(String token) {
        return tokens.contains(token);
    }
    
    

    @Override
    public String toString() {
        return "Entrypoint{" + "callback=" + callback + ", route=" + route + ", requestType=" + requestType + '}';
    }

}
