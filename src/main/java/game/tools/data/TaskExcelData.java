package game.tools.data;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * @author Yunzhe.Jin
 * 2021/7/15 17:10
 */
public class TaskExcelData {

    @ExcelProperty("id")
    public int id;

    @ExcelProperty("name")
    public String name;

    @ExcelProperty("area")
    public int level;

    @ExcelProperty("area")
    public int i1;

    @ExcelProperty("area")
    public int areaId;

    @ExcelProperty("area")
    public int npcId;

    @ExcelProperty("area")
    public int num;

    @ExcelProperty("completeNpcId")
    public int completeNpcId;

    @ExcelProperty("list1")
    public String list1;

    @ExcelProperty("list2")
    public String list2;

    @ExcelProperty("completeType")
    public int completeType;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(final int level) {
        this.level = level;
    }

    public int getI1() {
        return i1;
    }

    public void setI1(final int i1) {
        this.i1 = i1;
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

    public int getNum() {
        return num;
    }

    public void setNum(final int num) {
        this.num = num;
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
}
