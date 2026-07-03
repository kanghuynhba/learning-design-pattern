package com.hbk.book_market.strategy;

import com.hbk.book_market.constant.AuthorLevels;

public class ExpertAuthorLevelStrategy implements AuthorLevelStrategy {
  @Override
  public String getLevelName() {
    return AuthorLevels.EXPERT;
  }

  @Override
  public long getMaxBookCount() {
    return Long.MAX_VALUE;
  }
}
