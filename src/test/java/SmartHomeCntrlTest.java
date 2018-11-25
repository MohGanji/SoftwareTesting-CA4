import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmartHomeCntrlTest {
    @Test
    public void test1() {
        SecurityConfig securityConfig = new SecurityConfig(1, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.gas(2);
        assertEquals(new HomeState(Windows.Close, Doors.Close, Lights.NormalDay, Alarm.Off),
                smartHomeController.getHomeState());
    }
}
