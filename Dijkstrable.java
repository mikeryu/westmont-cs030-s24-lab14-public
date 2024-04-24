/**
 * Westmont College Spring 2024
 * CS 030 Lab 14, Task 2
 *
 * @author Assistant Professor Mike Ryu mryu@westmont.edu
 */

import java.util.List;

public interface Dijkstrable {

  /**
   * Implements the Dijkstra's algorithm to compute the shortest paths from the starting vertex
   * specified to every other vertex in a directed graph with weighted edges, and presents the
   * result of executing the algorithm on a graph as a {@link List} of {@link List<Integer>}.
   * <br><br>
   * For instance, an example of an outcome could look something like:
   * <pre>
   *    0: [0]
   *    1: [0, 1]
   *    2: [0, 2]
   *    3: [0, 1, 6, 4, 3]
   *    4: [0, 1, 6, 4]
   *    5: [0, 1, 6, 4, 5]
   *    6: [0, 1, 6]
   * </pre>
   * where each index of the outer list contains a list of shortest paths to reach
   * the vertex represented by the index value of the outer list (i.e., v0 through v6).
   *
   * @param fromVertex the starting vertex (with distance 0)
   * @return {@link List} of {@link List<Integer>} that shows the shortest path
   * from the starting vertex to each of the other vertices in a graph.
   */
  List<List<Integer>> dijkstra(int fromVertex);
}
