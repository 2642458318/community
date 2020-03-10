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