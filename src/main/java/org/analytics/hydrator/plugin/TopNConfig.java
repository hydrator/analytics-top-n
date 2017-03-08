package org.analytics.hydrator.plugin;

import co.cask.cdap.api.annotation.Description;
import co.cask.cdap.api.annotation.Macro;
import co.cask.cdap.api.annotation.Name;
import co.cask.cdap.api.plugin.PluginConfig;
import com.google.common.annotations.VisibleForTesting;

import javax.annotation.Nullable;

/**
 * Config for top N of plugins.
 */
public class TopNConfig extends PluginConfig {
  @Nullable
  @Description("Number of partitions to use when aggregating. If not specified, the execution framework " +
    "will decide how many to use.")
  protected Integer numPartitions;

  @Name("topField")
  @Description("The field by which top results are sorted")
  @Macro
  private final String topField;

  @Name("topSize")
  @Description("The maximum number of top records sorted by topField in result")
  @Macro
  private final int topSize;

  public TopNConfig() {
    this.topField = "";
    this.topSize = 0;
  }

  @VisibleForTesting
  TopNConfig(String topField, int topSize) {
    this.topField = topField;
    this.topSize = topSize;
  }

  String getTopField() {
    return topField;
  }

  int getTopSize() {
    return topSize;
  }
}
