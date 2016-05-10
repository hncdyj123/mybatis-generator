package ${system.project.packagename}.dao.base;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author hncdyj123@163.com
 * @date 2016年5月7日 下午5:00:02
 * 
 * @param <T>实体对象
 * @param <E>查询对象
 * @param <K>主键
 */
public abstract interface BaseDao<T, E, K> extends Serializable {
	/**新增对象 组装为空字段**/
	public abstract int insert(T paramT);

	/**新增对象 不组装为空字段**/
	public abstract int insertSelective(T paramT);

	/**删除对象 不组装为空字段**/
	public abstract int deleteByCriteria(E paramE);

	/**删除对象 根据主键删除**/
	public abstract int deleteByPrimaryKey(K paramK);

	/**修改对象 不组装为空字段**/
	public abstract int updateByCriteriaSelective(@Param("record") T paramT, @Param("example") E paramE);

	/**修改对象 根据主键修改**/
	public abstract int updateByPrimaryKeySelective(T paramT);

	/**查询count 根据条件查询count**/
	public abstract int countByCriteria(E paramE);

	/**查询对象 根据主键查询**/
	public abstract T selectByPrimaryKey(K paramK);

	/**查询对象 根据对象查询**/
	public abstract List<T> selectByCriteria(E paramE);
}
