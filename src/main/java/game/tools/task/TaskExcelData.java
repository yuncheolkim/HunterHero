package game.tools.task;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Yunzhe.Jin
 * 2021/7/15 17:10
 */
public class TaskExcelData {

    @ExcelIgnore
    public int nodeId;
    @ExcelIgnore
    public Set<Integer> before = new HashSet<>();
    @ExcelIgnore
    public Set<Integer> after = new HashSet<>();
    @ExcelIgnore
    public boolean completeNext;

    @ExcelProperty("id")
    public int id;

    @ExcelProperty("title")
    public String title;

    @ExcelProperty("areaId")
    public int areaId;

    @ExcelProperty("npcId")
    public int npcId;

    @ExcelProperty("i3")
    public int i3;

    @ExcelProperty("completeNpcId")
    public int completeNpcId;

    @ExcelProperty("list1")
    public String list1;

    @ExcelProperty("list2")
    public String list2;

    @ExcelProperty("completeType")
    public int completeType;

    @ExcelProperty("targetList")
    public String targetList;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(final int areaId) {
        this.areaId = areaId;
    }

    public int getNpcId() {
        return npcId;
    }

    public void setNpcId(final int npcId) {
        this.npcId = npcId;
    }

    public int getI3() {
        return i3;
    }

    public void setI3(final int i3) {
        this.i3 = i3;
    }

    public int getCompleteNpcId() {
        return completeNpcId;
    }

    public void setCompleteNpcId(final int completeNpcId) {
        this.completeNpcId = completeNpcId;
    }

    public String getList1() {
        return list1;
    }

    public void setList1(final String list1) {
        this.list1 = list1;
    }

    public String getList2() {
        return list2;
    }

    public void setList2(final String list2) {
        this.list2 = list2;
    }

    public int getCompleteType() {
        return completeType;
    }

    public void setCompleteType(final int completeType) {
        this.completeType = completeType;
    }

    public String getTargetList() {
        return targetList;
    }

    public void setTargetList(final String targetList) {
        this.targetList = targetList;
    }
}
