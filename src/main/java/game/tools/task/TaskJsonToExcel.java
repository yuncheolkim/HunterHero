package game.tools.task;

import com.alibaba.excel.EasyExcel;
import com.google.common.collect.Lists;
import game.utils.FileUtils;

import java.io.IOException;

/**
 * @author Yunzhe.Jin
 * 2021/7/15 16:53
 */
public class TaskJsonToExcel {

    public static void main(final String[] args) throws IOException {
        final String s = FileUtils.readFile("data/task_4-任务.json");
        System.out.println(s);

        final TaskExcelData data = new TaskExcelData();
        data.list1 = "[1,2,3]";
        EasyExcel.write("test.xlsx", TaskExcelData.class).sheet("模板").doWrite(Lists.newArrayList(data));


    }
}
