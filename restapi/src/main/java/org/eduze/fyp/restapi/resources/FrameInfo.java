/*
 * Copyright to Eduze@UoM 2017
 */

package org.eduze.fyp.restapi.resources;

import org.eduze.fyp.core.api.Point;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class FrameInfo {

    private Camera camera;
    private long timestamp;
    private List<Point> coordinates;

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public List<Point> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Point> coordinates) {
        this.coordinates = coordinates;
    }

    public String toString() {
        return String.format("{ camera : %s, timestamp : %d}", camera, timestamp);
    }
}
