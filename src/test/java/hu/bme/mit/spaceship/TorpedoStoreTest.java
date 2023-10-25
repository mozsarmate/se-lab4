package hu.bme.mit.spaceship;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TorpedoStoreTest {

    private TorpedoStore store;

    @BeforeEach
    public void init() {
        this.store = new TorpedoStore(0);
    }

    @Test
    void fire_Success() {
        // Arrange
        store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);
        int quantity = store.getTorpedoCount();

        // Assert
        assertTrue(result);
        assertEquals(0,quantity);
    }

    @Test
    void empty_Fail() {
        // Arrange
        store = new TorpedoStore(0);
        boolean result;

        try {
            // Act
            result = !store.fire(1);
        } catch (IllegalArgumentException e){
            result = true;
        } catch (Exception e){
            result = false;
        }

        // Assert
        assertTrue(result);
    }

}
