

/**
 * CSC-223 Weeks #14/15 Graphs * DUE DATE:
 * DATE SUBMITTED:
 * PROGRAMMED BY: A. Wright
 * MODIFIED BY: 
 
 *
 */
 
package mazetake3;

import java.util.Deque;

import java.util.ArrayList;

/**
 *
 * @author A. Wright
 * CLASS DESCRIPTION: Using a Queue to visit each vertex,
 * traverse a graph in a breadth-first fashion; produces a "parent" array of the
 * vertices so it is possible to retrace the path from one vertex to the
 * "starting" vertex.
 */
public class BreadthFirstSearch {

   private CircularArrayQueue<Integer> visitVertices;
   private Integer[] vParent;
   private boolean[] notVisited;
   private AMUndirGraph graph;
   private static int count = 0;

   public BreadthFirstSearch(AMUndirGraph g, int root) {
      graph = g;
      visitVertices = new CircularArrayQueue<Integer>(); // visiting order
      vParent = new Integer[graph.getNumVertices()]; // keep track of parents
      notVisited = new boolean[graph.getNumVertices()]; //indicate visited or not

      for (int i = 0; i < graph.getNumVertices(); i++) {
         vParent[i] = -1;  // initialize the parents of vertices to -1
         notVisited[i] = true;  // set visitation to NOT YET (true)
      }
      notVisited[root] = false;    // mark starting vertex as visited
      visitVertices.enqueue(root); // add starting vertex to the queue

   }

   public Integer[] runBFSearch() {
      while (!visitVertices.isEmpty()) {  // still have vertices to process
         System.out.println(" Queue trace " + (count++) + visitVertices);
         int currentV = visitVertices.dequeue();
         for (int i = 0; i < graph.getNumVertices(); i++) // add neighbors to Q
         {
            if (notVisited[i]
                    && graph.hasEdge(currentV, i)) // if adjacent, and NOT visited
            {
               visitVertices.enqueue(i);  // add this neighbor to the queue
               notVisited[i] = false;     // mark it as visited (once is enough)
               vParent[i] = currentV;     // assign the neighbor's parent to
                                          // this (currentV)
            }
         }
      }
      return vParent;
   }

}
