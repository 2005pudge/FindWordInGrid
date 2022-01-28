package com.javarush.task.task20.task2026;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/*
Кроссворд
*/

public class GoodExampleOfBadCode {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'f', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'f', 'g', 'r', 'o', 'v'},
                {'m', 'm', 'p', 'r', 'r', 'h'},
                {'p', 'e', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        System.out.println(detectAllWords(crossword, "home", "same"));
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> listWord = new ArrayList<>();
        TreeSet<Character> treeSet = new TreeSet<>();
        int[][] wordsArray = new int[words.length][];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int countOfLetters = word.length();
            wordsArray[i] = new int[countOfLetters];
            for (int j = 0; j < countOfLetters; j++) {
                char charAt = word.charAt(j);
                treeSet.add(charAt);
                wordsArray[i][j] = charAt;
            }
        }

        /*for (int i = 0; i < crossword.length; i++) {
            int[] array = crossword[i];
            for (int j = 0; j < array.length; j++) {
                if (!treeSet.contains((char) crossword[i][j])) {
                    crossword[i][j] = 0;
                }
            }
        }*/

        /*for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[i].length; j++) {
                System.out.print((char) crossword[i][j]);
            }
            System.out.println();
        }

        System.out.println("_________________");*/

        /*for (int i = 0; i < crossword.length; i++) {
            int[] array = crossword[i];
            for (int j = 0; j < array.length; j++) {
                if (treeSet.contains((char) crossword[i][j])) {
                    try {
                        if (crossword[i - 1][j - 1] + crossword[i - 1][j] + crossword[i - 1][j + 1] + crossword[i][j - 1] +
                                crossword[i][j + 1] + crossword[i + 1][j - 1] + crossword[i + 1][j] + crossword[i + 1][j + 1] == 0) {
                            crossword[i][j] = 0;
                        }
                    } catch (Exception e) {
                        if (i == 0) {
                            if (j == 0) {
                                if (crossword[i][j + 1] + crossword[i + 1][j] + crossword[i + 1][j + 1] == 0) {
                                    crossword[i][j] = 0;
                                }
                            } else if (j == array.length - 1) {
                                if (crossword[i][j - 1] + crossword[i + 1][j - 1] + crossword[i + 1][j] == 0) {
                                    crossword[i][j] = 0;
                                }
                            }
                        } else if (i == crossword.length - 1) {
                            if (j == 0) {
                                if (crossword[i - 1][j] + crossword[i - 1][j + 1] + crossword[i][j + 1] == 0) {
                                    crossword[i][j] = 0;
                                }
                            } else if (j == array.length - 1) {
                                if (crossword[i - 1][j - 1] + crossword[i - 1][j] + crossword[i][j - 1] == 0) {
                                    crossword[i][j] = 0;
                                }
                            }
                        } else {
                            if (j == 0) {
                                if (crossword[i - 1][j] + crossword[i + 1][j] + crossword[i - 1][j + 1] + crossword[i + 1][j + 1] + crossword[i][j + 1] == 0) {
                                    crossword[i][j] = 0;
                                }
                            } else if (j == array.length - 1) {
                                if (crossword[i - 1][j - 1] + crossword[i - 1][j] + crossword[i][j - 1] + crossword[i + 1][j - 1] + crossword[i + 1][j] == 0) {
                                    crossword[i][j] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }*/

        /*for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[i].length; j++) {
                System.out.print((char) crossword[i][j]);
            }
            System.out.println();
        }

        System.out.println("_______________");*/

        for (int k = 0; k < words.length; k++) {
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {
                    if (crossword[i][j] == wordsArray[k][0]) {
                        int m = 0;
                        try {
                            if (crossword[i][j + 1] == wordsArray[k][m + 1]) {
                                if((m+1) == wordsArray[k].length -1 ) {
                                    Word word = new Word(words[k]);
                                    word.setStartPoint(j,i);
                                    word.setEndPoint(j+1,i);
                                    listWord.add(word);
                                }
                                for (int l = m+2, o = j+2; l < wordsArray[k].length; l++, o++) {
                                    if(crossword[i][o] == wordsArray[k][l]){
                                        if(l == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(o,i);
                                            listWord.add(word);
                                        }
                                    }
                                }
                                // считаем вправо та же строка
                                //
                            }
                            if (crossword[i][j - 1] == wordsArray[k][m + 1]) {
                                if((m+1) == wordsArray[k].length -1 ) {
                                    Word word = new Word(words[k]);
                                    word.setStartPoint(j,i);
                                    word.setEndPoint(j-1,i);
                                    listWord.add(word);
                                }
                                for (int l = m+2, o = j-2; l < wordsArray[k].length; l++, o--) {
                                    if(crossword[i][o] == wordsArray[k][l]){
                                        if(l == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(o,i);
                                            listWord.add(word);
                                        }
                                    }
                                }
                                // считаем влево та же строка
                                //
                            }
                            if (crossword[i - 1][j] == wordsArray[k][m + 1]) {
                                if((m+1) == wordsArray[k].length -1 ) {
                                    Word word = new Word(words[k]);
                                    word.setStartPoint(j,i);
                                    word.setEndPoint(j,i-1);
                                    listWord.add(word);
                                }
                                for (int l = m+2, o = i-2; l < wordsArray[k].length; l++, o--) {
                                    if(crossword[o][j] == wordsArray[k][l]){
                                        if(l == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(j,o);
                                            listWord.add(word);
                                        }
                                    }
                                }
                                // считаем вверх тот же столбец
                                //
                            }
                            if (crossword[i + 1][j] == wordsArray[k][m + 1]) {
                                if((m+1) == wordsArray[k].length -1 ) {
                                    Word word = new Word(words[k]);
                                    word.setStartPoint(j,i);
                                    word.setEndPoint(j,i+1);
                                    listWord.add(word);
                                }
                                for (int l = m+2, o = i+2; l < wordsArray[k].length; l++, o++) {
                                    if(crossword[o][j] == wordsArray[k][l]){
                                        if(l == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(j,o);
                                            listWord.add(word);
                                        }
                                    }
                                }
                                // считаем вниз тот же столбец
                                //
                            }
                            if (crossword[i - 1][j - 1] == wordsArray[k][m + 1]) {
                                if((m+1) == wordsArray[k].length -1 ) {
                                    Word word = new Word(words[k]);
                                    word.setStartPoint(j,i);
                                    word.setEndPoint(j-1,i-1);
                                    listWord.add(word);
                                }
                                for (int l = m+2, o = i-2, p = j - 2; l < wordsArray[k].length; l++, o--, p--) {
                                    if(crossword[o][p] == wordsArray[k][l]){
                                        if(l == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(p,o);
                                            listWord.add(word);
                                        }
                                    }
                                }
                                // считаем влево вверх
                                //
                            }
                            if (crossword[i + 1][j + 1] == wordsArray[k][m + 1]) {
                                if((m+1) == wordsArray[k].length -1 ) {
                                    Word word = new Word(words[k]);
                                    word.setStartPoint(j,i);
                                    word.setEndPoint(j+1,i+1);
                                    listWord.add(word);
                                }
                                for (int l = m+2, o = i+2, p=j+2; l < wordsArray[k].length; l++, o++, p++) {
                                    if(crossword[o][p] == wordsArray[k][l]){
                                        if(l == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(p,o);
                                            listWord.add(word);
                                        }
                                    }
                                }
                                // считаем вправо вниз
                                //
                            }
                            if (crossword[i - 1][j + 1] == wordsArray[k][m + 1]) {
                                if((m+1) == wordsArray[k].length -1 ) {
                                    Word word = new Word(words[k]);
                                    word.setStartPoint(j,i);
                                    word.setEndPoint(j+1,i-1);
                                    listWord.add(word);
                                }
                                for (int l = m+2, o = i-2, p=j+2; l < wordsArray[k].length; l++, o--, p++) {
                                    if(crossword[o][p] == wordsArray[k][l]){
                                        if(l == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(p,o);
                                            listWord.add(word);
                                        }
                                    }
                                }
                                // считаем вправо вверх
                                //
                            }
                            if (crossword[i + 1][j - 1] == wordsArray[k][m + 1]) {
                                if((m+1) == wordsArray[k].length -1 ) {
                                    Word word = new Word(words[k]);
                                    word.setStartPoint(j,i);
                                    word.setEndPoint(j-1,i+1);
                                    listWord.add(word);
                                }
                                for (int l = m+2, o = i+2, p=j-2; l < wordsArray[k].length; l++, o++, p--) {
                                    if(crossword[o][p] == wordsArray[k][l]){
                                        if(l == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(p,o);
                                            listWord.add(word);
                                        }
                                    }
                                }
                                // считаем влево вниз
                                //
                            }
                        } catch (Exception e) {
                            if (i == 0) {
                                if (j == 0) {
                                    if (crossword[i][j + 1] == wordsArray[k][m + 1]) {
                                        if((m+1) == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(j+1,i);
                                            listWord.add(word);
                                        }
                                        for (int l = m+2, o = j+2; l < wordsArray[k].length; l++, o++) {
                                            if(crossword[i][o] == wordsArray[k][l]){
                                                if(l == wordsArray[k].length -1 ) {
                                                    Word word = new Word(words[k]);
                                                    word.setStartPoint(j,i);
                                                    word.setEndPoint(o,i);
                                                    listWord.add(word);
                                                }
                                            }
                                        }
                                        // считаем вправо та же строка
                                    }
                                    if (crossword[i + 1][j] == wordsArray[k][m + 1]) {
                                        if((m+1) == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(j,i+1);
                                            listWord.add(word);
                                        }
                                        for (int l = m+2, o = i+2; l < wordsArray[k].length; l++, o++) {
                                            if(crossword[o][j] == wordsArray[k][l]){
                                                if(l == wordsArray[k].length -1 ) {
                                                    Word word = new Word(words[k]);
                                                    word.setStartPoint(j,i);
                                                    word.setEndPoint(j,o);
                                                    listWord.add(word);
                                                }
                                            }
                                        }
                                        // считаем вниз тот же столбец
                                    }
                                    if (crossword[i + 1][j + 1] == wordsArray[k][m + 1]) {
                                        if((m+1) == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(j+1,i+1);
                                            listWord.add(word);
                                        }
                                        for (int l = m+2, o = i+2, p=j+2; l < wordsArray[k].length; l++, o++, p++) {
                                            if(crossword[o][p] == wordsArray[k][l]){
                                                if(l == wordsArray[k].length -1 ) {
                                                    Word word = new Word(words[k]);
                                                    word.setStartPoint(j,i);
                                                    word.setEndPoint(p,o);
                                                    listWord.add(word);
                                                }
                                            }
                                        }
                                        // считаем вправо вниз
                                    }
                                } else if (j == crossword[i].length - 1) {
                                    if (crossword[i][j - 1] == wordsArray[k][m + 1]) {
                                        if((m+1) == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(j-1,i);
                                            listWord.add(word);
                                        }
                                        for (int l = m+2, o = j-2; l < wordsArray[k].length; l++, o--) {
                                            if(crossword[i][o] == wordsArray[k][l]){
                                                if(l == wordsArray[k].length -1 ) {
                                                    Word word = new Word(words[k]);
                                                    word.setStartPoint(j,i);
                                                    word.setEndPoint(o,i);
                                                    listWord.add(word);
                                                }
                                            }
                                        }
                                        // считаем влево та же строка
                                    }
                                    if (crossword[i + 1][j - 1] == wordsArray[k][m + 1]) {
                                        if((m+1) == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(j-1,i+1);
                                            listWord.add(word);
                                        }
                                        for (int l = m+2, o = i+2, p=j-2; l < wordsArray[k].length; l++, o++, p--) {
                                            if(crossword[o][p] == wordsArray[k][l]){
                                                if(l == wordsArray[k].length -1 ) {
                                                    Word word = new Word(words[k]);
                                                    word.setStartPoint(j,i);
                                                    word.setEndPoint(p,o);
                                                    listWord.add(word);
                                                }
                                            }
                                        }
                                        // считаем влево вниз
                                    }
                                    if (crossword[i + 1][j] == wordsArray[k][m + 1]) {
                                        if((m+1) == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(j,i+1);
                                            listWord.add(word);
                                        }
                                        for (int l = m+2, o = i+2; l < wordsArray[k].length; l++, o++) {
                                            if(crossword[o][j] == wordsArray[k][l]){
                                                if(l == wordsArray[k].length -1 ) {
                                                    Word word = new Word(words[k]);
                                                    word.setStartPoint(j,i);
                                                    word.setEndPoint(j,o);
                                                    listWord.add(word);
                                                }
                                            }
                                        }
                                        // считаем вниз тот же столбец
                                    }
                                }
                            } else if (i == crossword.length - 1) {
                                if (j == 0) {
                                    if (crossword[i - 1][j] == wordsArray[k][m + 1]) {
                                        if((m+1) == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i-1);
                                            word.setEndPoint(j,i-1);
                                            listWord.add(word);
                                        }
                                        for (int l = m+2, o = i-2; l < wordsArray[k].length; l++, o--) {
                                            if(crossword[o][j] == wordsArray[k][l]){
                                                if(l == wordsArray[k].length -1 ) {
                                                    Word word = new Word(words[k]);
                                                    word.setStartPoint(j,i);
                                                    word.setEndPoint(j,o);
                                                    listWord.add(word);
                                                }
                                            }
                                        }
                                        // считаем вверх тот же столбец
                                    }
                                    if (crossword[i - 1][j + 1] == wordsArray[k][m + 1]) {
                                        if((m+1) == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(j+1,i-1);
                                            listWord.add(word);
                                        }
                                        for (int l = m+2, o = i-2, p=j+2; l < wordsArray[k].length; l++, o--, p++) {
                                            if(crossword[o][p] == wordsArray[k][l]){
                                                if(l == wordsArray[k].length -1 ) {
                                                    Word word = new Word(words[k]);
                                                    word.setStartPoint(j,i);
                                                    word.setEndPoint(p,o);
                                                    listWord.add(word);
                                                }
                                            }
                                        }
                                        // считаем вправо вверх
                                    }
                                    if (crossword[i][j + 1] == wordsArray[k][m + 1]) {
                                        if((m+1) == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(j+1,i);
                                            listWord.add(word);
                                        }
                                        for (int l = m+2, o = j+2; l < wordsArray[k].length; l++, o++) {
                                            if(crossword[i][o] == wordsArray[k][l]){
                                                if(l == wordsArray[k].length -1 ) {
                                                    Word word = new Word(words[k]);
                                                    word.setStartPoint(j,i);
                                                    word.setEndPoint(o,i);
                                                    listWord.add(word);
                                                }
                                            }
                                        }
                                        // считаем вправо та же строка
                                    }
                                }
                                if (j == crossword[i].length - 1) {
                                    if (crossword[i - 1][j - 1] == wordsArray[k][m + 1]) {
                                        if((m+1) == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(j-1,i-1);
                                            listWord.add(word);
                                        }
                                        for (int l = m+2, o = i-2, p = j - 2; l < wordsArray[k].length; l++, o--, p--) {
                                            if(crossword[o][p] == wordsArray[k][l]){
                                                if(l == wordsArray[k].length -1 ) {
                                                    Word word = new Word(words[k]);
                                                    word.setStartPoint(j,i);
                                                    word.setEndPoint(p,o);
                                                    listWord.add(word);
                                                }
                                            }
                                        }
                                        // считаем влево вверх
                                    }
                                    if (crossword[i - 1][j] == wordsArray[k][m + 1]) {
                                        if((m+1) == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(j,i-1);
                                            listWord.add(word);
                                        }
                                        for (int l = m+2, o = i-2; l < wordsArray[k].length; l++, o--) {
                                            if(crossword[o][j] == wordsArray[k][l]){
                                                if(l == wordsArray[k].length -1 ) {
                                                    Word word = new Word(words[k]);
                                                    word.setStartPoint(j,i);
                                                    word.setEndPoint(j,o);
                                                    listWord.add(word);
                                                }
                                            }
                                        }
                                        // считаем вверх тот же столбец
                                    }
                                    if (crossword[i][j - 1] == wordsArray[k][m + 1]) {
                                        if((m+1) == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(j-1,i);
                                            listWord.add(word);
                                        }
                                        for (int l = m+2, o = j-2; l < wordsArray[k].length; l++, o--) {
                                            if(crossword[i][o] == wordsArray[k][l]){
                                                if(l == wordsArray[k].length -1 ) {
                                                    Word word = new Word(words[k]);
                                                    word.setStartPoint(j,i);
                                                    word.setEndPoint(o,i);
                                                    listWord.add(word);
                                                }
                                            }
                                        }
                                        // считаем влево та же строка
                                    }
                                }
                            } else {
                                if (j == 0) {
                                    if (crossword[i - 1][j] == wordsArray[k][m + 1]) {
                                        if((m+1) == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(j,i-1);
                                            listWord.add(word);
                                        }
                                        for (int l = m+2, o = i-2; l < wordsArray[k].length; l++, o--) {
                                            if(crossword[o][j] == wordsArray[k][l]){
                                                if(l == wordsArray[k].length -1 ) {
                                                    Word word = new Word(words[k]);
                                                    word.setStartPoint(j,i);
                                                    word.setEndPoint(j,o);
                                                    listWord.add(word);
                                                }
                                            }
                                        }
                                        // считаем вверх тот же столбец
                                    }
                                    if (crossword[i + 1][j] == wordsArray[k][m + 1]) {
                                        if((m+1) == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(j,i+1);
                                            listWord.add(word);
                                        }
                                        for (int l = m+2, o = i+2; l < wordsArray[k].length; l++, o++) {
                                            if(crossword[o][j] == wordsArray[k][l]){
                                                if(l == wordsArray[k].length -1 ) {
                                                    Word word = new Word(words[k]);
                                                    word.setStartPoint(j,i);
                                                    word.setEndPoint(j,o);
                                                    listWord.add(word);
                                                }
                                            }
                                        }
                                        // считаем вниз тот же столбец
                                    }
                                    if (crossword[i - 1][j + 1] == wordsArray[k][m + 1]) {
                                        if((m+1) == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(j+1,i-1);
                                            listWord.add(word);
                                        }
                                        for (int l = m+2, o = i-2, p=j+2; l < wordsArray[k].length; l++, o--, p++) {
                                            if(crossword[o][p] == wordsArray[k][l]){
                                                if(l == wordsArray[k].length -1 ) {
                                                    Word word = new Word(words[k]);
                                                    word.setStartPoint(j,i);
                                                    word.setEndPoint(p,o);
                                                    listWord.add(word);
                                                }
                                            }
                                        }
                                        // считаем вправо вверх
                                    }
                                    if (crossword[i + 1][j + 1] == wordsArray[k][m + 1]) {
                                        if((m+1) == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(j+1,i+1);
                                            listWord.add(word);
                                        }
                                        for (int l = m+2, o = i+2, p=j+2; l < wordsArray[k].length; l++, o++, p++) {
                                            if(crossword[o][p] == wordsArray[k][l]){
                                                if(l == wordsArray[k].length -1 ) {
                                                    Word word = new Word(words[k]);
                                                    word.setStartPoint(j,i);
                                                    word.setEndPoint(p,o);
                                                    listWord.add(word);
                                                }
                                            }
                                        }
                                        // считаем вправо вниз
                                    }
                                    if (crossword[i][j + 1] == wordsArray[k][m + 1]) {
                                        if((m+1) == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(j+1,i);
                                            listWord.add(word);
                                        }
                                        for (int l = m+2, o = j+2; l < wordsArray[k].length; l++, o++) {
                                            if(crossword[i][o] == wordsArray[k][l]){
                                                if(l == wordsArray[k].length -1 ) {
                                                    Word word = new Word(words[k]);
                                                    word.setStartPoint(j,i);
                                                    word.setEndPoint(o,i);
                                                    listWord.add(word);
                                                }
                                            }
                                        }
                                        // считаем вправо та же строка
                                    }
                                }
                                if (j == crossword[i].length - 1) {
                                    if (crossword[i - 1][j - 1] == wordsArray[k][m + 1]) {
                                        if((m+1) == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(j-1,i-1);
                                            listWord.add(word);
                                        }
                                        for (int l = m+2, o = i-2, p = j - 2; l < wordsArray[k].length; l++, o--, p--) {
                                            if(crossword[o][p] == wordsArray[k][l]){
                                                if(l == wordsArray[k].length -1 ) {
                                                    Word word = new Word(words[k]);
                                                    word.setStartPoint(j,i);
                                                    word.setEndPoint(p,o);
                                                    listWord.add(word);
                                                }
                                            }
                                        }
                                        // считаем влево вверх
                                    }
                                    if (crossword[i - 1][j] == wordsArray[k][m + 1]) {
                                        if((m+1) == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(j,i-1);
                                            listWord.add(word);
                                        }
                                        for (int l = m+2, o = i-2; l < wordsArray[k].length; l++, o--) {
                                            if(crossword[o][j] == wordsArray[k][l]){
                                                if(l == wordsArray[k].length -1 ) {
                                                    Word word = new Word(words[k]);
                                                    word.setStartPoint(j,i);
                                                    word.setEndPoint(j,o);
                                                    listWord.add(word);
                                                }
                                            }
                                        }
                                        // считаем вверх тот же столбец
                                    }
                                    if (crossword[i][j - 1] == wordsArray[k][m + 1]) {
                                        if((m+1) == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(j-1,i);
                                            listWord.add(word);
                                        }
                                        for (int l = m+2, o = j-2; l < wordsArray[k].length; l++, o--) {
                                            if(crossword[i][o] == wordsArray[k][l]){
                                                if(l == wordsArray[k].length -1 ) {
                                                    Word word = new Word(words[k]);
                                                    word.setStartPoint(j,i);
                                                    word.setEndPoint(o,i);
                                                    listWord.add(word);
                                                }
                                            }
                                        }
                                        // считаем влево та же строка
                                    }
                                    if (crossword[i + 1][j - 1] == wordsArray[k][m + 1]) {
                                        if((m+1) == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(j-1,i+1);
                                            listWord.add(word);
                                        }
                                        for (int l = m+2, o = i+2, p=j-2; l < wordsArray[k].length; l++, o++, p--) {
                                            if(crossword[o][p] == wordsArray[k][l]){
                                                if(l == wordsArray[k].length -1 ) {
                                                    Word word = new Word(words[k]);
                                                    word.setStartPoint(j,i);
                                                    word.setEndPoint(p,o);
                                                    listWord.add(word);
                                                }
                                            }
                                        }
                                        // считаем влево вниз
                                    }
                                    if (crossword[i + 1][j] == wordsArray[k][m + 1]) {
                                        if((m+1) == wordsArray[k].length -1 ) {
                                            Word word = new Word(words[k]);
                                            word.setStartPoint(j,i);
                                            word.setEndPoint(j,i+1);
                                            listWord.add(word);
                                        }
                                        for (int l = m+2, o = i+2; l < wordsArray[k].length; l++, o++) {
                                            if(crossword[o][j] == wordsArray[k][l]){
                                                if(l == wordsArray[k].length -1 ) {
                                                    Word word = new Word(words[k]);
                                                    word.setStartPoint(j,i);
                                                    word.setEndPoint(j,o);
                                                    listWord.add(word);
                                                }
                                            }
                                        }
                                        // считаем вниз тот же столбец
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


        return listWord;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
