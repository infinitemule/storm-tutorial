/*
 * Storm - Rick Roll
 */
package com.infinitemule.storm.rickroll;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.utils.Utils;

public class RickRollTopology {

  public static void start() {
    
    TopologyBuilder builder = new TopologyBuilder();  
    
    builder.setSpout("Never gonna",   new NeverGonnaSpout());    
    builder.setBolt ("  give you up", new GiveYouUpBolt()  )
    
    .shuffleGrouping("Never gonna" );
    builder.setBolt ("  let you down", new LetYouDownBolt() )
    
    .shuffleGrouping("Never gonna");
    builder.setBolt ("  run around and desert you", new RunAroundAndDesertYouBolt())
    
    .shuffleGrouping("Never gonna");
    builder.setBolt ("  make you cry", new MakeYouCryBolt())    
    
    .shuffleGrouping("Never gonna");
    builder.setBolt ("  say goodbye", new SayGoodbyeBolt())    
    
    .shuffleGrouping("Never gonna");
    builder.setBolt ("  tell a lie and hurt you", new TellALieAndHurtYouBolt())    
    
    .shuffleGrouping("Never gonna"); 
    builder.setBolt ("  give, never gonna give", new GiveNeverGonnaGiveBolt())    
    
    .shuffleGrouping("Never gonna"); // give you up
    
    
    Config conf = new Config();
    conf.setDebug(true);
    conf.setNumWorkers(5);
    conf.setDebug(false);

    LocalCluster cluster = new LocalCluster();
    cluster.submitTopology("rickRoll", conf, builder.createTopology());
    
    Utils.sleep(10000);
    
    cluster.killTopology("rickRoll");
    cluster.shutdown();
  }
}
