<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >

<!-- Always ensure to use the correct XML header as above! -->
<#if pro?exists>
<mapper namespace="${packageName}.dao.${pro.className}Dao">
	<insert id="insert${pro.className?cap_first}" parameterType="${pro.className?uncap_first}">
		insert into ${pro.tableName} (
		<#list pro.columns as c>
		<#if c_index != 0>
		${c.databaseName}<#if c_has_next>,</#if>
		</#if>
		</#list>
		)
		values
		(
		<#list pro.columns as c>
		<#if c_index != 0>
		${"#"}{${c.fieldName},jdbcType=${c.dataType?upper_case}}<#if c_has_next>,</#if>	
		</#if>
		</#list>
		)
	</insert>
	
	<delete id="delete${pro.className?cap_first}" parameterType="${pro.className?uncap_first}">
		delete from ${pro.tableName}
		<where>
			<#list pro.columns as c>
			<if test="${c.fieldName} != null">
			  AND ${c.databaseName} = ${"#"}{${c.fieldName}}
			</if>
			</#list>
		</where>
	</delete>
	
	<update id="update${pro.className?cap_first}" parameterType="${pro.className?uncap_first}">
		update ${pro.tableName}
		<set>
			<#list pro.columns as c>
			<if test="${c.fieldName} != null">
			${c.databaseName} = ${"#"}{${c.fieldName}}<#if c_has_next>,</#if>
			</if>
			</#list>
		</set>
		where ${pro.columns[0].databaseName} = ${"#"}{${pro.columns[0].fieldName}}
	</update>
	
	<select id="list${pro.className?cap_first}" resultType="${pro.className?uncap_first}" parameterType="${pro.className?uncap_first}">
		select
		<#list pro.columns as c>
			${c.databaseName} AS ${c.fieldName}<#if c_has_next>,</#if>
		</#list>
		from ${pro.tableName} WHERE 1 = 1
		<#list pro.columns as c>
		<if test="${c.fieldName} != null">
		 AND ${c.databaseName} = ${"#"}{${c.fieldName}}
		</if>
		</#list>
		<if test="pageNo != null and pageSize != null">
			limit ${"#"}{pageNo},${"#"}{pageSize}
		</if>
	</select>

	<select id="list${pro.className?cap_first}Count" resultType="java.lang.Integer" parameterType="${pro.className?uncap_first}">
		select
		COUNT(*)
		from
		${pro.tableName} where 1 = 1
		<#list pro.columns as c>
		<if test="${c.fieldName} != null">
		 AND ${c.databaseName} = ${"#"}{${c.fieldName}}
		</if>
		</#list>
	</select>
	
	<select id="query${pro.className?cap_first}ById" resultType="${pro.className?uncap_first}" parameterType="${pro.className?uncap_first}">
		select
		<#list pro.columns as c>
			${c.databaseName} AS ${c.fieldName}<#if c_has_next>,</#if>
		</#list>
		from ${pro.tableName}
		where ${pro.columns[0].databaseName} = ${"#"}{${pro.columns[0].fieldName}}
	</select>
	
	<select id="query${pro.className?cap_first}ByCondition" resultType="${pro.className?uncap_first}" parameterType="${pro.className?uncap_first}">
		select
		<#list pro.columns as c>
			${c.databaseName} AS ${c.fieldName}<#if c_has_next>,</#if>
		</#list>
		from ${pro.tableName} WHERE 1 = 1
		<#list pro.columns as c>
		<if test="${c.fieldName} != null">
		 AND ${c.databaseName} = ${"#"}{${c.fieldName}}
		</if>
		</#list>
    </select>
</mapper>
</#if>