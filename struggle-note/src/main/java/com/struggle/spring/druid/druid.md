# Druid
Druid 是阿里巴巴开源的一款数据库连接池。能够提供强大的监控和扩展功能。

Druid是一个开源地址，源代码地址：[https://github.com/alibaba/druid](https://github.com/alibaba/druid)。

## 组成
* DruidDriver：能够提供基于 Filter-Chain 模式的插件体系；
* DruidDataSource：高效可管理的数据库连接池；
* SQLParser：支持所有 JDBC 兼容的数据库，包括 Oracle、MySQL 等。

## Druid 集成
### 1.MAVEN 配置
	<dependency>
		<groupId>com.alibaba</groupId>
		<artifactId>druid</artifactId>
		<version>${druid-version}</version>
	</dependency>
	
### 2.配置yml文件
[yml文件详细配置](https://github.com/gavin9508/struggle/blob/master/struggle-spring/src/main/resources/application.yml)

### 3.配置数据源与监控
[DruidConfig数据源配置](https://github.com/gavin9508/struggle/blob/master/struggle-spring/src/main/java/com/struggle/spring/common/config/druid/DruidConfig.java)
[后台监控配置](https://github.com/gavin9508/struggle/blob/master/struggle-spring/src/main/java/com/struggle/spring/common/config/druid/DruidConfig.java)

### 4.访问监控
http://localhost:8080/druid/login.html
	