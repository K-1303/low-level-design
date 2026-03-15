package org.example;

import java.util.ArrayList;
import java.util.Scanner;

import org.example.entity.Cell;
import org.example.entity.Move;
import org.example.entity.Player;
import org.example.enums.Status;
import org.example.factory.King;
import org.example.factory.Piece;
import org.example.singleton.Board;

public class ChessGame {
    private Board board;
    // Assuming player1 is always WHITE
    private Player player1;
    // Assuming player2 is always BLACK
    private Player player2;
    boolean isWhiteTurn;
    private ArrayList<Move> gameLog;
    private Status status;
    // Constructor to initialize the game with two players
    public ChessGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = Board.getInstance(8); // Initialize board with 8 rows
        this.isWhiteTurn = true;
        this.status = Status.ACTIVE;
        this.gameLog = new ArrayList<>();
    }
    // Start the game
    public void start() {
        Scanner scanner = new Scanner(System.in);
        displayBoard();
        while (this.status == Status.ACTIVE) {
            Player currentPlayer = isWhiteTurn ? player1 : player2;
            System.out.println("\n" + currentPlayer.getName() + "'s turn (" + (currentPlayer.isWhiteSide() ? "White" : "Black") + ")");

            // Ask for source coordinates
            System.out.print("Enter source row and column (e.g., 6 4): ");
            int startRow = scanner.nextInt();
            int startCol = scanner.nextInt();

            // Ask for destination coordinates
            System.out.print("Enter destination row and column (e.g., 4 4): ");
            int endRow = scanner.nextInt();
            int endCol = scanner.nextInt();


            // Get the start and end cells from the board
            Cell startCell = board.getCell(startRow, startCol);
            Cell endCell = board.getCell(endRow, endCol);


            if (startCell == null || startCell.getPiece() == null) {
                System.out.println("Invalid move: No piece at source cell.");
                continue;
            }
            // Make the move
            makeMove(new Move(startCell, endCell), currentPlayer);
        }
        System.out.println("Game Over! Status: " + this.status);
    }

    // Make a move in the game
    public void makeMove(Move move, Player player) {
        // Initial check for a valid move
        // To check if source and destination don't contain the same color pieces
        if (move.isValid()) {
            Piece sourcePiece = move.getStartCell().getPiece();
            // Check if the source piece can be moved or not
            if (sourcePiece.canMove(this.board, move.getStartCell(), move.getEndCell())) {
                Piece destinationPiece = move.getEndCell().getPiece();
                // Check if the destination cell contains some piece
                if (destinationPiece != null) {
                    // If the destination cell contains King and currently white is
                    // playing --> White wins
                    if (destinationPiece instanceof King && isWhiteTurn) {
                        this.status = Status.WHITE_WIN;
                        return;
                    }
                    // If the destination cell contains King and currently Black is
                    // playing --> Black wins
                    if (destinationPiece instanceof King && !isWhiteTurn) {
                        this.status = Status.BLACK_WIN;
                        return;
                    }
                    // Set the destination piece as killed
                    destinationPiece.setKilled(true);
                }
                // Adding the valid move to the game logs
                gameLog.add(move);
                // Moving the source piece to the destination cell
                move.getEndCell().setPiece(sourcePiece);
                // Setting the source cell to null (means it doesn't have any piece)
                move.getStartCell().setPiece(null);
                // Toggling the turn
                this.isWhiteTurn = !isWhiteTurn;
                displayBoard();
            } else {
                System.out.println("Invalid move: Piece cannot move that way.");
            }
        } else {
            System.out.println("Invalid move: Cannot move to that cell.");
        }
    }

    // Display the current state of the board
    private void displayBoard() {
        System.out.println("\n  0 1 2 3 4 5 6 7");
        System.out.println("  ---------------");
        for (int row = 0; row < 8; row++) {
            System.out.print(row + "|");
            for (int col = 0; col < 8; col++) {
                Cell cell = board.getCell(row, col);
                if (cell.getPiece() == null) {
                    System.out.print(". ");
                } else {
                    Piece piece = cell.getPiece();
                    String symbol = getPieceSymbol(piece);
                    if (piece.isWhite()) {
                        System.out.print(symbol.toUpperCase() + " ");
                    } else {
                        System.out.print(symbol.toLowerCase() + " ");
                    }
                }
            }
            System.out.println("|" + row);
        }
        System.out.println("  ---------------");
        System.out.println("  0 1 2 3 4 5 6 7\n");
    }

    // Get the symbol for a piece
    private String getPieceSymbol(Piece piece) {
        if (piece instanceof King) {
            return "K";
        } else if (piece instanceof org.example.factory.Queen) {
            return "Q";
        } else if (piece instanceof org.example.factory.Bishop) {
            return "B";
        } else if (piece instanceof org.example.factory.Knight) {
            return "N";
        } else if (piece instanceof org.example.factory.Rook) {
            return "R";
        } else if (piece instanceof org.example.factory.Pawn) {
            return "P";
        }
        return "?";
    }
}