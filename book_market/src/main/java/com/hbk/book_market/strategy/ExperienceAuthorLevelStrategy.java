package com.hbk.book_market.strategy;

import com.hbk.book_market.constant.AuthorLevels;

public class ExperienceAuthorLevelStrategy implements AuthorLevelStrategy {
  @Override
  public String getLevelName() {
    return AuthorLevels.EXPERIENCE;
  }

  @Override
  public long getMaxBookCount() {
    return 6;
  }
}
