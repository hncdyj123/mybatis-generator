#首先想说说写这个项目的目的<br/>
#####以前写过2个版本，后面看公司的项目，思想挺好的。所以重写了以前的代码。<br/>
#####第一版本：https://github.com/hncdyj123/mybatis-generator-v2<br/>
#####第二版本：https://github.com/hncdyj123/super-generator<br/>
1.项目表太多。<br/>
2.mybatis自带的生成mybatis-generator生成的代码可能不太友好，而且只有model,mapper,xml。<br/>
3.继承mybatis-generator本身的生成。<br/>
4.项目里面里面要写很多Service方法。<br/>
5.生成基本可以做所有表的增删改查的前端页面。<br/>
6.只专注在service层的业务开发。<br/>
<br/>

##1.项目采用assembly打包，打出来的包可以直接解压到linux或者window上面运行<br/>
项目结构如图：
![image](https://github.com/hncdyj123/super-mybatis-generator/blob/master/image/project.jpg)

##2.项目运行修改配置：<br/>
###修改根目录下mybatis-config.xml<br/>
```javascript
<configuration>
    <settings> 
        <!-- changes from the defaults for testing -->
        <setting name="cacheEnabled" value="false" />
        <setting name="useGeneratedKeys" value="true" /> 
        <setting name="defaultExecutorType" value="REUSE" /> 
    </settings>
    <typeAliases>
       <typeAlias alias="ColumnEntity" type="org.app.mybatis.db.ColumnEntity"/>
       <typeAlias alias="TableEntity" type="org.app.mybatis.db.TableEntity"/>
    </typeAliases>
    <environments default="development">
       <environment id="development">
           <transactionManager type="jdbc"/> 
           <dataSource type="POOLED">
              <property name="driver" value="com.mysql.jdbc.Driver"/>
              <property name="url" value="jdbc:mysql://127.0.0.1/ams"/>
              <property name="username" value="root"/>
              <property name="password" value="root"/>
           </dataSource>
       </environment>
    </environments>
    <mappers>
        <mapper resource="mappers/mysqlmappers.xml" />
    </mappers>
</configuration>
```
替换三项本地配置<br/>
```
<property name="url" value="jdbc:mysql://127.0.0.1/ams"/>
<property name="username" value="root"/>
<property name="password" value="root"/>
```
<br/>

###修改根目录下的mbgConfiguration.xml<br/>

```javascript
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
  PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
  "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>
	<!-- 配置mysql 驱动jar包路径用了绝对路径 -->
	<classPathEntry location="D:\Tools\mysql\mysql-connector-java\5.1.34\mysql-connector-java-5.1.34.jar" />
	<context id="ams_mysql_tables" targetRuntime="MyBatis3">
		<plugin type="org.mybatis.generator.plugins.RenameExampleClassPlugin">
			<property name="searchString" value="Example$" />
			<property name="replaceString" value="Criteria" />
		</plugin>
		<plugin type="org.mybatis.supergen.plugin.MySQLPaginationPlugin" />
		<plugin type="org.mybatis.supergen.plugin.RenameExampleMethodPlugin" />
		<plugin type="org.mybatis.supergen.plugin.ModelFieldCustomizePlugin" />
		<plugin type="org.mybatis.generator.plugins.SerializablePlugin" />
		<!-- 为了防止生成的代码中有很多注释，比较难看，加入下面的配置控制 -->
		<commentGenerator>
			<property name="suppressAllComments" value="true" />
			<property name="suppressDate" value="true" />
		</commentGenerator>
		<!-- 注释控制完毕 -->
		<!-- 数据库连接 -->
		<jdbcConnection driverClass="com.mysql.jdbc.Driver" connectionURL="jdbc:mysql://127.0.0.1:3306/ams?characterEncoding=utf8" userId="root" password="root">
			<property name="remarks" value="true" />
		</jdbcConnection>
		<javaTypeResolver>
			<property name="forceBigDecimals" value="false" />
		</javaTypeResolver>
		<!-- 数据表对应的model 层 -->
		<javaModelGenerator targetPackage="com.sym.ams.domain" targetProject="D:\super-easyui\src\main\java">
			<property name="enableSubPackages" value="false" />
			<property name="trimStrings" value="true" />
			<!-- <property name="rootClass" value="com.smy.framework.base.BaseEntity" /> -->
		</javaModelGenerator>
		<!-- sql mapper 隐射配置文件 -->
		<sqlMapGenerator targetPackage="mapper" targetProject="D:\super-easyui\src\main\resources\mybatis">
			<property name="enableSubPackages" value="true" />
		</sqlMapGenerator>
		<!-- 在ibatis2 中是dao层，但在mybatis3中，其实就是mapper接口 -->
		<!-- <javaClientGenerator type="XMLMAPPER" targetPackage="com.yihaomen.inter" targetProject="src"> -->
		<!-- <property name="enableSubPackages" value="true" /> -->
		<!-- </javaClientGenerator> -->
		<!-- 要对那些数据表进行生成操作 -->
		<table tableName="ams_operator_channel" />
		<table tableName="ams_operator_activity" />
		<table tableName="ams_operator_originality" />
	</context>
</generatorConfiguration>
```

###修改本地配置<br/>
修改数据库配置信息<br/>
```
<!-- 数据库连接 -->
<jdbcConnection driverClass="com.mysql.jdbc.Driver" connectionURL="jdbc:mysql://127.0.0.1:3306/ams?characterEncoding=utf8" userId="root" password="root">
<property name="remarks" value="true" />
</jdbcConnection>
```
<br/>
修改model和mapper<br/>
1.javaModelGenerator targetProject="D:\super-easyui\src\main\java"  D:\super-easyui需要和config.properties配置项：system.projectname保持一致。<br/>
targetPackage="com.sym.ams.domain" 需要和config.properties配置项：system.project.packagename保持一致。
2.sqlMapGenerator targetProject="D:\super-easyui\src\main\resources\mybatis" D:\super-easyui需要和config.properties配置项：system.projectname保持一致。<br/>
```
<!-- 数据表对应的model 层 --><br/>
<javaModelGenerator targetPackage="com.sym.ams.domain" targetProject="D:\super-easyui\src\main\java">
<property name="enableSubPackages" value="false" />
<property name="trimStrings" value="true" />
<!-- <property name="rootClass" value="com.smy.framework.base.BaseEntity" /> -->
</javaModelGenerator>
<!-- sql mapper 隐射配置文件 -->
<sqlMapGenerator targetPackage="mapper" targetProject="D:\super-easyui\src\main\resources\mybatis">
<property name="enableSubPackages" value="true" />
</sqlMapGenerator>
```
<br/>
配置需要生成的表,建议所有表，因为innerservice,service,controller,页面会生成所有<br/>
```
<!-- 要对那些数据表进行生成操作 -->
<table tableName="ams_operator_channel" />
<table tableName="ams_operator_activity" />
<table tableName="ams_operator_originality" />
```
<br/>

###修改根目录下config.properties
```
#要生成项目的项目名
system.projectname=D:\\super-easyui
#项目DB
system.db.name=ams
#项目的包名
system.project.packagename=com.sym.ams
#表分隔符号 例如：ams_demo表，生成时候会replace掉_
system.table.sub=_
#字段分隔符号 例如：ams_demo表，中的有一个字段为user_name 生成时候会replace掉_
system.column.sub=_
#外部模板位置(此项暂时不需要配置)
system.freemarker.filepath=
#log config(要生成项目的日志根)
log.project.name=super-easyui
#log.level(要生成项目的日志等级)
log.level=INFO
# sources file config(要生成项目的配置文件，在src/main/resources/prosource下面)
prosource.fileNames=app.properties,applicationContext.xml,logback.xml,pom.xml
#jdbc config(要生成项目的jdbc连接和本次取表的jdbc连接)
jdbc.driver.config=com.mysql.jdbc.Driver
jdbc.url.config=jdbc:mysql://127.0.0.1:3306/ams?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&zeroDateTimeBehavior=convertToNull
jdbc.username.config=root
jdbc.password.config=root
jdbc.pool.initialSize.config=150
jdbc.pool.minIdle.config=50
jdbc.pool.maxActive.config=150
```

##3.生成项目预览
查询操作<br/>
![image](https://github.com/hncdyj123/super-mybatis-generator/blob/master/image/search.jpg)
修改操作<br/>
![image](https://github.com/hncdyj123/super-mybatis-generator/blob/master/image/update.jpg)

##4.生成项目后运行可能遇到的问题
1.样式错乱。(这个可以微调easyui样式)<br/>
2.新增和修改抓包报400错，这是spring绑定实体对象报错。(表单不要提交date,datetime,timestamp等类型，一般提交字符串，用VO接收)<br/>
3.每次重新生成请清理src/main/resources/mybatis/mapper目录，因为mybatis-generator会在原来的文件中追加sql。

##5.项目资源
1.sql脚本在项目根目录sql下。<br/>
2.可执行的tar.gz在项目根目录startrun下。<br/>
3.生成的项目在根目录startrun下。<br/>

##6.个人想法
本来是准备统一mybatis-generator生成配置文件，后面想想，要修改源代码重新编译打包，后来放弃了，有兴趣的童鞋可以自己想想合并配置。

其余功能不累赘介绍，大家可以下载代码看。<br/>
有好的建议请联系我，hncdyj123@163.com <br/>
如果您是土豪，请捐助一顿饭钱，谢谢！支付宝账号:hncdyj123@163.com <br/>
