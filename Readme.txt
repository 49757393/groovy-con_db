groovy -cp ../libs/commons-csv-1.8.jar  readCsv.groovy

清单4
def list = ["Java", "Groovy", "JavaScript"]
list.each{language->
  println language
}
清单 4 中的第一行是 Groovy 用于构建java.util.ArrayList的便捷语法。
可以将println list.class添加到此脚本来验证这一点。接下来，只需对列表调用each()，
并在闭包体内输出language变量。在闭包的开始处使用language->语句命名language变量。
如果没有提供变量名，Groovy 提供了一个默认名称it。在命令行提示符中输入groovy listTest运行 listTest.groovy。

建表语句
CREATE TABLE acc_trade(trade_date VARCHAR(30), trade_time VARCHAR(30),acc_no VARCHAR(30),money VARCHAR(30),flag VARCHAR(10),comment VARCHAR(50));
create table brch_qry_dtl (
    tran_date date,
    timestampl character varying(14),
    acc character varying(19),  
    amt numeric(16,2), 
    dr_cr_flag integer, 
    rpt_sum character varying(8)
);
打包步骤
gradle init
完成目录初始化之后修改build.gradle里面主函数入口的定义
同时将代码放到/home/yangliang/project/scala/helloGroovy/yangliang/con_db/src/main/groovy/con_db
gradle build 由于涉及本地第三方包需要在build.gradle里面加上
compile files('libs/postgresql-42.2.12.jar')
compile files('libs/commons-csv-1.8.jar')
利用gradle shadowJar 完成打包执行java -jar ./con_db-all.jar 

开发踩的坑
stati不创建对象就能调用对象的方法 不然就要new一个对象
list存放数据库的结果集 每一行row可以用map或者对象的方式存储