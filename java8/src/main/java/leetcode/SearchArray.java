package leetcode;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author huanghaoxing
 */
public class SearchArray {


  public static void main(String[] args) {
    int V = 4;
    for (int t = 0; t < V; t++) {
      for (int v = 0; v < V; v++) {
        for (int w = 0; w < V; w++) {
          System.out.println("dis[" + t + +v + w + "]=dis[" + v + t + "]" + "+" + "dis[" + t + w + "]");
        }
        System.out.println("----------------");
      }
      System.out.println("----------------");
    }
//          if(dis[v][t] != Integer.MAX_VALUE && dis[t][w] != Integer.MAX_VALUE
//              && dis[v][t] + dis[t][w] < dis[v][w])
//            dis[v][w] = dis[v][t] + dis[t][w];
  }
}
