package com.zuhlke.kata.mastermind;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CodeMaker {

    private Color[] code;

    public CodeMaker(Color code1, Color code2, Color code3, Color code4) {
        this.code = new Color[]{code1, code2, code3, code4};
    }

    public int[] feedback(Color guess1, Color guess2, Color guess3, Color guess4) {
        Color[] guess = {guess1, guess2, guess3, guess4};

        int exactMatches = 0;
        List<Color> codeExcludingExactMatch = new ArrayList<>(), guessExcludingExactMatch = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            if (code[i] == guess[i]) {
                exactMatches++;
            } else {
                codeExcludingExactMatch.add(code[i]);
                guessExcludingExactMatch.add(guess[i]);
            }
        }

        int colorMatches = 0;
        for (Iterator<Color> guessIte = guessExcludingExactMatch.iterator(); guessIte.hasNext(); ) {
            final Color nextGuess = guessIte.next();
            for (Iterator<Color> codeIte = codeExcludingExactMatch.iterator(); codeIte.hasNext(); ) {
                if (codeIte.next() == nextGuess) {
                    colorMatches++;
                    codeIte.remove();
                    guessIte.remove();
                    break;
                }
            }
        }

        return new int[]{exactMatches, colorMatches};

    }
}
