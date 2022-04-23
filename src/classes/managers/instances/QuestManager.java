package src.classes.managers.instances;

public class QuestManager {
  private static QuestManager questManager = new QuestManager();

  private QuestManager() {}

  public static QuestManager getQuestManager() {
    return questManager;
  }
}
