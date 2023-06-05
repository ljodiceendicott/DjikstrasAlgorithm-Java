/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jodic
 */
public class WeightedEdge {
    private int source;  // id of source vertex
    private int dest;    // id of destination vertex;
    private int cost;

    public WeightedEdge(int source, int dest, int cost) {
        this.source = source;
        this.dest = dest;
        this.cost = cost;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
/*
When your code prints out the costs you should see something like this...
Node: 0 Cost: 0 Backtrace Parent: -1
Node: 1 Cost: 4 Backtrace Parent: 2
Node: 2 Cost: 1 Backtrace Parent: 0
Node: 3 Cost: 5 Backtrace Parent: 1
etc...
*/
