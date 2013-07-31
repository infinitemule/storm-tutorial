/*
 * Storm - Rick Roll 
 */
package com.infinitemule.storm.rickroll;

import java.util.Map;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

/**
 * 
 */
public class NeverGonnaSpout extends BaseRichSpout {
  
  private static final long serialVersionUID = -2991121936088229009L;

  private SpoutOutputCollector collector;
  
  @SuppressWarnings("rawtypes")
  public void open(Map conf, 
                   TopologyContext context,
                   SpoutOutputCollector collector) {
    
    this.collector = collector;
  }

  public void nextTuple() {
    
    collector.emit(new Values("Never gonna "));
  }

  public void declareOutputFields(OutputFieldsDeclarer declarer) {
    declarer.declare(new Fields("neverGonna"));
  }

}
