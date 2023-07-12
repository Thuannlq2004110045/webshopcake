<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ page
language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:url value="/template/admin" var="url"></c:url>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Quản lý người dùng</title>
    <!-- BOOTSTRAP STYLES-->
    <link href="${url}/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="${url}/css/font-awesome.css" rel="stylesheet" />
    <!-- MORRIS CHART STYLES-->

    <!-- CUSTOM STYLES-->
    <link href="${url}/css/custom.css" rel="stylesheet" />
    <!-- GOOGLE FONTS-->
    <link
      href="http://fonts.googleapis.com/css?family=Open+Sans"
      rel="stylesheet"
      type="text/css"
    />
    <!-- TABLE STYLES-->
    <link
      href="${url}/js/dataTables/dataTables.bootstrap.css"
      rel="stylesheet"
    />
  </head>
  <body>
    <div id="wrapper">
      <jsp:include page="/views/admin/nav-bar.jsp"></jsp:include>

      <!-- /. NAV TOP  -->
      <jsp:include page="/views/admin/slide-bar.jsp"></jsp:include>
      <!-- /. NAV SIDE  -->
      <div id="page-wrapper">
        <div id="page-inner">
          <div class="row">
            <div class="col-md-12">
              <h2>Tất cả người dùng</h2>
              <h5>Bạn có thể quản lý người dùng ở đây</h5>
            </div>
          </div>
          <!-- /. ROW  -->
          <hr />

          <div class="row">
            <div class="col-md-12">
              <!-- Advanced Tables -->z
              <div class="panel panel-default">
                <div class="panel-heading">Quản lý người dùng</div>
                <div class="panel-body">
                  <div class="table-responsive">
                    <table
                      class="table table-striped table-bordered table-hover"
                      id="dataTables-example"
                    >
                      <thead>
                        <tr>
                          <th>ID</th>
                          <th>Tên tài khoản</th>
                          <th>Mật khẩu</th>
                          <th>Họ Tên</th>
                          <th>Role ID</th>
                          <th>Gmail</th>
                          <th>Thao tác</th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach items="${userList }" var="user">
                          <tr class="odd gradeX">
                            <td>${user.userId }</td>

                            <td>${user.userName }</td>
                            <td>${user.password }</td>
                            <td>${user.fullName }</td>
                            <td>${user.roleId }</td>
                            <td>${user.gmail }</td>
                            <td>
                              <a
                                href="<c:url value='/edit-user?userId=${user.userId }'/>"
                                class="center"
                                >Sửa</a
                              >
                              |
                              <a
                                href="<c:url value='/delete-user?userId=${user.userId }'/>"
                                class="center"
                                >Xóa</a
                              >
                            </td>
                          </tr>
                        </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
              <!--End Advanced Tables -->
            </div>
          </div>
        </div>
      </div>
      <!-- /. PAGE INNER  -->
    </div>
    <!-- /. PAGE WRAPPER  -->
    <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="${url}/js/jquery-1.10.2.js"></script>
    <!-- BOOTSTRAP SCRIPTS -->
    <script src="${url}/js/bootstrap.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="${url}/js/jquery.metisMenu.js"></script>
    <!-- DATA TABLE SCRIPTS -->
    <script src="${url}/js/dataTables/jquery.dataTables.js"></script>
    <script src="${url}/js/dataTables/dataTables.bootstrap.js"></script>
    <script>
      $(document).ready(function () {
        $("#dataTables-example").dataTable();
      });
    </script>
    <!-- CUSTOM SCRIPTS -->
    <script src="${url}/js/custom.js"></script>
  </body>
</html>
