package it.unibo.alexpod.lam_project_signal_maps;

import com.google.android.gms.maps.model.LatLng;

import org.junit.Test;

import it.unibo.alexpod.lam_project_signal_maps.utils.CoordinateConverter;

import static org.junit.Assert.*;

public class CoordinateConverterTest {
    @Test
    public void LatLonToMrgs_isCorrect() throws Exception {
        LatLng location = new LatLng(37.4, -122.1);
        String mgrs = CoordinateConverter.LatLngToMgrs(location);
        LatLng out_location = CoordinateConverter.MgrsToLatLng(mgrs);
        assertEquals(location.latitude, out_location.latitude, 0.01);
        assertEquals(location.longitude, out_location.longitude, 0.01);
    }

    @Test
    public void MgrsToLatLon_isCorrect() throws Exception{
        String mgrs = "10SEG 79658 39627";
        LatLng latlon = CoordinateConverter.MgrsToLatLng(mgrs);
        String mgrs_out = CoordinateConverter.LatLngToMgrs(latlon);
        assertTrue(mgrs.equals(mgrs_out));
    }

    @Test
    public void LatLonToMgrsQuadrant_isCorrect() throws Exception{
        String mgrs_quadrant = "10SEG 7965 3962";
        LatLng location = new LatLng(37.39994, -122.10009 );
        String mgrs_quadrant_out = CoordinateConverter.LatLngToMgrsQuadrant(location);
        assertTrue(mgrs_quadrant_out.equals(mgrs_quadrant));
    }
}
