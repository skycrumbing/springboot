# springboot
one learning example
## restful
* RESTful风格  
一种软件架构风格。从MVC到前后端完全分离。首先从浏览器发送AJAX请求，然后服务端接受该请求并返回JSON数据返回给浏览器，最后在浏览器中进行界面渲染
服务端将内部资源发布REST服务，客户端通过URL来定位这些资源并通过HTTP协议来访问它们。
* Springboot如何实现restful风格
主要改变在controller层，原先的controller变为了API，与前端完成彻底分离，只是进行json数据的传输

