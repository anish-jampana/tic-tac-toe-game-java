package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TicTacToeBoardTest {

  @Test
  public void testValidBoardNoWinner() {
    TicTacToeBoard board = new TicTacToeBoard("xOOoXXxxo");
    assertEquals(Evaluation.NoWinner, board.evaluate());
    TicTacToeBoard board1 = new TicTacToeBoard("oOxXXoOxO");
    assertEquals(Evaluation.NoWinner, board1.evaluate());
    TicTacToeBoard board2 = new TicTacToeBoard("X.x.O..o.");
    assertEquals(Evaluation.NoWinner, board2.evaluate());
    TicTacToeBoard board3 = new TicTacToeBoard("----x----");
    assertEquals(Evaluation.NoWinner, board3.evaluate());
  }

  @Test
  public void testValidBoardBlankNoWinner() {
    TicTacToeBoard board = new TicTacToeBoard("---------");
    assertEquals(Evaluation.NoWinner, board.evaluate());
  }

  @Test
  public void testValidBoardUnreachableState() {
    TicTacToeBoard board = new TicTacToeBoard("xXXXxxXxx");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
    TicTacToeBoard board1 = new TicTacToeBoard("ooOooOoOO");
    assertEquals(Evaluation.UnreachableState, board1.evaluate());
    TicTacToeBoard board2 = new TicTacToeBoard("oXooxoOxO");
    assertEquals(Evaluation.UnreachableState, board2.evaluate());
    TicTacToeBoard board3 = new TicTacToeBoard("xxxxooxoo");
    assertEquals(Evaluation.UnreachableState, board3.evaluate());
  }

  @Test
  public void testValidBoardTwoWinnersUnreachableState() {
    TicTacToeBoard board = new TicTacToeBoard("xxxOOO...");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
    TicTacToeBoard board1 = new TicTacToeBoard("xo-xo-xo-");
    assertEquals(Evaluation.UnreachableState, board1.evaluate());
  }

  @Test
  public void testValidBoardXWinsVertical() {
    TicTacToeBoard board = new TicTacToeBoard("XooxOxXXo");
    assertEquals(Evaluation.Xwins, board.evaluate());
    TicTacToeBoard board1 = new TicTacToeBoard("oXOxX-OXO");
    assertEquals(Evaluation.Xwins, board1.evaluate());
  }

  @Test
  public void testValidBoardOWinsVertical() {
    TicTacToeBoard board = new TicTacToeBoard("OxXoxoOoX");
    assertEquals(Evaluation.Owins, board.evaluate());
    TicTacToeBoard board1 = new TicTacToeBoard("XoxOo-xox");
    assertEquals(Evaluation.Owins, board1.evaluate());
  }

  @Test
  public void testValidBoardXWinsHorizontal() {
    TicTacToeBoard board = new TicTacToeBoard("o.oXxX.xO");
    assertEquals(Evaluation.Xwins, board.evaluate());
    TicTacToeBoard board1 = new TicTacToeBoard("XXxOXOxoo");
    assertEquals(Evaluation.Xwins, board1.evaluate());
  }

  @Test
  public void testValidBoardOWinsHorizontal() {
    TicTacToeBoard board = new TicTacToeBoard("x.XooO.oX");
    assertEquals(Evaluation.Owins, board.evaluate());
    TicTacToeBoard board1 = new TicTacToeBoard("OoOxOxoxx");
    assertEquals(Evaluation.Owins, board1.evaluate());
  }

  @Test
  public void testValidBoardXWinsDiagonal() {
    TicTacToeBoard board = new TicTacToeBoard("Oox.X.x.o");
    assertEquals(Evaluation.Xwins, board.evaluate());
    TicTacToeBoard board1 = new TicTacToeBoard("XOxXxoOOX");
    assertEquals(Evaluation.Xwins, board1.evaluate());
  }

  @Test
  public void testValidBoardOWinsDiagonal() {
    TicTacToeBoard board = new TicTacToeBoard("xxo.O.O.x");
    assertEquals(Evaluation.Owins, board.evaluate());
    TicTacToeBoard board1 = new TicTacToeBoard("oXOooxXxo");
    assertEquals(Evaluation.Owins, board1.evaluate());
  }


}
