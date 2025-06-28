
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Dashboard Template · Bootstrap v5.1</title>


    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>


    <!-- Custom styles for this template -->
    <link href="assets/css/dashboard.css" rel="stylesheet">
</head>
<body>
<!--topbar插入的地方-->
<jsp:include page="commons/topbar.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">

        <!--sidebar插入的地方-->
        <jsp:include page="commons/sidebar.jsp"></jsp:include>
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            Dashboard的页面内容
        </main>
    </div>
</div>


<script src="css/assets/dist/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/feather.min.js"></script>
<script src="assets/js/Chartv-2.9.4.js"></script>
<script src="assets/js/dashboard.js"></script>
</body>
</html>
</html>
