package com.hbk.book_market.strategy;

import com.hbk.book_market.constant.AuthorLevels;

public class NewOneAuthorLevelStrategy implements AuthorLevelStrategy {
  @Override
  public String getLevelName() {
    return AuthorLevels.NEW_ONE;
  }

  @Override
  public long getMaxBookCount() {
    return 3;
  }
}
