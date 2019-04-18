# 首先想说说写这个项目的目的<br/>

1.项目表太多。

2.mybatis自带的生成mybatis-generator生成的代码可能不太友好，而且只有model,mapper,xml。

3.继承mybatis-generator本身的生成。

4.项目里面里面要写很多Service方法。

5.生成基本可以做所有表的增删改查的前端页面。

6.只专注在service层的业务开发。

## 1.项目采用assembly打包，打出来的包可以直接解压到linux或者window上面运行

项目结构如图：
![image](https://github.com/hncdyj123/super-mybatis-generator/blob/master/image/project.jpg)

## 2.项目运行修改配置
### 修改根目录下的mbgConfiguration.xml<br/>
```Java
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
  PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
  "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>
	<!-- 配置mysql 驱动jar包路径用了绝对路径 -->
	<!-- <classPathEntry location="D:\Tools\mysql\mysql-connector-java\5.1.34\mysql-connector-java-5.1.34.jar" /> -->
	<!-- 配置oracle 驱动jar包路径用了绝对路径 -->
	<classPathEntry location="D:\Tools\com\oracle\ojdbc6\11.2.0\ojdbc6-11.2.0.jar" />

	<context id="ams_mysql_tables" targetRuntime="MyBatis3">
		<property name="javaFileEncoding" value="UTF-8" />
		<plugin type="org.mybatis.generator.plugins.RenameExampleClassPlugin">
			<property name="searchString" value="Example$" />
			<property name="replaceString" value="Criteria" />
		</plugin>
		<plugin type="org.mybatis.supergen.plugin.MySQLPaginationPlugin" />
		<plugin type="org.mybatis.supergen.plugin.RenameExampleMethodPlugin" />
		<plugin type="org.mybatis.supergen.plugin.ModelFieldCustomizePlugin" />
		<plugin type="org.mybatis.supergen.plugin.LombokPlugin" />
		<plugin type="org.mybatis.generator.plugins.SerializablePlugin" />

		<!-- 为了防止生成的代码中有很多注释，比较难看，加入下面的配置控制 -->
		<commentGenerator>
			<property name="suppressAllComments" value="true" />
			<property name="suppressDate" value="true" />
		</commentGenerator>
		<!-- 注释控制完毕 -->

		<!-- 数据库连接mysql -->
		<jdbcConnection driverClass="com.mysql.jdbc.Driver" connectionURL="jdbc:mysql://127.0.0.1:3306/mybatis_generator_test?characterEncoding=utf8" userId="root" password="root123">
			<property name="remarks" value="true" />
		</jdbcConnection>

		<!-- 数据库连接oracle -->
		<!-- <jdbcConnection driverClass="oracle.jdbc.driver.OracleDriver" connectionURL="jdbc:oracle:thin:@192.168.1.222:1521:mybatis_generator_test" userId="vehicle" password="vehicle_2022"> -->
		<!-- <property name="remarks" value="true" /> -->
		<!-- </jdbcConnection> -->

		<javaTypeResolver>
			<property name="forceBigDecimals" value="false" />
		</javaTypeResolver>

		<!-- 数据表对应的model 层 -->
		<javaModelGenerator targetPackage="com.jzx.generator.domain" targetProject="D:\mybatis-generator-test\src\main\java">
			<property name="enableSubPackages" value="false" />
			<property name="trimStrings" value="true" />
			<!-- <property name="rootClass" value="com.smy.framework.base.BaseEntity" /> -->
		</javaModelGenerator>

		<!-- sql mapper 隐射配置文件 -->
		<sqlMapGenerator targetPackage="mapper" targetProject="D:\mybatis-generator-test\src\main\resources\mybatis">
			<property name="enableSubPackages" value="true" />
		</sqlMapGenerator>

		<!-- 在ibatis2 中是dao层，但在mybatis3中，其实就是mapper接口 -->
		<!-- <javaClientGenerator type="XMLMAPPER" targetPackage="com.yihaomen.inter" targetProject="src"> -->
		<!-- <property name="enableSubPackages" value="true" /> -->
		<!-- </javaClientGenerator> -->

		<!-- 要对那些数据表进行生成操作 -->
		<table tableName="test_operator_activity" schema="" />
		<table tableName="test_operator_channel" schema="" />
		<table tableName="test_operator_originality" schema="" />
	</context>
</generatorConfiguration>
```

### 修改本地配置<br/>
修改数据库配置信息<br/>
```Java
<!-- 数据库连接 -->
<jdbcConnection driverClass="com.mysql.jdbc.Driver" connectionURL="jdbc:mysql://127.0.0.1:3306/mybatis_generator_test?characterEncoding=utf8" userId="root" password="root">
<property name="remarks" value="true" />
</jdbcConnection>
```

修改model和mapper

```
<!-- 数据表对应的model 层 -->
<javaModelGenerator targetPackage="com.jzx.generator.domain" targetProject="D:\mybatis-generator-test\src\main\java">
	<property name="enableSubPackages" value="false" />
	<property name="trimStrings" value="true" />
</javaModelGenerator>
```

```
<!-- sql mapper 隐射配置文件 -->
<sqlMapGenerator targetPackage="mapper" targetProject="D:\mybatis-generator-test\src\main\resources\mybatis">
	<property name="enableSubPackages" value="true" />
</sqlMapGenerator>
```

**以上两个配置targetPorject存放根路径要一致**;<br/>
**另外：targetPackage="com.jzx.generator.domain" 要和config.properties中的system.project.packagename包名保持一致。**

配置需要生成的表,建议所有表，因为innerservice,service,controller,页面会生成所有<br/>
```Java
<!-- 要对那些数据表进行生成操作 -->
<table tableName="test_operator_activity" schema="" />
<table tableName="test_operator_channel" schema="" />
<table tableName="test_operator_originality" schema="" />
```

### 修改根目录下config.properties
```Java
# 项目根目录
system.projectname=D:\\mybatis-generator-test
# schema名称(针对oracle一个用户下建立多个表空间)
system.db.schema=vehicle6
# 项目包名(数据库查询xml和项目包会用到此配置)
system.project.packagename=com.jzx.generator
# 表字符替换名(与Dao,Service,Controller,Jsp,Js生成文件名相关,默认用"_"替换，可不配置)
system.table.sub=_
# 表字符替换名(与Dao,Service,Controller,Jsp,Js生成文件名相关,默认用"_"替换，可不配置)
system.column.sub=_
# 生成项目中的log的project名称
log.project.name=mybatis-generator-test
# 生成项目中log的等级
log.level=INFO
# 生成项目中的资源文件
prosource.fileNames=app.properties,applicationContext.xml,logback.xml,pom.xml
# 生成项目中的JDBC连接
jdbc.driver.config=com.mysql.jdbc.Driver
jdbc.url.config=jdbc:mysql://127.0.0.1:3306/mybatis_generator_test?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&zeroDateTimeBehavior=convertToNull
jdbc.username.config=root
jdbc.password.config=root123
jdbc.pool.initialSize.config=150
jdbc.pool.minIdle.config=50
jdbc.pool.maxActive.config=150
```

## 3.生成项目预览
查询操作<br/>
![image](https://github.com/hncdyj123/super-mybatis-generator/blob/master/image/search.jpg)
修改操作<br/>
![image](https://github.com/hncdyj123/super-mybatis-generator/blob/master/image/update.jpg)

## 4.生成项目后运行可能遇到的问题
1.样式错乱。(这个可以微调easyui样式)

2.新增和修改抓包报400错，这是spring绑定实体对象报错。(表单不要提交date,datetime,timestamp等类型，一般提交字符串，用VO接收)

3.每次重新生成请清理src/main/resources/mybatis/mapper目录，因为mybatis-generator会在原来的文件中追加sql。

4.缺失oracle驱动，请自行下载并且上传到maven库中。

5.关于oracle重复生成的问题，请在mbgConfiguration.xml里面的
```xml<table tableName="T_ROBOT_CAR_MODEL" schema=""/>```
加入schema，避免schema下的表字段不一致，重复生成缺失字段问题。

6.经过验证，生成项目在jetty中跑没有问题，在tomcat中访问init方法会报jsp找不到的问题。（可能是jsp文件名敏感问题）

7.jsp页面翻页失效问题，请在domain里面的实体类继承 domain下的Page类。<br/>

## 5.项目资源
1.sql脚本在项目根目录sql下。<br/>
2.可执行的tar.gz在项目根目录startrun下。<br/>
3.生成的项目在根目录startrun下。<br/>

## 6.关于作者
```
var info = {
    nickName  : "杰锅锅",
    introduce : "七年以上码农，算不上资深",
    site : "http://blog.csdn.net/hncdyj"
  }
```
有好的建议请联系我，hncdyj123#163.com (#换成@) <br/>