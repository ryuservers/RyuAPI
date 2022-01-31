package com.ryuservers.api.utils.http;

import com.google.gson.Gson;

import static spark.Spark.*;

public class SparkIntegrator {

    private static SparkIntegrator instance = null;
    private Gson gson;

    public static SparkIntegrator getInstance() {
        if(instance == null) {
            instance = new SparkIntegrator();
        }
        return instance;
    }

    public SparkIntegrator() {
        this.gson = Utils.getStandardGsonInstance();
    }

    public void setPort(int port) {
        port(port);
    }

    boolean fromEntryPoint(Entrypoint entryPoint) {
        switch(entryPoint.getRequestType()) {
            case GET:
                get(entryPoint.getRoute(), (request, response) -> {
                    if(entryPoint.isTokenEnabled()) {
                        if(!request.queryParams().contains("token")) {
                            return "UNAUTHORIZED";
                        }
                        if(!entryPoint.isTokenOnList(request.queryParams("token"))) {
                            return "UNAUTHORIZED";
                        }
                    }

                    response.type("application/json");
                    return entryPoint.getCallback().callWithParams(request.params());
                }, new JSONTransformer());
            case DELETE:
                delete(entryPoint.getRoute(), (request, response) -> {
                    if(entryPoint.isTokenEnabled()) {
                        if(!request.queryParams().contains("token")) {
                            return "UNAUTHORIZED";
                        }
                        if(!entryPoint.isTokenOnList(request.queryParams("token"))) {
                            return "UNAUTHORIZED";
                        }
                    }

                    response.type("application/json");
                    return entryPoint.getCallback().callWithParams(request.params());
                }, new JSONTransformer());
            case PUT:
                put(entryPoint.getRoute(), (request, response) -> {
                    if(entryPoint.isTokenEnabled()) {
                        if(!request.queryParams().contains("token")) {
                            return "UNAUTHORIZED";
                        }
                        if(!entryPoint.isTokenOnList(request.queryParams("token"))) {
                            return "UNAUTHORIZED";
                        }
                    }

                    response.type("application/json");
                    return entryPoint.getCallback().callWithParams(request.params());
                }, new JSONTransformer());
            case POST:
                post(entryPoint.getRoute(), (request, response) -> {
                    if(entryPoint.isTokenEnabled()) {
                        if(!request.queryParams().contains("token")) {
                            return "UNAUTHORIZED";
                        }
                        if(!entryPoint.isTokenOnList(request.queryParams("token"))) {
                            return "UNAUTHORIZED";
                        }
                    }

                    response.type("application/json");
                    return entryPoint.getCallback().callWithParams(request.params());
                }, new JSONTransformer());
        }
        return true;
    }

    public void configureFromConfig(RyuAPIConfiguration configuration) {
        setPort(configuration.getInt(DefaultConfigurationEntry.PORT));
        for(Entrypoint entry: configuration.deserializeEntrypoints()) {
            fromEntryPoint(entry);
        }
    }
}
