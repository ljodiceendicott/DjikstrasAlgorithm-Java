/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jodic
 */
import java.util.ArrayList;
import java.util.Stack;

public class Dijkstrafinder {
    final static int UNKNOWN = -1;  // Indicates an unknown cost or parent

    /**
     * This method prints out the shortest path between a source
     * and destination vertex. There are nNodes in the graph and
     * the nodes are numbered 0 to nNodes-1.  The edges have weights.
     * Uses Dijkstra's algorithm to find the shortest path.
     * The graphic is acyclic (no cycles).
     *
     * @param edges
     * @param start index of starting vertex
     * @param dest index of ending vertex
     * @param nNodes number of nodes in graph
     */
    private static void findShortestPath(ArrayList<WeightedEdge> edges, int start, int dest, int nNodes) {
        int costs[] = new int[nNodes];  // costs[i] = the cheapest cost to get to node i
        int parents[] = new int[nNodes];  // parents[i] = the node we used to get to node i.
        boolean doneWithNode[] = new boolean[nNodes];  // we're done if we've looked at the node and considered edges

        // Let's start marking all our costs and parent tracking as unknown.
        //initializing values
        for (int i = 0; i<nNodes; i++) {
            costs[i] = UNKNOWN;
            parents[i] = UNKNOWN;
            doneWithNode[i] = false;
        }
        //node that is started
        int node = start;
        costs[node] = 0;

        // loop until there are no more nodes left to process
        while (node != UNKNOWN) {
            int cost = costs[node];  // the cost to get to the node we're working on
            for(int i=0; i<nNodes; i++){
               if(edges.get(i).getSource()== node){
                 if(costs[i]==UNKNOWN){
                     costs[i]=edges.get(i).getCost();
                     parents[i]=edges.get(i).getSource();
                 } 
                    if(costs[i]>edges.get(i).getCost()){
                    costs[i]=edges.get(i).getCost();
                    parents[i]=edges.get(i).getSource();
                 }
                   /*  int edge = edges.get(i).getCost();
                   if(costs[i]==UNKNOWN||costs[i]<edge){
                       costs[i]=edges.get(i).getCost();
                       parents[i]=edges.get(i).getSource();
               }*/
            }
            }
            // We need to loop through the children of this node.
            // This means looping through all the edges and
            // skipping those that aren't an edge coming out of node.
            // for loop...
            // for () {

                // Let's say we have an edge that goes from node to destination d.
                // We have to figure out a potential new cost for getting to node d.
                // Is that cheaper that any cost currently assigned to d?  Or is there no cost assigned?
                // If so, we have to update the cost of getting to d (costs[d]) and
                // update the parent node associated with d (parents[d]).
                //have to see if the cost that I currently have is cheaper that the node 

           // }

            doneWithNode[node] = true;

            node = getLowestCostUnprocessedNode(costs, doneWithNode);
        }

        for (int i=0; i<parents.length; i++) {
            System.out.println("Node: " + i + " Cost: " + costs[i] + " Backtrace Parent: " + parents[i]);
        }

        backtrace(dest, parents);
    }
    

    private static void backtrace(int dest, int[] parents) {
        Stack<Integer> stack = new Stack<Integer>();

        // Push on to the stack how you got to dest.
        // First push on the destination.
        int node = dest;
        stack.push(node);

        // Ok, now how did you get to node?
        // It's in parents[node].  Push it on to the stack
        // We need iteratively do this until we get to the start
        // (or get to a node that has no parent).

        // Add code...a while loop with stuff in it!
        while(parents[node]!=UNKNOWN){
            int i = parents[node];
            stack.push(i);
            node = i;
            }
        
        System.out.println("Path" );
        while (!stack.empty()) {
            System.out.println(" " + stack.pop());
        }
    }

    // Given that we know which nodes we've already processed, pick
    // a node to process next.  Only pick a node if we know the cost
    // of getting to that node.
    private static int getLowestCostUnprocessedNode(int[] costs, boolean[] doneWithNode) {
        int result = UNKNOWN;
        int lowestCost = Integer.MAX_VALUE;
        
            //mkae sure it is the lowest cost node
            //if you are not done know the cost and is the one with the lowest cost
            //if there are no such node you return unknown
            
        // Loop thru the nodes, only considering nodes that are: (1) unfinished (not done) 
        // and (2) have a cost that is not UNKNOWN.
        for (int i=0; i<doneWithNode.length; i++) {
             // Code..
            if(!doneWithNode[i]&&costs[i]!=UNKNOWN){
                if(costs[i]<lowestCost){
                    lowestCost=costs[i];
                    result = i;
                }
                }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<WeightedEdge> edges = new ArrayList<WeightedEdge>();

        edges.add(new WeightedEdge(0, 2, 1));
        edges.add(new WeightedEdge(0, 4, 2));
        edges.add(new WeightedEdge(1, 3, 1));
        edges.add(new WeightedEdge(1, 5, 2));
        edges.add(new WeightedEdge(1, 6, 2));
        edges.add(new WeightedEdge(2, 1, 3));
        edges.add(new WeightedEdge(2, 4, 5));
        edges.add(new WeightedEdge(3, 5, 1));
        edges.add(new WeightedEdge(3, 6, 1));
        edges.add(new WeightedEdge(4, 6, 1));
        edges.add(new WeightedEdge(5, 6, 1));
        edges.add(new WeightedEdge(5, 7, 1));
        edges.add(new WeightedEdge(6, 7, 3));

        findShortestPath(edges, 0, 7, 8);
    }
}
