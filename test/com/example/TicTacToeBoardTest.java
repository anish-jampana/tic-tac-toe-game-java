package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TicTacToeBoardTest {

  @Test
  public void testValidBoardNoWinnerWhenComplete() {
    TicTacToeBoard board = new TicTacToeBoard("xOOoXXxxo");
    assertEquals(Evaluation.NoWinner, board.evaluate());
    TicTacToeBoard board1 = new TicTacToeBoard("oOxXXoOxO");
    assertEquals(Evaluation.NoWinner, board1.evaluate());
  }

  @Test
  public void testValidBoardNoWinnerWhenIncomplete() {
    TicTacToeBoard board = new TicTacToeBoard("X.x.O..o.");
    assertEquals(Evaluation.NoWinner, board.evaluate());
    TicTacToeBoard board1 = new TicTacToeBoard("----x----");
    assertEquals(Evaluation.NoWinner, board1.evaluate());
  }

  @Test
  public void testValidBoardNoWinnerBlank() {
    TicTacToeBoard board = new TicTacToeBoard("---------");
    assertEquals(Evaluation.NoWinner, board.evaluate());
  }

  @Test
  public void testValidBoardUnreachableStateOnlyXOrO() {
    TicTacToeBoard board = new TicTacToeBoard("xXXXxxXxx");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
    TicTacToeBoard board1 = new TicTacToeBoard("ooOooOoOO");
    assertEquals(Evaluation.UnreachableState, board1.evaluate());
  }

  @Test
  public void testValidBoardUnreachableStateSingleWinnerVerticalAndHorizontal() {
    TicTacToeBoard board = new TicTacToeBoard("xxxxooxoo");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
  }

  @Test
  public void testValidBoardUnreachableStateTwoWinners() {
    TicTacToeBoard board = new TicTacToeBoard("xxxOOO...");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
    TicTacToeBoard board1 = new TicTacToeBoard("xo-xo-xo-");
    assertEquals(Evaluation.UnreachableState, board1.evaluate());
  }

  @Test
  public void testValidBoardUnreachableStateDifferenceBetweenTurnsGreaterThan1 () {
    TicTacToeBoard board = new TicTacToeBoard("XxXxxXooX");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
  }

  @Test
  public void testValidBoardXWinsVerticalComplete() {
    TicTacToeBoard board = new TicTacToeBoard("XooxOxXXo");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testValidBoardXWinsVerticalIncomplete() {
    TicTacToeBoard board = new TicTacToeBoard("oXOxX-OXO");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testValidBoardOWinsVerticalComplete() {
    TicTacToeBoard board = new TicTacToeBoard("OxXoxoOoX");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test
  public void testValidBoardOWinsVerticalIncomplete() {
    TicTacToeBoard board = new TicTacToeBoard("XoxOo-xox");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test
  public void testValidBoardXWinsHorizontalIncomplete() {
    TicTacToeBoard board = new TicTacToeBoard("o.oXxX.xO");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testValidBoardXWinsHorizontalComplete() {
    TicTacToeBoard board = new TicTacToeBoard("XXxOXOxoo");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testValidBoardOWinsHorizontalIncomplete() {
    TicTacToeBoard board = new TicTacToeBoard("x.XooO.oX");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test
  public void testValidBoardOWinsHorizontalComplete() {
    TicTacToeBoard board = new TicTacToeBoard("OoOxOxoxx");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test
  public void testValidBoardXWinsDiagonalIncomplete() {
    TicTacToeBoard board = new TicTacToeBoard("Oox.X.x.o");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testValidBoardXWinsDiagonalComplete() {
    TicTacToeBoard board1 = new TicTacToeBoard("XOxXxoOOX");
    assertEquals(Evaluation.Xwins, board1.evaluate());
  }

  @Test
  public void testValidBoardOWinsDiagonalIncomplete() {
    TicTacToeBoard board = new TicTacToeBoard("xxo.O.O.x");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test
  public void testValidBoardOWinsDiagonalComplete() {
    TicTacToeBoard board = new TicTacToeBoard("oXOooxXxo");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test
  public void testValidBoardXWinsDiagonalAndHorizontal() {
    TicTacToeBoard board = new TicTacToeBoard("xOOxxxooX");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testValidBoardOWinsDiagonalAndVertical() {
    TicTacToeBoard board = new TicTacToeBoard("oOxxoxXoo");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test
  public void testValidBoardXWinsHorizontalAndVertical() {
    TicTacToeBoard board = new TicTacToeBoard("oxoxxxoxo");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testInvalidBoardThrowsIllegalArgumentException() {
    boolean thrown = false;

    try {
      TicTacToeBoard board = new TicTacToeBoard("xxxxxxxxxxx");
      board.evaluate();
    } catch(IllegalArgumentException e) {
      thrown = true;
    }
    assertEquals(true, thrown);
  }
}
