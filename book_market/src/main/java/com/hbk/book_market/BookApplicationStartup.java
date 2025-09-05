package com.hbk.book_market;

import com.tvd12.ezyhttp.server.boot.EzyHttpApplicationBootstrap;

public class BookApplicationStartup {
    public static void main(String[] args) throws Exception {
        EzyHttpApplicationBootstrap.start(
            BookApplicationStartup.class
        );
    }
}
