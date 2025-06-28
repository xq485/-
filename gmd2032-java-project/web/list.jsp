<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.zpark.gmd.project.beans.Employee" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>员工管理系统 - 员工列表</title>
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/dashboard.css" rel="stylesheet">
</head>
<body>
<jsp:include page="commons/topbar.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="commons/sidebar.jsp"></jsp:include>
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h2>员工信息列表</h2>
                <div class="btn-toolbar mb-2 mb-md-0">
                    <!-- 修改1：获取上下文路径的正确方式 -->
                    <a href="${pageContext.request.contextPath}/emp/addEmp" class="btn btn-sm btn-primary">
                        <i class="bi bi-plus-circle"></i> 新增员工
                    </a>
                </div>
            </div>

            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th scope="col">员工编号</th>
                        <th scope="col">员工姓名</th>
                        <th scope="col">员工性别</th>
                        <th scope="col">员工薪资</th>
                        <th scope="col">入职日期</th>
                        <th scope="col">所属部门</th>
                        <th scope="col">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="emp">
                        <tr>
                            <td>${emp.id}</td>
                            <td>${emp.name}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${emp.gender == '1'}">男</c:when>
                                    <c:when test="${emp.gender == '0'}">女</c:when>
                                    <c:otherwise>未知</c:otherwise>
                                </c:choose>
                            </td>
                            <td>¥${emp.salary}</td>
                            <td>
                                <!-- 使用fmt标签库格式化日期 -->
                                <fmt:formatDate value="${emp.joinDate}" pattern="yyyy-MM-dd"/>
                            </td>
                            <td>${emp.deptId}</td>
                            <td>
                                <!-- 修改2：获取上下文路径的正确方式 -->
                                <a href="${pageContext.request.contextPath}/emp/editEmpById?id=${emp.id}"
                                   class="btn btn-sm btn-success">
                                    <i class="bi bi-pencil"></i> 修改
                                </a>
                                <!-- 修改3：获取上下文路径的正确方式 -->
                                <a href="${pageContext.request.contextPath}/emp/delEmpById?id=${emp.id}"
                                   class="btn btn-sm btn-danger"
                                   onclick="return confirm('确定要删除员工 ${emp.name} 吗？')">
                                    <i class="bi bi-trash"></i> 删除
                                </a>
                            </td>
                        </tr>
                    </c:forEach>

                    <c:if test="${empty list}">
                        <tr>
                            <td colspan="7" class="text-center text-muted">
                                <i class="bi bi-info-circle"></i> 暂无员工数据
                            </td>
                        </tr>
                    </c:if>
                    </tbody>
                </table>
            </div>

            <div class="d-flex justify-content-between align-items-center">
                <div class="text-muted">共 ${totalCount} 条记录</div>
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li class="page-item"><a class="page-link" href="#">上一页</a></li>
                        <li class="page-item active"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item"><a class="page-link" href="#">下一页</a></li>
                    </ul>
                </nav>
            </div>
        </main>
    </div>
</div>

<script src="assets/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/feather.min.js"></script>
<script src="assets/js/dashboard.js"></script>
</body>
</html>