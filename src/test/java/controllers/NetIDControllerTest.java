package api;

import controllers.*;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NetIDControllerTest {
    @Test
    public void getNetID() {
        NetIDController netId = new NetIDController();
        String id = netId.getNetID();
        assertEquals("hz464", id);


    }

}