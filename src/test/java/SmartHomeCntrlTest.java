import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void smoke_test1() {  // TTT
        SecurityConfig securityConfig = new SecurityConfig(1, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.smoke(0);
        assertTrue(new HomeState(Windows.Open, Doors.Close, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void smoke_test2() {  // FTT
        SecurityConfig securityConfig = new SecurityConfig(1, SecurityMode.Thief_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.smoke(0);
        assertTrue(new HomeState(Windows.Close, Doors.Close, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void smoke_test3() {  // TFT
        SecurityConfig securityConfig = new SecurityConfig(1, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.smoke(0);
        assertTrue(new HomeState(Windows.Close, Doors.Close, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void smoke_test4() {  // TTF
        SecurityConfig securityConfig = new SecurityConfig(1, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.smoke(2);
        assertTrue(new HomeState(Windows.Open, Doors.Close, Lights.Emergency, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void smoke_test5() {  // FTF
        SecurityConfig securityConfig = new SecurityConfig(1, SecurityMode.Thief_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.smoke(2);
        assertTrue(new HomeState(Windows.Close, Doors.Close, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void smoke_test6() {  // TFF
        SecurityConfig securityConfig = new SecurityConfig(1, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.smoke(2);
        assertTrue(new HomeState(Windows.Close, Doors.Close, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void smoke_test7() {  // FFF
        SecurityConfig securityConfig = new SecurityConfig(1, SecurityMode.Thief_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.smoke(2);
        assertTrue(new HomeState(Windows.Close, Doors.Close, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void smoke_test8() {  // FF
        SecurityConfig securityConfig = new SecurityConfig(1, SecurityMode.Vacation_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.smoke(2);
        assertTrue(new HomeState(Windows.Open, Doors.Close, Lights.Emergency, Alarm.On).equals
                (smartHomeController.getHomeState()));
    }

    // part 2

    @Test
    public void smoke_test9() {  // FTTFT
        SecurityConfig securityConfig = new SecurityConfig(4, SecurityMode.Thief_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.smoke(2);
        assertTrue(new HomeState(Windows.Open, Doors.Open, Lights.Emergency, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void smoke_test10() {  // FFTFT
        SecurityConfig securityConfig = new SecurityConfig(4, SecurityMode.Vacation_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.smoke(2);
        assertTrue(new HomeState(Windows.Open, Doors.Close, Lights.Emergency, Alarm.On).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void smoke_test11(){  // FTFFT
        SecurityConfig securityConfig = new SecurityConfig(2, SecurityMode.Thief_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.smoke(0);
        assertTrue(new HomeState(Windows.Close, Doors.Close, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void smoke_test12(){  // FTTTT
        SecurityConfig securityConfig = new SecurityConfig(4, SecurityMode.Thief_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.smoke(2);
        assertTrue(new HomeState(Windows.Close, Doors.Close, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void smoke_test13() {  // FTTFF
        SecurityConfig securityConfig = new SecurityConfig(4, SecurityMode.Thief_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.smoke(0);
        assertTrue(new HomeState(Windows.Close, Doors.Close, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    // part 3

    @Test
    public void smoke_test14() {  // T
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Vacation_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.smoke(0);
        assertTrue(new HomeState(Windows.Open, Doors.Close, Lights.Emergency, Alarm.On).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void smoke_test15() {  // F
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.smoke(0);
        assertTrue(new HomeState(Windows.Close, Doors.Close, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }
}
