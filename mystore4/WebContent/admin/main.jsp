<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/style.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/pageStyle.css">

</head>
<body style="background:#f3f3f3;">

<div class="main_top">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">商品管理</strong><small></small></div>
    </div>
    <hr>
    <div class="am-g">
        <div class="am-u-sm-12 am-u-md-6">
            <div class="am-btn-toolbar">
                <div class="am-btn-group am-btn-group-xs">
                    <button id="add" class="am-btn am-btn-default">
                        <span class="am-icon-plus"></span> 新增</button>
                </div>
            </div>
        </div>
        <div class="am-u-sm-12 am-u-md-3">

        </div>
        <div class="am-u-sm-12 am-u-md-3">
            <div class="am-input-group am-input-group-sm">
                <input type="text" class="am-form-field" id="input_search">
                <span class="am-input-group-btn">
                    <button class="am-btn am-btn-default" type="button" id="input_search_btn">搜索</button>
                </span>
            </div>
        </div>
    </div>



</div>

<div class="goods_list">
    <ul class="title_ul">
        <li>序号</li>
        <li>商品图片</li>
        <li>商品名称</li>
        <li>商品价格</li>
        <li>编辑</li>
        <li>删除</li>
    </ul>

<c:forEach items="${requestScope.allGoods }" var="goods" varStatus="status">
	<ul class="list_goods_ul">
        <li>${status.index+1 }</li>
        <li><img src="${pageContext.request.contextPath }/admin/pimages/${ goods.g_image}" alt=""></li>
        <li>${goods.g_name }</li>
        <li>${goods.g_price }</li>
        <li><a href="${pageContext.request.contextPath }/GoodsServlet?action=editUIGoods&id=${goods.g_id}"><img class="img_icon" src="${pageContext.request.contextPath }/admin/images/edit_icon.png" alt=""></a></li>
        <li><a href="${pageContext.request.contextPath }/GoodsServlet?action=delGoods&id=${goods.g_id}"><img class="img_icon" src="${pageContext.request.contextPath }/admin/images/delete_icon.png" alt=""></a></li>
    </ul>
</c:forEach>
    
    
    <!--分页-->
    <div id="page" class="page_div">aaa</div>
</div>

<script src="${pageContext.request.contextPath }/admin/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/admin/js/paging.js"></script>
<script>
    //分页
    $("#page").paging({
        pageNo:5,
        totalPage: 10,
        totalSize: 300,
        callback: function(num) {
            alert(num);
        }
    });

    $("#add").click(function () {
    	/* 转发到对应的servlet,用jS 进行botten事件的监控 */
        $(window).attr('location','${ pageContext.request.contextPath}/GoodsServlet?action=addULGoods');
    });

</script>

</body>
</html>