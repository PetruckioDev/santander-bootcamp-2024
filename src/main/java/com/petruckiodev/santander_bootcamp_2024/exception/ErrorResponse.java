package com.petruckiodev.santander_bootcamp_2024.exception;

import java.time.LocalDateTime;

public record ErrorResponse(int status, String message, LocalDateTime timestamp) {
}
