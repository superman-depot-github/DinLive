# DinLive
**APP描述**
## 技术要点  
kotlin、组件化、rxjava2、retrofit2、tinker、视频播放、腾讯TBS文件阅读、ARouter  
项目采用MVC、MVVM两种开发模式，根据业务进行组件化开发、通过ARouter进行页面跳转和数据交互  

- 组件化框架：[CC](https://qibilly.com/CC-website)
- 崩溃手机、热更新方案：[bugly、tinker](https://bugly.qq.com/docs/)
- 模块间路由、通信，解耦：[ARouter](https://github.com/alibaba/ARouter/blob/master/README_CN.md)
- 屏幕适配方案：[AndroidAutoSize](https://github.com/JessYanCoding/AndroidAutoSize/blob/master/README-zh.md)
- 视屏播放器：[GSYVideoPlayer](https://github.com/CarGuo/GSYVideoPlayer)
- 网络请求框架：[RxEasyHttp](https://github.com/zhou-you/RxEasyHttp) retrofit2+okhttp3+rxjava2二次封装
- 图片加载：Glide V4
- BaseAdapter：[BaseRecyclerViewAdapterHelper](https://github.com/CymChad/BaseRecyclerViewAdapterHelper)
- H5与原生通信JsBridge：[JsBridge](https://github.com/lzyzsd/JsBridge)

## 工程目录
- app -> 壳模块  
    MainActivity、启动页、欢迎页、微信支付分享配置 
- module_login -> 登录模块  
    登录、注册、三方登录（QQ,微信）
## 业务流程

### 报名流程  
所有教育课程的报名必须用户登录，并且完成实名认证方可报名缴费

1. 继续教育（除眉山地区）  
选择城市》填写报名资料》提交订单》完成支付》学习课程》考试》结业
报名资料根据后台返回规则进行填写，成都地区继续教育报名需要进行审核，审核通过后报名成功，用户可在APP进行缴费，缴费成功方可学习
2. 安全教育、记分教育（包括眉山的继续教育报名）  
选择需要报名的学习计划》填写报名资料》提交订单》完成支付》学习课程》考试》结业
3. 从业教育  
选择需要报名的学习计划》填写报名资料》订单支付》等待审核  
从业教育报名只需要在APP完成报名资料的填写，其余业务由线下完成
