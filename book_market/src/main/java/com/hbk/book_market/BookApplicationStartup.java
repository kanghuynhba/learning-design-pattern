package com.hbk.book_market;

import com.tvd12.ezyhttp.server.boot.EzyHttpApplicationBootstrap;

import io.sentry.Sentry;

public class BookApplicationStartup {
    public static void main(String[] args) throws Exception {
        Sentry.init();
        EzyHttpApplicationBootstrap.start(
            BookApplicationStartup.class
        );
    }
}
