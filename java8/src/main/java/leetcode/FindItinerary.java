package leetcode;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * @author huanghaoxing
 */
public class FindItinerary {
  /**
   * 图的定点数
   */
  int V;
  /**
   * 图的边数
   */
  int E;

  /**
   * 邻接点
   */
  Map<String, List<String>> adj;

  LinkedList<String> path;

  public List<String> findItinerary(List<List<String>> tickets) {
    // 构建图
    E = tickets.size();
    adj = new HashMap<>();
    path = new LinkedList<>();
    for (List<String> ticket : tickets) {
      String from = ticket.get(0);
      String to = ticket.get(1);
      List<String> vertex = adj.computeIfAbsent(from, k -> new ArrayList<>());
      vertex.add(to);
    }
    V = adj.size();
    for (List<String> vertex : adj.values()) {
      Collections.sort(vertex);
    }

    // 欧拉路径
    eulerPath("JFK");
    return path;
  }
  
  private void eulerPath(String v){
    List<String> list = adj.get(v);
    while(list != null && list.size() > 0){
      String w = list.iterator().next();
      adj.get(v).remove(w);
      eulerPath(w);
    }
    path.addFirst(v);
  }

  public static void main(String[] args) {
    // [["EZE","AXA"],["TIA","ANU"],["ANU","JFK"],["JFK","ANU"],["ANU","EZE"],["TIA","ANU"],["AXA","TIA"],["TIA","JFK"],["ANU","TIA"],["JFK","TIA"]]
    FindItinerary findItinerary = new FindItinerary();
    List<List<String>> tickets = new ArrayList<>();
    tickets.add(Lists.newArrayList("EZE","AXA"));
    tickets.add(Lists.newArrayList("TIA","ANU"));
    tickets.add(Lists.newArrayList("ANU","JFK"));
    tickets.add(Lists.newArrayList("JFK","ANU"));
    tickets.add(Lists.newArrayList("ANU","EZE"));
    tickets.add(Lists.newArrayList("TIA","ANU"));
    tickets.add(Lists.newArrayList("AXA","TIA"));
    tickets.add(Lists.newArrayList("TIA","JFK"));
    tickets.add(Lists.newArrayList("ANU","TIA"));
    tickets.add(Lists.newArrayList("JFK","TIA"));

    List<String> itinerary = findItinerary.findItinerary(tickets);
    for (String s : itinerary) {
      System.out.println(s);
    }
  }
}
