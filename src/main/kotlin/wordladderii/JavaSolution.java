package wordladderii;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder-ii
 *
 * @author Rugal Bernstein
 */
public class JavaSolution {

  private String getWord(final String word, final int i) {
    return String.format("%s_%s", word.substring(0, i), word.substring(i + 1));
  }

  /**
   * Create word map of words that have the same pattern, for instance all word matches AB_ will be
   * grouped together and so forth.
   *
   * @param wordList
   * @return
   */
  private Map<String, List<String>> build(final List<String> wordList) {
    final Map<String, List<String>> map = new HashMap<>();
    for (String word : wordList) {
      for (int i = 0; i < word.length(); ++i) {
        final String key = this.getWord(word, i);
        final List<String> get = map.getOrDefault(key, new ArrayList<>());
        get.add(word);
        map.put(key, get);
      }
    }
    return map;
  }

  /**
   * Similar to the original question, but need to have path.<BR>
   * So still use BFS, but need to do that with knowing the level detail<BR>
   * Because we need to add all combination of that specific level.
   *
   * @param beginWord
   * @param endWord
   * @param wordList
   * @return
   */
  public List<List<String>> findLadders(final String beginWord,
                                        final String endWord,
                                        final List<String> wordList) {
    final List<List<String>> result = new ArrayList<>();

    if (beginWord == null || endWord == null || wordList == null) {
      return result;
    }
    final Map<String, List<String>> map = this.build(wordList);
    final Set<String> unvisited = new HashSet<>(wordList);
    final Set<String> currentVisited = new HashSet<>();
    final Queue<Pair> bfsQueue = new LinkedList<>();

    bfsQueue.offer(new Pair(beginWord, new ArrayList<>()));
    currentVisited.add(beginWord);

    boolean foundEnd = false;

    while (!foundEnd && !bfsQueue.isEmpty()) {
      //Get rid of visited word only after visiting each layer
      unvisited.removeAll(currentVisited);
      //because within the same layer, we still allow duplicate visit
      currentVisited.clear();
      //Scan only for one level
      //To control scope of BFS
      //because only one level at a time, the result from same level must all be the best path
      final int size = bfsQueue.size();
      //traverse each element within this level
      for (int w = 0; w < size; w++) {
        final Pair top = bfsQueue.poll();
        //traverse all possible words
        for (int i = 0; i < top.getLastWord().length(); ++i) {
          for (final String s : map.getOrDefault(this.getWord(top.getLastWord(), i), new ArrayList<>())) {
            if (!unvisited.contains(s)) {
              continue;
            }
            final Pair newNode = new Pair(s, top.path);
            if (s.equals(endWord)) {
              //once it ends here, we need to save all possible path, save this result
              result.add(newNode.path);
              //we can exit the loop, but not until go through all element in this level
              foundEnd = true;
            }
            bfsQueue.offer(newNode);
            currentVisited.add(s);
          }
        }
      }
    }

    return result;
  }

  class Pair {

    List<String> path;

    Pair(String word, List<String> path) {
      this.path = new ArrayList<>(path);
      this.path.add(word);
    }

    String getLastWord() {
      return this.path.get(this.path.size() - 1);
    }
  }
}
