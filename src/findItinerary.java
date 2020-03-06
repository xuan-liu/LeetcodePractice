import java.util.*;

public class findItinerary {
    static Map<String, PriorityQueue<String>> map = new HashMap<>();
    // key is the depart airport, value if the destination airport PriorityQueue
    static List<String> route = new LinkedList<>();
    // the answer list


    public static List<String> mySolution(List<List<String>> tickets) {
        // put each tickets in the map
        for (List<String> t: tickets) {
            if (map.containsKey(t.get(0))) {
                map.get(t.get(0)).add(t.get(1));
            } else {
                PriorityQueue<String> tmp = new PriorityQueue<>();
                tmp.add(t.get(1));
                map.put(t.get(0), tmp);
            }
        }

        visit("JFK");
        return route;
    }

    /* a help method for recursive tracking the route by DFS */
    private static void visit(String airpot) {
        while (map.containsKey(airpot) && !map.get(airpot).isEmpty()) {
            visit(map.get(airpot).poll());
        }
        route.add(0, airpot);
    }

    public static void main(String[] args) {
        List<List<String>> input = new ArrayList<>();
        input.add(Arrays.asList("JFK","SFO"));
        input.add(Arrays.asList("JFK","ATL"));
        input.add(Arrays.asList("SFO","ATL"));
        input.add(Arrays.asList("ATL","JFK"));
        input.add(Arrays.asList("ATL","SFO"));

        System.out.println(mySolution(input));
    }
}
