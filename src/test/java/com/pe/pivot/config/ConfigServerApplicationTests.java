package com.pe.pivot.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Smoke test that verifies the Config Server application context starts correctly.
 */
@SpringBootTest
@ActiveProfiles("native")
class ConfigServerApplicationTests {

  @Test
  @DisplayName("Should load the Config Server application context")
  void shouldLoadApplicationContext() {
  }
}
