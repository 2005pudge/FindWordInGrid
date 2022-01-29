import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

public class FindWordInGrid2 {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        System.out.println(detectAllWords(crossword, "home", "same"));
                        /*Ожидаемый результат
                        home - (5, 3) - (2, 0)
                        same - (1, 1) - (4, 1)*/
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        List<Word> wordList = new ArrayList<>();
        int[] mArray = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] nArray = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        for (int p = 0; p < words.length; p++) {
            // для каждого слова, которое нужно найти
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {
                    // пробегаем по каждому символу кроссворда
                    if ((char) crossword[i][j] == words[p].charAt(0)) {
                        for (int m = 0, n = 0; m < mArray.length; m++, n++) {
                            // если символ равен 1-ой букве искомого слова, то ищем в 8-и направлениях 2-ю букву
                            for (int k = 1; k < words[p].length(); k++) {
                                // для каждой буквы искомого слова
                                try {
                                    if ((char) crossword[i + (k * mArray[m])][j + (k * nArray[n])] == words[p].charAt(k)) {
                                        // если вокруг 1-ой буквы слова нашли 2-ю (3-ю, 4-ю...) букву слова
                                        if ((k + 1) == words[p].length()) {
                                            Word word = new Word(words[p]);
                                            word.setStartPoint(j, i);
                                            word.setEndPoint(j + (k * nArray[n]), i + (k * mArray[m]));
                                            wordList.add(word);
                                        }
                                    } else break;
                                } catch (Exception ignored) {
                                }
                            }
                        }
                    }
                }
            }
        }
        return wordList;
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
