import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("@MadeWithLove: Noughts and Crosses\n");

        System.out.print("Please enter first player name: ");
        final String firstPlayer = input.nextLine();

        System.out.print("Please enter second player name: ");
        final String secondPlayer = input.nextLine();

        char[] board = {
                '0',
                '1',
                '2',
                '3',
                '4',
                '5',
                '6',
                '7',
                '8',
                '9'
        };

        char playerMark;
        int playerTurn;
        int markPosition;
        int gameControl;

        for (playerTurn = 1, gameControl = -1; gameControl == -1; playerTurn++) {
            playerTurn = playerTurn % 2;
            playerMark = (playerTurn == 1) ? 'X' : 'O';

            printBoard(board);

            if (playerTurn == 1) {
                System.out.print(firstPlayer + ", please enter marking position: ");
            } else {
                System.out.print(secondPlayer + ", please enter marking position: ");
            }

            markPosition = input.nextInt();

            if (markBoard(board, playerMark, markPosition) == 1) {
                System.out.println("Position incorrect, Please try again.");

                playerTurn--;
                continue;
            }

            gameControl = readBoard(board);
        }

        printBoard(board);

        if (gameControl == 1) {
            if (--playerTurn == 1) {
                System.out.println(firstPlayer + " has won the game!");
            } else {
                System.out.println(secondPlayer + " has won the game!");
            }
        } else {
            System.out.println("Nobody has won the game!");
        }
    }

    static void printBoard(char[] boardArray) {
        System.out.println();
        System.out.printf("  %c  |  %c  |  %c  \n_____|_____|_____\n", boardArray[1], boardArray[2], boardArray[3]);
        System.out.printf("  %c  |  %c  |  %c  \n_____|_____|_____\n", boardArray[4], boardArray[5], boardArray[6]);
        System.out.printf("  %c  |  %c  |  %c  \n     |     |     \n", boardArray[7], boardArray[8], boardArray[9]);
    }

    static int markBoard(char[] boardArray, char mark, int position) {
        if (position == 1 && boardArray[1] == '1') {
            boardArray[1] = mark;
        } else if (position == 2 && boardArray[2] == '2') {
            boardArray[2] = mark;
        } else if (position == 3 && boardArray[3] == '3') {
            boardArray[3] = mark;
        } else if (position == 4 && boardArray[4] == '4') {
            boardArray[4] = mark;
        } else if (position == 5 && boardArray[5] == '5') {
            boardArray[5] = mark;
        } else if (position == 6 && boardArray[6] == '6') {
            boardArray[6] = mark;
        } else if (position == 7 && boardArray[7] == '7') {
            boardArray[7] = mark;
        } else if (position == 8 && boardArray[8] == '8') {
            boardArray[8] = mark;
        } else if (position == 9 && boardArray[9] == '9') {
            boardArray[9] = mark;
        } else return 1;
        return 0;
    }

    static int readBoard(char[] boardArray) {
        if (boardArray[1] == boardArray[2] && boardArray[2] == boardArray[3]) return 1;
        else if (boardArray[4] == boardArray[5] && boardArray[5] == boardArray[6]) return 1;
        else if (boardArray[7] == boardArray[8] && boardArray[8] == boardArray[9]) return 1;
        else if (boardArray[1] == boardArray[4] && boardArray[4] == boardArray[7]) return 1;
        else if (boardArray[2] == boardArray[5] && boardArray[5] == boardArray[8]) return 1;
        else if (boardArray[3] == boardArray[6] && boardArray[6] == boardArray[9]) return 1;
        else if (boardArray[1] == boardArray[5] && boardArray[5] == boardArray[9]) return 1;
        else if (boardArray[3] == boardArray[5] && boardArray[5] == boardArray[7]) return 1;
        else if (boardArray[1] != '1' && boardArray[2] != '2' && boardArray[3] != '3') {
            if (boardArray[4] != '4' && boardArray[5] != '5' && boardArray[6] != '6') {
                if (boardArray[7] != '7' && boardArray[8] != '8' && boardArray[9] != '9') {
                    return 0;
                }
                return -1;
            }
            return -1;
        } else return -1;
    }
}
