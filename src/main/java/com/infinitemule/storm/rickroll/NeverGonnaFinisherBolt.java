/*
 * Storm - Rick Roll
 */
package com.infinitemule.storm.rickroll;

import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;



/**
 * 
 */
public abstract class NeverGonnaFinisherBolt extends BaseRichBolt {

  private static final long serialVersionUID = -6206272654124525550L;

  private String suffix;
  
  public NeverGonnaFinisherBolt(String suffix) {
    this.suffix = suffix;
  }

  @SuppressWarnings("rawtypes")
  public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
    
  }
  
  public void execute(Tuple input) {    
    System.out.println(input.getString(0) + suffix);
  }
  
  public void declareOutputFields(OutputFieldsDeclarer declarer) {
    
  }

}
