package com.example;

import sun.awt.EventListenerAggregate;
import sun.security.util.Cache;

/**
 * Takes in and evaluates a string representing a tic tac toe board.
 */
public class TicTacToeBoard {

    /**
     * This field represents the specific board that this class will evaluate.
     */
    private String specificBoard;

    /**
     * This field represents the side length of the board, which should be 3.
     */
    private int boardSideLength;

    /**
     * This method should load a string into your TicTacToeBoard class.
     *
     * @param board The string representing the board
     */
    public TicTacToeBoard(String board) {
        if (board.length() != 9) {
            throw new IllegalArgumentException("size of board must be 3 by 3, other sizes are invalid");
        }
        specificBoard = board;
        boardSideLength = (int) Math.sqrt(specificBoard.length());
    }

    /**
     * Checks the state of the board (unreachable, no winner, X wins, or O wins)
     *
     * @return an enum value corresponding to the board evaluation
     */
    public Evaluation evaluate() {
        int numOfX = 0;
        int numOfO = 0;

        // counts the amount of Xs and Os in the board
        for (int position = 0; position < specificBoard.length(); position++) {
            if (specificBoard.toUpperCase().charAt(position) == 'X') {
                numOfX++;
            } else if (specificBoard.toUpperCase().charAt(position) == 'O') {
                numOfO++;
            }
        }

        int distanceToCenter = (boardSideLength * boardSideLength) / 2;

        // difference between turns in TicTacToe can't be more than 1
        if (Math.abs(numOfO - numOfX) <= 1) {

            Evaluation isWinner = Evaluation.NoWinner;

            // check if any columns in board result in a winner
            for (int position = 0; position < boardSideLength; position++) {
                char letterAtPosition = specificBoard.toUpperCase().charAt(position);
                char letterAtPosition1RowDown = specificBoard.toUpperCase().charAt(position + boardSideLength);
                char letterAtPosition2RowDown = specificBoard.toUpperCase().charAt(position + ((boardSideLength - 1) * boardSideLength));
                if (letterAtPosition == 'X') {
                    if (letterAtPosition == letterAtPosition1RowDown && letterAtPosition == letterAtPosition2RowDown) {
                        // X and O can't win simultaneously and X can't win both vertically and horizontally if middle is not X
                        if (isWinner == Evaluation.Owins || (isWinner == Evaluation.Xwins && specificBoard.toUpperCase().charAt(distanceToCenter) != 'X')) {
                            isWinner = Evaluation.UnreachableState;
                        } else {
                            isWinner = Evaluation.Xwins;
                        }
                    }
                } else if (letterAtPosition == 'O') {
                    if (letterAtPosition == letterAtPosition1RowDown && letterAtPosition == letterAtPosition2RowDown) {
                        // X and O can't win simultaneously and O can't win both vertically and horizontally if middle is not O
                        if (isWinner == Evaluation.Xwins  || (isWinner == Evaluation.Owins && specificBoard.toUpperCase().charAt(distanceToCenter) != 'O')) {
                            isWinner = Evaluation.UnreachableState;
                        } else {
                            isWinner = Evaluation.Owins;
                        }
                    }
                }
            }

            // check if any rows in board result in a winner
            for (int position = 0; position < specificBoard.length(); position = position + boardSideLength) {
                char letterAtPosition = specificBoard.toUpperCase().charAt(position);
                char letterAtPosition1ColRight = specificBoard.toUpperCase().charAt(position + 1);
                char letterAtPosition2ColRight = specificBoard.toUpperCase().charAt(position + 2);
                if (letterAtPosition == 'X') {
                    if (letterAtPosition == letterAtPosition1ColRight && letterAtPosition == letterAtPosition2ColRight) {
                        // X and O can't win simultaneously and X can't win both vertically and horizontally if middle is not X
                        if (isWinner == Evaluation.Owins || (isWinner == Evaluation.Xwins && specificBoard.toUpperCase().charAt(distanceToCenter) != 'X')) {
                            isWinner = Evaluation.UnreachableState;
                        } else {
                            isWinner = Evaluation.Xwins;
                        }
                    }
                } else if (letterAtPosition == 'O') {
                    if (letterAtPosition == letterAtPosition1ColRight && letterAtPosition == letterAtPosition2ColRight) {
                        // X and O can't win simultaneously and O can't win both vertically and horizontally if middle is not O
                        if (isWinner == Evaluation.Xwins  || (isWinner == Evaluation.Owins && specificBoard.toUpperCase().charAt(distanceToCenter) != 'O')) {
                            isWinner = Evaluation.UnreachableState;
                        } else {
                            isWinner = Evaluation.Owins;
                        }
                    }
                }
            }

            // check if any diagonals in board result in a winner
            for (int position = 0; position < boardSideLength; position++) {
                char diagonalfirstPosition = specificBoard.toUpperCase().charAt(position);
                char centerPosition = specificBoard.toUpperCase().charAt(position + distanceToCenter);
                char diagonalLastPosition = specificBoard.toUpperCase().charAt(position + (2 * distanceToCenter));
                if (diagonalfirstPosition == 'X') {
                    if (diagonalfirstPosition == centerPosition && diagonalfirstPosition == diagonalLastPosition) {
                        if (isWinner != Evaluation.UnreachableState) {
                            isWinner = Evaluation.Xwins;
                        }
                    }
                } else if (diagonalfirstPosition == 'O') {
                    if (diagonalfirstPosition == centerPosition && diagonalfirstPosition == diagonalLastPosition) {
                        if (isWinner != Evaluation.UnreachableState) {
                            isWinner = Evaluation.Owins;
                        }
                    }
                }
                distanceToCenter--;
            }

            return isWinner;

        } else {
            return Evaluation.UnreachableState;
        }
    }
}
