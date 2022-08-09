package net.tirasa.test.testcontainers5680;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
class ReproducerTest {

    static final PostgreSQLContainer<?> INTERNAL_STORAGE;

    static {
        INTERNAL_STORAGE = new PostgreSQLContainer<>("postgres:12").
                withTmpFs(Map.of("/var/lib/postgresql/data", "rw")).
                withDatabaseName("syncope").withPassword("syncope").withUsername("syncope").
                withUrlParam("stringtype", "unspecified");
        INTERNAL_STORAGE.start();
    }

    @Test
    void check() {
        assertTrue(true);
    }
}
