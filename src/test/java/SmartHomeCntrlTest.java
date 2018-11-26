import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
        assertTrue(new HomeState(Windows.Open, Doors.Close, Lights.Off, Alarm.Off).equals
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

    @Test
    public void gas_test1() {  // TTF
        SecurityConfig securityConfig = new SecurityConfig(1, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.gas(2);
        assertTrue(new HomeState(Windows.Open, Doors.Close, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void gas_test2() {  // TFT
        SecurityConfig securityConfig = new SecurityConfig(1, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.gas(2);
        assertTrue(new HomeState(Windows.Open, Doors.Close, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void gas_test3() {  // FTF
        SecurityConfig securityConfig = new SecurityConfig(1, SecurityMode.Vacation_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.gas(2);
        assertFalse(new HomeState(Windows.Open, Doors.Close, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void gas_test4() {  // TFF
        SecurityConfig securityConfig = new SecurityConfig(1, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.gas(2);
        assertFalse(new HomeState(Windows.Open, Doors.Close, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void gas_test5() {  // FFT
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Vacation_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.gas(2);
        assertFalse(new HomeState(Windows.Open, Doors.Close, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void gas_test6() {  // TTT
        SecurityConfig securityConfig = new SecurityConfig(3, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.gas(2);
        assertTrue(new HomeState(Windows.Open, Doors.Close, Lights.Off, Alarm.On).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void gas_test7() {  // FFF
        SecurityConfig securityConfig = new SecurityConfig(3, SecurityMode.Vacation_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.gas(2);
        assertFalse(new HomeState(Windows.Open, Doors.Close, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void gas_test8() {  // TF
        SecurityConfig securityConfig = new SecurityConfig(2, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.gas(2);
        assertTrue(new HomeState(Windows.Open, Doors.Close, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void gas_test9() {  // FT
        SecurityConfig securityConfig = new SecurityConfig(3, SecurityMode.Vacation_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.gas(2);
        assertFalse(new HomeState(Windows.Open, Doors.Close, Lights.Off, Alarm.On).equals
                (smartHomeController.getHomeState()));
    }

    // part 2

    @Test
    public void gas_test10() {  // TFTT
        SecurityConfig securityConfig = new SecurityConfig(5, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.gas(2);
        assertTrue(new HomeState(Windows.Open, Doors.Open, Lights.Emergency, Alarm.On).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void gas_test11() {  // FFTT
        SecurityConfig securityConfig = new SecurityConfig(5, SecurityMode.Vacation_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.gas(2);
        assertFalse(new HomeState(Windows.Open, Doors.Open, Lights.Emergency, Alarm.On).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void gas_test12() {  // TTTT
        SecurityConfig securityConfig = new SecurityConfig(5, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.gas(2);
        assertFalse(new HomeState(Windows.Open, Doors.Open, Lights.Emergency, Alarm.On).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void gas_test13() {  // TFFT
        SecurityConfig securityConfig = new SecurityConfig(3, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.gas(2);
        assertFalse(new HomeState(Windows.Open, Doors.Open, Lights.Emergency, Alarm.On).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void gas_test14() {  // TFTF
        SecurityConfig securityConfig = new SecurityConfig(5, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.gas(0);
        assertFalse(new HomeState(Windows.Open, Doors.Open, Lights.Emergency, Alarm.On).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void gas_test15() {  // FTFF
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Vacation_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.gas(0);
        assertFalse(new HomeState(Windows.Open, Doors.Open, Lights.Emergency, Alarm.On).equals
                (smartHomeController.getHomeState()));
    }

    // part 3

    @Test
    public void gas_test16() {  // TF
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Vacation_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.gas(0);
        assertTrue(new HomeState(Windows.Open, Doors.Close, Lights.Emergency, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void gas_test17() {  // TT
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Vacation_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.gas(0);
        assertFalse(new HomeState(Windows.Open, Doors.Close, Lights.Emergency, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void gas_test18() {  // FF
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.gas(0);
        assertFalse(new HomeState(Windows.Open, Doors.Close, Lights.Emergency, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void gas_test19() {  // FF
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 0, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.gas(0);
        assertFalse(new HomeState(Windows.Open, Doors.Close, Lights.Emergency, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test1_1() {  // abcd TTTT
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 2, 2);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.fire(0);
        assertTrue(new HomeState(Windows.Open, Doors.Open, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test1_2() {  // abcd FTTT
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Vacation_Mode);
        EnvState envState = new EnvState(0, 2, 2);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.fire(0);
        assertFalse(new HomeState(Windows.Open, Doors.Open, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test1_3() {  // abcd TFTT
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 2, 2);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.fire(0);
        assertFalse(new HomeState(Windows.Open, Doors.Open, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test1_4() {  // abcd TTFT
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 1, 2);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.fire(0);
        assertFalse(new HomeState(Windows.Open, Doors.Open, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test1_5() {  // abcd TTTF
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 2, 1);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.fire(0);
        assertFalse(new HomeState(Windows.Open, Doors.Open, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test2_1() {  // abcd TTFT
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 1, 2);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.fire(0);
        assertTrue(new HomeState(Windows.Open, Doors.Close, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test2_2() {  // abcd TTTF
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 2, 1);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.fire(0);
        assertTrue(new HomeState(Windows.Open, Doors.Close, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test2_3() {  // abcd FTFT
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Vacation_Mode);
        EnvState envState = new EnvState(0, 1, 2);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.fire(0);
        assertFalse(new HomeState(Windows.Open, Doors.Close, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test2_4() {  // abcd TFFT
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 1, 2);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.fire(0);
        assertFalse(new HomeState(Windows.Open, Doors.Close, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test2_5() {  // abcd TTFF
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 1, 1);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.fire(0);
        assertFalse(new HomeState(Windows.Open, Doors.Close, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test2_6() {  // abcd TTTT
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 2, 2);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.fire(0);
        assertFalse(new HomeState(Windows.Open, Doors.Close, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test2_7() {  // abcd FTTF
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Vacation_Mode);
        EnvState envState = new EnvState(0, 2, 1);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.fire(0);
        assertFalse(new HomeState(Windows.Open, Doors.Close, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test2_8() {  // abcd TFTF
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 2, 1);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.fire(0);
        assertFalse(new HomeState(Windows.Open, Doors.Close, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test3_1() {  // afcd TTFT
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Thief_Mode);
        EnvState envState = new EnvState(0, 1, 2);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.fire(2);
        assertTrue(new HomeState(Windows.Close, Doors.Close, Lights.Emergency, Alarm.On).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test3_2() {  // afcd TTTF
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Thief_Mode);
        EnvState envState = new EnvState(0, 2, 1);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.fire(2);
        assertTrue(new HomeState(Windows.Close, Doors.Close, Lights.Emergency, Alarm.On).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test3_3() {  // afcd FTFT
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 1, 2);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.fire(2);
        assertFalse(new HomeState(Windows.Close, Doors.Close, Lights.Emergency, Alarm.On).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test3_4() {  // afcd TFFT
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Thief_Mode);
        EnvState envState = new EnvState(0, 1, 2);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.fire(1);
        assertFalse(new HomeState(Windows.Close, Doors.Close, Lights.Emergency, Alarm.On).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test3_5() {  // afcd TTFF
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Thief_Mode);
        EnvState envState = new EnvState(0, 1, 1);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.fire(2);
        assertFalse(new HomeState(Windows.Close, Doors.Close, Lights.Emergency, Alarm.On).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test4_6() {  // afcd FTTF
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 2, 1);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.fire(2);
        assertFalse(new HomeState(Windows.Close, Doors.Close, Lights.Emergency, Alarm.On).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test3_7() {  // afcd TFTF
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Thief_Mode);
        EnvState envState = new EnvState(0, 2, 1);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.fire(1);
        assertFalse(new HomeState(Windows.Close, Doors.Close, Lights.Emergency, Alarm.On).equals
                (smartHomeController.getHomeState()));
    }

    // Home state with Doors open cannot be tested!
    @Test
    public void fire_test4_1_1() {  // ag(~c)d TFTT
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Vacation_Mode);
        EnvState envState = new EnvState(0, 2, 1);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.fire(1);
        assertFalse(new HomeState(Windows.Close, Doors.Close, Lights.Emergency, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test4_2_1() {  // abcde TFTTF
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Vacation_Mode);
        EnvState envState = new EnvState(0, 1, 0);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.fire(1);
        assertFalse(new HomeState(Windows.Open, Doors.Open, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test4_2_2() {  // abcde TFTFT
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Vacation_Mode);
        EnvState envState = new EnvState(0, 0, 1);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.fire(1);
        assertFalse(new HomeState(Windows.Open, Doors.Open, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test_CACC1_1() {  // abcd TTTT
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 2, 2);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.fire(1);
        assertTrue(new HomeState(Windows.Open, Doors.Open, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test_CACC1_2() {  // abcd FTTT
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Thief_Mode);
        EnvState envState = new EnvState(0, 2, 2);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.fire(1);
        assertFalse(new HomeState(Windows.Open, Doors.Open, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test_CACC1_3() {  // abcd TFTT
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 2, 2);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.fire(1);
        assertFalse(new HomeState(Windows.Open, Doors.Open, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test_CACC1_4() {  // abcd TTFT
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 1, 2);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.fire(1);
        assertFalse(new HomeState(Windows.Open, Doors.Open, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test_CACC1_5() {  // abcd TTTF
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 2, 1);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.fire(1);
        assertFalse(new HomeState(Windows.Open, Doors.Open, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test_CACC2_1() {  // abcd TTTT
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 2, 2);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.fire(1);
        assertTrue(new HomeState(Windows.Open, Doors.Close, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test_CACC2_2() {  // abcd FTTT
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 2, 2);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.fire(1);
        assertFalse(new HomeState(Windows.Open, Doors.Close, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test_CACC2_3() {  // abcd FTTF
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Thief_Mode);
        EnvState envState = new EnvState(0, 2, 1);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.fire(1);
        assertFalse(new HomeState(Windows.Open, Doors.Open, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test_CACC2_4() {  // abcd TFTF
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 2, 1);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.fire(1);
        assertFalse(new HomeState(Windows.Open, Doors.Open, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    @Test
    public void fire_test_CACC2_5() {  // abcd TTFF
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Normal_Mode);
        EnvState envState = new EnvState(0, 1, 1);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.fire(1);
        assertFalse(new HomeState(Windows.Open, Doors.Open, Lights.Off, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    // tested before
//    @Test
//    public void fire_test_CACC3_1() {  // afcd TTFT
//        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Thief_Mode);
//        EnvState envState = new EnvState(0, 1, 2);
//        SmartHomeController smartHomeController =
//                new SmartHomeController(securityConfig, envState, Time.Day);
//        smartHomeController.fire(2);
//        assertTrue(new HomeState(Windows.Close, Doors.Close, Lights.Emergency, Alarm.On).equals
//                (smartHomeController.getHomeState()));
//    }

    // tested before
//    @Test
//    public void fire_test_CACC3_2() {  // afcd TTTF
//        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Thief_Mode);
//        EnvState envState = new EnvState(0, 2, 1);
//        SmartHomeController smartHomeController =
//                new SmartHomeController(securityConfig, envState, Time.Day);
//        smartHomeController.fire(2);
//        assertTrue(new HomeState(Windows.Close, Doors.Close, Lights.Emergency, Alarm.On).equals
//                (smartHomeController.getHomeState()));
//    }

    @Test
    public void fire_test_CACC3_3() {  // afcd FTFT
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Thief_Mode);
        EnvState envState = new EnvState(0, 1, 1);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Day);
        smartHomeController.fire(1);
        assertFalse(new HomeState(Windows.Close, Doors.Close, Lights.Emergency, Alarm.On).equals
                (smartHomeController.getHomeState()));
    }

    // tested before
//    @Test
//    public void fire_test_CACC3_4() {  // afcd TFFT
//        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Thief_Mode);
//        EnvState envState = new EnvState(0, 1, 2);
//        SmartHomeController smartHomeController =
//                new SmartHomeController(securityConfig, envState, Time.Day);
//        smartHomeController.fire(1);
//        assertFalse(new HomeState(Windows.Close, Doors.Close, Lights.Emergency, Alarm.On).equals
//                (smartHomeController.getHomeState()));
//    }

    // tested before
//    @Test
//    public void fire_test_CACC3_5() {  // afcd TTFF
//        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Thief_Mode);
//        EnvState envState = new EnvState(0, 1, 1);
//        SmartHomeController smartHomeController =
//                new SmartHomeController(securityConfig, envState, Time.Day);
//        smartHomeController.fire(2);
//        assertFalse(new HomeState(Windows.Close, Doors.Close, Lights.Emergency, Alarm.On).equals
//                (smartHomeController.getHomeState()));
//    }

    // Home state with Doors open cannot be tested!
    @Test
    public void fire_test_CACC4_1_3() {  // agcd TFTT
        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Vacation_Mode);
        EnvState envState = new EnvState(0, 1, 2);
        SmartHomeController smartHomeController =
                new SmartHomeController(securityConfig, envState, Time.Night);
        smartHomeController.fire(1);
        assertFalse(new HomeState(Windows.Close, Doors.Close, Lights.Emergency, Alarm.Off).equals
                (smartHomeController.getHomeState()));
    }

    // tested before
//    @Test
//    public void fire_test_CACC4_2_1() {  // agcd TFTTF
//        SecurityConfig securityConfig = new SecurityConfig(0, SecurityMode.Vacation_Mode);
//        EnvState envState = new EnvState(0, 1, 0);
//        SmartHomeController smartHomeController =
//                new SmartHomeController(securityConfig, envState, Time.Night);
//        smartHomeController.fire(1);
//        assertFalse(new HomeState(Windows.Open, Doors.Open, Lights.Off, Alarm.Off).equals
//                (smartHomeController.getHomeState()));
//    }

}
