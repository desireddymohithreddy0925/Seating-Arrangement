package com.sag.demo;

import org.springframework.stereotype.Service;

@Service
public class SeatingService {

    public String[][] generate(int rows, int cols, String[] participants, String[][] conflicts) {

        String[][] seats = new String[rows][cols];

        arrange(0, seats, rows, cols, participants, conflicts);

        return seats;
    }

    boolean isConflict(String p1, String p2, String[][] conflicts) {
        for (String[] c : conflicts) {
            if (c[0].equals(p1) && c[1].equals(p2)) return true;
        }
        return false;
    }

    boolean isSafe(int r, int c, String person, String[][] seats, String[][] conflicts) {

        if (c > 0 && seats[r][c - 1] != null)
            if (isConflict(person, seats[r][c - 1], conflicts)) return false;

        if (r > 0 && seats[r - 1][c] != null)
            if (isConflict(person, seats[r - 1][c], conflicts)) return false;

        return true;
    }

    boolean isPlaced(String p, String[][] seats, int rows, int cols) {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (p.equals(seats[i][j])) return true;
        return false;
    }

    boolean arrange(int index, String[][] seats, int rows, int cols,
                    String[] participants, String[][] conflicts) {

        if (index == participants.length) return true;

        int r = index / cols;
        int c = index % cols;

        for (String p : participants) {

            if (!isPlaced(p, seats, rows, cols)) {

                if (isSafe(r, c, p, seats, conflicts)) {
                    seats[r][c] = p;

                    if (arrange(index + 1, seats, rows, cols, participants, conflicts))
                        return true;

                    seats[r][c] = null;
                }
            }
        }
        return false;
    }
}