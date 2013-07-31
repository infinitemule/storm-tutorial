/*
 * Storm - Rick Roll
 */
package com.infinitemule.storm.rickroll;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.utils.Utils;

public class RickRollTopology {

  public static void main(String[] args) {
    
    TopologyBuilder builder = new TopologyBuilder();  
    
    builder.setSpout("neverGonna", new NeverGonnaSpout());    
    builder.setBolt ("giveYouUp",  new GiveYouUpBolt())
    .shuffleGrouping("neverGonna");
    builder.setBolt ("letYouDown", new LetYouDownBolt())
    .shuffleGrouping("neverGonna");
    builder.setBolt ("runAroundAndDesertYou", new RunAroundAndDesertYouBolt())
    .shuffleGrouping("neverGonna");
    
    Config conf = new Config();
    conf.setDebug(true);
    conf.setNumWorkers(2);
    conf.setDebug(false);

    LocalCluster cluster = new LocalCluster();
    cluster.submitTopology("rickRoll", conf, builder.createTopology());
    
    Utils.sleep(10000);
    
    cluster.killTopology("rickRoll");
    cluster.shutdown();
  }
}
