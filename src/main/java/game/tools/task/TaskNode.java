package game.tools.task;

/**
 * @author Yunzhe.Jin
 * 2021/7/16 14:15
 */
public class TaskNode {
    // node id
    public int id;
    public int npcId;
    public int areaId;
    public int num;
    public String title;
    public int nodeType;
    public boolean completeNext;

    public TaskExcelData toTaskExcelData() {
        final TaskExcelData d = new TaskExcelData();

        d.nodeId = id;
        d.id = npcId * 10000 + areaId * 100 + num;
        d.title = title;
        d.areaId = areaId;
        d.npcId = npcId;
        d.i3 = num;
        d.completeType = nodeType;
        d.completeNext = completeNext;

        return d;
    }

}
