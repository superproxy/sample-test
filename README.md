# sample-test

##单元测试示例<br/>

testng和单元覆盖工具集成 <br/>
testng和spring test集成 <br/>
mockito和spring mvc mock对象集成 <br/>
controller service dao 单元测试和集成测试的方法<br/>


###2015/8/29
扩展了testng dataprovider的功能<br/>
添加cvs和json测试文件支持  <br/>




###使用
1. 本地查看<br/>
执行local_unitreport.bat <br/>
在target/surefire-reports中查看测试结果<br/>
在target/site/cobertura中查看测试覆盖率<br/>

2. sonar集成查看<br/>
下载sonar<br/>
下载单元测试覆盖率插件cobertura<br/>
http://docs.sonarqube.org/display/PLUG/Cobertura+Plugin<br/>

运行 cobertura.bat，在sonar上查看结果<br/>