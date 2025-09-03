package com.hbk.book_market.handler;

import com.tvd12.ezyhttp.core.response.ResponseEntity;

public class GlobalExceptionHandler implements Handler<Exception ,ResponseEntity> {
    @Override
    public ResponseEntity handle(Exception input) {
        return ResponseEntity.badRequest(input.getMessage());
    }
}
