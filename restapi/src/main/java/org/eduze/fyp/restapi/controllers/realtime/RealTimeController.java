package org.eduze.fyp.restapi.controllers.realtime;

import org.eduze.fyp.restapi.resources.FrameInfo;
import org.eduze.fyp.restapi.services.realtime.RealtimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Controller which handle all the realtime data transfers
 *
 * @author Imesha Sudasingha
 */
@Path("/realtime")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RealTimeController {

    private static final Logger logger = LoggerFactory.getLogger(RealTimeController.class);

    private RealtimeService realtimeService = new RealtimeService();

    @POST
    public Response postFrameInfo(FrameInfo frameInfo) {
        logger.debug("Received a FrameInfo request : {}", frameInfo);
        try {
            realtimeService.addFrameInfo(frameInfo);
        } catch (Exception e) {
            return Response.status(500).build();
        }

        return Response.status(200).build();
    }

    @GET
    public Response getFrameInfo() {
        logger.debug("Received frame info GET request");
        return Response.status(200).build();
    }
}
