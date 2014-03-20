Wechat_Public_Platform_API
==========================

this project will test the wechat public platform api

这个项目主要介绍微信公众平台接口的调用，代码里面有相应地介绍：
项目主要有3块内容：
wxCustomMenu：该文件夹 主要介绍自定义菜单的创建和使用；包含小demo
              说明：你需要在config文件中更具要求填写自己公众平台的ID信息，相关的jar包 在menuLib 下面；

Wechat_Public_Platform_API：这是一个完整的微信公众平台demo：
主要功能如下：公众平台会回复你点击的菜单按键值，回复用户发送的消息类型和消息内容。
项目框架使用：Spring+Spring MVC+Hibernate
其中Hibrenate 模块和配置文件已经被我移除。spring 和sping mvc 配置文件依然配置有效

目录说明：
controller：项目的控制器，复制处理收到的给个类型的信息
message：微信API中消息的整理，其中包括有 事件，菜单，请求消息，回复消息等所有的消息类型；
utils：包括各个工具类：xml读写，文件下载，配置文件读写等。
