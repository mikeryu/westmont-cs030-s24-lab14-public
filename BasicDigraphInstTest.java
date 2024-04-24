/**
 * Westmont College Spring 2024
 * CS 030 Lab 14, Task 2
 *
 * @author Assistant Professor Mike Ryu mryu@westmont.edu
 */

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicDigraphInstTest {

  private static BasicDigraph lectureExampleGraph;
  private static BasicDigraph lecturePracticeGraph;

  @BeforeAll
  static void setUp() {
    lectureExampleGraph = new BasicDigraph(7);
    lecturePracticeGraph = new BasicDigraph(7);

    populateLectureExampleGraph();
    populateLecturePracticeGraph();
  }

  private static void populateLectureExampleGraph() {
    // v_1 from lecture slides.
    lectureExampleGraph.addEdge(0, 1, 2);
    lectureExampleGraph.addEdge(0, 3, 1);

    // v_2.
    lectureExampleGraph.addEdge(1, 3, 3);
    lectureExampleGraph.addEdge(1, 4, 10);

    // v_3.
    lectureExampleGraph.addEdge(2, 0, 4);
    lectureExampleGraph.addEdge(2, 5, 5);

    // v_4.
    lectureExampleGraph.addEdge(3, 2, 2);
    lectureExampleGraph.addEdge(3, 4, 2);
    lectureExampleGraph.addEdge(3, 5, 8);
    lectureExampleGraph.addEdge(3, 6, 4);

    // v_5.
    lectureExampleGraph.addEdge(4, 6, 6);

    // v_6 has no outgoing edge; now v_7.
    lectureExampleGraph.addEdge(6, 5, 1);
  }

  private static void populateLecturePracticeGraph() {
    // A from lecture slides.
    lecturePracticeGraph.addEdge(0, 1, 5);
    lecturePracticeGraph.addEdge(0, 2, 3);

    // B.
    lecturePracticeGraph.addEdge(1, 2, 2);
    lecturePracticeGraph.addEdge(1, 4, 3);
    lecturePracticeGraph.addEdge(1, 6, 1);

    // C.
    lecturePracticeGraph.addEdge(2, 3, 7);
    lecturePracticeGraph.addEdge(2, 4, 7);

    // D.
    lecturePracticeGraph.addEdge(3, 0, 2);
    lecturePracticeGraph.addEdge(3, 5, 6);

    // E.
    lecturePracticeGraph.addEdge(4, 3, 2);
    lecturePracticeGraph.addEdge(4, 5, 1);

    // F has no outgoing edge; now G.
    lecturePracticeGraph.addEdge(6, 4, 1);
  }

  @Test
  void dijkstraLectureExample() {
    List<List<Integer>> expected = new ArrayList<>(7);
    expected.add(List.of(0));
    expected.add(List.of(0, 1));
    expected.add(List.of(0, 3, 2));
    expected.add(List.of(0, 3));
    expected.add(List.of(0, 3, 4));
    expected.add(List.of(0, 3, 6, 5));
    expected.add(List.of(0, 3, 6));


    printForDebugging(lectureExampleGraph, 0);
    assertEquals(expected, lectureExampleGraph.dijkstra(0));
  }

  @Test
  void dijkstraLectureExampleAlternate() {
    List<List<Integer>> expected = new ArrayList<>(7);
    expected.add(List.of(3, 2, 0));
    expected.add(List.of(3, 2, 0, 1));
    expected.add(List.of(3, 2));
    expected.add(List.of(3));
    expected.add(List.of(3, 4));
    expected.add(List.of(3, 6, 5));
    expected.add(List.of(3, 6));


    printForDebugging(lectureExampleGraph, 3);
    assertEquals(expected, lectureExampleGraph.dijkstra(3));
  }

  @Test
  void dijkstraLecturePractice() {
    List<List<Integer>> expected = new ArrayList<>(7);
    expected.add(List.of(0));
    expected.add(List.of(0, 1));
    expected.add(List.of(0, 2));
    expected.add(List.of(0, 1, 6, 4, 3));
    expected.add(List.of(0, 1, 6, 4));
    expected.add(List.of(0, 1, 6, 4, 5));
    expected.add(List.of(0, 1, 6));

    printForDebugging(lecturePracticeGraph, 0);
    assertEquals(expected, lecturePracticeGraph.dijkstra(0));
  }

  @Test
  void dijkstraLecturePracticeAlternate() {
    List<List<Integer>> expected = new ArrayList<>(7);
    expected.add(List.of(4, 3, 0));
    expected.add(List.of(4, 3, 0, 1));
    expected.add(List.of(4, 3, 0, 2));
    expected.add(List.of(4, 3));
    expected.add(List.of(4));
    expected.add(List.of(4, 5));
    expected.add(List.of(4, 3, 0, 1, 6));

    printForDebugging(lecturePracticeGraph, 4);
    assertEquals(expected, lecturePracticeGraph.dijkstra(4));
  }

  private void printForDebugging(BasicDigraph bdg, int fromVertex) {
    System.out.println();
    System.out.println(bdg);

    List<List<Integer>> result = bdg.dijkstra(fromVertex);
    for (int v = 0; v < result.size(); v++) {
      System.out.printf("To %2d: %s\n", v, result.get(v).toString());
    }
  }
}