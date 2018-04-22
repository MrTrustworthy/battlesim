package player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import savegames.HealthPool;

import static org.junit.Assert.assertEquals;

class HealthPoolTest {

    private HealthPool testPool;

    @BeforeEach
    void setUp() {
        this.testPool = new HealthPool(100);
    }

    @Test
    void takeDamageNoShield() {
        assertEquals(100, this.testPool.getCurrentHealth());
        this.testPool.takeDamage(12);
        assertEquals(88, this.testPool.getCurrentHealth());
    }

    @Test
    void takeDamageShieldLow() {
        this.testPool.setShielding(5);
        assertEquals(100, this.testPool.getCurrentHealth());
        assertEquals(5, this.testPool.getShielding());
        this.testPool.takeDamage(12);
        assertEquals(93, this.testPool.getCurrentHealth());
        assertEquals(0, this.testPool.getShielding());
    }

    @Test
    void takeDamageShieldHigh() {
        this.testPool.setShielding(15);
        assertEquals(100, this.testPool.getCurrentHealth());
        assertEquals(15, this.testPool.getShielding());
        this.testPool.takeDamage(12);
        assertEquals(100, this.testPool.getCurrentHealth());
        assertEquals(3, this.testPool.getShielding());
    }


    @Test
    void healDamageNoShield() {
        this.testPool.takeDamage(12);
        this.testPool.healDamage(6);
        assertEquals(94, this.testPool.getCurrentHealth());
    }

    @Test
    void testStatistics() {
        this.testPool.takeDamage(1);
        assertEquals(99, this.testPool.getHealthPercentage());
    }
}