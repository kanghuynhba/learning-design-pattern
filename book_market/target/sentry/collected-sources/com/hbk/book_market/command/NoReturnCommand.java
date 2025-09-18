package com.hbk.book_market.command;

public interface NoReturnCommand extends Command<Void> {
    @Override
    default Void execute() throws Exception {
        voidExecute();
        return null;
    }

    void voidExecute() throws Exception;
}
