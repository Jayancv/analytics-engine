/*
 * Copyright to Eduze@UoM 2017
 */

package org.eduze.fyp.ui;

import org.eduze.fyp.restapi.resources.Camera;
import org.eduze.fyp.restapi.resources.FrameInfo;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

public class RealTimeControllerTest extends AbstractTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RealTimeControllerTest.class);

    @Test
    public void testGetFrameInfo() {
        Client client = JerseyClientBuilder.createClient();

        UriBuilder builder = UriBuilder.fromPath("api")
                .scheme("http")
                .path("v1")
                .path("realtime")
                .host("localhost")
                .port(8085);

        WebTarget target = client.target(builder);

        logger.debug("Sending request");
        Response response = target.request(MediaType.APPLICATION_JSON)
                .get();

        Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
    }

    @Test
    public void testPostFrameInfo() {
        Client client = JerseyClientBuilder.createClient();

        UriBuilder builder = UriBuilder.fromPath("api")
                .scheme("http")
                .path("v1")
                .path("realtime")
                .host("localhost")
                .port(8085);

        WebTarget target = client.target(builder);

        float coordinates[][] = new float[5][2];
        coordinates[1][0] = 12.55f;
        coordinates[1][1] = 12.55f;

        Camera camera = new Camera(1);
        FrameInfo frameInfo = new FrameInfo();
        frameInfo.setCamera(camera);
        frameInfo.setTimestamp(System.currentTimeMillis());
        frameInfo.setCoordinates(coordinates);

        logger.debug("Sending request");
        Response response = target.request(MediaType.APPLICATION_JSON)
                .post(Entity.json(frameInfo));

        Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
    }
}