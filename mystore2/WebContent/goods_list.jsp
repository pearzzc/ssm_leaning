<%@page import="com.mystore.domian.Goods"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>码蚁商城</title>
    <!--设置标签图标-->
    <link rel="stylesheet" href="style/index.css">
    <link rel="stylesheet" href="style/pageStyle.css">
</head>
<body>
<!--热买商品-->
<%--头部信息 --%>
<jsp:include page="header.jsp"></jsp:include>
<div id="hot_goods">
    <h3 class="hot_goods_title">热卖商品</h3>
    <div class="hot_goods_body">
        <ul>
            <c:if test="${ empty allGoods }">
            out.write("没有商品")	;
            </c:if>
            <c:forEach items="${allGoods }" var="goods">
            	<li>
                <a href="">
                    <img src="images/goods/${goods.image }" alt="">
                    <p>${goods.name }</p>
                    <i class="yuan">￥</i><span class="price">${goods.price }</span>
                </a>
            </li>
            </c:forEach>
        </ul>
    </div>
    <!--分页-->
    <div id="page" class="page_div"></div>
</div>

<!--尾部-->
<jsp:include page="footer.jsp"></jsp:include>
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/paging.js"></script>
<script>
    //分页
    $("#page").paging({
        pageNo:5,
        totalPage: 10,
        totalSize: 300,
        callback: function(num) {
            alert(num);
        }
    })
</script>

</body>

</html>


