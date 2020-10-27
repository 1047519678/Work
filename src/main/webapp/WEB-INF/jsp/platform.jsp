<%--
  Created by IntelliJ IDEA.
  User: benon94
  Date: 2020/3/10
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
    <title>员工自助平台</title>
    <link rel="stylesheet" href="<%=basePath%>css/service.css"/>
    <link rel="stylesheet" href="<%=basePath%>css/platform.css"/>
</head>
<body>
<%--<header>--%>
<%--    <div class="header-bigbor">--%>
<%--        <div class="header-bor">--%>
<%--            员工自助平台--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</header>--%>
<form>
    <div class="platform-border">
        <p>个人中心<span style="color: #1f7eff">丨</span></p>
        <div class="function-bor">
            <a href="<%=basePath%>Uri/kaoqin">
                <div class="fun-bor">
                    <img src="<%=basePath%>images/23.jpg"/>
                    <div>刷卡查询</div>
                </div>
            </a>
            <a href="<%=basePath%>Uri/applyITService">
                <div class="fun-bor">
                    <img src="<%=basePath%>images/28.jpg"/>
                    <div>资讯服务</div>
                </div>
            </a>

<%--            <a href="<%=basePath%>errorpage.html">--%>
<%--                <div class="fun-bor">--%>
<%--                    <img src="<%=basePath%>images/29.jpg"/>--%>
<%--                    <div>我的资产</div>--%>
<%--                </div>--%>
<%--            </a>--%>
            <a href="<%=basePath%>errorpage.html">
                <div class="fun-bor">
                    <img src="<%=basePath%>images/49.jpg"/>
                    <div>宿舍查询</div>
                </div>
            </a>
            <a href="<%=basePath%>Uri/toChangePw">
                <div class="fun-bor">
                    <img src="<%=basePath%>images/57.jpg"/>
                    <div>修改密码</div>
                </div>
            </a>
        </div>
        <div class="function-bor">

            <a href="https://mp.weixin.qq.com/s?__biz=MjM5MDg1NDkzMw==&mid=2661399452&idx=2&sn=6e6dfad4d04607fd7410e8fbfda8972f&chksm=bdeb61e68a9ce8f0154816b1c20de3017189351e2d83b45df2b2b93d85d3efbc7ac65ef9cb46&scene=0&xtrack=1&key=baed9475c9f7eb8b44753fe928ae92ccbe1f2442ed59d6544a9f1018d6ad0f3d529c9812dcfbc54fcc3e3a62d0d4d76a97705549ad08264440fa78be016b187a68e0063f72d5fe149d033b406118ba41f8f72e33d9edd18bce246d60c188823d61c0013932cded12e31d12b4ca2e6740379be6135f27fa07e054f64f25e36aa3&ascene=1&uin=MTEyNzUwMjk0Mg%3D%3D&devicetype=Windows+10+x64&version=62090538&lang=zh_CN&exportkey=AyXd3dKCKxTgTng8jQvd8Rk%3D&pass_ticket=jfqWJqMu4wW1EsNuEZCRu3gTNKxpctbNaPP2mB90zNgqoJaZvVtg41Ycp2aorgJS&wx_header=0">
                <div class="fun-bor">
                    <img src="<%=basePath%>images/36.jpg"/>
                    <div>社保查询</div>
                </div>
            </a>

            <a href="<%=basePath%>Uri/glserver">
                <div class="fun-bor">
                    <img src="<%=basePath%>images/61.png"/>
                    <div>隔离测温</div>
                </div>
            </a>

            <a href="<%=basePath%>Uri/outsideuser">
                <div class="fun-bor">
                    <img src="<%=basePath%>images/64.png"/>
                    <div>外宿码</div>
                </div>
            </a>

            <a href="<%=basePath%>Uri/myQrcode">
                <div class="fun-bor">
                    <img src="<%=basePath%>images/2Qcode.png"/>
                    <div>个人信息</div>
                </div>
            </a>
        </div>
        <div class="function-bor">
            <a href="<%=basePath%>Uri/userTiWen">
                <div class="fun-bor">
                    <img src="<%=basePath%>images/58.jpg"/>
                    <div>体温查询</div>
                </div>
            </a>
<%--            <a href="<%=basePath%>pages/XLIdea3.html">--%>
<%--                <div class="fun-bor">--%>
<%--                    <img src="<%=basePath%>images/icon101.png"/>--%>
<%--                    <div>测试</div>--%>
<%--                </div>--%>
<%--            </a>--%>

            <!-- <a href="<%=basePath%>Uri/quest/A">
                <div class="fun-bor">
                    <img src="<%=basePath%>images/43.jpg"/>
                    <div>领班满意度調查表</div>
                </div>
            </a> -->
        </div>
    </div>
    <div class="platform-border">
        <p>OA管理<span style="color: #1f7eff">丨</span></p>
        <div class="function-bor">
            <a href="<%=basePath%>Uri/applyOutSingle">
                <div class="fun-bor">
                    <img src="<%=basePath%>images/40.jpg"/>
                    <div>外出单申请</div>
                </div>
            </a>
            <a href="<%=basePath%>Uri/applyItemRelease">
                <div class="fun-bor">
                    <img src="<%=basePath%>images/51.jpg"/>
                    <div>资产搬出证</div>
                </div>
            </a>
            <a href="<%=basePath%>Uri/applyCardSingle">
                <div class="fun-bor">
                    <img src="<%=basePath%>images/42.jpg"/>
                    <div>补办证件</div>
                </div>
            </a>
            <a href="<%=basePath%>Uri/applyWearSingle">
                <div class="fun-bor">
                    <img src="<%=basePath%>images/62.png"/>
                    <div>工衣工鞋申请</div>
                </div>
            </a>
        </div>
        <div class="function-bor">
            <a href="http://oa.phihong.online/autowork/OAInstruction.aspx">
                <div class="fun-bor">
                    <img src="<%=basePath%>images/c001.png" style="width: 43px"/>
                    <div>使用说明</div>
                </div>
            </a>
            <a href="<%=basePath%>toOA.html">
                <div class="fun-bor">
                    <img src="<%=basePath%>images/40.jpg"/>
                    <div>待签核区</div>
                </div>
            </a>
        </div>

    </div>
    <div class="platform-border">
        <p>行政管理<span style="color: #1f7eff">丨</span></p>
        <div class="function-bor">
            <a href="<%=basePath%>errorpage.html">
                <div class="fun-bor">
                    <img src="<%=basePath%>images/48.jpg"/>
                    <div>宿舍管理</div>
                </div>
            </a>
            <a href="<%=basePath%>errorpage.html">
                <div class="fun-bor">
                    <img src="<%=basePath%>images/30.jpg"/>
                    <div>物品放行</div>
                </div>
            </a>
            <a href="<%=basePath%>Uri/toFA">
                <div class="fun-bor">
                    <img src="<%=basePath%>images/46.jpg"/>
                    <div>固定资产</div>
                </div>
            </a>

            <a href="<%=basePath%>Uri/tdreplace">
                <div class="fun-bor">
                    <img src="<%=basePath%>images/40.jpg"/>
                    <div>测温代写</div>
                </div>
            </a>
        </div>
    </div>

    <div class="platform-border">
        <p>制造管理<span style="color: #1f7eff">丨</span></p>
        <div class="function-bor">
            <a href="<%=basePath%>Uri/checkWork">
                <div class="fun-bor">
                    <img src="<%=basePath%>images/53.jpg"/>
                    <div>在线点名</div>
                </div>
            </a>
            <shiro:hasPermission name="wx_checkReport">
            <a href="<%=basePath%>Uri/checkReport">
                <div class="fun-bor">
                    <img src="<%=basePath%>images/65.png"/>
                    <div>点名报表</div>
                </div>
            </a>
            </shiro:hasPermission>
            <%-- <a id="check" href="javasrcipt:void(0);" runat="server" onserverclick="checkWork">
                 <div class="fun-bor">
                     <img src="images/53.jpg" />
                     <div>製造調動</div>
                 </div>
             </a>--%>
            <%--            <a href="<%=basePath%>toPHP.html">--%>
            <%--                <div class="fun-bor">--%>
            <%--                    <img src="<%=basePath%>images/65.png" />--%>
            <%--                    <div>PHP看板</div>--%>
            <%--                </div>--%>
            <%--            </a>--%>
            <a href="<%=basePath%>Uri/ZZunLock">
                <div class="fun-bor">
                    <img src="<%=basePath%>images/66.png"/>
                    <div>包裝攔截</div>
                </div>
            </a>
                <a href="<%=basePath%>Uri/ZZReport">
                    <div class="fun-bor">
                        <img src="<%=basePath%>images/63.png"/>
                        <div>攔截报表</div>
                    </div>
                </a>
        </div>
    </div>
</form>
</body>
</html>
