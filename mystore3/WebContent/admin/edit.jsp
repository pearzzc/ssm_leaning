<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
	String ctx = request.getContextPath();
	pageContext.setAttribute("ctx", ctx);
%>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="${ctx }/admin/css/style.css" type="text/css" />
    <link rel="stylesheet" href="${ctx }/admin/css/amazeui.min.css" />
</head>
<body>

<div class="main_top">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">更新商品</strong><small></small></div>
    </div>
    <hr>
	
    <div class="edit_content">
		<form action="${ctx }/GoodsEditServlet" method="post" id="edit_form" style="background: none; width: 700px;">
			<div class="item1">
			<input type="text" name="g_id" value="${goods.g_id }" style="display: none ">
            <div>
                <span>商品名称：</span>
                <input type="text" class="am-form-field" name="g_name" value="${goods.g_name }">&nbsp;&nbsp;
            </div>
            <div>
                <span>商品价格：</span>
                <input type="text" class="am-form-field" name="g_price" value="${goods.g_price }">
            </div>

        </div>

        <div class="item1">
        	<div>
        	
        		<span>所属分类：</span>
                 <select id="category_select" name="g_cid">
                 <!-- 用EL表达式取出在request域里的数据  用就JSTL进行逻辑判断-->
                 	<c:forEach items="${category }" var="category">
                 		<option value="${category.cid }">${category.cname }</option>
                 	</c:forEach>
                 </select>
                 &nbsp;
        	</div>
        	
        	<div>
        		<span>是否热门：</span>
                 <select id="ishotselect" name="g_is_hot">
                    <option value="0">否</option>
                     <option value="1">是</option>
                 </select>
        	</div>        
                 
        </div>

        <div class="item1">
                <span>商品图片：</span>
                <input type="file" name="g_image" />
        </div>
        
        <div class="item1 item_desc">
            <span>商品描述：</span>
         <textarea  id="desc_goods" name="g_desc" rows="4" cols="50">${goods.g_desc }</textarea>
        </div>
        <button class="am-btn am-btn-default" type="button" id="edit">更新</button>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <button class="am-btn am-btn-default" type="button" id="reset">重置</button>
		</form>
   </div>

</div>

<!-- 引入Jquery 的库件 -->
<script src="${ctx }/admin/js/jquery.min.js"></script>

	<script>

	$(function() {
		/* 监听edit botten 事件 */
	    $("#edit").click(function () {
	        //让表单提交 GoodsAddServlet
	        //获取表单  让其提交通过表单的id名
	        $("#edit_form").submit();
	    });
		
		$("#ishotselect option[value=${goods.g_is_hot}]").prop("selected",true);
		
		$("#category_select option[value=${goods.g_cid}]").prop("selected",true);
	});
	
	

</script>
</body>
</html>