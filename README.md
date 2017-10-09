目标：旨在高仿真实现虎扑



1. 架构：依照MVP进行
2. 组件化：注意这里将在不同组件中使用基础层中不同的库，因此需统一封装API
    1. 基础库base：各个接口基类的封装，以及基础框架搭建
    2. 网络库：
    3. 图片库：
    4. 事件通信
    5. 数据持久

3. 引用库：
    1. OkHttp／Retrofit
    2. RxJava2
    3. ButterKnife
        1. [入门介绍](https://github.com/JakeWharton/butterknife)
    4. glide/Picasso
    5. realm
    6. PullLoadMoreRecycleView
    7. Dagger2
        1. [入门介绍](http://www.jianshu.com/p/65737ac39c44)
    8. ARouter
        1. [入门介绍](https://github.com/alibaba/ARouter)
3. 使用git，并且进行代码审查husky以及lint-staged