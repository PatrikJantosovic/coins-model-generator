package com.jantosovic.dss;

public enum PLAYER {
  ALICE, BOB;

  PLAYER switchPlayer() {
    if (this == ALICE) {
      return BOB;
    }
    return ALICE;
  }

}
