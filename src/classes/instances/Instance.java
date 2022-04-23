package src.classes.instances;

public abstract class Instance {
  private String name;

  public Instance(String Name) {
    name = Name;
  }

  public String getName() {
    return name;
  }
}
