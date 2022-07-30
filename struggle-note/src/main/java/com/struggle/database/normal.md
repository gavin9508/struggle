# 数据库
## 数据库三范式
### 1NF(第一范式)
> 属性（对应于表中的字段）不能再被分割，也就是这个字段只能是一个值，不能再分为多个其他的字段了。1NF 是所有关系型数据库的最基本要求 ，也就是说关系型数据库中创建的表一定满足第一范式。

### 2NF(第二范式)
> 2NF 在 1NF 的基础之上，消除了非主属性对于码的部分函数依赖。如下图所示，展示了第一范式到第二范式的过渡。第二范式在第一范式的基础上增加了一个列，这个列称为主键，非主属性都依赖于主键。

### 3NF(第三范式)
> 3NF 在 2NF 的基础之上，消除了非主属性对于码的传递函数依赖 。

## DML 语句和 DDL 语句

### DML（Data Manipulation Language）
> DML是数据库操作语言，指对数据库中表记录的操作，主要包括表记录的插入（insert）、更新（update）、删除（delete）和查询（select），是开发人员日常使用最频繁的操作。

### DDL（Data Definition Language）
> DDL是数据定义语言，就是对数据库内部的对象进行创建、删除、修改的操作语言。
### 删除语句
#### drop
>将表都删除，DDL语句。操作会放到 rollback segement 中，事务提交之后才生效。

eg:drop table 表名

#### truncate
>清空表数据，DDL语句。 操作立即生效，原数据不放到 rollback segment 中，不能回滚，操作不触发 trigger。

eg:truncate table 表名

#### delete
>根据条件删除表数据，DML语句。

eg:delete from 表名 where 列名=值
#### 执行速度
>drop > truncate > delete