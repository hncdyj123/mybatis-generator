package ${system.project.packagename}.domain.base;

import java.util.Collection;
/**
 * 返回表格
 * @author hncdyj123@163.com
 */
@SuppressWarnings("rawtypes")
public class DataGrid extends Message {
	/** 总记录数 **/
	private int total;
	/** 数据集 **/
	private Collection rows;

	public DataGrid() {
		super();
	}
	public DataGrid(int total, Collection rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Collection getRows() {
		return rows;
	}
	public void setRows(Collection rows) {
		this.rows = rows;
	}

}
