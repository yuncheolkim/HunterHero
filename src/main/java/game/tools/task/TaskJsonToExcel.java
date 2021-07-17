package game.tools.task;

import com.alibaba.excel.EasyExcel;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import game.utils.FileUtils;
import game.utils.JsonUtil;

import java.io.IOException;
import java.util.*;

/**
 * @author Yunzhe.Jin
 * 2021/7/15 16:53
 */
public class TaskJsonToExcel {

    public static void main(final String[] args) throws IOException {
        final String s = FileUtils.readFile("json/test.json");
        System.out.println(s);
        final Multimap<Integer, Integer> fromTo = ArrayListMultimap.create();
        final Multimap<Integer, Integer> toFrom = ArrayListMultimap.create();

        final TaskJsonData taskNode = JsonUtil.fromJsonString(s, TaskJsonData.class);
        // Parse task data
        final Map<Integer, TaskExcelData> taskNodeMap = new HashMap<>();

        for (final TaskNode node : taskNode.nodeList) {
            final TaskExcelData put = taskNodeMap.put(node.id, node.toTaskExcelData());
            assert put == null;
        }

        for (final TaskNodeConnection taskNodeConnection : taskNode.connectionList) {
            fromTo.put(taskNodeConnection.from.nodeId, taskNodeConnection.to.nodeId);
            toFrom.put(taskNodeConnection.to.nodeId, taskNodeConnection.from.nodeId);
        }

        // Make excel data
        for (final Map.Entry<Integer, Integer> entry : fromTo.entries()) {
            final TaskExcelData from = taskNodeMap.get(entry.getKey());
            final TaskExcelData to = taskNodeMap.get(entry.getValue());
            if (from != null && to != null) {
                from.after.add(to.id);
                to.before.add(from.id);
            }
        }
        final List<TaskExcelData> dataList = new ArrayList<>(taskNodeMap.size());

        for (final TaskExcelData value : taskNodeMap.values()) {
            value.list1 = value.before.toString();
            value.list2 = value.after.toString();
            value.targetList = String.format("[%d]", value.id);

            if (value.completeNext) {
                value.completeNpcId = taskNodeMap.get(fromTo.get(value.nodeId).stream().findFirst().get()).npcId;
            } else {
                value.completeNpcId = value.npcId;
            }

            dataList.add(value);
        }

        dataList.sort(Comparator.comparingInt(o -> o.id));

        EasyExcel.write("excel/task_city4.xlsx", TaskExcelData.class).sheet("模板").doWrite(dataList);


    }
}
