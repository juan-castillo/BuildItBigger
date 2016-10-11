/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.udacity.gradle.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.gradle.jokes.Joker;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokeApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.gradle.udacity.com",
                ownerName = "backend.gradle.udacity.com",
                packagePath = ""
        )
)
public class JokeEndpoint {

    /**
     * A simple endpoint method that retrieves a joke from a joke library
     */
    @ApiMethod(name = "getJoke")
    public JokeBean getJoke() {
        JokeBean response = new JokeBean();
        response.setJoke(new Joker().getJoke());

        return response;
    }

}
