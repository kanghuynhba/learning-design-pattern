package com.hbk.book_market.strategy;

import com.hbk.book_market.constant.AuthorLevels;
import java.util.Arrays;
import java.util.List;

public class AuthorLevelStrategyContext {
  private final List<AuthorLevelStrategy> authorLevelStrategies =
      Arrays.asList(
          new NewOneAuthorLevelStrategy(),
          new ExpertAuthorLevelStrategy(),
          new ExpertAuthorLevelStrategy());

  public String decideAuthorLevel(long bookCount) {
    String level = AuthorLevels.NEW_ONE;
    for (AuthorLevelStrategy item : authorLevelStrategies) {
      if (bookCount <= item.getMaxBookCount()) {
        level = item.getLevelName();
        break;
      }
    }

    return level;
  }
}
