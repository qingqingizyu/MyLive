功能划分
1.热门界面，附近界面，推荐界面，（mvp）
2.以及热门界面点击城市跳转到该城市界面
3.推荐界面点击更多跳转到更多界面，更多界面点击城市跳转城市界面
4.实现拉流功能，点击可以进入直播间观看直播
5.提供点击头像跳转主播详情界面功能，
6.与toolbar界面的按钮，（只看男，只看女，看全部） 的功能实现联动效果
额外功能：toolbar标题居中 ，增加向右滑动退出二级activity的功能

1.app首次开启需要登陆才可以进入app，如果不登录就不能进入，登陆以后只要不退出登陆就不用重新登陆
2.QQ登陆和手机号登陆
3.qq登陆获取qq头像，qq昵称，性别所有能拿到的信息，存起来，用来在抽屉中展示用户信息用
4.以及在关注界面点击关注主播以后，收藏该主播的信息，
5.写关注界面并显示所有关注的主播。
6.关注界面，点击条目 跳转到主播详情界面
ps:由于app并没有正式上线，所有需要加好友设置内测资格才可以得到qq官方授权登陆


1.欢迎界面，抽屉界面，并展示用户数据
2.点击不同条目跳转不同界面
3.可以让用户自己设置头像
4.可以修改昵称，个性签名，以及性别
5.主界面toolbar上增加 一个让用户选择想看的分类（看全部，男，女），用户选择不同的选项，就与主界面实现联动效果
6.提供退出登陆功能，退出以后跳转到登陆界面。
额外：实现顶部toast功能


1.主播详情界面，根据传过来的地址，去获取网路数据并展示。（mvp）
2.自定义主题activity开启的时候是从下往上出来
3.6.0动态获取权限
4.实现直播推流功能
5.抽屉里的直播按钮可以进入拉流界面，mainActivity的浮动按钮进入直播界面，两者实现直播的推拉流
6.git的方面


使用的第三方框架有
网络请求：OKHttp3
图片加载：fresco
解析Json:Gson
RxJava，RxAndroid

第三方架包
推流          乐视云
拉流          网易云
定位          百度
第三方登录    腾讯开放平台
手机登录      Bmob