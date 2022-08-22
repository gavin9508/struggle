# 1. linux命令
> Linux 服务器端一般是命令行界面，通过命令和 linux 系统交互。通过命令进行各种操作。
## 1.1 磁盘管理
### 1.1.1  切换目录：cd 目录名
```text
1. 由当前目录切换到 /usr/local
例如：cd /usr/local
2. 回到根目录（类似于我的电脑）
例如：cd /
```
### 1.1.2 列出当前目录下的文件：ll、ls
```text
1. 列出目录下的详细内容（相当于 Windows 的列表查看）
例如：在当前目录下执行 ll
```
![](img/ll.png)
```text
2. 使用 ll 目录名 查看指定目录下的文件和目录列表
-rw-rw-rw - 表示文件
drw-rw-rw d 表示目录文件夹
```
![](img/ll-path.png)
```text
③ 只列出文件/目录名
例如：在当前目录执行 ls
```
![](img/ls.png)
### 1.1.3 显示当前所在目录位置： pwd
```text
例如：在当前目录下执行 pwd
```
![](img/pwd.png)
## 1.2 文件管理
### 1.2.1 创建目录：mkdir 目录名
>例如：mkdir test

![](img/mkdir-name.png)

>查看创建的目录 ls

![](img/ls-test.png)
### 1.2.2 删除文件或目录 rm , rm –r
> 在 home 目录下测试  cd /hom
```text
1. 使用 rm 删除文件
新建空文件
touch my.txt
例如：rm my.txt
在 test01 目录执行 echo “ok” > my.txt 创建一个 my.txt 的文件
查看 cat my.txt
在执行 rm my.txt 回车后， 系统会提示是否删除确认
在提示位置输入 y ,表示同意，文件删除。 输入 n 取消删除操作。
```
![](img/rm_name.png)
```text
2. 不用确认的直接删除
例如： rm -f my.txt
```
![](img/rm_-f_name.png)
```text
③ 删除目录
rm 目录
例如：rm -rf test01
rm 不加参数，不能删除目录
rm -rf test01 删除文件夹 r 表示递归删除， f不做确认提示
```
![](img/rm_-rf_name_删除文件.png)
### 1.2.3 复制文件命令 cp ，cp -rf
```text
1. 复制文件：aa.txt 是新的文件名
语法：cp 被复制的文件名 新文件名
例如：cp anaconda-ks.cfg aa.txt
重复执行名，询问是否覆盖
输入“y”同意覆盖， 输入“n”取消操作
```
![](img/cp_复制文件名_目标文件名.png)
```text
2. 复制文件夹
语法：cp -rf 文件夹 新的文件夹名
例如 cp -rf myfolder newfolder
```
![](img/cp_文件夹_新的文件夹名.png)
### 1.2.4 查看文件全部内容： cat 文件路径
> 例如：cat /root/anaconda-ks.cfg
![](img/cat_文件路径.png)
### 1.2.5 分页查看文件内容：more 文件路径
>例如：more /root/anaconda-ks.cfg （命令输入完按 Enter）
屏幕底下，显示当前屏幕展示总内容的百分比

![](img/more_文件路径.png)
>按 Enter 之后

![](img/more_文件路径_enter.png)
>按空格之后

![img.png](img/more_文件路径_space.png)

### 1.2.6 查看文件开头的 n 行数据: head -n 数字
```text
1. 例如：head /root/anaconda-ks.cfg (默认是 10 行)
2. 例如显示文件开始的指定行数
```
![](img/head_-n_文件路径.png)
### 1.2.7 显示文件尾部的 n 行数据 tail -n 数字 ，默认是 10 行
```text
1. 例如：tail /root/anaconda-ks.cfg
2. 例如：显示文件尾部指定的 n 行
```
![](img/tail_-n_文件路径.png)
### 1.2.8 文件内搜索: grep
```text
在文件中(可以多个文件同时)搜索字符串，可以使用正则表达式
语法： grep [参数] 搜索的字符串内容 文件名 1 [文件 n]
```
>1 搜索文本”java”：grep java my.txt
没有大写的“JAVA ”,默认是区分大小写的搜索

![](img/grep_搜索的字符串内容_文件内容.png)

>2 搜索文本”java” 区分大小写：grep -i java my.txt -i：不区分大小写

![](img/grep_-i_搜索的字符串内容_文件名_-i.png)

>3 搜索的文本中有空格，使用引号括起来
例如 grep “java is” my.txt

![](img/grep_文中有空格.png)

>4 搜索整个单词，是其他字符串的一部分的不符合条件  -w ：搜索单词
搜索单词 java : grep -w java my.txt

![](img/grep_-w_搜索整个单词.png)

>5 使用正则， 以 java 开头的行
例如 grep “^java” my.txt

![](img/grep_正则表达式搜索.png)

> 6 在多个文件搜索
例如 grep java my.txt test.txt

![](img/grep_多文件搜索.png)

>7 使用管道 “|”
例如： cat my.txt | grep java

![](img/grep_使用管道搜索.png)
## 1.3 系统设置
### 1.3.1 显示系统日期和时间：date
>显示系统当前时间

![](img/显示系统当前时间.png)
### 1.3.2 切换用户：su 用户名
**以其他用户身份使用系统，（类似 windows10 系统，有些程序以管理员身份执行）**
```text
1. 从 root 用户切换到普通用户
例如：以 root 用户登录系统，执行 su sly
注意命令提示符“#”变为“$” , root@sly-virtual-machine 变为
sly@sly-virtual-machine
```
![](img/su_切换普通用户.png)
```text
2. 从普通用户切换到 root 用户，需要输入 root 用户密码
例如 su root
Password 输入密码，linux 不显示输入的字符， 输入密码后直
接按“Enter”.
```
![](img/su.png) 
### 1.3.3 清除屏幕：clear
例如：clear
### 1.3.4 重启系统：reboot
例如：reboot
### 1.3.5 关机：shutdown -h now
例如：shutdown -h no
### 1.3.6 查看系统进程： ps -ef
```text
ps [命令参数]
常用参数：
-e :显示当前所有进程
-f :显示 UID,PPID,C 与 STIME 栏位信息
UID:拥有改程序的用户
PID:程序的进程 id
PPID:父进程的 id
C: CPU 使用的资源百分比
STIME :系统启动时间
TTY：登录系统的终端位置（客户端的标识）
TIME:使用掉的 CPU 时间
CMD:进程是有哪些程序启动的
```
```text
查看系统当前运行的进程（程序）
例如：在任意位置执行 ps -ef
```
![](img/ps_-ef.png)
```text
组合常用命令：ps -ef |grep 进程名称
例如：ps -ef | grep mysql
```
![](img/ps_-ef_组合搜索.png)
### 1.3.7 kill 进程：kill
```text
例如：
kill pid：杀掉进程
kill -9 pid 强制杀掉进程
不能随意使用，会被系统进程杀掉，程序不能使用
```
![](img/kill_pid.png)
## 1.4 压缩/解压
### 1.4.1 tar 压缩（归档） 
```text
tar 用来压缩和解压文件, tar 压缩后的文件也叫归档文件。
语法: tar 参数 要压缩或解压的文件或目录
```
```text
常用参数：
z：使用压缩，生成的文件名是xxx.tar.gz这是linux中常用的压缩格式
c：创建压缩文档
v：显示压缩，解压过程中处理的文件名
f：指定归档的文件名，tar参数后面是归档的文件名
x：从归档文件中释放文件，就是解压
t：列出归档文件内容，查看文件内容
c：解压到指定目录，使用方式 -C 目录，C是大写
```
#### 1.4.1.1 创建归档文件（压缩）
```text
语法：tar -zcvf 归档文件名 要归档的文件列表
例如：tar -zcvf myfile.tar.gz my.txt
```
![](img/tar_-zcvf_创建归档文件.png)
#### 1.4.1.2 归档多个文档
```text
例如：tar -zcvf myfile01.tar.gz my.txt my01.txt
```
![](img/tar_-zcvf_压缩多个文档.png)
```text
也可以使用通配符 * 表示要压缩的文件名的一部分
例如：tar -zcvf myfile02.tar.gz *.tx
```
![](img/tar_-zcvf_使用通配符压缩文件.png)
#### 1.4.1.3 归档目录（即压缩目录）
```text
语法：tar -zcvf 归档文件名 归档目录
例如：tar -zcvf mypackge.tar.gz text01
```
![](img/tar_-zcvf_归档目录.png)
## 1.5 网络通讯
## 1.6 网络访问
## 1.7 权限管理
## 1.8 管道和重定向
## 1.9 vi 编辑命令
## 1.10 安装软件命令