package twopointer;

public class ValidWordAbbreviation {
    public static void main(String[] args) {
        String[] words = {"a", "a", "abcdefghijklmnopqrst", "abcdefghijklmnopqrst", "word", "internationalization", "localization"};
        String[] abbreviations = {"a", "b", "a18t", "a19t", "w0rd", "i18n", "l12n"};

        for (int i = 0; i < words.length; i++) {
            System.out.println((i + 1) + ".\t word: '" + words[i] + "'");
            System.out.println("\t abbr: '" + abbreviations[i] + "'");
            System.out.println("\n\t Is '" + abbreviations[i] + "' a valid abbreviation for the word '" + words[i] + "'? " + (validWordAbbreviation(words[i], abbreviations[i])? "Yes" : "No"));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public static boolean validWordAbbreviation(String word, String abbr) {
        abbr = abbr.toLowerCase();
        word = word.toLowerCase();

        if (word.length() < abbr.length())
            return false;

        int index = 0;
        StringBuilder numberstr = new StringBuilder();
        for (int i = 0; i < abbr.length(); i++) {
            char ac = abbr.charAt(i);
            if (ac == '0' && "".equals(numberstr.toString())) {
                return false;
            }
            while (ac >= '0' && ac <= '9' && i < abbr.length()) {
                numberstr.append(ac);
                ac = abbr.charAt(++i);
            }
            if (numberstr.length() > 0) {
                int num = Integer.parseInt(numberstr.toString());
                if (index + num > word.length()) {
                    return false;
                } else {
                    index += num;
                    numberstr = new StringBuilder("");
                }
            } else if (ac != word.charAt(index)) {
                return false;
            }
            index++;
        }
        // Replace the following return statement with your code
        return true;
    }
}
