##github
[OAuth]https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/


##github登录
1.调用（authorize接口）访问github，github回调参数redirect_uri（携带code）
2.请求github获取token，access_token（携带code），github会返回token
3.调用github（user接口携带token）如果正确，github会返回用户信息
4.存入数据、更新登录状态
##cooking跟session
session是账号密码，cooking是银行卡
cooking是不能跨域的

##vhr
https://github.com/lenve/vhr

##idea快捷键
Ctrl+E 最近的文件
Ctrl+H 查看点中的类的继承关系
Ctrl+P 可以显示参数信息
Alt+Q 可以看到当前方法的声明