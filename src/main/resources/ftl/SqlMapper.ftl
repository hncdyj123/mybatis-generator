<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >

<!-- Always ensure to use the correct XML header as above! -->
 <#if pro?exists>
<mapper namespace="${pro.packageName?replace("/",".")}.${pro.className?uncap_first}">
	<insert id="insert${pro.className?cap_first}" parameterType="${pro.className?uncap_first}">
		insert into ${pro.tableName} (
		<#list pro.columns as c>
		${c.databaseName} AS ${c.fieldName}<#if c_has_next>,</#if>
		</#list>
		)
		values
		(
		<#list pro.columns as c>
		${"#"}{${c.fieldName},jdbcType=${c.dataType}}<#if c_has_next>,</#if>
		</#list>
		)
	</insert>
	
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
	
	<select id="list${pro.className?cap_first}" resultType="${pro.className?uncap_first}" parameterType="${pro.className?uncap_first}">
		select
		<#list pro.columns as c>
			${c.databaseName} AS ${c.fieldName}<#if c_has_next>,</#if>
		</#list>
		from ${pro.tableName} WHERE 1=1
		<#list pro.columns as c>
		<if test="${c.fieldName} != null">
		 AND ${c.databaseName} = ${"#"}{${c.fieldName}}
		</if>
		</#list>
	</select>

	<select id="list${pro.className?cap_first}Count" resultType="java.lang.Integer" parameterType="${pro.className?uncap_first}">
		select
		COUNT(*)
		from
		${pro.tableName} where 1=1
		<#list pro.columns as c>
		<if test="${c.fieldName} != null">
		 AND ${c.databaseName} = ${"#"}{${c.fieldName}}
		</if>
		</#list>
	</select>
	
	<select id="find${pro.className?cap_first}ByID" resultType="${pro.className?uncap_first}" parameterType="${pro.className?uncap_first}">
		select
		<#list pro.columns as c>
			${c.databaseName} AS ${c.fieldName}<#if c_has_next>,</#if>
		</#list>
		from ${pro.tableName}
		where ${pro.columns[0].databaseName} = ${"#"}{${pro.columns[0].fieldName}}
	</select>
	
	<select id="find${pro.className?cap_first}ByCondition" resultType="${pro.className?uncap_first}" parameterType="${pro.className?uncap_first}">
		select
		<#list pro.columns as c>
			${c.databaseName} AS ${c.fieldName}<#if c_has_next>,</#if>
		</#list>
		from ${pro.tableName} WHERE 1=1
		<#list pro.columns as c>
		<if test="${c.fieldName} != null">
		 AND ${c.databaseName} = ${"#"}{${c.fieldName}}
		</if>
		</#list>
    </select>
</mapper>
</#if>