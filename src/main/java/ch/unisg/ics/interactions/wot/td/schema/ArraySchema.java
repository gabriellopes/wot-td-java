package ch.unisg.ics.interactions.wot.td.schema;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArraySchema extends DataSchema {
  private List<DataSchema> items;
  private Optional<Integer> minItems;
  private Optional<Integer> maxItems;
  
  public ArraySchema(String type, List<DataSchema> items, Optional<Integer> minItems, 
      Optional<Integer> maxItems) {
    super(type);
    
    this.items = items;
    this.minItems = minItems;
    this.maxItems = maxItems;
  }
  
  public List<DataSchema> getItems() {
    return items;
  }

  public Optional<Integer> getMinItems() {
    return minItems;
  }

  public Optional<Integer> getMaxItems() {
    return maxItems;
  }
  
  public static class Builder {
    private List<DataSchema> items;
    private Optional<Integer> minItems;
    private Optional<Integer> maxItems;
    
    public Builder() {
      this.items = new ArrayList<DataSchema>();
    }
    
    public Builder addItem(DataSchema item) {
      this.items.add(item);
      return this;
    }
    
    public Builder addMinItems(Integer minItems) throws IllegalArgumentException {
      if (minItems < 0) {
        throw new IllegalArgumentException("The number of minimum items of an array cannot be negative.");
      }
      
      this.minItems = Optional.of(minItems);
      return this;
    }
    
    public Builder addMaxItems(Integer maxItems) throws IllegalArgumentException {
      if (maxItems < 0) {
        throw new IllegalArgumentException("The number of minimum items of an array cannot be negative.");
      }
      
      this.maxItems = Optional.of(maxItems);
      return this;
    }
    
    public ArraySchema build() {
      return new ArraySchema(DataSchema.ARRAY, items, minItems, maxItems);
    }
  }
}
