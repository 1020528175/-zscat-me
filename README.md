springboot dubbo redis solr mq kafka 商城 blog cms
###  单机版商城  http://git.oschina.net/JiaGou-XiaoGe/payshop
###  jeeplus单机版商城 https://gitee.com/JiaGou-XiaoGe/jeeplusBanDuoShangJiaShangCheng
### 支付聚合 https://gitee.com/catshen/xxpay-master


### qq群 483681368

<a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=a00f8452d401d9302d7f1fe04e77a5d2760824a9ed6bb77662d93fedfecb26d8"><img border="0" src="//pub.idqqimg.com/wpa/images/group.png" alt="springboot-dubbo分布式框" title="springboot-dubbo分布式框"></a>
 
![输入图片说明](https://git.oschina.net/uploads/images/2017/0830/111141_ed72ed26_134431.png "1504062698384.png")

# 演示地址


- http://j3shop.tunnel.qydev.com/street/index
- http://j3shop.tunnel.qydev.com/login
- 
- http://j3shop.tunnel.qydev.com/diaShop/index
- http://j3shop.tunnel.qydev.com/web/index
- 
- http://j3shop.tunnel.qydev.com/web/cms/index
- http://j3shop.tunnel.qydev.com/blog/index

# zscat


- ├── sw-common -- SSM框架公共模块（kafka提供者）
- ├── dubbo-cache-starter --dubbo自定义缓存（redis,ehcache,mixcache）
- ├── app-monitor --dubbo服务监控和统计
- ├── sw-portl -- 官网门户展示
- ├── sw-search-- search管理系统（实现了luence，solr两种搜索）
- |    ├── search-api -- search相关的service
- |    ├── search-service -- search相关的service实现  dubbo服务
- |    ├── search-web -- search消费者 前端展示
- ├── sw-blog-- blog管理系统
- |    ├── blog-api -- blog相关的service
- |    ├── blog-service -- blog相关的service实现  dubbo服务
- |    ├── blog-web -- blog消费者 前端展示
- ├── sw-cms-- cms管理系统
- |    ├── cms-api -- cms相关的service
- |    ├── cms-service -- cms相关的service实现  dubbo服务
- |    ├── cms-web -- cms消费者 前端展示
- ├── sw-shop-- shop管理系统
- |    ├── shop-goods-api -- shop商品相关的service
- |    ├── shop-goods-service -- shop商品相关的service实现  dubbo服务
- |    ├── shop-member-api -- shop会员相关的service
- |    ├── shop-member-service -- shop会员相关的service实现  dubbo服务
- |    ├── shop-order-api -- shop订单相关的service
- |    ├── shop-order-service -- shop订单相关的service实现  dubbo服务
- |    ├── shop-rabbitmq-- 商城mq消费
- |    ├── shop-web -- shop消费者 前端展示
- |    ├── shop-h5-- h5消费者 前端展示
- |    ├── shop-admin-- 商城后端展示

- [搜索模块具体介绍](http://git.oschina.net/catshen/zscat_sw/blob/master/sw-search/README.md)
- [后台管理具体介绍](http://git.oschina.net/catshen/zscat_sw/tree/master/sw_manager/README.md)
- [blog管理具体介绍](http://git.oschina.net/catshen/zscat_sw/tree/master/sw_blog/README.md)
- [cms管理具体介绍](http://git.oschina.net/catshen/zscat_sw/tree/master/sw_cms/README.md)
- [商城管理具体介绍](http://git.oschina.net/catshen/zscat_sw/tree/master/sw_shop/README.md)
- [mq管理具体介绍](http://git.oschina.net/catshen/zscat_sw/tree/master/sw-mq/README.md)
- [dubbo缓存具体介绍](http://git.oschina.net/catshen/zscat_sw/tree/master/dubbo-cache-starter/README.md)
- [dubbo监控和统计具体介绍](http://git.oschina.net/catshen/zscat_sw/tree/master/dubbo-monitor/README.md)


rabbitmq 安装
http://blog.csdn.net/hzw19920329/article/details/53156015
使用场景 登录 注册的时候添加积分数据
rabbitmq 提供者
         subject.login(token);
            RabbitMsg msg = new RabbitMsg();
            Map map =new HashMap();
            map.put("userid",MemberUtils.getSessionLoginUser().getId());
            map.put("count",Constan.LOGIN.getCode());
            map.put("msg",Constan.LOGIN.getMsg());
            msg.setMap(map);
            msg.setType("addjifen"); // 登录的时候添加积分
            sender.send(msg);

rabbitmq 消费者
switch (btype) {
            case "addjifen": //添加积分
                if (map.get("userid")!=null){
                    JifendataDO jifendata = new JifendataDO();
                    jifendata.setAddcount((Integer) map.get("count"));
                    jifendata.setSource((String) map.get("msg"));
                    jifendata.setCreatedate(new Date());
                    jifendata.setUserid((Long) map.get("userid"));
                    jifendataService.save(jifendata);
                    TMemberDO m = tMemberService.get((Long) map.get("userid"));
                    m.setJifen(m.getJifen()+(Integer) map.get("count"));
                    tMemberService.update(m);
                }
                break;

            default: {
                System.out.println("unknown btype="+btype);

            }
        }

1. 1.项目部署，根据doc目录下的 zscat.sql，分别创建数据库，相关数据库配置 参考application.properties
3. 加群下载 zscat-tools.jar  解压运行zscat-tools 下面的run.cmd 同时启动zookeep Redis nginx，默认配置 参考application.properties修改

### 4.shop模块为例  


### 需要启动redis 127.0.0.1 6379 没有密码
- a.启动shop-services下面的ShopServiceApplication主类，启动shop的dubbo服务
- c.启动shop-rabbitmq下面的ShopWebApplication主类 先按照rabbitmq 然后启动
- b.启动shop-web下面的ShopWebApplication主类，访问  http://localhost:9992/diaShop/index
- c.启动shop-h5下面的ShopWebApplication主类，访问 http://localhost:9993/taobao/index
- c.启动shop-admin下面的ShopWebApplication主类，访问 http://localhost:9994



https://gitee.com/catshen/xxpay-masterr 支付
###  请作者喝杯咖啡

![输入图片说明](https://git.oschina.net/uploads/images/2017/0829/203712_6694b4c1_134431.jpeg "weixin.jpg")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0829/203723_5567bd56_134431.jpeg "alipay.jpg")