package com.jantosovic.dss;

import java.util.Objects;

/**
 * Class representing a state of the game after each move.
 */
final class Move implements Comparable<Move> {
  private final String name;
  private final Integer remaining;
  private final Integer taken;
  private final PLAYER player;

  Move(Move parent, Integer taken) {
    this.player = parent.player.switchPlayer();
    this.remaining = parent.remaining - taken;
    this.taken = taken;
    this.name = this.player.toString() + '-' + remaining;
  }

  Move(Integer remaining) {
    this.player = PLAYER.ALICE;
    this.name = this.player.toString() + '-' + remaining;
    this.remaining = remaining;
    this.taken = 0;
  }

  /**
   * Value of field name.
   *
   * @return value of field name
   */
  public String getName() {
    return name;
  }

  /**
   * Value of field player.
   *
   * @return value of field player
   */
  public PLAYER getPlayer() {
    return player;
  }

  /**
   * Value of field remaining.
   *
   * @return value of field remaining
   */
  public Integer getRemaining() {
    return remaining;
  }

  @Override
  public String toString() {
    if (remaining == 0) {
      return name + " (" + ((player == PLAYER.ALICE) ? "-1" : "+1") + ';' + ((player == PLAYER.ALICE) ? "+1" : "-1") + ')';
    }
    return name;
  }

  @Override
  public int compareTo(Move o) {
    // taken = 2 => 4 - 3 = 1 => right subtree
    // taken = 1 => 1 - 3 = -2 => left subtree
    return (int) (Math.pow(taken,2) - 3);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Move move = (Move) o;
    return Objects.equals(name, move.name)
        && Objects.equals(remaining, move.remaining)
        && player == move.player;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (remaining != null ? remaining.hashCode() : 0);
    result = 31 * result + (player != null ? player.hashCode() : 0);
    return result;
  }
}
