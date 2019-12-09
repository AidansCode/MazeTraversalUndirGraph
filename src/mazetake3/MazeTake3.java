package mazetake3;
import java.util.Stack;

public class MazeTake3 {

    public static void main(String[] args) {
        AMUndirGraph myGraph = new AMUndirGraph(10);
        Integer[] parentList;
        Stack<Integer> stack = new Stack<>();
        myGraph.addEdge(0, 2, 1);
        myGraph.addEdge(0, 5, 1);
        myGraph.addEdge(5, 3, 1);
        myGraph.addEdge(5, 6, 1);
        myGraph.addEdge(6, 3, 1);
        myGraph.addEdge(6, 7, 1);
        myGraph.addEdge(7, 8, 1);
        myGraph.addEdge(7, 4, 1);
        myGraph.addEdge(8, 1, 1);
        myGraph.addEdge(8, 9, 1);

        BreadthFirstSearch bfs = new BreadthFirstSearch(myGraph, 0);
        parentList = bfs.runBFSearch();
        for (Integer i : parentList) {
            System.out.println(i);
        }

        int curVertex = parentList.length - 1;
        while (curVertex != -1) {
            stack.push(curVertex);
            curVertex = parentList[curVertex];
        }
        
        StringBuilder output = new StringBuilder();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            output.append(cur).append(" => ");
        }
        output.append("EXIT");
        
        System.out.println("The best path through the maze starting from entry point 0 travelling to exit point " + (parentList.length - 1) + " is: ");
        System.out.println(output.toString());
    }

}
