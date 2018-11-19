<html>
<head>
    <title></title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
</head>
<body>
<div style="padding:40px 0; height:auto; min-height:100px; text-align:center;">
    <table style="width: 200px;margin: 0 auto;border: 1px solid black">
    <#list users?sort_by("id") as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <!--留意以下陷阱,springboot静态页默认就是具有static文件夹前缀,所以这里不需要写static -->
            <td><a href="${context}/page/${user.id}.html">查看详情</a></td>
        </tr>
    </#list>
    </table>
</div>
</div>
</body>
</html>

