<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<html>
<head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<title>Login</title>
</head>
<style>
.center_div{
    margin: 0 auto;
    width: 60%;
    top:50%;
}
</style>
<body>
    <div class="container center_div">
        <div class="row"><div style="height: 30%"></div></div>
        <div class="row">
            <div class="col"></div>
            <div class="col">
    <form action="/login" class=" text-center" method="post" action="${contextPath}/login">
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" class="form-control" id="username">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password">
        </div>
        <div>${errormsg}</div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<div class="col"></div>
</div>
<div class="row"></div>
</div>
</body>
</html>