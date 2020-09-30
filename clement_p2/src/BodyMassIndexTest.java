import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BodyMassIndexTest {

    int height, weight;

    @Test
    public void testFindScore() {
        BodyMassIndex e = new BodyMassIndex(height, weight);
        assertEquals(26.3625, e.find_score(60,135));
    }

    @Test
    public void testFindCategory() {
        BodyMassIndex e = new BodyMassIndex(height, weight);
        assertEquals("Normal weight", e.find_category(72,150));
    }

    @Test
    public void testUnderweight() {
        BodyMassIndex e = new BodyMassIndex(height, weight);
        assertEquals("Underweight", e.find_category(60,80));
    }

    @Test
    public void testNormalWeight() {
        BodyMassIndex e = new BodyMassIndex(height, weight);
        assertEquals("Normal weight", e.find_category(60,120));
    }

    @Test
    public void testOverweight() {
        BodyMassIndex e = new BodyMassIndex(height, weight);
        assertEquals("Overweight", e.find_category(60,140));
    }

    @Test
    public void testObesity() {
        BodyMassIndex e = new BodyMassIndex(height, weight);
        assertEquals("Obesity", e.find_category(60,160));
    }

}
