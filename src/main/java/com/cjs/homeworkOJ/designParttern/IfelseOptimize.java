package com.cjs.homeworkOJ.designParttern;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jinsheng
 * @date 2022年03月11日 00:00
 */
public class IfelseOptimize {

    public static void main(String[] args) {
        String chose = "A";
        if ("A".equals(chose)) {
            System.out.println("Adddd");
        } else if ("B".equals(chose)) {
            System.out.println("Bcccc");
        } else if ("C".equals(chose)) {
            System.out.println("Cffff");
        }

        HashMap<String, String> map = new HashMap<>();
        map.put("A", "Adddd");
        map.put("B", "Bcccc");
        map.put("C", "Cffff");

        OuterWordFilter wordFilter = FilterFactory.getFilter(map);

        wordFilter.start("A");

    }
}

class OuterWordFilter {
    private final WordFilter nextFilter;

    public OuterWordFilter(WordFilter nextFilter) {
        this.nextFilter = nextFilter;
    }

    public void start(String name) {
        nextFilter.next(name);
    }
}

class WordFilter {
    private String name;
    private String word;

    private WordFilter nextFilter;

    public WordFilter() {
        this(null, null);
    }

    public WordFilter(String name, String word) {
        this(name, word, null);
    }

    public WordFilter(String name, String word, WordFilter nextFilter) {
        this.name = name;
        this.word = word;
        this.nextFilter = nextFilter;
    }

    public WordFilter getNextFilter() {
        return nextFilter;
    }

    public void setNextFilter(WordFilter nextFilter) {
        this.nextFilter = nextFilter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void next(String choseName) {
        if (choseName == null) return;
        if (choseName.equals(name)) {
            System.out.println(word);
        }
        if (hasNext()) {
            nextFilter.next(choseName);
        }
    }

    public boolean hasNext() {
        return nextFilter != null;
    }
}

class FilterFactory {
    public static OuterWordFilter getFilter(HashMap<String, String> map) {
        List<WordFilter> list = map.entrySet()
                .stream()
                .map(i -> new WordFilter(i.getKey(), i.getValue()))
                .collect(Collectors.toList());
        WordFilter sumFilter = new WordFilter();
        OuterWordFilter outerFilter = new OuterWordFilter(sumFilter);
        WordFilter iterFilter = sumFilter;
        for (WordFilter wordFilter : list) {
            iterFilter.setNextFilter(wordFilter);
            iterFilter = wordFilter;
        }
        return outerFilter;
    }
}